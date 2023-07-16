package Model;

import java.util.List;
import java.util.stream.Collectors;

import Controller.iGetModel;

public class ModelList implements iGetModel {
    private List<Student> students;

    public ModelList(List<Student> students) {
        this.students = students;
    }

    public List<Student> getAllStudents()
    {
        return students;
    }

    @Override
    public void deleteSelStud(Student std) {    
            this.getAllStudents().remove(std);
    }


    @Override
    public List<Student> getFoundStudByName(String stdName) {
        List<Student> result = this.getAllStudents().stream().filter(item -> item.getName().equals(stdName))
        .collect(Collectors.toList());
        return result;
        
    }

    @Override
    public List<Student> getFoundStudById(int id) {
        List<Student> result = this.getAllStudents().stream().filter(item -> Integer.valueOf(item.getId()).equals(id))
        .collect(Collectors.toList());
        return result;
    }

    
}
