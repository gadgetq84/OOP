package Controllers;

import Domen.Student;
import Domen.Teacher;
import Services.StudentService;

public class StudentController implements iPersonController<Student> {
    private final StudentService dataService = new StudentService();

    // Метод регистрации студената в базе данных
    @Override
    public Student create(String firstName, int age) {
        Student student = dataService.create(firstName, age);
        dataService.sortByFIOStdLst();
        return student;
    }

    public void PrintAll() {
        for (Student item : dataService.getAll()) {
            System.out.println(item.toString());
        }
    }

        // вызов из сервиса среднего возраста
    public int getAverageAge() {
        return dataService.getAgeAverage();
    }

}