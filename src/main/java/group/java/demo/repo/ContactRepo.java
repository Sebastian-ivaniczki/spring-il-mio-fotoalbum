package group.java.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.java.demo.pojo.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
