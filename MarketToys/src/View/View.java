package View;

import java.util.List;
import java.util.Scanner;
import Controller.iGetView;
import Model.Toy;

public class View implements iGetView  {

    private final String lang = "ru";
    langRu lng;

    public View() {
        this.lng = new langRu();
    }

    @Override
    public void printAllToys(List<Toy> toys) {
        System.out.println(lng.msg4);
        for (Toy stud : toys) {
            System.out.println(stud);
        }
        System.out.println("===============================");
    }

    @Override
    public String prompt(String msg)  {
        Scanner in = new Scanner(System.in , "CP866");
        System.out.print(msg);
        return in.nextLine();
    }


    @Override
    public langRu getLanguage() {
        return this.lng;
    }


}
