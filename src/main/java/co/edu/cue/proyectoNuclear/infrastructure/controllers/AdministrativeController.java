package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/administrative-tools")
@AllArgsConstructor
@Controller
public class AdministrativeController {
    private final AdministrativeService administrativeService;

    private final UserService userService;

    @GetMapping("/users-table")
    public ModelAndView post(){
        //Esta lista se llena desde la base de datos
        List<User> userList = userService.generateUsers();
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINTABLE);
        modelAndView.addObject("users",userList);
        return modelAndView;
    }

    @GetMapping("/teachers/{id}")
    public void deleteTeacherById(@PathVariable Long id) {
        administrativeService.deleteTeacherById(id);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = administrativeService.createCourse(course);
        return ResponseEntity.ok(createdCourse);
    }
}
