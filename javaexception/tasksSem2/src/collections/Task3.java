package collections;

import java.util.Scanner;

public class Task3 {
    private int myNumber;
    private int pos;
    Scanner dig;

    public Task3(int position) {
        this.dig = new Scanner(System.in);
        this.pos = position;
    }

    public void SetVar() throws NumberOutOfRangeException, DivisionByZeroException {
        System.out.println("############################################################################");
        System.out.println("Введите число:");
        this.myNumber = Integer.parseInt(this.dig.nextLine());
        switch (pos) {
            case 1:
                if (myNumber > 100) {
                    throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
                }
                break;
            case 2:
                if (myNumber < 0) {
                    throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
                }
                break;
            case 3:
                if (myNumber == 0) {
                    throw new DivisionByZeroException("Деление на ноль недопустимо");
                } else {
                    System.out.println("Проверка пройдена успешно");
                }
                break;

            default:
                break;
        }
    }

    public int getPos() {
        return pos;
    }

    public int getNumber() {
        return this.myNumber;
    }

    public void getSum(Task3 num) throws NumberSumException {
        int sum = this.myNumber + num.getNumber();

        if (this.pos <= 2 && num.getPos() <= 2 && sum < 10) {
            throw new NumberSumException("Сумма первого и второго чисел слишком мала");
        } else {
            System.out.printf("Сумма двух чисел равна: %d\n", sum);
        }
    }

}
