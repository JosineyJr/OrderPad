package br.OrderPad.app.service;

import br.OrderPad.app.model.Operator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MyOperatorService {
    private OperatorService operatorService;

    @Override
    @Transactional
    public UserDetails loadUserByUserName(String userName) throws UsernameNotFoundException{
        Operator operator =
    }
}
