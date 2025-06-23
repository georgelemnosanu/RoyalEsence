package org.example.royalessence.service;

import org.example.royalessence.models.Role;
import org.example.royalessence.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getById(Integer id) {
        return roleRepository.findById(id);
    }

    public Optional<Role> getByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role updateRole(Role updated) {
        return roleRepository.save(updated);
    }

    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
}
