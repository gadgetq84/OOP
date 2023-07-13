import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.Controller;
import Controller.iGetModel;
import Controller.iGetView;
import Model.ModelFile;
import Model.ModelList;
import Model.Student;
import Model.hashModel;
import View.View;
import View.ViewEng;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        List<Student> students = new ArrayList<Student>();
        Student s1 = new Student("Сергей", 21, 101);
        Student s2 = new Student("Андрей", 22, 111);
        Student s3 = new Student("Ivan", 22, 121);
        Student s4 = new Student("Игорь", 23, 301);
        Student s5 = new Student("Даша", 25, 171);
        Student s6 = new Student("Лена", 23, 104);
        Student s7 = new Student("Сергей", 21, 1);
        Student s8 = new Student("Андрей", 22, 2);
        Student s9 = new Student("Ivan", 22, 3);
        Student s10 = new Student("Игорь", 23, 4);
        Student s11 = new Student("Даша", 25, 5);
        Student s12 = new Student("Лена", 23, 6);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        HashMap<Long, Student> studentsMap = new HashMap<Long, Student>();
        studentsMap.put((long) s7.hashCode(), s7);
        studentsMap.put((long) s8.hashCode(), s8);
        studentsMap.put((long) s9.hashCode(), s9);
        studentsMap.put((long) s10.hashCode(), s10);
        studentsMap.put((long) s11.hashCode(), s11);
        studentsMap.put((long) s12.hashCode(), s12);

        // ModelFile fModel = new ModelFile("StudentDB.txt");
        // fModel.saveAllStudentToFile(students);

        // iGetModel modelFile = fModel;

        // создаем лист наших моделей которые определили выше
        List<iGetModel> modelList = new ArrayList<iGetModel>();
        iGetModel model = new ModelList(students);
        iGetModel modelMap = new hashModel(studentsMap);
        // добавляем модели в лист
        modelList.add(model);
        modelList.add(modelMap);

        iGetView view = new View();
        iGetView viewEn = new ViewEng();
        // передаем в статический метод наши вьюшки для выбора языка
        iGetView viewLang = Controller.selectLanguage(view, viewEn);
        // создаем контроллер
        Controller control = new Controller(modelList, viewLang);

        // control.update();
        control.run();

    }
}
