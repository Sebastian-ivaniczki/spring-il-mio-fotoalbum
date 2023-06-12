package group.java.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import group.java.demo.pojo.Photo;
import group.java.demo.service.PhotoService;

@Controller
public class MainController {
	
	@Autowired
	private PhotoService photoService;
	
	
	
	@GetMapping("/")
	public String getGuestHome(Model model) {
		List<Photo> photos = photoService.findAll();
        model.addAttribute("photos", photos);
		return "home";
	}
	
	@GetMapping("/users")
	public String getUserHome() {
		
        

		return "users-home";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String getAdminHome() {
		
		return "admins - only admin";
	}
	
	
    
    
}
