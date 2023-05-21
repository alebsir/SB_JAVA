package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;
import ma.pfe.mappers.StudentMapper;
import ma.pfe.repositories.StudentRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private static final  Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository studentRepository;

    private StudentMapper studentMapper= Mappers.getMapper(StudentMapper.class);


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    @Override
    public Long save(StudentDto dto) {
        LOGGER.debug("Start Methode Save");
        StudentDto studentDTO = studentMapper.convertToDto(studentRepository.save(studentMapper.convertToEntity(dto)));
        return studentDTO.getStudentId().getId();
    }

    @Override
    public Long update(StudentDto dto) {
        LOGGER.debug("Start Methode update");
        StudentDto studentDTO = studentMapper.convertToDto(studentRepository.save(studentMapper.convertToEntity(dto)));
        return studentDTO.getStudentId().getId();
    }

    public Boolean delete(StudentIdDto idCompos) {
        LOGGER.debug("Start Methode delete");
        studentRepository.deleteById(studentMapper.studentIdDtoToStudentId(idCompos));
        return true;
    }

    @Override
    public List<StudentDto> selectAll() {
        LOGGER.debug("Start Methode selectAll");
        return studentMapper.convertToDtos(studentRepository.findAll());
    }

    @Override
    public StudentDto selectById(StudentIdDto idCompos) {
        return  studentMapper.convertToDto(studentRepository.findById(studentMapper.studentIdDtoToStudentId(idCompos)).orElse(null));
    }

}
