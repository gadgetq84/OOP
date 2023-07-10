package Controllers;


import Domen.Emploee;
import Services.EmploeeService;
//import Services.StudentService;

public class EmploeeController implements iPersonController<Emploee> {
    private final EmploeeService empService = new EmploeeService();

    @Override
    public Emploee create(String firstName, int age) {
        return empService.create(firstName, age);
    }

    public static <T extends Emploee> void paySalary(T person) {
        System.out.println(person.getName() + " выплачена зарплата 10000р. ");
    }

    public void PrintAll() {
        for (Emploee item : empService.getAll()) {
            System.out.println(item.toString());
        }
    }

        // вызов из сервиса среднего возраста 
    public int getAverageAge() {
        return empService.getAgeAverage();
    }
}
