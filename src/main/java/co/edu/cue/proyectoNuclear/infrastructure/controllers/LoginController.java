package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
@Controller
public class LoginController {

    private final UserService userService;


    @GetMapping("/")
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView(Pages.LOGIN);
        return modelAndView;
    }
    @GetMapping("/start-login")
    public ModelAndView getData(@RequestParam("identification") String identification, @RequestParam("password") String password ) {
        ModelAndView modelAndView = null;
        String rol = null;
        if(userService.validateUser(identification,password)) {
            switch (userService.getUser().getRole()) {
                case "Student" -> {
                    modelAndView = new ModelAndView(Pages.STUDENTHOME);
                    rol = "Student";
                }
                case "Teacher" -> {
                    modelAndView = new ModelAndView(Pages.STUDENTHOME);
                    rol = "Teacher";
                }
                case "Administrative" -> {
                    modelAndView = new ModelAndView(Pages.STUDENTHOME);
                    rol = "Administrative";
                }
            }
            modelAndView.addObject("usuario",userService.getUser());
            return modelAndView;
        }
        else {
            modelAndView = new ModelAndView("index");
            System.out.print("Usuario no encontrado");
            return modelAndView;
        }
    }
}
