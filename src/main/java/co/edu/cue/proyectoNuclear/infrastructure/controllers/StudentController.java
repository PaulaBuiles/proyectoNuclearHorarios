package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.infrastructure.dao.ScheduleDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.StudentDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.ScheduleDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.StudentMapper;
import co.edu.cue.proyectoNuclear.services.StudentService;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
@Controller
public class StudentController {

    private final LoginController loginController;

    @Autowired
    private final UserService userService;

    @Autowired
    private final StudentService studentService;

    @Autowired
    private StudentDAOImpl studentDAO;

    @Autowired
    private StudentMapper studentMapper;


    /*
    Esta función permite retornar al usuario
    a la interfaz donde está alguna información de la universidad donde no mucha funcionalidad
    */
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView =new ModelAndView(Pages.STUDENTHOME);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    /*
    Esta función permite llevar al usuario al apartado de la información general
    allí puede ver su información básica con el respectivo semestre y carrera, también
    con la información de las materias donde está inscrito con información general de la misma
    */
    @GetMapping("/info")
    public ModelAndView info(){
        ModelAndView modelAndView = new ModelAndView(Pages.STUDENTINFORMATION);
        modelAndView.addObject("userStudent",studentService.findUserStudent(userService.getUser()));
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    /*
    Esta función permite llevar al usuario a un formulario donde puede editar algunos campos, ya que
    un estudiante no puede editar todos sus campos
    */
    @GetMapping("/edit")
    public ModelAndView edit(){
        ModelAndView modelAndView =new ModelAndView(Pages.CHANGES);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    /*
    Esta función permite obtener los datos del formulario y los lleva al apartado del servicio de estudiante
    para trasformar la información y poderla editar en la base de datos
    */
    @PostMapping("/changes")
    public ModelAndView changes(@RequestParam("name") String name, @RequestParam("email") String email){
        Student user = studentMapper.mapToEntity(studentService.findUserStudent(userService.getUser()));
        user.setName(name);
        user.setEmail(email);
        studentService.editStudent(name,email);
        return info();
    }
    /*
    Esta función es la más importante, está permite visualizar el horario a un estudiante
     solo muestra las materias en específico de cada estudiante
    */
    @GetMapping("/schedule")
    public ModelAndView scheduleStudent() {
        ModelAndView modelAndView = new ModelAndView(Pages.SCHEDULESTUDENT);
        modelAndView.addObject("user", userService.getUser());
        modelAndView.addObject("userStudent",studentService.findUserStudent(userService.getUser()));
        modelAndView.addObject("hours", userService.getHoursList());
        modelAndView.addObject("days", userService.getDaysList());
        modelAndView.addObject("studentSchedules", userService.getUserSchedule(studentService.findUserStudent(userService.getUser()).subject()));
        return modelAndView;

    }
    /*
    Esta función es muy sencilla, permite al usuario ver el formulario para
     cambiar la contraseña
    */
    @GetMapping("/changePassword")
    public ModelAndView changePassword(){
        ModelAndView modelAndView = new ModelAndView(Pages.PASSWORD);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    /*
    Esta función es muy sencilla, permite al usuario cambiar la contraseña que tiene
    por una nueva y está información se actualiza en la base de datos
    */
    @PostMapping("/editPassword")
    public ModelAndView editPassword(@RequestParam("password") String password){
        Student user = studentMapper.mapToEntity(studentService.findUserStudent(userService.getUser()));
        user.setPassword(password);
        studentDAO.updatePassword(studentMapper.mapStudent(user));
        return loginController.post();
    }


}
