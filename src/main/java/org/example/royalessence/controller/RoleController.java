package org.example.royalessence.controller;

import org.example.royalessence.models.Role;
import org.example.royalessence.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/roles")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // Create role
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role created = roleService.createRole(role);
        return ResponseEntity.ok(created);
    }

    // Get all roles
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> list = roleService.getAllRoles();
        return ResponseEntity.ok(list);
    }

    // Get role by ID
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
        Optional<Role> opt = roleService.getById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get role by name
    @GetMapping("/by-name/{name}")
    public ResponseEntity<Role> getRoleByName(@PathVariable String name) {
        Optional<Role> opt = roleService.getByName(name);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update role
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Integer id, @RequestBody Role role) {
        role.setId(id);
        Role updated = roleService.updateRole(role);
        return ResponseEntity.ok(updated);
    }

    // Delete role
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
