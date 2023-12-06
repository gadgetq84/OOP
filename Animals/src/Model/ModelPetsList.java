package Model;

import java.util.List;
import java.util.stream.Collectors;

import Controller.iGetModel;

public class ModelPetsList implements iGetModel<Pets> {
    private List<Pets> pets;

    public ModelPetsList(List<Pets> pets) {
        this.pets = pets;
    }
    
    public List<Pets> getAllAni() {
        return pets;
    }


    @Override
    public void deleteSelAni(Pets ani) {
        this.getAllAni().remove(ani);
        
    }

    @Override
    public List<Pets> getFoundAniByName(String stdName) {
        List<Pets> result = this.getAllAni().stream().filter(item -> item.getName().equals(stdName))
                .collect(Collectors.toList());
        return result;

    }

    @Override
    public List<Pets> getFoundAniById(int id) {
        List<Pets> result = this.getAllAni().stream().filter(item -> Integer.valueOf(item.getId()).equals(id))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void addNewAni(Pets newani) {
        this.getAllAni().add(newani);
    }


}
