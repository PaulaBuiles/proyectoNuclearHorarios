package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/administrative-tools")
@AllArgsConstructor
@Controller
public class AdministrativeController {

    @Autowired
    private final AdministrativeService administrativeService;
    @Autowired
    private final UserService userService;


    @GetMapping("/users-table")
    public ModelAndView getUsersTable(){
        //Esta lista se llena desde la base de datos
        List<UserDto> userDtoList = userService.getUsers();
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINTABLEUSERS);
        modelAndView.addObject("users",userDtoList);
        modelAndView.addObject("role","Todos");
        return modelAndView;
    }

    @PostMapping("/users-table-filter")

    public  ModelAndView getUsersTableFilter(@RequestParam("filter") String role){
        List<UserDto> userDtoList = userService.filterUsersByRole(role);
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINTABLEUSERS);
        modelAndView.addObject("users",userDtoList);
        modelAndView.addObject("role",role);
        return modelAndView;
    }
    @GetMapping("/teachers/{id}")
    public void deleteTeacherById(@PathVariable Long id) {
        //administrativeService.deleteTeacherById(id);
    }

    @GetMapping("/students/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        //administrativeService.deleteStudentById(id);
    }

    /*@PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = administrativeService.createCourse(course);
        return ResponseEntity.ok(createdCourse);
    }*/
}
