package vn.edu.hcmulsa.springboot_html.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.hcmulsa.springboot_html.form.BillForm;
import vn.edu.hcmulsa.springboot_html.model.BillEntity;
import vn.edu.hcmulsa.springboot_html.repository.BillRepository;

/**
 * Bill controller
 * @author Huynh
 */

@Controller
public class BillController {

    @Autowired
    private BillRepository billRepository;

    /**
     * Tạo đối tượng BillForm() gửi lên giao diện nập dữ liệu
     * @param model
     * @return giao diện nhập dữ liệu tương ứng "inputbill.html"
     */
    @GetMapping(value = "/inputbill")
    public String inputBillForm(Model model){
        model.addAttribute("bill", new BillForm());
        return "inputbill";
    }

    /**
     * Chuyển dữ liệu từ đối tượng BillForm() vào BillEntity() để lưu vào DB
     * @param billForm
     * @return giao diện thông báo kết quả lưu (resultbill.html)
     */
    @PostMapping(value = "/inputbill")
    public String inputBillSubmit(@ModelAttribute BillForm billForm){
        BillEntity billEntity = new BillEntity();
        billEntity.setId(billForm.getId());
        billEntity.setBilldate(billForm.getBilldate());
        billEntity.setStaffid(billForm.getStaffid());
        billEntity.setKind(billForm.getKind());
        this.billRepository.save(billEntity);
        return "resultbill";
    }
}
