package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import co.edu.cue.proyectoNuclear.infrastructure.dao.TeacherDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.SubjectDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.SubjectMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.TeacherMapper;
import co.edu.cue.proyectoNuclear.services.*;
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
    private final LoginController loginController;
    @Autowired
    private final TeacherService teacherService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final AvailabilityService availabilityService;
    @Autowired
    private final SubjectService subjectService;
    @Autowired
    private final ClassroomService classroomService;
    @Autowired
    private final ScheduleService scheduleService;
    @Autowired
    private final TeacherMapper teacherMapper;
    @Autowired
    private final SubjectMapper subjectMapper;
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

    @GetMapping("/reservation")
    public ModelAndView reservationTeacher() {
    ModelAndView modelAndView = new ModelAndView(Pages.ADD_RESERVATION);
        modelAndView.addObject("classrooms",classroomService.generateClassroom());
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
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

    @GetMapping("/schedule-teacher")
    public ModelAndView teacherSchedule(){
        ModelAndView modelAndView = new ModelAndView(Pages.SCHEDULE_TEACHER);
        modelAndView.addObject("user", userService.getUser());
        modelAndView.addObject("hours", userService.getHoursList());
        modelAndView.addObject("days", userService.getDaysList());
        modelAndView.addObject("teacherSchedules", userService.getUserSchedule(teacherService.findUserTeacher(userService.getUser()).subjects()));
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
    public ModelAndView deleteAvailability(@PathVariable("id") Long id) {
        // Eliminar disponibilidad por ID
        teacherService.deleteById(userService.getUser().id(), id);

        System.out.println("controller teacher");
        return info();

    }

    @GetMapping("/editar/{id}")
    public ModelAndView editAvailability(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView(Pages.EDITAVAILABILITY);
        modelAndView.addObject("idAvailability",id);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }
    @PostMapping("/change-availability/{id}")
    public ModelAndView editChangeAvailability(@PathVariable("id") Long id,@RequestParam("day") int day, @RequestParam("start") String startRequest, @RequestParam("end") String endRequest){
        LocalTime start = LocalTime.parse(startRequest);
        LocalTime end = LocalTime.parse(endRequest);
        teacherService.editAvailability(id,day,start,end,teacherService.findUserTeacher(userService.getUser()));
        return info();
    }

    @PostMapping("/new-reservation")
    public ModelAndView addReservation(@RequestParam("credit") int credit, @RequestParam("name") String name, @RequestParam("classroom") Long classroom, @RequestParam("teacher") String teacher, @RequestParam("day") int day, @RequestParam("durability") String durability, @RequestParam("start") String startRequest, @RequestParam("end") String endRequest) {
        subjectService.addSubject(name,teacherService.findUserTeacher(userService.getUser()).id(),credit,classroom);
        SubjectDto subjectDto = subjectService.getSubjectByTeacher(name,teacherService.findUserTeacher(userService.getUser()));
        System.out.println(subjectDto.name()+"--------"+subjectDto.id());
        LocalTime start = LocalTime.parse(startRequest);
        LocalTime end = LocalTime.parse(endRequest);
        Time duration = new Time(Integer.parseInt(durability),00,00);
        DayOfWeek dayOfWeek = DayOfWeek.getByValue(day);
        scheduleService.asingSubject(null,dayOfWeek,duration,start,end,subjectMapper.mapToEntity(subjectDto));
        //availabilityService.newAvailability(day, start, end, teacherService.findUserTeacher(userService.getUser()));
        return teacherSchedule();
    }



}
