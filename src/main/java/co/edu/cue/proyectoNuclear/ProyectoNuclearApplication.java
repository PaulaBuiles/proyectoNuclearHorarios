package co.edu.cue.proyectoNuclear;

import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.domain.entities.Subject;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.domain.enums.Semester;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.StudentDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AdministrativeMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.TeacherMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
import co.edu.cue.proyectoNuclear.services.StudentService;
import co.edu.cue.proyectoNuclear.services.TeacherService;
import co.edu.cue.proyectoNuclear.services.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class ProyectoNuclearApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoNuclearApplication.class, args);
    }

    @Autowired
    public StudentService studentService;

    @Autowired
    public TeacherService teacherService;


    @Autowired
    public TeacherMapper mapper;


    @Override
    public void run(String... args) throws Exception {

        /*Teacher teacher = mapper.mapToEntity(teacherService.getById(1L));

        List<Subject> subjects = new ArrayList<>();
        Subject subject = Subject.builder()
                .name("test")
                .credit(3)
                .teacher(teacher)
                .build();

        subjects.add(subject);
        //Crear un estudiante

        studentService.createStudent(new StudentDto(1094L, "Monica", "email", "password", "role", "carrera", Semester.SEMESTER3,subjects ));
*/
        //	studentService.addSubject(2L,1L);

		/*Administrative administrative = new Administrative(new User(56L, "Samuel", "sberrio@gmail.com", "123", "Administrativo"), "Holaaaaa");
		AdministrativeDto adminDto = administrativeMapper.mapAdministrative(administrative);
		System.out.println(adminDto.user().getName());
		UserDto userDto = userMapper.mapUser(adminDto.user());
		userDAO.save(userDto);
		administrativeDAO.save(adminDto);*/




		/*userGeneralDAO.getTableList();
		System.out.println("");
		subjectDAO.getTableList();
		System.out.println("");
		teacherDAO.getTableList();
		System.out.println("");
		studentDAO.getTableList();
		System.out.println("");
		scheduleDAO.getTableList();
		System.out.println("");
		historyStudentDAO.getTableList();
		System.out.println("");
		historyTeacherDAO.getTableList();
		System.out.println("");
		elementDAO.getTableList();
		System.out.println("");
		courseDAO.getTableList();
		System.out.println("");
		classroomDAO.getTableList();
		System.out.println("");
		characteristicDAO.getTableList();
		System.out.println("");
		availabilityDAO.getTableList();
		System.out.println("");
		administrativeDAO.getTableList();*/
    }

}
