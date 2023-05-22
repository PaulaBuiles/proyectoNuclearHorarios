package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/navigation")
@AllArgsConstructor
@Controller
public class NavigationController {

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView(Pages.HOME);
        return modelAndView;
    }
    @GetMapping("/info")
    public ModelAndView info(){
        ModelAndView modelAndView = new ModelAndView(Pages.HOME);
        return modelAndView;
    }
    @GetMapping("/schedule")
    public ModelAndView schedule(){
        ModelAndView modelAndView = new ModelAndView(Pages.HOME);
        return modelAndView;
    }

}
