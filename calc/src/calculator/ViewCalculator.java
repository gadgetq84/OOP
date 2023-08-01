
import java.util.Scanner;

public class ViewCalculator {

    private iCalculable calculator;

    public ViewCalculator(iCalculable calculator) {
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            double primaryArg = promptDoub("Введите первый аргумент: ");
            try {
                calculator.sum(primaryArg,1);
            } catch (Exception e) {
                System.out.println("произошла ошибка: " + e.getMessage());
            }

            // iCalculable calculator = calculableFactory.create(primaryArg);
            while (true) {
                String cmd = prompt("Введите команду (*, +,-,/,^ =) : ");
                if (cmd.equals("*")) {
                    double arg = promptDoub("Введите второй аргумент: ");
                    try {
                        calculator.multi(arg);
                    } catch (Exception e) {
                        System.out.println("произошла ошибка: " + e.getMessage());
                    }
                    continue;
                }
                if (cmd.equals("+")) {
                    double arg = promptDoub("Введите второй аргумент: ");
                    try {
                        calculator.sum(arg,0);
                    } catch (Exception e) {
                        System.out.println("произошла ошибка: " + e.getMessage());
                    }
                    continue;
                }
                if (cmd.equals("-")) {
                    double arg = promptDoub("Введите второй аргумент: ");
                    try {
                        calculator.subtraction(arg);
                    } catch (Exception e) {
                        System.out.println("произошла ошибка: " + e.getMessage());
                    }
                    continue;
                }
                if (cmd.equals("/")) {
                    double arg = promptDoub("Введите второй аргумент: ");
                    try {
                        calculator.division(arg);
                    } catch (Exception e) {
                        System.out.println("произошла ошибка: " + e.getMessage());
                    }
                    continue;
                }
                if (cmd.equals("^")) {
                    double arg = promptDoub("Введите второй аргумент: ");
                    try {
                        calculator.expon(arg);
                    } catch (Exception e) {
                        System.out.println("произошла ошибка: " + e.getMessage());
                    }
                    continue;
                }
                if (cmd.equals("=")) {
                    double result = calculator.getResult();
                    System.out.printf("Результат %.2f\n", result);
                    break;
                }
            }
            String cmd = prompt("Продолжить ??? (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {

        Scanner inp = new Scanner(System.in);
        System.out.print(message);
        return inp.nextLine().toUpperCase();
    }

    private double promptDoub(String message) {
        Scanner inpp = new Scanner(System.in);
        System.out.print(message);
        try {
            return Double.parseDouble(inpp.nextLine());
        } catch (Exception e) {
            System.out.printf("некорректное число!!! аргумент будет равен:0 \n");
            return 0;
        }

    }
}
