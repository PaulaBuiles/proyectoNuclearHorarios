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
    public void editAvailability(Long id,int day, LocalTime start, LocalTime end, TeacherDto teacherDto) {
        
        //Función
        Teacher teacher = teacherMapper.mapToEntity(teacherDto);
        List<TeacherDto> teacherDtoList = teacherDAO.getTableList();
        DayOfWeek[] daysOfWeek = DayOfWeek.values();
        DayOfWeek dayOfWeek = daysOfWeek[day];

        for (TeacherDto teacherDto1 : teacherDtoList) {
            if (teacherDto1.id().equals(teacherDto.id())) {
                for(Availability availabilityList: teacherDto1.availability())
                    if(availabilityList.getId().equals(id)) {
                        availabilityList.setDayOfWeek(dayOfWeek);
                        availabilityList.setStart(start);
                        availabilityList.setEnd(end);
                        availabilityDAO.update(availabilityList); // Actualiza la disponibilidad en la tabla Availability
                        teacherDAO.update(teacher); // Actualiza el profesor en la tabla Teacher
                    }
            }
        }


    }
    @Override
    public void deleteById(Long idTeacher, Long id) {
        List<TeacherDto> teacherDtoList = teacherDAO.getTableList();
        for (TeacherDto teacherDto : teacherDtoList) {
            if (teacherDto.id().equals(idTeacher)) {
                List<Availability> availabilities = teacherDto.availability();
                availabilities.removeIf(availability -> availability.getId().equals(id));
                availabilityDAO.delete(id);
                teacherDAO.update(teacherMapper.mapToEntity(teacherDto));
            }
        }

    }
}
