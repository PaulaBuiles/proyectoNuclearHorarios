package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.infrastructure.dao.StudentDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.mappers.StudentMapper;
import co.edu.cue.proyectoNuclear.services.StudentService;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



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

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView =new ModelAndView(Pages.STUDENTHOME);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }

    @GetMapping("/info")
    public ModelAndView info(){
        ModelAndView modelAndView = new ModelAndView(Pages.STUDENTINFORMATION);
        modelAndView.addObject("userStudent",studentService.findUserStudent(userService.getUser()));
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }
    @GetMapping("/edit")
    public ModelAndView edit(){
        ModelAndView modelAndView =new ModelAndView(Pages.CHANGES);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }
    @PostMapping("/changes")
    public ModelAndView changes(@RequestParam("name") String name, @RequestParam("email") String email){
        Student user = studentMapper.mapToEntity(studentService.findUserStudent(userService.getUser()));
        user.setName(name);
        user.setEmail(email);
        studentService.editStudent(name,email);
        return info();
    }
    @GetMapping("/schedule")
    public ModelAndView scheduleStudent(){
        ModelAndView modelAndView =new ModelAndView(Pages.SCHEDULESTUDENT);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }
    @GetMapping("/changePassword")
    public ModelAndView changePassword(){
        ModelAndView modelAndView = new ModelAndView(Pages.PASSWORD);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }
    @PostMapping("/editPassword")
    public ModelAndView editPassword(@RequestParam("password") String password){
        Student user = studentMapper.mapToEntity(studentService.findUserStudent(userService.getUser()));
        user.setPassword(password);
        studentDAO.updatePassword(studentMapper.mapStudent(user));
        return loginController.post();
    }

}
