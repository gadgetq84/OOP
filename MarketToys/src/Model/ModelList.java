package Model;

import java.util.List;
import java.util.stream.Collectors;

import Controller.iGetModel;

public class ModelList implements iGetModel {
    private List<Toy> students;

    public ModelList(List<Toy> students) {
        this.students = students;
    }

    public List<Toy> getAllToys() {
        return students;
    }

    @Override
    public void deleteSelToy(Toy toy) {
        this.getAllToys().remove(toy);
    }

    @Override
    public List<Toy> getFoundToyByName(String stdName) {
        List<Toy> result = this.getAllToys().stream().filter(item -> item.getName().equals(stdName))
                .collect(Collectors.toList());
        return result;

    }

    @Override
    public List<Toy> getFoundToyById(int id) {
        List<Toy> result = this.getAllToys().stream().filter(item -> Integer.valueOf(item.getId()).equals(id))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void addNewToy(Toy newtoy) {
        this.getAllToys().add(newtoy);
    }


}
