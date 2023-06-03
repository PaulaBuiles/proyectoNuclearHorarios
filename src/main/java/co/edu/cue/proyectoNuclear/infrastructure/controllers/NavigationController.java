package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.infrastructure.dao.UserDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
import co.edu.cue.proyectoNuclear.services.StudentService;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/navigation")
@AllArgsConstructor
@Controller
public class NavigationController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final StudentService studentService;

    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView(Pages.STUDENTHOME);
        return modelAndView;
    }
    @GetMapping("/info")
    public ModelAndView info(){
        ModelAndView modelAndView = new ModelAndView(Pages.STUDENTINFORMATION);
        modelAndView.addObject("userStudent",studentService.findUserStudent(userService.getUser()));
        return modelAndView;
    }
    @GetMapping("/schedule")
    public ModelAndView schedule(){
        ModelAndView modelAndView = new ModelAndView(Pages.STUDENTHOME);
        return modelAndView;
    }
    @GetMapping("/management")
    public ModelAndView management(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINHOME);
        return modelAndView;
    }
    @GetMapping("/edit")
    public ModelAndView edit(){
        ModelAndView modelAndView = new ModelAndView(Pages.CHANGES);
        return modelAndView;
    }
    @PostMapping("/changes")
    public ModelAndView changes(@RequestParam("name") String name, @RequestParam("email") String email){
        User user = userMapper.mapToEntity(userService.getUser());
        user.setName(name);
        user.setEmail(email);
        userDAO.update(userMapper.mapUser(user));
        return info();
    }
}
