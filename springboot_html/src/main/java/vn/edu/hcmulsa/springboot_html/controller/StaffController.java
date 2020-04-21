package vn.edu.hcmulsa.springboot_html.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmulsa.springboot_html.form.StaffForm;
import vn.edu.hcmulsa.springboot_html.model.StaffEntity;
import vn.edu.hcmulsa.springboot_html.repository.StaffRepository;

import java.util.List;

/**
 * Staff Controller
 *
 * @author Huynh
 */
@Controller
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    /**
     *
     * @return
     */
    @GetMapping("/getstaff")
    public ResponseEntity<?> getStaff(){
        List<StaffEntity> list = this.staffRepository.findAll();
        return ResponseEntity.ok(list);
    }

    /**
     * Chuyển dữ liệu từ model lên view
     * @param model
     * @return
     */
    @GetMapping("/viewstaff")
    public String viewStaff(Model model,@RequestParam(defaultValue = "0") int page){
        //List<StaffEntity> list = this.staffRepository.findAll();
        if(page>0) page=page-1;
        model.addAttribute("staffs",this.staffRepository.findAll(PageRequest.of(page,4)));
        model.addAttribute("currentPage",page);
        return "viewstaff";
    }

    /**
     *
     * @param staffForm
     * @return
     * @throws Exception
     */
    @PostMapping("/poststaff")
    public ResponseEntity postStaff(@RequestBody StaffForm staffForm) throws Exception{
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setId(staffForm.getId());
        staffEntity.setFirstname(staffForm.getFirstname());
        staffEntity.setLastname(staffForm.getLastname());
        staffEntity.setGender(staffForm.getGender());
        staffEntity.setAddress(staffForm.getAddress());
        staffEntity.setPhone(staffForm.getPhone());
        this.staffRepository.save(staffEntity);
        return ResponseEntity.ok("Successfully!");
    }

    /**
     * Tạo đối tượng (StaffForm) nhận dữ liệu từ giao diện (HTML)
     * @param model
     * @return "inputstaff" cũng là tên file html (inputstaff.html) hiển thị giao diện nhập dữ liệu
     */
    @GetMapping("/inputstaff")
    public String inputStaffForm(Model model){
        model.addAttribute("staff", new StaffForm());
        return "inputstaff";
    }

    /**
     * Chuyển dữ liệu từ đối tượng StaffForm vào StaffEntity và lưu vào DB
     * @param staffForm là đối tượng đã nhận dữ liệu từ form
     * @return "resultstaff" cũng là tên file html (resultstaff.html) hiển thị giao diện thông báo kết quả
     */
    @PostMapping("/inputstaff")
    public String inputStaffSubmit(@ModelAttribute StaffForm staffForm){
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setId(staffForm.getId());
        staffEntity.setFirstname(staffForm.getFirstname());
        staffEntity.setLastname(staffForm.getLastname());
        staffEntity.setGender(staffForm.getGender());
        staffEntity.setAddress(staffForm.getAddress());
        staffEntity.setPhone(staffForm.getPhone());
        this.staffRepository.save(staffEntity);
        return "resultstaff";
    }
    @GetMapping("DelStaff/{id}")
    public String delStaff(@PathVariable Integer id) throws Exception{
        this.staffRepository.deleteById(id);
        return "ok";
    }
}
