
// Создать логирование операций, для класса Calculator. Класс Calculator не должен изменится.

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws SecurityException, IOException {
        iCalculable calculator = new Calculator("");
        iCalculable newCalcLog = new CalcDecorator(calculator, new myLogger("log.txt"));

        ViewCalculator view = new ViewCalculator(newCalcLog);
        view.run();
    }
}
