import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Calculator implements iCalculable {

    private String primaryArg;
    List<String> terms;

    public Calculator(String primaryArg) {
        this.primaryArg = primaryArg;
        this.terms = new ArrayList<String>();
    }

    @Override
    public iCalculable sum(String arg) {

        primaryArg += (primaryArg.length() > 0 ? "+" + arg : arg);
        getTerms(primaryArg);
        // пока terms не наберет нужное кол-во элемтов пропускаем вычисление
        if (terms.size() == 4) {
            double a = Math.round((Double.valueOf(this.terms.get(0)) + Double.valueOf(this.terms.get(2))) * 100.0)
                    / 100.0;
            double bi = Math.round((Double.valueOf(this.terms.get(1))
                    + Double.valueOf(this.terms.get(3))) * 100.0) / 100.0;
            primaryArg = "(" + String.valueOf(a) + (bi >= 0 ? "+" + String.valueOf(bi) : String.valueOf(bi)) + "i)";
        }
        return this;
    }

    @Override
    public iCalculable multi(String arg) {
        primaryArg += (primaryArg.length() > 0 ? "*" + arg : arg);
        getTerms(primaryArg);
        // пока terms не наберет нужное кол-во элемтов пропускаем вычисление
        if (terms.size() == 4) {
            double a = Math.round((Double.valueOf(this.terms.get(0)) * Double.valueOf(this.terms.get(2))
                    - Double.valueOf(this.terms.get(1))
                            * Double.valueOf(this.terms.get(3)))
                    * 100.0) / 100.0;
            double bi = Math.round((Double.valueOf(this.terms.get(0)) * Double.valueOf(this.terms.get(3))
                    + Double.valueOf(this.terms.get(2)) * Double.valueOf(this.terms.get(1))) * 100.0) / 100.0;

            primaryArg = "(" + String.valueOf(a) + (bi >= 0 ? "+" + String.valueOf(bi) : String.valueOf(bi)) + "i)";
        }
        return this;
    }

    @Override
    public String getResult() {
        return primaryArg;
    }

    @Override
    public iCalculable divis(String arg) {
        primaryArg += (primaryArg.length() > 0 ? "/" + arg : arg);
        getTerms(primaryArg);
        // пока terms не наберет нужное кол-во элемтов пропускаем вычисление
        if (terms.size() == 4) {
            double a11 = Double.valueOf(this.terms.get(0)) * Double.valueOf(this.terms.get(2))
                    + Double.valueOf(this.terms.get(1)) * Double.valueOf(this.terms.get(3));
            double a22 = Math.pow(Double.valueOf(this.terms.get(2)), 2)
                    + Math.pow(Double.valueOf(this.terms.get(3)), 2);

            double bi11 = Double.valueOf(this.terms.get(2)) * Double.valueOf(this.terms.get(1))
                    - Double.valueOf(this.terms.get(0)) * Double.valueOf(this.terms.get(3));
            primaryArg = "(" + String.valueOf(Math.round((a11 / a22) * 100) / 100.0)
                    + (bi11 / a22 >= 0 ? "+" + String.valueOf(Math.round((bi11 / a22) * 100) / 100.0)
                            : String.valueOf(Math.round((bi11 / a22) * 100) / 100.0))
                    + "i)";
        }
        return this;
    }

    // разделяем уравнение на отдельные части
    private List<String> getTerms(String string) {
        // регулярное вырожение которое мы будем использовать для поиска чисел
        // https://regex101.com/
        String regex = "[+-]?([0-9]*[.])?[0-9]+";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(string);
        terms.clear();
        while (matcher.find()) {
            //System.out.println("Full match: " + matcher.group(0));
            if (!matcher.group(0).isEmpty())
                terms.add(matcher.group(0));
        }
        // пример вывода
        // String string = "(256-588i)*(37777777+20i)";
        // [256, -588, 37777777, +20]
        return terms;
    }
}
