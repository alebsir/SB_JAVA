package ma.pfe.controllers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;
import ma.pfe.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService service;

    @PostMapping
    public Long save(@RequestBody StudentDto dto) {
        LOGGER.debug("start methode save: " ,dto);
        return service.save(dto);
    }

    @PutMapping
    public Long update(@RequestBody StudentDto dto) {
        LOGGER.debug("start methode update",dto);
        return service.update(dto);
    }

    @DeleteMapping("/{ids}/{code}")
    public boolean delete(@PathVariable("ids")Long id,@PathVariable("code")String code) {
        LOGGER.debug("start methode delete",id);
        StudentIdDto idCompos = new StudentIdDto(id, code);
        return service.delete(idCompos);
    }

    @GetMapping
    public List<StudentDto> selectAll() {
        LOGGER.debug("start methode selectAll");
        return service.selectAll();
    }

    //get by id and code

    @GetMapping("/{ids}/{code}")
    public StudentDto selectById(@PathVariable("ids")Long id,@PathVariable("code")String code) {
        LOGGER.debug("start methode selectById",id,code);
        StudentIdDto idCompos = new StudentIdDto(id, code);
        return service.selectById(idCompos);
    }



}
