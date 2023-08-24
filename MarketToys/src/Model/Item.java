package Model;

public abstract class Item {
    private String name;
    private int weight;
    private static int itemCount;
    static {
        itemCount = 0;
    }
    

    
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getItemCount() {
        return itemCount;
    }
    protected void addItemCount() {
        itemCount++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", age=" + weight + "]";
    }
    
}
