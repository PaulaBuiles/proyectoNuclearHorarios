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
    private final LoginController loginController; // Controlador de inicio de sesión (dependencia)
    @Autowired
    private final TeacherService teacherService; // Servicio de maestros (dependencia)
    @Autowired
    private final UserService userService; // Servicio de usuarios (dependencia)
    @Autowired
    private final AvailabilityService availabilityService; // Servicio de disponibilidad (dependencia)
    @Autowired
    private final SubjectService subjectService; // Servicio de asignaturas (dependencia)
    @Autowired
    private final ClassroomService classroomService; // Servicio de aulas (dependencia)
    @Autowired
    private final ScheduleService scheduleService; // Servicio de horarios (dependencia)
    @Autowired
    private final TeacherMapper teacherMapper; // Mapper de maestros (dependencia)
    @Autowired
    private final SubjectMapper subjectMapper; // Mapper de asignaturas (dependencia)
    @Autowired
    private final TeacherDAOImpl teacherDAO; // Implementación del DAO de maestros (dependencia)

    // Obtiene la información de todos los maestros
    @GetMapping("/teacher-information")
    public ModelAndView getInformation() {
        List<TeacherDto> teacherList = teacherService.generateTeacher();
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHERINFORMATION);
        modelAndView.addObject("teachers", teacherList);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    // Página de inicio para los maestros
    @GetMapping("/home-teacher")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHERHOME);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    // Obtiene la información del maestro actualmente autenticado
    @GetMapping("/info-teacher")
    public ModelAndView info() {
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHERINFORMATION);
        modelAndView.addObject("userTeacher", teacherService.findUserTeacher(userService.getUser()));
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    // Vista para editar la información del maestro actualmente autenticado
    @GetMapping("/edit-teacher")
    public ModelAndView edit() {
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHEREDIT);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    // Realiza cambios en la información del maestro actualmente autenticado
    @PostMapping("/changes-teacher")
    public ModelAndView changes(@RequestParam("name") String name, @RequestParam("email") String email) {
        teacherService.editTeacher(name, email);
        return info();
    }

    // Vista para realizar una reserva de aula
    @GetMapping("/reservation")
    public ModelAndView reservationTeacher() {
        ModelAndView modelAndView = new ModelAndView(Pages.ADD_RESERVATION);
        modelAndView.addObject("classrooms", classroomService.generateClassroom());
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    // Vista para agregar disponibilidad de horario para el maestro
    @GetMapping("/add-availability")
    public ModelAndView addAvailability() {
        ModelAndView modelAndView = new ModelAndView(Pages.TEACHERAVAILABILITY);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    // Agrega una nueva disponibilidad de horario para el maestro
    @PostMapping("/newAvailability")
    public ModelAndView changesAvailability(@RequestParam("day") int day, @RequestParam("start") String startRequest, @RequestParam("end") String endRequest) {
        LocalTime start = LocalTime.parse(startRequest);
        LocalTime end = LocalTime.parse(endRequest);
        availabilityService.newAvailability(day, start, end, teacherService.findUserTeacher(userService.getUser()));
        return info();
    }

    // Vista para cambiar la contraseña del maestro actualmente autenticado
    @GetMapping("/changePassword")
    public ModelAndView changePassword() {
        ModelAndView modelAndView = new ModelAndView(Pages.CHANGEPASSSWORD);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    // Actualiza la contraseña del maestro actualmente autenticado
    @PostMapping("/editPassword")
    public ModelAndView editPassword(@RequestParam("password") String password) {
        Teacher user = teacherMapper.mapToEntity(teacherService.findUserTeacher(userService.getUser()));
        user.setPassword(password);
        teacherDAO.updatePassword(teacherMapper.mapTeacher(user));
        return loginController.post();
    }

    // Elimina la disponibilidad de horario del maestro según el ID proporcionado
    @GetMapping("/eliminar/{id}")
    public ModelAndView deleteAvailability(@PathVariable("id") Long id) {
        teacherService.deleteById(userService.getUser().id(), id);

        return info();
    }

    // Vista para editar la disponibilidad de horario del maestro según el ID proporcionado
    @GetMapping("/editar/{id}")
    public ModelAndView editAvailability(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView(Pages.EDITAVAILABILITY);
        modelAndView.addObject("idAvailability", id);
        modelAndView.addObject("user", userService.getUser());
        return modelAndView;
    }

    // Actualiza la disponibilidad de horario del maestro según el ID y los parámetros proporcionados
    @PostMapping("/change-availability/{id}")
    public ModelAndView editChangeAvailability(@PathVariable("id") Long id, @RequestParam("day") int day, @RequestParam("start") String startRequest, @RequestParam("end") String endRequest) {
        LocalTime start = LocalTime.parse(startRequest);
        LocalTime end = LocalTime.parse(endRequest);
        teacherService.editAvailability(id, day, start, end, teacherService.findUserTeacher(userService.getUser()));
        return info();
    }

    // Realiza una reserva de asignatura según los parámetros proporcionados
    @PostMapping("/new-reservation")
    public ModelAndView addReservation(@RequestParam("credit") int credit, @RequestParam("name") String name, @RequestParam("classroom") Long classroom, @RequestParam("teacher") String teacher, @RequestParam("day") int day, @RequestParam("durability") String durability, @RequestParam("start") String startRequest, @RequestParam("end") String endRequest) {
        LocalTime start = LocalTime.parse(startRequest);
        LocalTime end = LocalTime.parse(endRequest);
        Time duration = new Time(Integer.parseInt(durability), 00, 00);
        DayOfWeek dayOfWeek = DayOfWeek.getByValue(day);
        if (scheduleService.verifyAvailability(dayOfWeek, start, end, classroomService.getById(classroom).name())) {
            subjectService.addSubject(name, teacherService.findUserTeacher(userService.getUser()).id(), credit, classroom);
            return confirmReservation(name, day, startRequest, endRequest, durability);
        } else {
            ModelAndView modelAndView = new ModelAndView(Pages.ADD_RESERVATION);
            modelAndView.addObject("classrooms", classroomService.generateClassroom());
            modelAndView.addObject("user", userService.getUser());
            modelAndView.addObject("message", "Salón ocupado en ese horario, intente otra opción");
            return modelAndView;
        }
    }

    // Confirma una reserva de asignatura según los parámetros proporcionados
    @PostMapping("/confirmReservation")
    public ModelAndView confirmReservation(String name, int day, String startRequest, String endRequest, String durability) {
        SubjectDto subjectDto = subjectService.getSubjectByTeacher(name, teacherService.findUserTeacher(userService.getUser()));
        LocalTime start = LocalTime.parse(startRequest);
        LocalTime end = LocalTime.parse(endRequest);
        Time duration = new Time(Integer.parseInt(durability), 00, 00);
        DayOfWeek dayOfWeek = DayOfWeek.getByValue(day);
        scheduleService.asingSubject(null, dayOfWeek, duration, start, end, subjectMapper.mapToEntity(subjectDto));
        return teacherSchedule();
    }

    // Vista del horario del maestro
    @GetMapping("/schedule-teacher")
    public ModelAndView teacherSchedule() {
        ModelAndView modelAndView = new ModelAndView(Pages.SCHEDULE_TEACHER);
        modelAndView.addObject("user", userService.getUser());
        modelAndView.addObject("hours", userService.getHoursList());
        modelAndView.addObject("days", userService.getDaysList());
        modelAndView.addObject("teacherSchedules", userService.getUserSchedule(teacherService.findUserTeacher(userService.getUser()).subjects()));
        return modelAndView;
    }
}

