//package truongph.java_spring.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import truongph.java_spring.entity.Student;
//import truongph.java_spring.util.DatetimeUtil;
//
//import java.util.Calendar;
//
////Chứa phần lớn thuộc tính từ Student và một số thuộc tính sửa đổi
//@Getter
//@Setter
//@NoArgsConstructor
//public class StudentDTO {
//    private String rollNumber;
//    private String fullName;
//    private String email;
//    private int status;
//    private String createdAt;
//    private String updatedAt;
//    private String username;
//    private String password;
//    private int accountStatus;
//
//    public StudentDTO(Student student){
//        this.rollNumber = student.getRollNumber();
//        this.fullName = student.getFullName();
//        this.email = student.getEmail();
//        this.createdAt = DatetimeUtil.convertLongToString(student.getCreatedAt());
//        this.updatedAt = DatetimeUtil.convertLongToString(student.getUpdatedAt());
//        this.status = student.getStatus();
//        this.username = student.getAccount().getUsername();
//        this.password = student.getAccount().getPassword();
//        this.accountStatus = student.getAccount().getStatus();
//    }
//
//    public Student getStudentInstance() {
//        Student student = new Student();
//        return student;
//    }
//}
