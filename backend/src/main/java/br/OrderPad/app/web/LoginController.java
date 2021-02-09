package br.OrderPad.app.web;

import br.OrderPad.app.model.Operator;
import br.OrderPad.app.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private OperatorService operatorService;

    @GetMapping("/registration/operator")
    public ModelAndView registrationOperator(){
        ModelAndView modelAndView = new ModelAndView();
        Operator operator = new Operator();
        operator.setUserName("Teste 001");
        modelAndView.addObject("operator", operator);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @GetMapping(value = {"/", "/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewOperator(@Valid Operator operator, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        Operator operatorExists = operatorService.findOperatorByUserName(operator.getUserName());
        if(operatorExists != null){
            bindingResult.rejectValue("userName", "error.user", "There is already a operator registered with the user name provided");
        }
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("registration");
        }else{
            operatorService.saveOperator(operator);
            modelAndView.addObject("succesMessage", "Operator has been registered successfully");
            modelAndView.addObject("user", new Operator());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

    @GetMapping(value = "/admin/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Operator operator = operatorService.findOperatorByUserName(auth.getName());
        modelAndView.addObject("userName", "Bem vindo" + operator.getUserName() + "/" + operator.getName());
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
}
