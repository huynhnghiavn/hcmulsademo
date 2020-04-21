package vn.edu.hcmulsa.springboot_html.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmulsa.springboot_html.form.ProductForm;
import vn.edu.hcmulsa.springboot_html.model.ProductEntity;
import vn.edu.hcmulsa.springboot_html.repository.ProductRepository;
import java.util.List;

/**
 * Product Controller
 *
 * @author Huynh
 */
@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /**
     *
     * @return
     */
    @GetMapping("/getproduct")
    public ResponseEntity<?> getProduct(){
        List<ProductEntity> list = this.productRepository.findAll();
        return ResponseEntity.ok(list);
    }

    /**
     * Chuyển dữ liệu từ model lên view
     * @param model
     * @return
     */
    @GetMapping("/viewproduct")
    public String viewProduct( Model model,@RequestParam(defaultValue = "0") int page) {
        //List<ProductEntity> list = ;
        if(page>0) page=page-1;
        model.addAttribute("products", this.productRepository.findAll(PageRequest.of(page,4)));
        model.addAttribute("currentPage",page);
        return "viewproduct";
    }

    /**
     *
     * @param productForm
     * @return
     * @throws Exception
     */
    @PostMapping("/postproduct")
    public ResponseEntity postProduct(@RequestBody ProductForm productForm) throws Exception {
        ProductEntity proEntity = new ProductEntity();
        proEntity.setId(productForm.getId());
        proEntity.setName(productForm.getName());
        proEntity.setUnit(productForm.getUnit());
        proEntity.setQuantity(productForm.getQuantity());
        this.productRepository.save(proEntity);
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/DelProduct/{id}")
    public String delProduct(@PathVariable Integer id) throws Exception {
        this.productRepository.deleteById(id);
        return "ok";
    }
    /**
     * Chuyển dữ liệu từ view vào đối tượng ProductForm trong model
     * @param model
     * @return giao diện nhập dữ liệu trên view (inputproduct.html)
     */
    @GetMapping("/inputproduct")
    public String inputProductForm(Model model){
        model.addAttribute("product", new ProductForm());
        return "inputproduct";
    }

    /**
     * Lưu dữ liệu vào DB
     * @param productForm đối tượng cần lưu
     * @return view thông báo kết quả (resultproduct.html)
     */
    @PostMapping("/inputproduct")
    public String inputProductSubmit(@ModelAttribute ProductForm productForm){
        ProductEntity proEntity = new ProductEntity();
        proEntity.setId(productForm.getId());
        proEntity.setName(productForm.getName());
        proEntity.setUnit(productForm.getUnit());
        proEntity.setQuantity(productForm.getQuantity());
        this.productRepository.save(proEntity);
        return "resultproduct";
    }
    public long countProduct(){
        return this.productRepository.count();
    }
}
