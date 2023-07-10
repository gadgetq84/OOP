package Controllers;

import Domen.Teacher;
import Services.TeacherService;

public class TeacherController implements iPersonController<Teacher> {
    private final TeacherService teachService = new TeacherService();

    // Метод создает нового учителя
    @Override
    public Teacher create(String firstName, int age) {
        Teacher teacher = teachService.create(firstName, age);
        return teacher;
    }

    // сортировка через компаратор
    public void sortTeachers() {
        teachService.sortByFIOStdLst();
    }

    // вывод списка в консоль
    public void PrintAll() {
        for (Teacher item : teachService.getAll()) {
            System.out.println(item.toString());
        }
    }

    // вызов из сервиса среднего возраста
    public int getAverageAge() {
        return teachService.getAgeAverage();
    }
}
