package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.domain.enums.Campus;
import co.edu.cue.proyectoNuclear.domain.enums.Property;
import co.edu.cue.proyectoNuclear.infrastructure.dao.ClassroomDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.ClassroomDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.ClassroomMapper;
import co.edu.cue.proyectoNuclear.services.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
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
    private final StudentService studentService;
    @Autowired
    private final TeacherService teacherService;
    @Autowired
    private final SubjectService subjectService;
    @Autowired
    private final ClassroomService classroomService;
    @Autowired
    private final ClassroomMapper classroomMapper;
    @Autowired
    private final TeacherMapper teacherMapper;

    @Autowired
    private final ClassroomMapper classroomMapper;

    @Autowired
    private final ClassroomDAOImpl classroomDAO;

    @GetMapping("/home-administrative")
    public ModelAndView homeAdministrative(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINHOME);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    @GetMapping("/manage-classroom")
    public ModelAndView manageClassroom(){
        ModelAndView modelAndView = new ModelAndView(Pages.CLASSROOM);
        modelAndView.addObject("user",userService.getUser());
        modelAndView.addObject("classrooms",classroomService.generateClassroom());
        return modelAndView;
    }

    @GetMapping("/eliminar/{id}")
    public ModelAndView deleteClassroom(@PathVariable("id") Long id) {
        classroomService.deleteClassroomById(id);
        return edit();

    }

    @GetMapping("/editar/{id}")
    public ModelAndView editClassroom(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView(Pages.EDITAVAILABILITY);
        modelAndView.addObject("idAvailability",id);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }


    @GetMapping("/users-table")
    public ModelAndView getUsersTable(){
        //Esta lista se llena desde la base de datos
        List<UserDto> userDtoList = userService.getUsers();
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINTABLEUSERS);
        modelAndView.addObject("users",userDtoList);
        modelAndView.addObject("role","Todos");
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView registerUsers(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINREGISTERUSERS);
        return modelAndView;
    }

    @PostMapping("/create-student")
    public ModelAndView createUser(@RequestParam("identificationStudent") String identification, @RequestParam("nameStudent") String name, @RequestParam("emailStudent") String email, @RequestParam("passwordStudent") String password, @RequestParam("semesterStudent") int semester) {
        studentService.createStudent(identification,name,email,password,"Estudiante","Ingenieria de Software",semester);
        return getUsersTable();
    }
    @PostMapping("/create-teacher")
    public ModelAndView createUser(@RequestParam("identificationTeacher") String identification, @RequestParam("nameTeacher") String name, @RequestParam("emailTeacher") String email, @RequestParam("passwordTeacher") String password) {
        teacherService.createTeacher(identification,name,email,password,"Profesor");
        return getUsersTable();
    }
    @PostMapping("/create-administrative")
    public ModelAndView createUser(@RequestParam("identificationAdministrative") String identification, @RequestParam("nameAdministrative") String name, @RequestParam("emailAdministrative") String email, @RequestParam("passwordAdministrative") String password, @RequestParam("chargeAdministrative") String charge) {
        administrativeService.createAdministrative(identification,name,email,password,"Administrativo",charge);
        return getUsersTable();
    }
    @PostMapping("/users-table-filter")
    public ModelAndView getUsersTableFilter(@RequestParam("filter") String role){
        List<UserDto> userDtoList = userService.filterUsersByRole(role);
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINTABLEUSERS);
        modelAndView.addObject("users",userDtoList);
        modelAndView.addObject("role",role);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    @GetMapping("/info")
    public ModelAndView info(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMININFORMATION);
        modelAndView.addObject("userStudent",studentService.findUserStudent(userService.getUser()));
        modelAndView.addObject("userTeacher", teacherService.findUserTeacher(userService.getUser()));
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
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    @PostMapping("/classroom")
    public ModelAndView createClassroom(@RequestParam("name") String name, @RequestParam("capacity") Integer capacity, @RequestParam("location") String location, @RequestParam("status") String status, @RequestParam("propertyList") String propertyListString, @RequestParam("observation") String observation) {
        classroomService.createClassroom(name, capacity, classroomService.determineLocation(location), status, classroomService.createPropertyListFromString(propertyListString), observation);
        return manageClassroom();
    }

    @GetMapping("/info-subject")
    public ModelAndView infoSubject(){
        ModelAndView modelAndView = new ModelAndView(Pages.SUBJECT);
        modelAndView.addObject("user", userService.getUser());
        modelAndView.addObject("userStudent",studentService.findUserStudent(userService.getUser()));
        modelAndView.addObject("userTeacher", teacherService.findUserTeacher(userService.getUser()));
        modelAndView.addObject("listClassroom",classroomService.generateClassroom());
        return modelAndView;
    }

    @PostMapping("/add-subject")
    public ModelAndView addSubject(@RequestParam("credit") int credit, @RequestParam("name") String name, @RequestParam("classroom") Long classroomId, @RequestParam("teacher")Long teacherId){
        subjectService.addSubject(name,teacherId,credit,classroomId);
        return infoSubject();
    }




}
