package Domen;

public class Teacher extends Person {
    private String acadDegree;

    public Teacher(String firstName, int age) {
        super(firstName, age);

    }

    public void addAcadDegree(String acadDegree)
    {
        this.acadDegree = acadDegree;
    }

}
