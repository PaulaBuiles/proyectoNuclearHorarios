package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserLoginDto;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@RequestMapping("/login")
@AllArgsConstructor
@Controller
public class LoginController {

    private final UserService userService;



    @GetMapping("/")
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView(Pages.LOGIN);
        modelAndView.addObject("userLoginDto",new UserLoginDto(null,"1"));
        return modelAndView;
    }

    @PostMapping("/start-login")
    public ModelAndView getData(@RequestParam("identification") Long identification, @RequestParam("password") String password) {
        UserLoginDto userLoginDto = new UserLoginDto(identification,password);
        System.out.println(userLoginDto.identification() + "    " + userLoginDto.password());
        ModelAndView modelAndView = null;
        if(userService.validateUser(identification,password)) {
            switch (userService.getUser().role()) {
                case "Estudiante" -> {
                    modelAndView = new ModelAndView(Pages.STUDENT_HOME);
                }
                case "Profesor" -> {
                    modelAndView = new ModelAndView(Pages.TEACHERHOME);
                }
                case "Administrativo" -> {
                    modelAndView = new ModelAndView(Pages.ADMIN_HOME);
                }
            }
            modelAndView.addObject("user",userService.getUser());
            return modelAndView;
        } else {
            modelAndView = new ModelAndView(Pages.LOGIN);
            modelAndView.addObject("message",true);
            return modelAndView;
        }
    }
}
