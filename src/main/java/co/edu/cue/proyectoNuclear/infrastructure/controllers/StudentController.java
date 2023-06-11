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
    private ScheduleDAOImpl scheduleDAO;

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
     solo muestra las materias en especifíco de cada estudiante
    */
    @GetMapping("/schedule")
    public ModelAndView scheduleStudent() {
        ModelAndView modelAndView = new ModelAndView(Pages.SCHEDULESTUDENT);
        modelAndView.addObject("user", userService.getUser());
        StudentDto student = studentService.findUserStudent(userService.getUser());
        modelAndView.addObject("userStudent", studentMapper.mapToEntity(student));

        List<LocalTime> hours = Arrays.asList(
                LocalTime.parse("07:00"), LocalTime.parse("08:00"), LocalTime.parse("09:00"), LocalTime.parse("10:00"), LocalTime.parse("11:00"), LocalTime.parse("12:00"),
                LocalTime.parse("13:00"), LocalTime.parse("14:00"), LocalTime.parse("15:00"), LocalTime.parse("16:00"), LocalTime.parse("17:00"), LocalTime.parse("18:00"),
                LocalTime.parse("19:00"), LocalTime.parse("20:00"), LocalTime.parse("21:00"), LocalTime.parse("22:00")
        );


        List<String> days = Arrays.asList(
                "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"
        );

        List<ScheduleDto> allSchedules = scheduleDAO.getTableList();
        List<ScheduleDto> studentSchedules = new ArrayList<>();

        for (ScheduleDto schedule : allSchedules) {
            for (Subject subject : student.subject()) {
                if (schedule.subject().getId().equals(subject.getId())) {
                    System.out.println(schedule.start().toString());
                    System.out.println(schedule.start());
                    studentSchedules.add(schedule);
                }
            }
        }

        modelAndView.addObject("hours", hours);
        modelAndView.addObject("days", days);
        modelAndView.addObject("studentSchedules", studentSchedules);
        modelAndView.addObject("student",studentService.findUserStudent(userService.getUser()));
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
