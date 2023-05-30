package co.edu.cue.proyectoNuclear;

import co.edu.cue.proyectoNuclear.domain.entities.Administrative;
import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.AdministrativeDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.AdministrativeMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.TeacherMapper;
import co.edu.cue.proyectoNuclear.mapping.mappers.UserMapper;
import co.edu.cue.proyectoNuclear.services.StudentService;
import co.edu.cue.proyectoNuclear.services.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
@SpringBootApplication
public class ProyectoNuclearApplication implements CommandLineRunner {


	@Autowired
	public UserDAOImpl userGeneralDAO;
	@Autowired
	public SubjectDAOImpl subjectDAO;
	@Autowired
	public TeacherDAOImpl teacherDAO;
	@Autowired
	public StudentDAOImpl studentDAO;
	@Autowired
	public ScheduleDAOImpl scheduleDAO;
	@Autowired
	public HistoryTeacherDAOImpl historyTeacherDAO;
	@Autowired
	public HistoryStudentDAOImpl historyStudentDAO;
	@Autowired
	public ElementDAOImpl elementDAO;
	@Autowired
	public CourseDAOImpl courseDAO;
	@Autowired
	public ClassroomDAOImpl classroomDAO;
	@Autowired
	public CharacteristicDAOImpl characteristicDAO;
	@Autowired
	public AvailabilityDAOImpl availabilityDAO;
	@Autowired
	public AdministrativeDAOImpl administrativeDAO;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoNuclearApplication.class, args);
	}

	@Autowired
	public StudentService studentService;

	@Autowired
	public UserDAOImpl userDAO;

	@Override
	public void run(String... args) throws Exception {

		studentService.addSubject(2L,1L);

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
