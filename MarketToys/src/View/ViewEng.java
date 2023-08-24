package View;

import java.util.List;
import java.util.Scanner;
import Controller.iGetView;
import Model.Toy;

public class ViewEng implements iGetView {
    public final String lang = "en";
    langEn lng;

    public ViewEng() {
        this.lng = new langEn();
    }

    @Override
    public void printAllToys(List<Toy> toys) {
        System.out.println(lng.msg4);
        for (Toy itm : toys) {
            System.out.println(itm);
        }
        System.out.println("===============================");
    }

    @Override
    public String prompt(String msg) {
        Scanner in = new Scanner(System.in, "CP866");
        System.out.print(msg);
        return in.nextLine();
    }

    @Override
    public langEn getLanguage() {
        return lng;
    }

}
