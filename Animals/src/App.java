import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Controller.Controller;
import Controller.iGetModel;
import Controller.iGetView;
import Model.ModelAnimalsList;
import Model.Animals;
import Model.Cats;
import Model.Dogs;
import Model.Hamster;
import Model.Horses;
import Model.Donkeys;
import Model.Camels;
import View.View;
import View.ViewEng;

public class App {
    public static void main(String[] args) throws Exception {

        List<Animals> ani = new ArrayList<Animals>();

         Dogs d1 = new Dogs("Fido", 5, new ArrayList<String>(Arrays.asList("Sit,Stay,Fetch".split(","))), "2020-01-01");
         Cats d2 = new Cats("Whiskers", 3, new ArrayList<String>(Arrays.asList("Sit,Pounce".split(","))), "2019-05-15");
         Hamster d3 = new Hamster("Hammy",  (float) 0.5, new ArrayList<String>(Arrays.asList("Roll,Hide".split(","))), "2021-03-10");
         Dogs d4 = new Dogs("Buddy", 6, new ArrayList<String>(Arrays.asList("Sit,Paw,Bark".split(","))), "2018-12-10");
         
         Horses p1 = new Horses("Thunder", 200, new ArrayList<String>(Arrays.asList("Trot,Canter,Gallop".split(","))), "2015-07-21");
         Camels p2 = new Camels("Sandy", 300, new ArrayList<String>(Arrays.asList("Walk,Carry Load".split(","))), "2021-03-10");
         Donkeys p3 = new Donkeys("Eeyore", 90, new ArrayList<String>(Arrays.asList("Walk,Carry Load,Bray".split(","))), "2018-12-10");
         Horses p4 = new Horses("Storm", 250, new ArrayList<String>(Arrays.asList("Trot,Canter".split(","))), "2015-07-21");


         ani.add(d1);
         ani.add(d2);
         ani.add(d3);
         ani.add(d4);
         ani.add(p1);
         ani.add(p2);
         ani.add(p3);
         ani.add(p4);
 

        // создаем лист наших моделей которые определили выше
        // List<iGetModel> modelList = new ArrayList<iGetModel>();
        iGetModel<Animals> model = new ModelAnimalsList<Animals>(ani);
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
