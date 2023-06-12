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

@Service // Anotación de Spring para marcar esta clase como un componente de servicio
@AllArgsConstructor // Anotación de Lombok para generar automáticamente un constructor que acepta todos los campos
public class TeacherServiceImpl implements TeacherService {

    @Autowired // Inyección de dependencias de TeacherDAOImpl
    private TeacherDAOImpl teacherDAO;

    @Autowired // Inyección de dependencias de TeacherMapper
    private TeacherMapper teacherMapper;

    @Autowired // Inyección de dependencias de UserServiceImpl
    private UserServiceImpl userService;

    @Autowired // Inyección de dependencias de AvailabilityDAOImpl
    private AvailabilityDAOImpl availabilityDAO;

    //Funciones para profesores

    @Override
    public List<TeacherDto> generateTeacher() {
        return teacherDAO.getTableList(); // Obtener la lista de profesores
    }

    @Override
    public void createTeacher(String identification, String name, String email, String password, String role) {
        Long id = Long.parseLong(identification);
        TeacherDto teacherDto = new TeacherDto(id, name, email, password, role, true, new ArrayList<>(), new ArrayList<>());
        teacherDAO.save(teacherMapper.mapToEntity(teacherDto)); // Crear un nuevo profesor en la base de datos
    }

    @Override
    public void editTeacher(String name, String email) {
        Teacher user = teacherMapper.mapToEntity(findUserTeacher(userService.getUser()));
        user.setName(name);
        user.setEmail(email);
        teacherDAO.update(user); // Actualizar los datos del profesor en la base de datos
    }

    public TeacherDto findUserTeacher(UserDto user) {
        List<TeacherDto> teacherDtoList = generateTeacher();
        TeacherDto teacherDto = null;
        // Buscar el profesor por el ID del usuario
        for (TeacherDto teacher : teacherDtoList) {
            if (teacher.id().equals(user.id())) {
                teacherDto = teacher;
            }
        }
        return teacherDto;
    }

    @Override
    public TeacherDto getById(Long id) {
        return teacherDAO.findById(id); // Obtener un profesor por su ID
    }

    @Override
    public void editAvailability(Long id, int day, LocalTime start, LocalTime end, TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.mapToEntity(teacherDto);
        List<TeacherDto> teacherDtoList = teacherDAO.getTableList();
        DayOfWeek[] daysOfWeek = DayOfWeek.values();
        DayOfWeek dayOfWeek = daysOfWeek[day];

        for (TeacherDto teacherDto1 : teacherDtoList) {
            if (teacherDto1.id().equals(teacherDto.id())) {
                for (Availability availabilityList : teacherDto1.availability()) {
                    if (availabilityList.getId().equals(id)) {
                        availabilityList.setDayOfWeek(dayOfWeek);
                        availabilityList.setStart(start);
                        availabilityList.setEnd(end);
                        availabilityDAO.update(availabilityList); // Actualiza la disponibilidad en la tabla Availability
                        teacherDAO.update(teacher); // Actualiza el profesor en la tabla Teacher
                    }
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
                availabilityDAO.delete(id); // Eliminar una disponibilidad por su ID
                teacherDAO.update(teacherMapper.mapToEntity(teacherDto)); // Actualizar el profesor en la base de datos
            }
        }
    }
}

