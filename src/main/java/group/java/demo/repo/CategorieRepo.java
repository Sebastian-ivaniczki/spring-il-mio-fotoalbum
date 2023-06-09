package group.java.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.java.demo.pojo.Categorie;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie, Integer> {

}
