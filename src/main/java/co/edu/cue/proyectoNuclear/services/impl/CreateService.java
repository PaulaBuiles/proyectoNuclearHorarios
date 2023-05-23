package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.*;
import co.edu.cue.proyectoNuclear.domain.enums.Campus;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import co.edu.cue.proyectoNuclear.domain.enums.Propertie;
import co.edu.cue.proyectoNuclear.domain.enums.Semester;
import co.edu.cue.proyectoNuclear.services.StudentService;
import co.edu.cue.proyectoNuclear.services.SubjectService;
import co.edu.cue.proyectoNuclear.services.TeacherService;
import co.edu.cue.proyectoNuclear.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreateService {

    public UserService userService;

    public TeacherService teacherService;

    public SubjectService subjectService;

    public StudentService studentService;

    private final List<Classroom> classroomList = new ArrayList<>();
    private final List<Propertie> propertieList = new ArrayList<>();
    private final List<Subject> subjectList = new ArrayList<>();
    private final List<Teacher> teacherList = new ArrayList<>();
    private final List<Student> studentList = new ArrayList<>();
    private final List<User> userList = userService.generateUsers();
    private final List<Availability> availabilityList = new ArrayList<>();


    public void classroomTest(){
        propertieList.add(Propertie.CAMERA);
        propertieList.add(Propertie.PROJECTOR);
        propertieList.add(Propertie.VENTILATOR);
        classroomList.add(new Classroom("1","202",25, Campus.PRINCIPAL,propertieList,subjectList.get(1)));
        classroomList.add(new Classroom("2","104B",32, Campus.PRINCIPAL,propertieList,subjectList.get(2)));
        classroomList.add(new Classroom("3","Sala de sistemas", 32, Campus.NOGAL, propertieList,subjectList.get(2)));
    }


    //Students
//    private static Student student1 = new Student();
//    /*private final GeneralDAO<Student> studentService;*/
//    public Student getStudent() {
//        System.out.printf(student1.toString());
//       /* User user = new User("1","1234","");
//        Student student = new Student();*/
//        return student1;
//    }


    public void generateStudent(){

        //Student student = new Student(userList.get(0),Semester.SEMESTER1,subjectList.get(3));
        //studentList.add(student);
    }

    //Subject
    public void generateSubjects(){
        subjectList.add(new Subject("1","Analisis Numerico",teacherList.get(0).getName(),true,3,studentList.stream()
                .filter(student -> student.getSemester().equals("SEMESTER3"))
                .collect(Collectors.toList())));
        subjectList.add(new Subject("2","Programacion I",teacherList.get(1).getName(),true,4,studentList.stream()
                .filter(student -> student.getSemester().equals("SEMESTER2"))
                .collect(Collectors.toList())));
        subjectList.add(new Subject("3","Algoritmos",teacherList.get(2).getName(),true,4,studentList.stream()
                .filter(student -> student.getSemester().equals("SEMESTER1"))
                .collect(Collectors.toList())));
        subjectList.add(new Subject("4","Programacion I",teacherList.get(3).getName(),true,4,studentList.stream()
                .filter(student -> student.getSemester().equals("SEMESTER4"))
                .collect(Collectors.toList())));
    }

    //Availiability
    public void generateAvailiability(){
        availabilityList.add(new Availability("1", DayOfWeek.MONDAY, LocalTime.of(4,0),LocalTime.of(8,0)));

    }
    //Teacher
    public void generateTeachers(){
        Teacher teacher = new Teacher(userList.get(1),subjectList.get(1),availabilityList.get(1));
        Teacher teacher1 = new Teacher(userList.get(4),subjectList.get(2),availabilityList.get(4));
        teacherList.add(teacher);
    }
}
