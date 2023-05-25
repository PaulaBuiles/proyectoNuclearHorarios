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
    public ModelAndView getData(@RequestParam("identification") String id, @RequestParam("password") String password ) {
        ModelAndView modelAndView = null;
        String rol = null;
        if(userService.validateUser(Long.valueOf(id),password)) {
            switch (userService.getUser().role()) {
                case "Estudiante" -> {
                    modelAndView = new ModelAndView(Pages.STUDENTHOME);
                    rol = "Student";
                }
                case "Profesor" -> {
                    modelAndView = new ModelAndView(Pages.STUDENTHOME);
                    rol = "Teacher";
                }
                case "Administrativo" -> {
                    modelAndView = new ModelAndView(Pages.ADMINHOME);
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
