package group.java.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.java.demo.pojo.Role;

@Repository
public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
