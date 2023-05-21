package ma.pfe.dtos;

import javax.persistence.EmbeddedId;
import java.util.List;

public class StudentDto {

    @EmbeddedId
    private StudentIdDto studentId;
    private AdresseDto adresse;
    private String name;
    private NiveauDto niveau;
    private List<CoursDto> courses;


    public StudentIdDto getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentIdDto studentId) {
        this.studentId = studentId;
    }

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NiveauDto getNiveau() {
        return niveau;
    }

    public void setNiveau(NiveauDto niveau) {
        this.niveau = niveau;
    }

    public List<CoursDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursDto> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "studentId=" + studentId +
                ", adresse=" + adresse +
                ", name='" + name + '\'' +
                ", niveau=" + niveau +
                ", courses=" + courses +
                '}';
    }
}
