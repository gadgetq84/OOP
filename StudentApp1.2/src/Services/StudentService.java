package Services;

import java.util.ArrayList;
import java.util.List;

import Domen.AverageAge;
import Domen.PersonComparator;
import Domen.Student;

public class StudentService implements iPersonService<Student> {
    private int count;
    private List<Student> students;

    public StudentService() {
        this.students = new ArrayList<Student>();
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public Student create(String firstName, int age) {
        Student per = new Student(firstName,age,count);
        count++;
        students.add(per);
        return per;   
    }    
    public int getAgeAverage()
    {
        AverageAge<Student> avr = new AverageAge<>();
        return avr.getAverageAge(students);
        
    }
    public void sortByFIOStdLst()
    {
       // List<Student> newStudentList = new ArrayList<Student>(students);
        students.sort( new PersonComparator<Student>());
        //return newStudentList;
    }


}
