package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import Controller.iGetModel;

public class hashModel implements iGetModel {

    private HashMap<Long, Student> students;
    List<Student> list = new ArrayList<Student>();

    public hashModel(HashMap<Long, Student> students) {
        this.students = students;
    }

    @Override
    public List<Student> getAllStudents() {
        list.clear();
        list.addAll(students.values());
        return list;
    }

    @Override
    public void deleteSelStud(Student std) {
        this.students.remove((long)std.hashCode());
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
