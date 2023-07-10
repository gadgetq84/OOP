package Controllers;

import Domen.Person;


public interface iPersonController<T extends Person> {
    T create(String firstName, int age);
    
}
