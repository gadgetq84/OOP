package Model;

public class Toy extends Item implements Comparable<Toy> {

    private int id;
//конструктор
    /**
     * @param name
     * @param weight
     */
    public Toy(String name, int weight) {
        super(name, weight);
        this.id = super.getItemCount();
        super.addItemCount();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toy [id=" + id + ", name=" + super.getName() + ", weight=" + super.getWeight() + "]";
    }

    @Override
    public int compareTo(Toy o) {

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
