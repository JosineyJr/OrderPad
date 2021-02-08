package br.OrderPad.app.service;

import br.OrderPad.app.model.Operator;
import br.OrderPad.app.model.Role;
import br.OrderPad.app.repository.OperatorsRepository;
import br.OrderPad.app.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OperatorService {

    private final OperatorsRepository operatorsRepository;
    private final RolesRepository rolesRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public OperatorService(OperatorsRepository operatorsRepository, RolesRepository rolesRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.operatorsRepository = operatorsRepository;
        this.rolesRepository = rolesRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

//    public Operator findOperatorByRole(Role role){
//
//    }

//    public Operator saveOperator(Operator operator){
//        operator.set
//    }

}
