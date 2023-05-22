package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/administrative-tools")
@AllArgsConstructor
@Controller
public class AdministrativeController {
    private final AdministrativeService teacherService;

    @GetMapping("/users-table")
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINTABLE);
        return modelAndView;
    }

    @GetMapping("/teachers/{id}")
    public void deleteTeacherById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }
}
