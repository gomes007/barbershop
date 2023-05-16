package com.schedule.barbershop.sevice;

import com.schedule.barbershop.model.Role;
import com.schedule.barbershop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Role delete(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        if (role != null) {
            roleRepository.delete(role);
        }
        return role;
    }

    public Role update(Role role) {
        Role existingRole = roleRepository.findById(role.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + role.getId()));

        existingRole.setName(role.getName());

        return roleRepository.save(existingRole);
    }


    public Role findById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + id));
    }


    public List<Role> findAll() {
        return roleRepository.findAll();
    }


}
