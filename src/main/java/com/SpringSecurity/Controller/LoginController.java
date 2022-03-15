package com.SpringSecurity.Controller;

import java.util.HashSet;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.SpringSecurity.Model.Role;
import com.SpringSecurity.Model.User;
import com.SpringSecurity.Repository.UserRepository;

@RestController
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

	@GetMapping("/")
    public ModelAndView Default() {
		ModelAndView mv=new ModelAndView("login");
        return mv;
    }
    @GetMapping("/login")
    public ModelAndView login() {
    	ModelAndView mv=new ModelAndView("login");
        return mv;
    }
	@GetMapping("/logout")
    public ModelAndView logout() {
		ModelAndView mv=new ModelAndView("logout");
        return mv;
    }

    @GetMapping(value = "/register")
    public ModelAndView registerPage(Model model) {
       
        model.addAttribute("user", new User());
        ModelAndView mv=new ModelAndView("register");
        return mv;
    }

    @PostMapping(value = "/register")
    public ModelAndView saveRegisterPage(@Validated @ModelAttribute("user") User user, @RequestParam String role, BindingResult result, Model model,
            Map<String, Object> map) {
    	ModelAndView mv=new ModelAndView("register");
        model.addAttribute("user", user);
        if (result.hasErrors()) {
        	
            return mv;
        }
         else
        
        {
       
        	
         Role r=new Role();
            r.setRole(role);
             user.setRoles(new HashSet<Role>() {{
             	add(r);
            }});
    		String pwd = user.getPassword();
    		String encryptPwd = passwordEncoder.encode(pwd);
    		user.setPassword(encryptPwd);
    		map.put("message", "Successful");
    		userRepository.save(user);

        }
        return mv;
    }

}