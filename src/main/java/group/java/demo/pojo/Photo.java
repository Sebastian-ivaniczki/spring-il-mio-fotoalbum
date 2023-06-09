package group.java.demo.pojo;

import java.util.Arrays;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	private String description;
	private String url;
	private boolean visibility;
	
	  @ManyToMany
	    private List<Categorie> categories;
	
	public Photo() {}
	
	public Photo(String title, String description, String url, boolean visibility) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisibility(visibility);
	}
	
	public Photo(String title, String description, String url, Boolean visible, Categorie... categories) {
		this(title, description, url, visible);
		setCategories(categories);
	}
	//getter and setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	public void setCategories(Categorie[] categories) {
		setCategories(Arrays.asList(categories));
	}
	public void removeCategory(Categorie categorie) {
		getCategories().remove(categorie);		
	}
	
	
}
