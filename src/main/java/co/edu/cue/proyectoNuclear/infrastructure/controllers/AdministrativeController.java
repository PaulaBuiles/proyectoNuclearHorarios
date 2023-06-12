package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AdministrativeMapper;
import co.edu.cue.proyectoNuclear.services.*;
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
    @Autowired
    private final StudentService studentService;
    @Autowired
    private final TeacherService teacherService;
    @Autowired
    private final SubjectDAOImpl subjectDAO;
    @Autowired
    private final ClassroomService classroomService;
    @Autowired
    private final UserDAOImpl userDAO;
    @Autowired
    private final TeacherDAOImpl teacherDAO;
    @Autowired
    private final SubjectService subjectService;
    private final AdministrativeMapper administrativeMapper;
    private final AdministrativeDAOImpl administrativeDAO;
    private final LoginController loginController;


    @GetMapping("/home-administrative")
    public ModelAndView homeAdministrative(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMIN_HOME);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    @GetMapping("/manage-classroom")
    public ModelAndView manageClassroom(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMIN_CLASSROOM);
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
        ModelAndView modelAndView = new ModelAndView(Pages.ADMIN_TABLE_USERS);
        modelAndView.addObject("users",userDtoList);
        modelAndView.addObject("role","Todos");
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    @GetMapping("/schedule-users/{id}")
    public ModelAndView viewUser(@PathVariable("id") Long userId) {
        UserDto userDto = userDAO.findById(userId);
        ModelAndView modelAndView = null;
        switch (userDto.role()){
            case "Estudiante":
                modelAndView = new ModelAndView(Pages.ADMIN_SCHEDULE_USERS);
                modelAndView.addObject("user", userService.getUser());
                modelAndView.addObject("hours", userService.getHoursList());
                modelAndView.addObject("days", userService.getDaysList());
                modelAndView.addObject("userViewSubjects",studentService.findUserStudent(userDAO.findById(userId)).subject());
                modelAndView.addObject("userView",studentService.findUserStudent(userService.getUser()));
                modelAndView.addObject("userSchedules", userService.getUserSchedule(studentService.findUserStudent(userDAO.findById(userId)).subject()));
                break;
            case "Profesor":
                modelAndView = new ModelAndView(Pages.ADMIN_SCHEDULE_USERS);
                modelAndView.addObject("user", userService.getUser());
                modelAndView.addObject("hours", userService.getHoursList());
                modelAndView.addObject("days", userService.getDaysList());
                modelAndView.addObject("userViewSubjects",teacherService.findUserTeacher(userDAO.findById(userId)).subjects());
                modelAndView.addObject("userView",teacherService.findUserTeacher(userService.getUser()));
                modelAndView.addObject("userSchedules",userService.getUserSchedule(teacherService.findUserTeacher(userDAO.findById(userId)).subjects()));
                break;
            case "Administrativo":
                List<UserDto> userDtoList = userService.getUsers();
                modelAndView = new ModelAndView(Pages.ADMIN_TABLE_USERS);
                modelAndView.addObject("users",userDtoList);
                modelAndView.addObject("role","Todos");
                modelAndView.addObject("user",userService.getUser());
                modelAndView.addObject("message",true);
                break;
        }
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView registerUsers(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMIN_REGISTER_USERS);
        modelAndView.addObject("user",userService.getUser());
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
        ModelAndView modelAndView = new ModelAndView(Pages.ADMIN_TABLE_USERS);
        modelAndView.addObject("users",userDtoList);
        modelAndView.addObject("role",role);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    @GetMapping("/info")
    public ModelAndView info(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMIN_INFORMATION);
        modelAndView.addObject("user",userService.getUser());
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
        ModelAndView modelAndView = new ModelAndView(Pages.ADMIN_CLASSROOM);
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
        ModelAndView modelAndView = new ModelAndView(Pages.ADMIN_SUBJECT);
        modelAndView.addObject("user", userService.getUser());
        modelAndView.addObject("subjects",subjectDAO.getTableList());
        modelAndView.addObject("teachers",teacherDAO.getTableList());
        modelAndView.addObject("classrooms",classroomService.generateClassroom());
        return modelAndView;
    }

    @PostMapping("/add-subject")
    public ModelAndView addSubject(@RequestParam("credit") int credit, @RequestParam("name") String name, @RequestParam("classroom") Long classroomId, @RequestParam("teacher")Long teacherId){
        subjectService.addSubject(name,teacherId,credit,classroomId);
        return infoSubject();
    }

    @GetMapping("/eliminar-subject/{id}")
    public ModelAndView deleteSubject(@PathVariable("id") Long id) {
        // Eliminar materia por ID
        subjectService.deleteById( id);

        return infoSubject();

    }

    @GetMapping("/editar-subject/{id}")
    public ModelAndView editSubject(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView(Pages.ADMIN_EDIT_SUBJECT);
        modelAndView.addObject("idSubject",id);
        modelAndView.addObject("user", userService.getUser());
        modelAndView.addObject("subjects",subjectDAO.getTableList());
        modelAndView.addObject("teachers",teacherDAO.getTableList());
        modelAndView.addObject("classrooms",classroomService.generateClassroom());
        return modelAndView;
    }

    @PostMapping("/change-subject/{id}")
    public ModelAndView editChangeSubject(@PathVariable("id") Long id, @RequestParam("credit") int credit,  @RequestParam("classroom") Long classroomId, @RequestParam("teacher")Long teacherId){
        subjectService.updateSubject(id,teacherId,credit,classroomId);
        return infoSubject();
    }

    @GetMapping("/changePassword")
    public ModelAndView changePassword(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMIN_PASSWORD);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    @PostMapping("/editPassword")
    public ModelAndView editPassword(@RequestParam("password") String password){
      Administrative user = administrativeMapper.mapToEntity(administrativeService.findUserAdmin(userService.getUser()));
        user.setPassword(password);
        administrativeDAO.updatePassword(administrativeMapper.mapAdministrative(user));
        return loginController.post();
    }
    @GetMapping("/eliminar-user/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        // Eliminar usuario por ID
        userService.deleteById(id);
        return getUsersTable();

    }

    @GetMapping("/editar-user/{id}")
    public ModelAndView editUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView(Pages.ADMIN_EDIT_USER);
        modelAndView.addObject("idUser",id);
        modelAndView.addObject("user", userService.getUser());

        return modelAndView;
    }
    @PostMapping("/changes-user/{id}")
    public ModelAndView changesUser(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("email") String email) {
        userService.editUser(id,name, email);
        return getUsersTable();
    }

}
