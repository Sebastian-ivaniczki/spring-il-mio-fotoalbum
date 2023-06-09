package group.java.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.java.demo.pojo.Photo;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Integer> {
	public List<Photo> findByTitleContaining(String title);
}
