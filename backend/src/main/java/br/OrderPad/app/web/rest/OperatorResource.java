package br.OrderPad.app.web.rest;

import br.OrderPad.app.model.Operator;
import br.OrderPad.app.repository.OperatorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class OperatorResource {

    @Autowired
    private OperatorsRepository operatorsRepository;

    @GetMapping("/teste")
    public String teste(){
        return "Olá mundo";
    }

    @GetMapping("/operadores")
    public List<Operator> listOperators(){
        return operatorsRepository.findAll();
    }

    @GetMapping("/operadores/{userName}")
    public ResponseEntity<Operator> getOperator(@PathVariable String userName){
        Operator operator = operatorsRepository.findByActiveTrueAndUserName(userName);

        if(operator == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(operator);
    }

    @DeleteMapping("/operadores/{userName}")
    public Operator deleteOperator(@PathVariable String userName){
//        return operatorsRepository.delete(operatorsRepository.findOperatorByUserName(userName));
        return null;
    }

    @PutMapping("/operadores")
    public ResponseEntity<Operator> insert(@RequestBody String userName){
        Operator operator = new Operator();
        operator.setUserName(userName);
        operator.setActive(true);
        operator.setName("dsdsd");
        operator.setPassword("dassdsdd");
        return null;
        //return ResponseEntity.created().body(operator);
    }
}
