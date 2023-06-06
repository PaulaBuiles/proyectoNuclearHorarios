package co.edu.cue.proyectoNuclear.services.impl;


import co.edu.cue.proyectoNuclear.infrastructure.dao.ClassroomDAOImpl;
import co.edu.cue.proyectoNuclear.mapping.dtos.ClassroomDto;
import co.edu.cue.proyectoNuclear.services.ClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    ClassroomDAOImpl classroomDAO;

    public static ClassroomDto classroomDto;


    @Override
    public List<ClassroomDto> generateClassroom() {
        List<ClassroomDto> classroomDtos = classroomDAO.getTableList();
        return classroomDtos;
    }

    @Override
    public void createClassroom(ClassroomDto classroomDto) {
        classroomDAO.save(classroomDto);
    }

    @Override
    public void editClassroom(ClassroomDto classroomDto) {
        classroomDAO.update(classroomDto);
    }

    @Override
    public void deleteClassroomById(Long id) {
        classroomDAO.delete(id);

    }
    public ClassroomDto getClassroomDto() {
        return classroomDto;
    }

}
