package group.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.java.demo.pojo.Photo;
import group.java.demo.repo.PhotoRepo;

@Service
public class PhotoService {
	@Autowired
	private PhotoRepo photoRepo;
	
	public List<Photo> findAll(){
		return photoRepo.findAll();
	}
	
	public Photo save(Photo photo) {
		return photoRepo.save(photo);
	}
	
	public Optional<Photo> findById(Integer id){
		return photoRepo.findById(id);
	}
	
	public List<Photo> findByTitle(String title){
		return photoRepo.findByTitleContaining(title);
	}
}
