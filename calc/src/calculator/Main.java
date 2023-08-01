
public class Main {
    public static void main(String[] args) {
        iCalculable calculator = new Calculator(0);
        ViewCalculator view = new ViewCalculator(calculator);
        view.run();
    }
}
