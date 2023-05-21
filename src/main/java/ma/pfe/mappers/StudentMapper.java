package ma.pfe.mappers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;
import ma.pfe.entities.StudentEntity;
import ma.pfe.entities.StudentId;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentEntity convertToEntity(StudentDto dto);
    StudentDto convertToDto(StudentEntity entity);
    List<StudentDto> convertToDtos(List<StudentEntity> studentEntities);
    List<StudentEntity> convertToEntities(List<StudentDto> studentDtos);

    StudentId studentIdDtoToStudentId(StudentIdDto studentIdDto);
}
