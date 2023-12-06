package Controller;

import java.util.List;

import Model.Animals;

public interface iGetModel<T extends Animals> {
    public List<T> getAllAni();
    public void deleteSelAni(T ani);
    public List<T> getFoundAniByName(String aniName);
    public List<T> getFoundAniById(int id);
    public void addNewAni(T newani);
}


