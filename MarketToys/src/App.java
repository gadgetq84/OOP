import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import Controller.Controller;
import Controller.iGetModel;
import Controller.iGetView;
import Model.ModelList;
import Model.Toy;
import View.View;
import View.ViewEng;

public class App {
    public static void main(String[] args) throws Exception {

        List<Toy> toys = new ArrayList<Toy>();
        Toy s1 = new Toy("Юла", 21);
        Toy s2 = new Toy("Кубик", 22);
        Toy s3 = new Toy("Барби", 30);
        Toy s4 = new Toy("Машинка", 40);
        Toy s5 = new Toy("Грузовик", 10);
        Toy s6 = new Toy("Подушка пердушка", 90);
        Toy s7 = new Toy("Свисток", 60);
        Toy s8 = new Toy("Лего", 20);
        Toy s9 = new Toy("Крот", 23);
        Toy s10 = new Toy("Кот компот", 4);
        Toy s11 = new Toy("Ракетка", 65);
        Toy s12 = new Toy("Шарики", 80);
        toys.add(s1);
        toys.add(s2);
        toys.add(s3);
        toys.add(s4);
        toys.add(s5);
        toys.add(s6);
        toys.add(s7);
        toys.add(s8);
        toys.add(s9);
        toys.add(s10);
        toys.add(s11);
        toys.add(s12);

        // создаем лист наших моделей которые определили выше
        // List<iGetModel> modelList = new ArrayList<iGetModel>();
        iGetModel model = new ModelList(toys);
        // добавляем модели в лист
        // modelList.add(model);
        iGetView view = new View();
        iGetView viewEn = new ViewEng();
        // передаем в статический метод наши вьюшки для выбора языка
        iGetView viewLang = Controller.selectLanguage(view, viewEn);
        // создаем контроллер
        Controller control = new Controller(model, viewLang);
        // control.update();
        control.run();

    }
}
