package truongph.java_spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import truongph.java_spring.entity.Student;

// abstraction
@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
//  Iterable<Student> findAllByFullName(String fullName);

  @Query("select s from Student s where  s.fullName like %:keyword%")
  Iterable<Student> search(@Param("keyword") String keyword);
}
