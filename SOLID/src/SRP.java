import java.sql.Date;

public class SRP {
    // создаем отдельный класс зарплата сотрудника 
    public class emplySalary {
        private int baseSalary;

        public emplySalary(int baseSalary) {
            this.baseSalary = baseSalary;
        }
// переносим сюда метод расчета чистой зп
        public int calculateNetSalary() {
            int tax = (int) (baseSalary * 0.25);// calculate in otherway
            return baseSalary - tax;
        }
    }

    public class Employee {
        private String name;
        private Date dob;
        emplySalary baseSalary;

        public Employee(String name, Date dob, int bSalary) {
            this.name = name;
            this.dob = dob;
            // добавляем при вызове конструктора Employee создаем экземпляр emplySalary
            baseSalary = new emplySalary(bSalary);
        }

        public String getEmpInfo() {
            return "name - " + name + " , dob - " + dob.toString();
        }

    }
}
