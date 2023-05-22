package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.domain.entities.Usuario;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
@RequestMapping("/")
@AllArgsConstructor
@Controller
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView getData(@RequestParam("identification") String identification, @RequestParam("password") String password ) {
        ModelAndView modelAndView = null;
        String rol = null;
        if(userService.validateUser(identification,password)) {
            switch (userService.getUser().getRole()) {
                case "Student":
                    modelAndView = new ModelAndView(Pages.INICIO);
                    rol = "Student";
                break;
                case "Teacher":
                   modelAndView = new ModelAndView(Pages.INICIO);
                   rol = "Teacher";
                break;
                case "Administrative":
                    modelAndView = new ModelAndView(Pages.INICIO);
                    rol = "Administrative";
                    break;
            }
            modelAndView.addObject("usuario",userService.getUser());
            return modelAndView;
        }
        else {
            modelAndView = new ModelAndView("index");
            System.out.printf("Usuario no encontrado");
            return modelAndView;
        }
    }
}
