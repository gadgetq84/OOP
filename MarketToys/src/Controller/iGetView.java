package Controller;

import java.util.List;

import Model.Toy;
import View.languagePack;

public interface iGetView {
    void printAllToys(List<Toy> toys);

    // Метод для запроса ввода пользователя, чтобы получить команду или данные от
    // него
    String prompt(String msg);

    languagePack getLanguage();

}

