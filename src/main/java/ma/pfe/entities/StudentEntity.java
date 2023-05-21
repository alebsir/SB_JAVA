package ma.pfe.entities;

import javax.persistence.*;
import java.util.List;

// @Embeddable @EmbeddedId
@Entity
@Table(name = "Student_test")
public class StudentEntity {

    @EmbeddedId
    private StudentId studentId;
    private Adresse adresse;

    @Column(name = "name_student")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<CourseEntity> courses;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private NiveauEntity niveau;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="rue",column = @Column(name = "rue_student")),
            @AttributeOverride(name="avenue",column = @Column(name = "avenue_student"))
    })

    public StudentId getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentId studentId) {
        this.studentId = studentId;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    public NiveauEntity getNiveau() {
        return niveau;
    }

    public void setNiveau(NiveauEntity niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studentId=" + studentId +
                ", adresse=" + adresse +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                ", niveau=" + niveau +
                '}';
    }
}
