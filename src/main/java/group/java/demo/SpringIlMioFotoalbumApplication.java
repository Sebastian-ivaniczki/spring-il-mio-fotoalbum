package group.java.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import group.java.demo.pojo.Categorie;
import group.java.demo.pojo.Photo;
import group.java.demo.pojo.Role;
import group.java.demo.pojo.User;
import group.java.demo.service.CategorieService;
import group.java.demo.service.PhotoService;
import group.java.demo.service.RoleService;
import group.java.demo.service.UserService;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategorieService categorieService;
	
	@Autowired
	private PhotoService photoService;

	@Override
	public void run(String... args) throws Exception {
		//Role and admin table seed
		Role roleUser = new Role("USER");
		Role roleAdmin = new Role("ADMIN");
		
		roleService.save(roleUser);
		roleService.save(roleAdmin);
		
		final String pws = new BCryptPasswordEncoder().encode("pws");
		
		User userUser = new User("user", pws, roleUser);
		User userAdmin = new User("admin", pws, roleAdmin);
				
		userService.save(userUser);
		userService.save(userAdmin);
		
		//seed photo and categories tables
		
		Categorie c1 = new Categorie("animals");
		Categorie c2 = new Categorie("nature");
		Categorie c3 = new Categorie("city");
		Categorie c4 = new Categorie("free");
		
		categorieService.save(c1);
		categorieService.save(c2);
		categorieService.save(c3);
		categorieService.save(c4);
		
		Photo p1 = new Photo("animal", "photo with animals", "https://picsum.photos/200/300?random=1", true);
		Photo p2 = new Photo("thincs", "random thincs photo", "https://picsum.photos/200/300?random=1", true);
		Photo p3 = new Photo("city", "photo with city", "https://picsum.photos/200/300?random=1", true);
		Photo p4 = new Photo("paesagistic", "paezagistic photo", "https://picsum.photos/200/300?random=1", true);
		
		photoService.save(p1);
		photoService.save(p2);
		photoService.save(p3);
		photoService.save(p4);
	}

}
