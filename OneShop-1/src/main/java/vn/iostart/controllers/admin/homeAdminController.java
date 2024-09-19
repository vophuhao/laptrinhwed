package vn.iostart.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/home")
public class homeAdminController {
	
	
	public String home() {
		
	
		return "admin/home";
	}
}
