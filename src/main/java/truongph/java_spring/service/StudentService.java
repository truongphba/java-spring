package truongph.java_spring.service;

import truongph.java_spring.entity.Student;
import truongph.java_spring.repository.MemoryStudentRepository;

import java.util.ArrayList;

public class StudentService {
    private static MemoryStudentRepository memoryStudentRepository = new MemoryStudentRepository();
    public boolean createStudent(Student student){
        memoryStudentRepository.save(student);
        return true;
    }

    public ArrayList<Student> getList(){
        return memoryStudentRepository.findAll();
    }

}
