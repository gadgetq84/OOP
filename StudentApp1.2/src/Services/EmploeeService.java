package Services;

import java.util.ArrayList;
import java.util.List;

import Domen.AverageAge;
import Domen.Emploee;

public class EmploeeService implements iPersonService<Emploee> {
    private List<Emploee> emploees;

    public EmploeeService() {
        this.emploees = new ArrayList<Emploee>();
    }

    @Override
    public List<Emploee> getAll() {
        return emploees;
    }

    @Override
    public Emploee create(String firstName, int age) {
        Emploee employ = new Emploee(firstName, age);
        emploees.add(employ);
        return employ;
    }

    public int getAgeAverage() {
        AverageAge<Emploee> avr = new AverageAge<>();
        return avr.getAverageAge(emploees);

    }
}
