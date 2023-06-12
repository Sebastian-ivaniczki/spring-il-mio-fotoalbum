package group.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.java.demo.pojo.Categorie;
import group.java.demo.repo.CategorieRepo;


@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepo categorieRepo;
	
	public List<Categorie> findAll(){
		return categorieRepo.findAll();
	}
	
	public Categorie save(Categorie categorie) {
		return categorieRepo.save(categorie);
	}
	
	public Optional<Categorie> findById(Integer id){
		return categorieRepo.findById(id);
	}
	public void delete(Categorie category) {
		
		categorieRepo.delete(category);
	}
}
