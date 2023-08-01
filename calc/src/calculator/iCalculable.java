

public interface iCalculable {
    iCalculable sum(double arg, int first);
    iCalculable multi(double arg);
    iCalculable subtraction(double arg);
    iCalculable division(double arg);
    iCalculable expon(double arg);

    double getResult();
}
