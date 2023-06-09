package group.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import group.java.demo.pojo.Categorie;
import group.java.demo.pojo.Photo;
import group.java.demo.service.CategorieService;
import group.java.demo.service.PhotoService;

@Controller
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategorieService categorieService;
	
	
	@GetMapping("/user/photo/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		
		Optional<Photo> photoOpt = photoService.findById(id);
		
		Photo photo = photoOpt.get();
		List<Categorie> categories = photo.getCategories();
		
		model.addAttribute("photo", photo);
		model.addAttribute("categories", categories);
		
		return "show-photo";
	}
	
	
    @GetMapping("/admin/photo/create")
    public String create(Model model) {
        List<Categorie> categories = categorieService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("photo", new Photo());
        return "create-photo";
    }
    
    @PostMapping("/admin/photo/store")
	public String store(@ModelAttribute Photo photo, Model model){
		
		
		photoService.save(photo);
		
		return "redirect:/";
	}
    
    
    @GetMapping("admin/photo/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		List<Categorie> categories = categorieService.findAll();
		
		Optional<Photo> photoOpt = photoService.findById(id);
		Photo photo = photoOpt.get();
		
		model.addAttribute("photo", photo);
		model.addAttribute("categories", categories);
		
		return "edit-photo";
	}
    
    @PostMapping("/admin/photo/update/{id}")
	public String update(@PathVariable("id") int id,  @ModelAttribute Photo photo) {
			
		
		photoService.save(photo);
		
		return "redirect:/";
	}
    @GetMapping("/admin/photo/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		
		Optional<Photo> photoOpt = photoService.findById(id);
		Photo photo= photoOpt.get();
		
		photoService.delete(photo);
		
		return "redirect:/";
	}
}
