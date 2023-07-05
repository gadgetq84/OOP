import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Domen.GroupIdCompare;
import Domen.Student;
import Domen.StudentFlow;
import Domen.StudentGroup;

public class App {
    public static void main(String[] args) throws Exception {
        // Заполняем список студентов

        Student s1 = new Student("Иван", 25, 121);
        Student s2 = new Student("Игорь", 23, 301);
        Student s3 = new Student("Расим", 22, 121);
        Student s4 = new Student("Юра", 23, 444);
        Student s5 = new Student("Даша", 23, 171);
        Student s6 = new Student("Света", 23, 104);
        Student s7 = new Student("Вера", 23, 445);
        Student s8 = new Student("Катя", 23, 174);
        Student s9 = new Student("Инга", 23, 105);
        Student s10 = new Student("Жора", 23, 174);
        Student s11 = new Student("Валера", 23, 105);
        // добвляем наших студентов в списки
        List<Student> listStud1 = new ArrayList<Student>();
        List<Student> listStud2 = new ArrayList<Student>();
        List<Student> listStud3 = new ArrayList<Student>();

        listStud3.add(s1);
        listStud3.add(s2);

        listStud2.add(s3);
        listStud2.add(s4);
        listStud2.add(s8);
        listStud2.add(s7);

        listStud1.add(s5);
        listStud1.add(s6);
        listStud1.add(s9);
        listStud1.add(s10);
        listStud1.add(s11);
        // добвляем наших двоечников в 3 группы
        StudentGroup group4580 = new StudentGroup(listStud1, 4580);
        StudentGroup group4585 = new StudentGroup(listStud2, 4585);
        StudentGroup group4590 = new StudentGroup(listStud3, 4590);

        List<StudentGroup> listGroups1 = new ArrayList<StudentGroup>();
        // формируем список групп
        listGroups1.add(group4580);
        listGroups1.add(group4585);
        listGroups1.add(group4590);
        // добавляем группы в поток
        StudentFlow flow1 = new StudentFlow(listGroups1, 1);

        // Для класса StudentSteam реализовать интерфейс Iterable и вывести через for
        // несколько групп со списком студентов на кансоль
        System.out.println("=========================================================");
        System.out.println("несколько групп со списком студентов");
        System.out.println("Поток: " + Integer.toString(flow1.getIdFlow()));
        for (StudentGroup grp : flow1) {
            System.out.println(grp);
        }
        System.out.println("=========================================================");
        // 3) Для класса StudentGroup реализовать интерфейс Comparable(сортировка по
        // количеству студентов в группе) и отсортировать группы студентов в потоке, а
        // затем вывести в консоль
        // сортируем по кол-ву человек в группе
        System.out.println("=========================================================");
        System.out.println("сортируем по кол-ву человек в группе");
        Collections.sort(flow1.getFlow());
        // выводим отсортированные данные
        System.out.println("Поток: " + Integer.toString(flow1.getIdFlow()));
        for (StudentGroup grp : flow1) {
            System.out.println(grp);
        }
        System.out.println("=========================================================");
        // (задача со *)
        // 1) Отсортировать группы студентов в потоке сначало по количеству студентов, а
        // затем по идентификатору группы
        System.out.println("=========================================================");
        System.out.println("сортируем по id группы");
        flow1.getFlow().sort(new GroupIdCompare());

        System.out.println("Поток: " + Integer.toString(flow1.getIdFlow()));
        for (StudentGroup grp : flow1) {
            System.out.println(grp);
        }
        // Переопределить методы ToString классов StudentGroup(выводить идентификатор
        // группы, количество студентов и список студентов) и StudentSteam(выводить
        // номер потока, количество групп и список студентов с указанием идентификатора
        // группы)
        System.out.println("=========================================================");
        System.out.println(
                "выводить идентификатор группы, количество студентов и список студентов");
        for (StudentGroup grp : flow1) {
            System.out.println(grp);
        }
        System.out.println("=========================================================");
        System.out.println(
                "выводить номер потока, количество групп и список студентов с указанием идентификатора группы");
        System.out.println(flow1);
        System.out.println("=========================================================");
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
    }
}
