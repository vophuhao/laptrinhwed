package vn.iostart.controllers.admin;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class homeAdminController {

	@RequestMapping("/admin/home")
	public String home() {
		
		
		
		return "admin/home";
	}
}
