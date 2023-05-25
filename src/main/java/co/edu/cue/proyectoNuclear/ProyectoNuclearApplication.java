package co.edu.cue.proyectoNuclear;

import co.edu.cue.proyectoNuclear.domain.entities.User;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	@Override
	public void run(String... args) throws Exception {
		List<User> userList = userGeneralDAO.getTableList();
		for (User user : userList) {
			System.out.println(user.getName());
		}


	}

}
