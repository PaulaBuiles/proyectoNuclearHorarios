package co.edu.cue.proyectoNuclear.services.impl;

import co.edu.cue.proyectoNuclear.domain.entities.Teacher;
import co.edu.cue.proyectoNuclear.infrastructure.dao.GeneralDAO;
import co.edu.cue.proyectoNuclear.services.AdministrativeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdministrativeServiceImpl implements AdministrativeService {

    private GeneralDAO<Teacher> teacherDAO;


    @Override
    public void deleteTeacherById(Long id) {
        teacherDAO.delete(id);
    }

}
