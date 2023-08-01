
public final class Calculator implements iCalculable {

    private double primaryArg;

    public Calculator(int primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public iCalculable sum(double arg, int first) {
        if (first == 1) {
            primaryArg = arg;
        } else
            primaryArg += arg;
        return this;
    }

    @Override
    public iCalculable multi(double arg) {
        if (primaryArg > Double.MAX_VALUE / arg) {
            throw new InvalidInputException("Результат умножения превысит максимальное значение Double "
                    + Double.toHexString(Double.MAX_VALUE));
        }
        primaryArg *= arg;
        return this;
    }

    @Override
    public double getResult() {
        return primaryArg;
    }

    @Override
    public iCalculable subtraction(double arg) {
        primaryArg -= arg;
        return this;
    }

    @Override
    public iCalculable division(double arg) {
        if (arg == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        primaryArg /= arg;
        return this;
    }

    @Override
    public iCalculable expon(double arg) {
        if (arg < 0) {
            throw new InvalidInputException("отрицательная степень");
        }
        if (primaryArg == 0) {
            throw new InvalidInputException("некорректное основание");
        }
        primaryArg = Math.pow(primaryArg, arg);
        return this;
    }
}
