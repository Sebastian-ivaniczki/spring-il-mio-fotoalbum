package group.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.java.demo.repo.RoleRepo;

@Service
public class RoleService {
	@Autowired
	private RoleRepo roleRepo;
	
	public List<RoleRepo> findAll() {
		
		return roleRepo.findAll();
	}
	public Optional<RoleRepo> findById(int id) {
		
		return roleRepo.findById(id);
	}
	public RoleRepo save(RoleRepo role) {
		
		return roleRepo.save(role);
	}
}
