package group.java.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.java.demo.pojo.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	public Optional<User> findByUsername(String username);
}
