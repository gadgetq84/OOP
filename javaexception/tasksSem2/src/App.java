import collections.Task1;
import collections.Task2;
import collections.Task3;

public class App {
    public static void main(String[] args) throws Exception {
        // Напишите программу, которая запрашивает у пользователя число и проверяет,
        // является ли оно положительным.
        Task1 tsk1 = new Task1();
        tsk1.checkVariables(tsk1.SetVariable());
        System.out.println("############################################################################");
        // Напишите программу, которая запрашивает у пользователя два числа и выполняет
        //их деление.
        Task2 tska = new Task2();
        Task2 tskb = new Task2();
        tska.SetVar();
        tskb.SetVar();
        tska.division(tskb);

        // Напишите программу, которая запрашивает у пользователя три числа и выполняет
        // следующие проверки:
        Task3 tsk3a = new Task3(1);
        Task3 tsk3b = new Task3(2);
        Task3 tsk3c = new Task3(3);
        tsk3a.SetVar();
        tsk3b.SetVar();
        tsk3c.SetVar();

        tsk3a.getSum(tsk3b);

        tsk3a.getSum(tsk3c);

    }
}
