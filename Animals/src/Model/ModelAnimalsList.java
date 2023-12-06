package Model;

import java.util.List;
import java.util.stream.Collectors;

import Controller.iGetModel;

public class ModelAnimalsList<T extends Animals> implements iGetModel<T> {
    private List<T> pets;

    public ModelAnimalsList(List<T> pets) {
        this.pets = pets;
    }

    public List<T> getAllAni() {
        return pets;
    }

    @Override
    public void deleteSelAni(T ani) {
        this.getAllAni().remove(ani);
        switch (ani.getClass().getSimpleName()) {
            case ("Dogs"):
                ani.delPetsCount();
                break;
            case ("Cats"):
                ani.delPetsCount();
                break;
            case ("Hamster"):
                ani.delPetsCount();
                break;
            case ("Donkeys"):
                ani.delPackCount();
                break;
            case ("Horses"):
                ani.delPackCount();
                break;
            case ("Camels"):
                ani.delPackCount();
                break;
        }

    }

    @Override
    public List<T> getFoundAniByName(String stdName) {

        List<T> result = this.getAllAni().stream().filter(item -> item.getName().equals(stdName))
                .collect(Collectors.toList());
        return result;

    }

    @Override
    public List<T> getFoundAniById(int id) {
        List<T> result = this.getAllAni().stream().filter(item -> Integer.valueOf(item.getId()).equals(id))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void addNewAni(T newani) {
        this.getAllAni().add(newani);
    }

}
