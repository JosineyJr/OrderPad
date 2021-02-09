package br.OrderPad.app.service;

import br.OrderPad.app.model.Operator;
import br.OrderPad.app.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class MyOperatorService implements UserDetailsService {
    private OperatorService operatorService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Operator operator = operatorService.findOperatorByUserName(userName);
        List<GrantedAuthority> authorities = getUserAuthority(operator.getRoles());
        return buildOperatorForAuthentication(operator, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> operatorRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : operatorRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildOperatorForAuthentication(Operator operator, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(operator.getUserName(), operator.getPassword(),
                operator.getActive(), true, true, true, authorities);
    }

}
