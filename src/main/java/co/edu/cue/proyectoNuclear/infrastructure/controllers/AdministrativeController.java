package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.Classroom;
import co.edu.cue.proyectoNuclear.infrastructure.dao.ClassroomDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.ClassroomMapper;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import co.edu.cue.proyectoNuclear.services.ClassroomService;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private final ClassroomService classroomService;

    @Autowired
    private final ClassroomMapper classroomMapper;

    @Autowired
    private final ClassroomDAOImpl classroomDAO;

    @GetMapping("/home-administrative")
    public ModelAndView homeAdministrative(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINHOME);
        return modelAndView;
    }

    /*@GetMapping("/assing-classroom")
    public ModelAndView assingClassroom(){
        ModelAndView modelAndView = new ModelAndView(Pages.CLASSROOM);
        return modelAndView;
    }*/


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

    @GetMapping("/info")
    public ModelAndView info(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMININFORMATION);
        //modelAndView.addObject("userStudent",studentService.findUserStudent(userService.getUser()));
        return modelAndView;
    }

    @GetMapping("/teachers/{id}")
    public void deleteTeacherById(@PathVariable Long id) {
        //administrativeService.deleteTeacherById(id);
    }
    @GetMapping("/courses")
    public void getCourses() {
    }

    @GetMapping("/students/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        //administrativeService.deleteStudentById(id);
    }

    @GetMapping("/courses/{idStudent}/subjects/{idSubject}")
    public void addCourse(@PathVariable Long idStudent,@PathVariable Long idSubject ) {
    }

    @GetMapping("/edit-classroom")
    public ModelAndView edit(){
        ModelAndView modelAndView = new ModelAndView(Pages.CLASSROOM);
        return modelAndView;
    }

    @PostMapping("/classroom")
    public ResponseEntity<String> changes(@RequestParam("number") String number, @RequestParam("capacity") String capacity, @RequestParam("location") String location){
        Classroom classroom = classroomMapper.mapToEntity(classroomService.getClassroomDto());
        classroom.setNumber(number);
        classroom.setCapacity(capacity);
        classroom.setLocation(location);

        classroomDAO.save(classroomMapper.mapClassroom(classroom));
        return ResponseEntity.ok("Classroom created successfully");

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
