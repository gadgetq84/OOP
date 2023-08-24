package Controller;

import java.util.List;

import Model.Toy;

public interface iGetModel {
    public List<Toy> getAllToys();
    public void deleteSelToy(Toy std);
    public List<Toy> getFoundToyByName(String stdName);
    public List<Toy> getFoundToyById(int id);
    public void addNewToy(Toy newtoy);
}


