package com.example.SpringMySqlApp2.myController;

import com.example.SpringMySqlApp2.model.Student;
import com.example.SpringMySqlApp2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    @GetMapping("/students/{accountNo}")
    public  Student findStudentByAccountNo(@PathVariable Long accountNo){
        return studentRepository.findByAccountNo(accountNo);
    }

    @PostMapping("/AddStudent")
    public long saveBook(@RequestBody Student st){
        studentRepository.save(st);
        return st.getId();
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteStudentById(@PathVariable("id") long id){
        studentRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllStudent(){
        studentRepository.deleteAll();
    }

    @PutMapping("/updateStudentById/{id}")
    private void updateStudent(@PathVariable("id") long stuid,
                               @RequestBody Student stuObj){

        Optional<Student> studata = studentRepository.findById(stuid);
        if(studata.isPresent()){
            Student s = studata.get();
            s.setName(stuObj.getName());
            s.setAccountNo(stuObj.getAccountNo());
            s.setId(stuObj.getId());
            s.setMarks(stuObj.getMarks());
            studentRepository.save(s);
        }

    }


}
