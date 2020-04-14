package vn.edu.hcmulsa.springboot_html.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/viewtmain")
    public String getMain(){
        return "viewmain";
    }

}
