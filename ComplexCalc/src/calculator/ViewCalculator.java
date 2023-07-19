
import java.util.Scanner;

public class ViewCalculator {

    private iCalculable calculator;

    public ViewCalculator(iCalculable calculator) {
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            String primaryArg = promptStr("Введите первое комплексное число в скобках (a1+b1i): ");
            calculator.sum(primaryArg);
            // iCalculable calculator = calculableFactory.create(primaryArg);
            while (true) {
                String cmd = prompt("Введите команду (*, +, /, =) : ");
                if (cmd.equals("*")) {
                    String arg = promptStr("Введите второе комплексное число в скобках (a2+b2i): ");
                    calculator.multi(arg);
                    continue;
                }
                if (cmd.equals("+")) {
                    String arg = promptStr(
                            "Введите второе комплексное число \u0432 \u0441\u043A\u043E\u0431\u043A\u0430\u0445 (a2+b2i): ");
                    calculator.sum(arg);
                    continue;
                }
                if (cmd.equals("/")) {
                    String arg = promptStr(
                            "Введите второе комплексное число \u0432 \u0441\u043A\u043E\u0431\u043A\u0430\u0445 (a2+b2i): ");
                    calculator.divis(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    String result = calculator.getResult();
                    System.out.printf("Результат %s\n", result);
                    break;
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y") || cmd.toLowerCase().equals("y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private String promptStr(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
