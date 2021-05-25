package truongph.java_spring.controller;

import org.springframework.web.bind.annotation.*;
import truongph.java_spring.entity.Student;

import java.util.ArrayList;

@RestController
@RequestMapping("/students")
public class HelloController {
    private static ArrayList<Student> list = new ArrayList<>();
    HelloController(){
        list.add(new Student("A001","truongph","truongph.ba@gmail.com"));
        list.add(new Student("A002","namph","namph.ba@gmail.com"));
        list.add(new Student("A003","ducnm","ducnm.ba@gmail.com"));
        list.add(new Student("A004","bangnd","bangnd.ba@gmail.com"));
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Student> getList(){
        return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getDetail(@PathVariable String id){
        Student student = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                student = list.get(i);
                break;
            }
        }
        return student;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student){
        list.add(student);
        return student;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Student updateStudent(@PathVariable String id,@RequestBody Student student){
        Student currentStudent = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                currentStudent = list.get(i);
                break;
            }
        }
        currentStudent.setFullName(student.getFullName());
        currentStudent.setEmail(student.getEmail());
        return currentStudent;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteStudent(@PathVariable String id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                list.remove(i);
                break;
            }
        }
        return true;
    }

}
