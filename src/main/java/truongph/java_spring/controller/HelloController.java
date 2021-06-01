package truongph.java_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
//import truongph.java_spring.dto.StudentDTO;
import truongph.java_spring.entity.Student;
import truongph.java_spring.repository.StudentJpaRepository;

@RestController
@RequestMapping("/students")
public class HelloController {
    @Autowired
    private StudentJpaRepository studentJpaRepository;

//    private static StudentService studentService = new StudentService();

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Student> getList(@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword, @RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        return studentJpaRepository.searchByKeyword(keyword, PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "createdAt")));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getDetail(@PathVariable String id){
        return studentJpaRepository.findById(id).orElse(null);
    }

//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) {
//        Student student = studentDTO.getStudentInstance();
//        studentJpaRepository.save(student);
//        return studentDTO;
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public Student updateStudent(@PathVariable String id,@RequestBody Student student){
//        Student currentStudent = null;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getRollNumber().equals(id)){
//                currentStudent = list.get(i);
//                break;
//            }
//        }
//        currentStudent.setFullName(student.getFullName());
//        currentStudent.setEmail(student.getEmail());
//        return currentStudent;
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteStudent(@PathVariable String id) {
        Student existStudent = studentJpaRepository.findById(id).orElse(null);
        if (existStudent != null) {
            studentJpaRepository.delete(existStudent);
            return true;
        }
        return false;
    }

}
