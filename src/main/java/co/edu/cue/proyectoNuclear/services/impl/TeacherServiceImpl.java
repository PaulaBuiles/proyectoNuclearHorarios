package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Availability;
import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.domain.enums.DayOfWeek;
import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.mapping.mappers.TeacherMapper;
import co.edu.cue.proyectoNuclear.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDAOImpl teacherDAO;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AvailabilityDAOImpl availabilityDAO;

    //Funciones para profesores
    @Override
    public List<TeacherDto> generateTeacher() {
        List<TeacherDto> teachers = teacherDAO.getTableList();
        return teachers;
    }

    @Override
    public void createTeacher(String identification,String name,String email,String password,String role) {
        Long id = Long.parseLong(identification);
        TeacherDto teacherDto = new TeacherDto(id,name,email,password,role,true,new ArrayList<>(),new ArrayList<>());
        teacherDAO.save(teacherMapper.mapToEntity(teacherDto));
    }

    @Override
    public void editTeacher(String name, String email) {
        Teacher user = teacherMapper.mapToEntity(findUserTeacher(userService.getUser()));
        user.setName(name);
        user.setEmail(email);
        teacherDAO.update(user);
    }

    @Override
    public void deleteTeacherById(Long id) {
        //teacherDAO.deleteById(id);

    }
    public TeacherDto findUserTeacher(UserDto user) {
        List<TeacherDto> teacherDtoList = generateTeacher();
        TeacherDto teacherDto = null;
        for (TeacherDto teacher: teacherDtoList) {
            if (teacher.id().equals(user.id())) {
                teacherDto = teacher;
            }
        }
        return teacherDto;
    }

    @Override
    public TeacherDto getById(Long id) {
        return teacherDAO.findById(id);
    }
    @Override
    public void editAvailability(int day, LocalTime start, LocalTime end, TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.mapToEntity(teacherDto);
        //Availability availability = null;
        DayOfWeek[] daysOfWeek = DayOfWeek.values();
        DayOfWeek dayOfWeek = daysOfWeek[day];

        /*availability.setId(null);
        availability.setDayOfWeek(dayOfWeek);
        availability.setStart(start);
        availability.setEnd(end);
        availability.setTeacher(teacher);*/
        Availability availability = new Availability(null, dayOfWeek, start, end, teacher);
        availabilityDAO.update(availability);


    }
    @Override
    public void deleteById(Long idTeacher, Long id) {
        List<TeacherDto> teacherDtoList = teacherDAO.getTableList();
        System.out.println("fUNCION");
        for (TeacherDto teacherDto : teacherDtoList) {
            if (teacherDto.id().equals(idTeacher)) {
                System.out.println("hola2");
                for (Availability availability: teacherDto.availability()){
                    System.out.println(availability.getId());
                    if (availability.getId().equals(id)){
                        teacherDto.availability().remove(availability);
                        availabilityDAO.delete(availability.getId());
                        teacherDAO.update(teacherMapper.mapToEntity(teacherDto));
                    }
                }
            }
        }

    }
}
