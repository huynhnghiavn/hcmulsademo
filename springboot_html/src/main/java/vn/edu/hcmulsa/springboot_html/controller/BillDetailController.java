package vn.edu.hcmulsa.springboot_html.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.hcmulsa.springboot_html.form.BillDetailForm;
import vn.edu.hcmulsa.springboot_html.model.BillDetailEntity;
import vn.edu.hcmulsa.springboot_html.repository.BillDetailRepository;

/**
 * Bill detail controller
 * @author Huynh
 */

@Controller
public class BillDetailController {
    @Autowired
    private BillDetailRepository billDetailRepository;

    /**
     * Tạo đối tượng BillDetailForm() gửi lên giao diện nập dữ liệu
     * @param model
     * @return giao diện nhập dữ liệu tương ứng "inputbilldetail.html"
     */
    @GetMapping(value = "/inputbilldetail")
    public String inputBillDetailForm(Model model){
        model.addAttribute("billdetail", new BillDetailForm());
        return "inputbilldetail";
    }

    /**
     * Chuyển dữ liệu từ đối tượng BillDetalForm() vào BillDetailEntity() để lưu vào DB
     * @param billDetailForm
     * @return giao diện thông báo kết quả lưu (resultbilldetail.html)
     */
    @PostMapping(value = "/inputbilldetail")
    public String inputBillDetailSubmit(@ModelAttribute BillDetailForm billDetailForm){
        BillDetailEntity billDetailEntity = new BillDetailEntity();
        billDetailEntity.setBillid(billDetailForm.getBillid());
        billDetailEntity.setProductid(billDetailForm.getProductid());
        billDetailEntity.setPrice(billDetailForm.getPrice());
        billDetailEntity.setQuantity(billDetailForm.getQuantity());
        this.billDetailRepository.save(billDetailEntity);
        return "resultbilldetail";
    }
}
