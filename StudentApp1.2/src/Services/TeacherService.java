package Services;

import java.util.ArrayList;
import java.util.List;

import Domen.AverageAge;
import Domen.PersonComparator;
import Domen.Teacher;

public class TeacherService implements iPersonService<Teacher> {

    private List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<Teacher>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public Teacher create(String firstName, int age) {

        Teacher teach = new Teacher(firstName, age);
        teachers.add(teach);
        return teach;
    }


    public void sortByFIOStdLst() {
        // List<Student> newStudentList = new ArrayList<Student>(students);
         teachers.sort( new PersonComparator<Teacher>());
        // return newStudentList;
    }

    public int getAgeAverage()
    {
        AverageAge<Teacher> avr = new AverageAge<>();
        return avr.getAverageAge(teachers);    
    }


}
