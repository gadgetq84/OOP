package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import View.languagePack;

public class Controller {

    private iGetModel model;
    private List<iGetModel> modelList = new ArrayList<>();
    private iGetView view;
    private languagePack lng;

    private List<Student> students = new ArrayList<>();

    // реализуем несколько конструкторов для удобства
    public Controller(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
        lng = view.getLanguage();

    }

    public Controller(List<iGetModel> model, iGetView view) {
        this.modelList = model;
        this.view = view;
        lng = view.getLanguage();

    }

    // проверка что лист не пустой
    private boolean testdata(List<Student> std) {
        if (std.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // метод удаляет запись из листа
    public void deleteStud(int id, iGetModel smodel) {
        List<Student> result = smodel.getFoundStudById(id);
        // если что-то есть в листе удаляем
        if (result.size() > 0) {
            for (Student std : result) {
                smodel.deleteSelStud(std);
            }
        } else {
            // если пусто просто говорим что нечего удалять
            System.out.println("===============================");
            System.out.println(lng.msg6);
            System.out.println("===============================");
        }

    }

    // тут мы пробегаемся по всем моделям, если они определены или по одной модели
    // это зависит какой конструктор мы используем
    public void deleteSelStud(int id) {
        if (modelList.isEmpty()) {
            deleteStud(id, model);
        } else {
            for (iGetModel model : modelList) {
                deleteStud(id, model);
            }

        }
    }

    // вывод в консоль через этот метод
    public void update(List<Student> std) {
        // MVP
        // students = smodel.getAllStudents();
        if (testdata(std)) {
            view.printAllStudents(std);
        } else {
            System.out.println(lng.msg1);
        }

    }

    // думаю и так понятно
    public void printMultiModel() {
        if (modelList.isEmpty()) {
            // view.printAllStudents(model.getAllStudents());
            update(model.getAllStudents());
        } else {
            for (iGetModel singleModel : modelList) {
                // view.printAllStudents(singleModel.getAllStudents());
                update(singleModel.getAllStudents());

            }
        }
    }

    // менюшка программы
    public void run() {
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt(lng.msg2);
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println(lng.msg3);
                    break;
                case LIST:
                    printMultiModel();
                    break;
                case DELETE:
                    int id = Integer.parseInt(view.prompt(lng.msg7));
                    deleteSelStud(id);
                    printMultiModel();
                    break;
                case SEARCH:
                    String stdName = view.prompt(lng.msg8);
                    searchMultiModel(stdName);
                    break;
                default:
                    getNewIteration = false;
                    System.out.println(lng.msg3);
                    break;

            }

        }
    }

    // метод реализует поиск вО всех моделях что мы определил
    private void searchMultiModel(String stdName) {
        List<Student> result = new ArrayList<>();
        if (modelList.isEmpty()) {
            result = searchInModel(stdName, model);
            update(result);
        } else {
            for (iGetModel smodel : modelList) {
                result = searchInModel(stdName, smodel);
                // передаем результат во view через Update
                update(result);
            }

        }

    }

    // метод реализует поиск в одной модели
    private List<Student> searchInModel(String stdName, iGetModel sModel) {
        return sModel.getFoundStudByName(stdName);

    }

    // менюшка для ввыбора языка
    public static iGetView selectLanguage(iGetView view, iGetView viewEn) {
        String command = viewEn.prompt("Select language interface\n\r Enter 1 for En: \n\r Enter 2 for Ru: \n\r");

        switch (command) {
            case "1":
                return viewEn;
            case "2":
                return view;
            default:
                return viewEn;

        }

    }

}
