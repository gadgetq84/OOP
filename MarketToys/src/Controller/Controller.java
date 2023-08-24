package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import Model.Toy;
import View.languagePack;

public class Controller {

    private iGetModel model;
    private List<iGetModel> modelList = new ArrayList<>();
    private iGetView view;
    private languagePack lng;
    private FilesOps fo;
    PriorityQueue<Toy> toysQueue;

    private List<Toy> toys = new ArrayList<>();

    // реализуем несколько конструкторов для удобства
    public Controller(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
        lng = view.getLanguage();
        // инициализируем нашу очередь
        // определяем для нашей очереди порядок построения вызывая свой компаратор
        toysQueue = new PriorityQueue<Toy>(new WeightComparator());
        fo =new FilesOps("prizetoys.txt");
    }

    public Controller(List<iGetModel> model, iGetView view) {
        this.modelList = model;
        this.view = view;
        lng = view.getLanguage();
        // инициализируем нашу очередь
        // определяем для нашей очереди порядок построения вызывая свой компаратор
        toysQueue = new PriorityQueue<Toy>(new WeightComparator());
        fo =new FilesOps("prizetoys.txt");
    }

    // добавляем наш лист с игрушками в очередь
    private boolean setListToQueue() {
        toysQueue.clear();
        toysQueue.addAll(this.model.getAllToys());
        if (toysQueue.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private void printQueue() {
        if (toysQueue.size() > 0) {
            System.out.println(lng.msg12);
            for (Toy item : toysQueue) {
                System.out.println(item);
            }
        }

    }

    // удаляем из начал очереди элемент и возвращаем его
    private Toy delFirstElemQueue() {
        Toy elem = toysQueue.poll();
        if (toysQueue.size() > 0) {
            System.out.println(lng.msg11 + "id=" + elem.getId() + " name=" + elem.getName());
        } else {
            System.out.println(lng.msg10);
        }
        return elem;
    }

    // проверка что лист не пустой
    private boolean testdata(List<Toy> ty) {
        if (ty.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addToy(String toyname, int toyweight) {
        if (!toyname.isEmpty() && toyweight > 0) {
            Toy newtoy = new Toy(toyname, toyweight);
            model.addNewToy(newtoy);
        } else {
            System.out.println("===============================");
            System.out.println(lng.msg9);
            System.out.println("===============================");
        }

    }

    // редактируем вес определенной игрушки
    public void editToy(int id) {
        List<Toy> result = new ArrayList<>();
        result = searchInModelbyID(id, model);
        if (result.size() > 0) {
            for (Toy toy : result) {
                System.out.println("id=" + toy.getId() + " name=" + toy.getName());
                int toyweight = Integer.parseInt(view.prompt(lng.msg14));
                toy.setWeight(toyweight);
            }
        } else {
            System.out.println("===============================");
            System.out.println(lng.msg9);
            System.out.println("===============================");
        }

    }

    // метод удаляет запись из листа
    public void deleteToy(int id, iGetModel smodel) {
        List<Toy> result = smodel.getFoundToyById(id);
        // если что-то есть в листе удаляем
        if (result.size() > 0) {
            for (Toy itm : result) {
                smodel.deleteSelToy(itm);
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
    public void deleteSelToy(int id) {
        deleteToy(id, model);
    }

    // вывод в консоль через этот метод
    public void update(List<Toy> toys) {
        if (testdata(toys)) {
            view.printAllToys(toys);
        } else {
            System.out.println(lng.msg1);
        }

    }

    // думаю и так понятно
    public void printMultiModel() {
        update(model.getAllToys());
    }

    // метод реализует поиск вО всех моделях что мы определил
    private void searchMultiModel(String toyName) {
        List<Toy> result = new ArrayList<>();
        result = searchInModel(toyName, model);
        update(result);
    }

    // метод реализует поиск в одной модели
    private List<Toy> searchInModel(String toyName, iGetModel sModel) {
        return sModel.getFoundToyByName(toyName);

    }

    private List<Toy> searchInModelbyID(int id, iGetModel sModel) {
        return sModel.getFoundToyById(id);
    }

    // менюшка для ввыбора языка
    public static iGetView selectLanguage(iGetView view, iGetView viewEn) {
        String command = viewEn.prompt("Select language interface\n\r Enter 1 for En: \n\r Enter 2 for Ru: \n\r #:");

        switch (command) {
            case "1":
                System.out.println("English language");
                return viewEn;
            case "2":
                System.out.println("Язык Русский");
                return view;
            default:
                return viewEn;

        }

    }

    // менюшка программы
    public void run() {
        Command com = Command.NONE;
        int id;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt(lng.msg16+lng.msg2 + " " + Arrays.asList(Command.values()) + ":");
            try {
                com = Command.valueOf(command.toUpperCase().trim());
            } catch (IllegalArgumentException e) {
                System.out.println(lng.msg9 + "  " + command.toUpperCase());
                // throw new RuntimeException(lng.msg9 + " " + command.toUpperCase());
                com = Command.NONE;
            }

            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println(lng.msg3);
                    break;
                case ADD:
                    String toyname = view.prompt(lng.msg13);
                    try {
                        int toyweight = Integer.parseInt(view.prompt(lng.msg14));
                        addToy(toyname, toyweight);
                        printMultiModel();
                    } catch (Exception e) {
                        System.out.println(e.getClass().getCanonicalName());
                        System.out.println(e.getLocalizedMessage());
                    }
                    break;
                case EDIT:
                    try {
                        id = Integer.parseInt(view.prompt(lng.msg15));
                        editToy(id);
                        printMultiModel();
                    } catch (Exception e) {
                        System.out.println(e.getClass().getCanonicalName());
                        System.out.println(e.getLocalizedMessage());
                    }
                    break;
                case LIST:
                    printMultiModel();
                    break;
                case DELETE:
                    try {
                        id = Integer.parseInt(view.prompt(lng.msg7));
                        deleteSelToy(id);
                        printMultiModel();
                    } catch (Exception e) {
                        System.out.println(e.getClass().getCanonicalName());
                        System.out.println(e.getLocalizedMessage());
                    }
                    break;
                case SEARCH:
                    String stdName = view.prompt(lng.msg8);
                    searchMultiModel(stdName);
                    break;
                case ADD_TO_QUEUE:
                    setListToQueue();
                    printQueue();
                    break;
                case GET_FROM_QUEUE:
                    Toy gtoy = delFirstElemQueue();
                    fo.saveToyToFile(gtoy);
                    break;
                case NONE:
                    printMultiModel();
                    break;
                default:
                    getNewIteration = false;
                    System.out.println(lng.msg3);
                    break;

            }

        }
    }

}
