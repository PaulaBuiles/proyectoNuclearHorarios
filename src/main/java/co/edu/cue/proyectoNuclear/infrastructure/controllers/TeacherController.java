package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import co.edu.cue.proyectoNuclear.infrastructure.dao.UserDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
import co.edu.cue.proyectoNuclear.services.TeacherService;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@AllArgsConstructor
@Controller
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;
    @Autowired
    private final UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDAOImpl userDAO;

    @GetMapping("/teacher-information")
    public ModelAndView getInformation(){
        List<TeacherDto> teacherList = teacherService.generateTeacher();
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHERINFORMATION);
        modelAndView.addObject("teachers",teacherList);
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView(Pages.ADMINHOME);
        return modelAndView;
    }
    @GetMapping("/info")
    public ModelAndView info(){
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHERINFORMATION);
        modelAndView.addObject("userTeacher",teacherService.findUserTeacher(userService.getUser()));
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView edit(){
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHEREDIT);
        return modelAndView;
    }
    @PostMapping("/changes")
    public ModelAndView changes(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("day") String day, @RequestParam("start") Time start, @RequestParam("end") Time end){
        User user = userMapper.mapToEntity(userService.getUser());
       // Availability availability = new Availability(1,day,start,end);
        Teacher teacher = new Teacher();
        user.setName(name);
        user.setEmail(email);
        userDAO.update(userMapper.mapUser(user));
      //  teacher.setAvailability(availability);
        return info();
    }


}
