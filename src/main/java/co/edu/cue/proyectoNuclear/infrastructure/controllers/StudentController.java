package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.services.StudentService;
import co.edu.cue.proyectoNuclear.services.impl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
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
