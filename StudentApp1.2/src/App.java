import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import Controllers.EmploeeController;
import Controllers.StudentController;
import Controllers.TeacherController;
import Domen.AverageAge;
import Domen.Emploee;
import Domen.Person;
import Domen.PersonComparator;
import Domen.Student;
import Domen.StudentGroup;
import Domen.Teacher;

public class App {
    public static void main(String[] args) throws Exception {

        // Student s1 = new Student("Иван", 25, 121);
        // Student s2 = new Student("Игорь", 23, 301);
        // Student s3 = new Student("Иван", 22, 121);
        // Student s4 = new Student("Игорь", 23, 444);
        // Student s5 = new Student("Даша", 23, 171);
        // Student s6 = new Student("Лена", 23, 104);

        // List<Student> listStud = new ArrayList<Student>();
        // listStud.add(s1);
        // listStud.add(s2);
        // listStud.add(s3);
        // listStud.add(s4);
        // listStud.add(s5);
        // listStud.add(s6);

        // StudentGroup group4580 = new StudentGroup(listStud, 4580);
        // System.out.println(group4580);

        // for(Student std : group4580)
        // {
        // System.out.println(std);
        // }

        // System.out.println("=========================================================");

        // Collections.sort(group4580.getGroup());

        // for(Student std: group4580.getGroup())
        // {
        // System.out.println(std);
        // }

        // Student s1 = new Student("Иван", 25, 121);
        // Student s2 = new Student("Игорь", 23, 301);

        // PersonComparator<Student> comS = new PersonComparator<Student>();
        // comS.compare(s1, s2);

        // Teacher t1 = new Teacher("Иван", 25, "Docent");
        // Teacher t2 = new Teacher("Игорь", 23, "Professor");

        // PersonComparator<Teacher> comT = new PersonComparator<Teacher>();
        // comT.compare(t1, t2);

        // //comS.compare(s1, t2);
        // PersonComparator<Person> comP = new PersonComparator<Person>();
        // comP.compare(s1, t2);

        // Emploee e1 = new Emploee("Федорович", 60, "разнорабочим");
        // EmploeeController empControll = new EmploeeController();
        // EmploeeController.paySalary(e1);
        // EmploeeController.paySalary(s1);
        // empControll.paySalary(e1);
        // empControll.paySalary(s1);

        // объявляем контроллер учителей
        TeacherController teachControll = new TeacherController();
        // заполняемнаш список
        Teacher t1 = teachControll.create("Иван", 25);
        // каждому учителю указываем его степень
        t1.addAcadDegree("Docent");
        Teacher t2 = teachControll.create("Сергей", 35);
        t2.addAcadDegree("Professor");

        Teacher t3 = teachControll.create("Людмила", 45);
        t3.addAcadDegree("Docent");
        Teacher t4 = teachControll.create("Евгений", 33);
        t4.addAcadDegree("Professor");

        Teacher t5 = teachControll.create("Папус", 24);
        t5.addAcadDegree("Docent");
        Teacher t6 = teachControll.create("Дедеус", 29);
        t6.addAcadDegree("Professor");
        // сортировка по имени
        teachControll.sortTeachers();
        // вывод на печать в консоль
        teachControll.PrintAll();
        System.out.println("=========================================================");
        System.out.println("Средний возраст учителей " + teachControll.getAverageAge());
        System.out.println("=========================================================");
        // объявляем контроллер РАБОТНИКОВ
        EmploeeController empControll = new EmploeeController();
        Emploee e1 = empControll.create("Федорович", 60);
        e1.addSpecial("разнорабочим");
        Emploee e2 = empControll.create("Василий", 90);
        e2.addSpecial("Слесарь");
        Emploee e3 = empControll.create("Василий", 40);
        e3.addSpecial("Слесарь");
        Emploee e4 = empControll.create("Василий", 50);
        e4.addSpecial("Слесарь");
        empControll.PrintAll();
        System.out.println("=========================================================");
        System.out.println("Средний возраст Работников " + empControll.getAverageAge());
        System.out.println("=========================================================");
        StudentController studControll = new StudentController();
        studControll.create("Иван", 23);
        studControll.create("Игорь", 23);
        studControll.create("Даша", 23);
        studControll.create("Лена", 23);
        studControll.PrintAll();
        System.out.println("=========================================================");

        System.out.println("Средний возраст Студентов " + studControll.getAverageAge());
        System.out.println("=========================================================");
    }
}
