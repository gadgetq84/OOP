package View;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Controller.iGetView;
import Model.Student;

public class View implements iGetView  {

    private final String lang = "ru";
    langRu lng;

    public View() {
        this.lng = new langRu();
    }

    public void printAllStudents(List<Student> students) {
        System.out.println(lng.msg4);
        for (Student stud : students) {
            System.out.println(stud);
        }
        System.out.println("===============================");
    }

    @Override
    public void printAllStudent(List<Student> students) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printAllStudent'");
    }

    @Override
    public String prompt(String msg) {
        Scanner in = new Scanner(System.in , "CP866");
        System.out.print(msg);
        return in.nextLine();
    }


    @Override
    public void displayStudents(List<Student> students) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayStudents'");
    }

    @Override
    public Student readStudent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readStudent'");
    }

    @Override
    public Long getStudentIdToUpdate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentIdToUpdate'");
    }

    @Override
    public langRu getLanguage() {
        return this.lng;
    }

    @Override
    public Long getStudentIdToDelete(int id, List<Student> students) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentIdToDelete'");
    }




}
