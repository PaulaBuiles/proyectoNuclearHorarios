package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.Student;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.infrastructure.dao.AvailabilityDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.TeacherDAOImpl;
import co.edu.cue.proyectoNuclear.infrastructure.dao.UserDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.TeacherMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
import co.edu.cue.proyectoNuclear.services.AvailabilityService;
import co.edu.cue.proyectoNuclear.services.TeacherService;
import co.edu.cue.proyectoNuclear.services.UserService;
import co.edu.cue.proyectoNuclear.services.impl.AvailabilityServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@AllArgsConstructor
@Controller
public class TeacherController {
    private final LoginController loginController;
    @Autowired
    private final TeacherService teacherService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final AvailabilityService availabilityService;
    @Autowired
    private final TeacherMapper teacherMapper;
    @Autowired
    private final TeacherDAOImpl teacherDAO;

    @GetMapping("/teacher-information")
    public ModelAndView getInformation() {
        List<TeacherDto> teacherList = teacherService.generateTeacher();
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHERINFORMATION);
        modelAndView.addObject("teachers", teacherList);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    @GetMapping("/home-teacher")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHERHOME);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    @GetMapping("/info-teacher")
    public ModelAndView info() {
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHERINFORMATION);
        modelAndView.addObject("userTeacher", teacherService.findUserTeacher(userService.getUser()));
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    @GetMapping("/edit-teacher")
    public ModelAndView edit() {
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHEREDIT);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }


    @PostMapping("/changes-teacher")
    public ModelAndView changes(@RequestParam("name") String name, @RequestParam("email") String email) {
        teacherService.editTeacher(name, email);
        return info();
    }

    @GetMapping("/add-availability")
    public ModelAndView addAvailability() {
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHERAVAILABILITY);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    @PostMapping("/newAvailability")
    public ModelAndView changesAvailability(@RequestParam("day") int day, @RequestParam("start") String startRequest, @RequestParam("end") String endRequest) {
        LocalTime start = LocalTime.parse(startRequest);
        LocalTime end = LocalTime.parse(endRequest);
        availabilityService.newAvailability(day, start, end, teacherService.findUserTeacher(userService.getUser()));
        return info();
    }
    @GetMapping("/changePassword")
    public ModelAndView changePassword(){
        ModelAndView modelAndView = new ModelAndView(Pages.CHANGEPASSSWORD);
        modelAndView.addObject("user",userService.getUser());
        return modelAndView;
    }
    @PostMapping("/editPassword")
    public ModelAndView editPassword(@RequestParam("password") String password){
        Teacher user = teacherMapper.mapToEntity(teacherService.findUserTeacher(userService.getUser()));
        user.setPassword(password);
        teacherDAO.updatePassword(teacherMapper.mapTeacher(user));
        return loginController.post();
    }


    @GetMapping("/eliminar/{id}")
    public ModelAndView eliminarDisponibilidad(@PathVariable("id") Long id) {
        // Eliminar disponibilidad por ID
        teacherService.deleteById(userService.getUser().id(), id);

        System.out.println("controller teacher");
        return info();

    }

    @GetMapping("/edit-availability")
    public ModelAndView editAvailability() {
        ModelAndView modelAndView = new ModelAndView(Pages.EDITAVAILABILITY);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }
    @PostMapping("/change-availability")
    public ModelAndView editChangeAvailability(@RequestParam("day") int day, @RequestParam("start") String startRequest, @RequestParam("end") String endRequest){
        LocalTime start = LocalTime.parse(startRequest);
        LocalTime end = LocalTime.parse(endRequest);
        availabilityService.editAvailability(day,start,end,teacherService.findUserTeacher(userService.getUser()));
        return info();
    }



}
