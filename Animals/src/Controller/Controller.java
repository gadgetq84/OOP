package Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.InvalidNameException;

import Model.Animals;
import Model.Horses;
import Model.Cats;
import Model.Dogs;
import Model.Hamster;
import Model.Donkeys;
import Model.Camels;
import View.languagePack;

public class Controller {

    private iGetModel<Animals> model;
    private List<iGetModel<Animals>> modelList = new ArrayList<>();
    private iGetView<Animals> view;
    private languagePack lng;
    private String dateFormat;

    // реализуем несколько конструкторов для удобства
    public Controller(iGetModel<Animals> model, iGetView<Animals> view) {
        this.model = model;
        this.view = view;
        lng = view.getLanguage();
        this.dateFormat = "yyyy-MM-dd";
        // инициализируем нашу очередь
        // определяем для нашей очереди порядок построения вызывая свой компаратор
    }

    public Controller(List<iGetModel<Animals>> model, iGetView<Animals> view) {
        this.modelList = model;
        this.view = view;
        lng = view.getLanguage();
        // инициализируем нашу очередь
        // определяем для нашей очереди порядок построения вызывая свой компаратор
    }

    // проверка что лист не пустой
    private boolean testdata(List<Animals> ty) {
        if (ty.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addAni(int type, String name, int weight, List<String> execCommands, String birthDate) {
        if (!name.isEmpty() && weight > 0) {
            Animals newani;
            switch (type) {
                case (1):
                    newani = new Dogs(name, weight, execCommands, birthDate);
                    model.addNewAni(newani);
                    break;
                case (2):
                    newani = new Cats(name, weight, execCommands, birthDate);
                    model.addNewAni(newani);
                    break;
                case (3):
                    newani = new Hamster(name, weight, execCommands, birthDate);
                    model.addNewAni(newani);
                    break;
                case (4):
                    newani = new Horses(name, weight, execCommands, birthDate);
                    model.addNewAni(newani);
                    break;
                case (5):
                    newani = new Donkeys(name, weight, execCommands, birthDate);
                    model.addNewAni(newani);
                    break;
                case (6):
                    newani = new Camels(name, weight, execCommands, birthDate);
                    model.addNewAni(newani);
                    break;
            }

        } else {
            System.out.println("===============================");
            System.out.println(lng.msg9);
            System.out.println("===============================");
        }

    }

    // редактируем вес определенной игрушки
    public void editAni(int id) {
        List<Animals> result = new ArrayList<>();
        result = searchInModelbyID(id, model);
        if (result.size() > 0) {
            for (Animals ani : result) {
                System.out.println("id=" + ani.getId() + " name=" + ani.getName());
                float aweight = Integer.parseInt(view.prompt(lng.msg14));
                ani.setWeight(aweight);
            }
        } else {
            System.out.println("===============================");
            System.out.println(lng.msg9);
            System.out.println("===============================");
        }

    }

    // метод удаляет запись из листа
    public void deleteAni(int id, iGetModel<Animals> smodel) {
        List<Animals> result = smodel.getFoundAniById(id);
        // если что-то есть в листе удаляем
        if (result.size() > 0) {
            for (Animals itm : result) {
                smodel.deleteSelAni(itm);
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
    public void deleteSelAni(int id) {
        deleteAni(id, model);
    }

    // вывод в консоль через этот метод
    public void update(List<Animals> anis) {
        if (testdata(anis)) {
            view.printAllAni(anis);
        } else {
            System.out.println(lng.msg1);
        }

    }

    // думаю и так понятно
    public void printMultiModel() {
        update(model.getAllAni());
        System.out.println("===============================");
        System.out.println("Pets=" + Animals.getPetsCount() + ", Pack Animals: " + Animals.getPackCount());
        System.out.println("===============================");
    }

    // метод реализует поиск вО всех моделях что мы определил
    private void searchMultiModel(String aniName) {
        List<Animals> result = new ArrayList<>();
        result = searchInModel(aniName, model);
        update(result);
    }

    // метод реализует поиск в одной модели
    private List<Animals> searchInModel(String aniName, iGetModel<Animals> sModel) {
        return sModel.getFoundAniByName(aniName);

    }

    private List<Animals> searchInModelbyID(int id, iGetModel<Animals> sModel) {
        return sModel.getFoundAniById(id);
    }

    // менюшка для ввыбора языка
    public static iGetView<Animals> selectLanguage(iGetView view, iGetView viewEn) {
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
            String command = view.prompt(lng.msg16 + lng.msg2 + " " + Arrays.asList(Command.values()) + ":");
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
                    try {
                        String name = view.prompt(lng.msg13);
                        int type = Integer.parseInt(view.prompt(lng.msg17));
                        int aweight = Integer.parseInt(view.prompt(lng.msg14));
                        String execCommands = (view.prompt(lng.msg11)).strip();

                        if (execCommands.isEmpty()) {
                            execCommands = "none";
                        }
                        String birthDate = (view.prompt(lng.msg12 +" "+dateFormat)).strip();
                        if (!DateValidator(birthDate))
                        {
                            throw new InvalidNameException("Invalid birthDate format\033[0;37m\n===============================");
                        }
                        java.time.LocalDate currentDate = java.time.LocalDate.now();

                        if (birthDate.isEmpty() && name.isEmpty()) {
                            System.out.println("===============================");
                            throw new InvalidNameException(
                                    "Invalid name or birthDate\033[0;37m\n===============================");

                        }
                        if (type > 6 || type < 1) {
                            System.out.println("===============================");
                            throw new NumberFormatException("Wrong type of animal\033[0;37m\n===============================");

                        }

                        if (aweight == 0) {
                            throw new NumberFormatException("Wrong weight of animal\033[0;37m\n===============================");
                        }

                        addAni(type, name, aweight, new ArrayList<String>(Arrays.asList(execCommands)),
                                birthDate);
                        printMultiModel();

                    } catch (Exception e) {
                        System.out.println("\033[0;31m"+e.getClass().getCanonicalName()+"\033[0;37m");
                        System.out.println("\033[0;31m"+e.getLocalizedMessage()+"\033[0;37m");
                    }
                    break;

                case EDIT:
                    try {
                        id = Integer.parseInt(view.prompt(lng.msg15));
                        editAni(id);
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
                        deleteSelAni(id);
                        printMultiModel();
                    } catch (Exception e) {
                        System.out.println(e.getClass().getCanonicalName());
                        System.out.println(e.getLocalizedMessage());
                    }
                    break;

                case SEARCH:
                    String aniName = view.prompt(lng.msg8);
                    searchMultiModel(aniName);
                    break;
                case SHOW_COMMANDS:
                    id = Integer.parseInt(view.prompt(lng.msg15));
                    showCommands(id, model);
                    break;
                case ADD_COMMANDS:
                    id = Integer.parseInt(view.prompt(lng.msg15));
                    addCommands(id, model);
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

    private void addCommands(int id, iGetModel<Animals> model2) {
        List<Animals> result = model.getFoundAniById(id);
        // если что-то есть показываем
        if (result.size() > 0) {
            for (Animals itm : result) {
                System.out.println("id=" + itm.getId() + " name=" + itm.getName());
                String com = view.prompt(lng.msg18);
                itm.addExecCommands(com);
                System.out.println("===============================");
                System.out.println(itm.getName() + " Умеет " + itm.getExecCommands());
                System.out.println("===============================");
            }
        } else {
            // если пусто просто говорим что нечего показывать
            System.out.println("===============================");
            System.out.println(lng.msg6);
            System.out.println("===============================");
        }
    }

    private void showCommands(int id, iGetModel<Animals> model) {
        List<Animals> result = model.getFoundAniById(id);
        // если что-то есть показываем
        if (result.size() > 0) {
            for (Animals itm : result) {
                System.out.println("===============================");
                System.out.println(itm.getName() + " Умеет " + itm.getExecCommands());
                System.out.println("===============================");
            }
        } else {
            // если пусто просто говорим что нечего показывать
            System.out.println("===============================");
            System.out.println(lng.msg6);
            System.out.println("===============================");
        }
    }

    public boolean DateValidator(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}
