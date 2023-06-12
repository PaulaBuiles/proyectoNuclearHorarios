package co.edu.cue.proyectoNuclear;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoNuclearApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoNuclearApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

        //Funcion para comprobar el horario
        Time localTime = new Time(2,0,0);
        SubjectDto subject = subjectDAO.findById(2L);

        scheduleService.asingSubject(3L, DayOfWeek.MONDAY, localTime, LocalTime.of(12,0),LocalTime.of(14,0),subjectMapper.mapToEntity(subject));
        //studentDAO.addSubject()



        /*Teacher teacher = mapper.mapToEntity(teacherService.getById(1L));

        List<Subject> subjects = new ArrayList<>();
        Subject subject = Subject.builder()
                .name("test")
                .credit(3)
                .teacher(teacher)
                .build();



        subjects.add(subject);
        //Crear un estudiante

        //studentService.createStudent(new StudentDto(1094L, "Monica", "email", "password", "role", "carrera", Semester.SEMESTER3,subjects ));
        studentService.createStudent(new StudentDto(1234L, "Cris", "email", "password", "role", "carrera1", Semester.SEMESTER2,subjects ));
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
