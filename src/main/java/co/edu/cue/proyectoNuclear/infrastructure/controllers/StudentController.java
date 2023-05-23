package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
@Controller
public class StudentController {
    @GetMapping("/student-information")
    public ModelAndView getInformation(){
        ModelAndView modelAndView = new ModelAndView(Pages.STUDENTINFORMATION);
        return modelAndView;
    }
}
