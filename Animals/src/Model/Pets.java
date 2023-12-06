package Model;

import java.util.List;

public abstract class Pets extends Animals implements Comparable<Pets> {

    private int id;

//конструктор
    /**
     * @param name
     * @param weight
     */
    public Pets(String name, float weight, List<String> execCommands,  String birthDate) {
        super(name, weight, execCommands, birthDate);
        this.id = super.getAniCount();
        super.addAniCount();
        super.addPetsCount();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        // return "Toy [id=" + id + ", name=" + super.getName() + ", weight=" + super.getWeight() + "]";
        return "Animals [id="+id+", name=" + super.getName() + ", BirthDay=" + super.getbirthDate() + ", weight="+super.getWeight()+"кг. class="+this.getClass().getSimpleName()+"]";
    }

    @Override
    public int compareTo(Pets o) {

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
