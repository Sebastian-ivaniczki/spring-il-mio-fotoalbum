package group.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import group.java.demo.pojo.Categorie;
import group.java.demo.pojo.Photo;
import group.java.demo.service.CategorieService;
import group.java.demo.service.PhotoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/categorie")
public class CategorieController {
	
	@Autowired
	private CategorieService categorieService;
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping
	public String index(Model model) {
		List<Categorie> categories = categorieService.findAll();
		
		model.addAttribute("categories", categories);
		
		return "categorie/index";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("categorie", new Categorie());
		return "categorie/create";
	}
	
	@PostMapping("/store")
public String store(@Valid @ModelAttribute Categorie categorie, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("categorie", categorie);
			model.addAttribute("errors", bindingResult);
			
			return "categorie/create";
		}
		
		categorieService.save(categorie);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		
		Optional<Categorie> categoryOpt = categorieService.findById(id);
		Categorie categorie = categoryOpt.get();
		
		for (Photo p : photoService.findAll()) {
			p.removeCategory(categorie);
			photoService.save(p);
		}
		
		categorieService.delete(categorie);
		
		return "redirect:/";
	}
}
