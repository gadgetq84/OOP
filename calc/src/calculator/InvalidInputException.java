
public class InvalidInputException extends ArithmeticException {

    public InvalidInputException(String e ) {
        super(e);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }

}
