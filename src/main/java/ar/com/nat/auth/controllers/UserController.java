package ar.com.nat.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.nat.auth.models.User;
import ar.com.nat.auth.service.SecurityService;
import ar.com.nat.auth.service.UserService;
import ar.com.nat.auth.validaciones.UserValidator;

@Controller
public class UserController {

	   @Autowired
	    private UserService userService;

	    @Autowired
	    private SecurityService securityService;

	    @Autowired
	    private UserValidator userValidator;

	    @RequestMapping(value = "/crearuser", method = RequestMethod.GET)
	    public String registration(Model model) {
	        model.addAttribute("userForm", new User());

	        return "nuevouser";
	    }

	    @RequestMapping(value = "/crearuser", method = RequestMethod.POST)
	    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
	        userValidator.validate(userForm, bindingResult);

	        if (bindingResult.hasErrors()) {
	            return "nuevouser";
	        }

	        userService.save(userForm);

	        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

	        return "redirect:/inicio";
	    }

	    @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(Model model, String error, String logout) {
	    	model.addAttribute("titulo", "Aplicacion X");
	        if (error != null)
	            model.addAttribute("error", "Nombre no valido");

	        if (logout != null)
	            model.addAttribute("message", "Logeado con suceso");

	        return "login";
	    }

	    @RequestMapping(value = {"/", "/inicio"}, method = RequestMethod.GET)
	    public String welcome(Model model) {
	        return "inicio";
	    }
}
