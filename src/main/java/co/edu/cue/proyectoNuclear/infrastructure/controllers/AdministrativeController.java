package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.Course;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import co.edu.cue.proyectoNuclear.services.CourseService;
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

    @Autowired
    private final AdministrativeService administrativeService;

    @Autowired
    private final CourseService courseService;


    @GetMapping("/users-table")
    public ModelAndView post(){
        //Esta lista se llena desde la base de datos
       // List<UserDto> userList = administrativeService
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINTABLE);
        //modelAndView.addObject("users",userList);
        return modelAndView;
    }

    @GetMapping("/teachers/{id}")
    public void deleteTeacherById(@PathVariable Long id) {
        //administrativeService.deleteTeacherById(id);
    }
    @GetMapping("/courses")
    public void getCourses() {
        courseService.getCourse();
    }

    @GetMapping("/students/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        //administrativeService.deleteStudentById(id);
    }

    @GetMapping("/courses/{idStudent}/subjects/{idSubject}")
    public void addCourse(@PathVariable Long idStudent,@PathVariable Long idSubject ) {
        courseService.studentToSubject(idStudent,idSubject);
    }

   /* @GetMapping("/teachers/{teacherId}/subjects/{subjectId}")
    public ResponseEntity<?> getTeacherSubject(@PathVariable Long teacherId, @PathVariable Long subjectId) {
        // Lógica para obtener información sobre el profesor y la materia usando los IDs recibidos
        // ...
        return ResponseEntity.ok().build();
    }*/

    /*@PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = administrativeService.createCourse(course);
        return ResponseEntity.ok(createdCourse);
    }*/
}
