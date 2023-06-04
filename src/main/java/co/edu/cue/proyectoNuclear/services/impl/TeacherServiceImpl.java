package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.infrastructure.dao.*;
import co.edu.cue.proyectoNuclear.mapping.dtos.TeacherDto;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserDto;
import co.edu.cue.proyectoNuclear.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDAOImpl teacherDAO;


    @Override
    public void createTeacher(UserDto user, TeacherDto teacher) {
        teacherDAO.save(teacher);
    }

    @Override
    public void editTeacher(UserDto user, TeacherDto teacher) {
        teacherDAO.update(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherDAO.deleteById(id);

    }

    @Override
    public TeacherDto getById(Long id) {
        return teacherDAO.findById(id);
    }
}
