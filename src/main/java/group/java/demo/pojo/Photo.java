package group.java.demo.pojo;

import java.util.HashSet;
import java.util.Set;


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
	    private Set<Categorie> categories = new HashSet<>();
	
	public Photo() {}
	
	public Photo(String title, String description, String url, boolean visibility) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisibility(visibility);
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

	public Set<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categorie> categories) {
		this.categories = categories;
	}
	
	
}
