package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserLoginDto;
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


    @PostMapping("/")
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView(Pages.LOGIN);
        return modelAndView;
    }

    @GetMapping("/start-login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("userLoginDto", new UserLoginDto());
        return "start-login";
    }

    @PostMapping("/start-login")
    public ModelAndView getData(@ModelAttribute("userLoginDto") UserLoginDto userLoginDto) {
        ModelAndView modelAndView = null;
        String rol = null;
        if(userService.validateUser(userLoginDto.identification(),userLoginDto.password())) {
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
