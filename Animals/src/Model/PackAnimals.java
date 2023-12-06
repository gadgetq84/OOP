package Model;

import java.util.List;

public abstract class PackAnimals extends Animals implements Comparable<PackAnimals> {

    private int id;
//конструктор
    /**
     * @param name
     * @param weight
     */
    public PackAnimals(String name, float weight, List<String> execCommands,  String birthDate) {
        super(name, weight, execCommands, birthDate);
        this.id = super.getAniCount();
        super.addAniCount();
        super.addPackCount();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Animals [id="+id+", name=" + super.getName() + ", BirthDay=" + super.getbirthDate() + ", weight="+super.getWeight()+"кг. class="+this.getClass().getSimpleName()+"]";
    }

    @Override
    public int compareTo(PackAnimals o) {

        System.out.println(super.getName() + " - " + o.getName());
        if (super.getWeight() == o.getWeight()) {
            if (id == o.getId())
                return 0;
            if (id > o.getId())
                return 1;
            else
                return -1;
        }

        if (super.getWeight() > o.getWeight())
            return 1;
        else
            return -1;
    }


}
