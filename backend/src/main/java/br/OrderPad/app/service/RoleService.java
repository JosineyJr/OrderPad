package br.OrderPad.app.service;

import br.OrderPad.app.model.Role;
import br.OrderPad.app.repository.RolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RolesRepository rolesRepository;

    private final Logger log = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    public RoleService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public List<Role> findAllList() {
        return this.rolesRepository.findAll();
    }

    public Optional<Role> findOne(Integer roleId) {
        log.debug("REST request to get role: {}", roleId);
        return this.rolesRepository.findById(roleId);
    }

    public Role saveRole(Role role) {
        log.debug("Request to save role: {}", role);
        role = this.rolesRepository.save(role);
        return role;
    }
}
