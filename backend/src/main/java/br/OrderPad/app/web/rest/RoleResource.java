package br.OrderPad.app.web.rest;

import br.OrderPad.app.model.Role;
import br.OrderPad.app.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/role")//public por enquanto somente para testa o software
public class RoleResource {

    private final RoleService roleService;

    private final Logger log = LoggerFactory.getLogger(RoleResource.class);

    @Autowired
    public RoleResource(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Role>> getRoles() {
        List<Role> roles = this.roleService.findAllList();
        if (roles.size() > 0) {
            return ResponseEntity.ok().body(roles);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<Role> getRole(@PathVariable Integer roleId) {
        log.debug("REST request to get Role: {}", roleId);
        Optional<Role> role = this.roleService.findOne(roleId);
        return role.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@Valid @RequestBody Role role) throws URISyntaxException {
        log.debug("REST request to save role: {}", role);
        if (this.roleService.findOne(role.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este cargo já existe");
        }
        Role result = this.roleService.saveRole(role);
        return ResponseEntity.created(new URI("/api/roles/" + result.getId())).body(result);
    }
}
