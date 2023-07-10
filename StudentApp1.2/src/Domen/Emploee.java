package Domen;

public class Emploee extends Person{
    private String special;
    public Emploee(String firstName, int age) {
        super(firstName, age);
    }

        public void addSpecial(String special)
    {
         this.special = special;
    }
}
