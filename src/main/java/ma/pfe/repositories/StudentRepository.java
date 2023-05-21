package ma.pfe.repositories;

import ma.pfe.entities.StudentEntity;
import ma.pfe.entities.StudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, StudentId> {

}
