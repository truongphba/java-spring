package truongph.java_spring.repository;

import truongph.java_spring.entity.Student;

import java.util.ArrayList;

//làm việc với db, không có nhiều xử lý logic
public class MemoryStudentRepository {
    private static ArrayList<Student> list = new ArrayList<>();

    public boolean save(Student student){
        list.add(student);
        return true;
    }

    public ArrayList<Student> findAll(){
        return list;
    }

}
