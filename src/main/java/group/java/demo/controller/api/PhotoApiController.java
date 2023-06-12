package group.java.demo.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.java.demo.pojo.Contact;
import group.java.demo.pojo.Photo;
import group.java.demo.service.ContactService;
import group.java.demo.service.PhotoService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class PhotoApiController {
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("photos")
	public ResponseEntity<List<Photo>> apiIndex() {

		List<Photo> photos = photoService.findByVisibilityTrue();

		if (photos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(photos, HttpStatus.OK);
		}
	}
	
	@GetMapping("photos/filter")
	public ResponseEntity<List<Photo>> filterByTitle(@RequestParam(required= false) String title){
		List<Photo> photos = photoService.findByTitle(title);
		if(photos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(photos, HttpStatus.OK);
		}
	}
	
	//email sending
	@PostMapping("contact/store")
	public ResponseEntity<Contact> apiContactCreate(@RequestBody Contact contact) {
		
		Contact newContact = contactService.save(contact);
		
		return new ResponseEntity<>(newContact, HttpStatus.OK);
	}
	
}
