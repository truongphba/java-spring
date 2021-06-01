package truongph.java_spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import truongph.java_spring.entity.Student;



public interface StudentJpaRepository extends JpaRepository<Student, String> {
    @Query("select s from Student s where  s.fullName like %:keyword%")
    Page<Student> searchByName(@Param("keyword") String keyword, Pageable pageable);

    @Query("select s from Student s where s.fullName like %:keyword% or s.email like %:keyword%")
    Page<Student> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);

    @Query("select s from Student s where (s.fullName like %:keyword% or s.email like %:keyword%) and s.status = :status")
    Page<Student> searchByNameAndEmail(@Param("keyword") String keyword,@Param("status") int status , Pageable pageable);

}
