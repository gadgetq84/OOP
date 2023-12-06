package Controller;

import java.util.List;

import View.languagePack;

public interface iGetView<T> {
    void printAllAni(List<T> ani);

    // Метод для запроса ввода пользователя, чтобы получить команду или данные от
    // него
    String prompt(String msg);

    languagePack getLanguage();

}

