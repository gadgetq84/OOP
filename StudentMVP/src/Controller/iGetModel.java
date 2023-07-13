package Controller;

import java.util.HashMap;
import java.util.List;

import Model.Student;

public interface iGetModel {
    public List<Student> getAllStudents();
    public void deleteSelStud(Student std);
    public List<Student> getFoundStudByName(String stdName);
    public List<Student> getFoundStudById(int id);
}


