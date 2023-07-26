package collections;

import java.util.Scanner;

public class Task2 {
    private int myNumber;
    Scanner dig;

    public Task2() {
        this.dig = new Scanner(System.in);
    }

    public void SetVar() {
        System.out.println("############################################################################");
        System.out.println("Введите число:");
        this.myNumber = Integer.parseInt(this.dig.nextLine());

    }

    public void division(Task2 num) throws DivisionByZeroException {
        if (num.getNumber() == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        } else {
            double res = Double.valueOf(this.myNumber) / Double.valueOf(num.getNumber());
            System.out.printf("Результат деления:%.2f\n", res);
        }
    }

    public int getNumber() {
        return this.myNumber;
    }
}
