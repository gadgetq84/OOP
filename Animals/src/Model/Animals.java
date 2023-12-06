package Model;

import java.util.List;

public abstract class Animals {
    private String name;
    private float weight;
    private String birthDate;
    private List<String> execCommands;
    private static int petscount;
    private static int packscount;
    private static int aniCount;
    static {
        aniCount = 0;
        petscount = 0;
        packscount = 0;
    }

    public abstract int getId();

    public Animals(String name, float weight, List<String> execCommands, String birthDate) {
        this.name = name;
        this.weight = weight;
        this.birthDate = birthDate;
        this.execCommands = execCommands;
    }

    public String getName() {
        return name;
    }

    public int getAniCount() {
        return aniCount;
    }

    protected void addAniCount() {
        aniCount++;
    }

    protected void delAniCount() {
        aniCount--;
    }

    static public int getPetsCount() {
        return petscount;
    }

    protected void addPetsCount() {
        petscount++;
    }

    protected void delPetsCount() {
        petscount--;
    }

    static public int getPackCount() {
        return packscount;
    }

    protected void addPackCount() {
        packscount++;
    }

    protected void delPackCount() {
        packscount--;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getExecCommands() {
        return execCommands;
    }

    public void addExecCommands(String execCommands) {
        this.execCommands.add(execCommands);
    }

    public void setbirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getbirthDate() {
        return this.birthDate;
    }

    public Float getWeight() {
        return this.weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animals [name=" + name + ", BirthDay=" + birthDate + ", weight=" + weight + "]";
    }

}
