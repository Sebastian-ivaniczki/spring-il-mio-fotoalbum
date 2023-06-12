package group.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.java.demo.pojo.Contact;
import group.java.demo.repo.ContactRepo;

@Service
public class ContactService {

	@Autowired
	private ContactRepo contactRepo;
	
	public List<Contact> findAll() {
		
		return contactRepo.findAll();
	}
	
	public Contact save(Contact contact) {
		
		return contactRepo.save(contact);
	}
	
	public Optional<Contact> findById(int id) {
		
		return contactRepo.findById(id);
	}
	
	public void delete(Contact contact) {
		
		contactRepo.delete(contact);
	}
}
