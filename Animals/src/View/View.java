package View;

import java.util.List;
import java.util.Scanner;
import Controller.iGetView;
import Model.Animals;

public class View implements iGetView<Animals> {

    private final String lang = "ru";
    langRu lng;

    public View() {
        this.lng = new langRu();
    }

    @Override
    public void printAllAni(List<Animals> anis) {
        System.out.println(lng.msg4);
        for (Animals ani : anis) {
            System.out.println(ani);
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
    public langRu getLanguage() {
        return this.lng;
    }

}
