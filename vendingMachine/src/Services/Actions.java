package Services;

import javax.swing.JList;
import javax.swing.JTextField;

import Domen.Bottle;
import Domen.HotDrink;
import Domen.Product;

public class Actions {

    public int validateData(Variables vars, JList<String> tfList, JTextField tfId, JTextField tfName,
            JTextField tfPrice,
            JTextField tfPlace, JTextField tfVolume, JTextField tfTemperature) {
        int valList = tfList.getSelectedIndex();
        Product prod;
        switch (valList) {
            case 0:
                prod = addProduct(Integer.parseInt(tfPrice.getText()), Integer.parseInt(tfPlace.getText()),
                        tfName.getText(),
                        Long.parseLong(tfId.getText()));
                vars.setInList(prod);
                if (prod.getName().length() > 0) {
                    return 1;
                }
                break;
            case 1:
                prod = addBottle(Integer.parseInt(tfPrice.getText()), Integer.parseInt(tfPlace.getText()),
                        tfName.getText(),
                        Long.parseLong(tfId.getText()), Float.parseFloat(tfVolume.getText()));
                vars.setInList(prod);
                if (prod.getName().length() > 0) {
                    return 1;
                }
                break;
            case 2:
                prod = addHotDrink(Integer.parseInt(tfPrice.getText()), Integer.parseInt(tfPlace.getText()),
                        tfName.getText(),
                        Long.parseLong(tfId.getText()), Integer.parseInt(tfTemperature.getText()));
                vars.setInList(prod);
                if (prod.getName().length() > 0) {
                    return 1;
                }
                break;

            default:
                break;
        }

        return -1;
    }

    public static Product addBottle(int price, int place, String name, long id, float volume) {
        Product item = new Bottle(price, place, name, id, volume);
        return item;
    }

    public static Product addProduct(int price, int place, String name, long id) {
        Product item = new Product(price, place, name, id);
        return item;
    }

    public static Product addHotDrink(int price, int place, String name, long id, int temper) {
        Product item = new HotDrink(price, place, name, id, temper);
        return item;
    }

    public void printProductList(VendingMachine venMachine) {
        for (Product prod : venMachine.getProducts()) {
            System.out.println(prod);
        }
    }

    public void fillInList(JList<String> tfProductList, Variables vars) {


        String[] myList = new String[vars.getInList().size()];
        int index = 0;
        for (Product prod : vars.venMachine.getProducts()) {
            myList[index] = "place=" + Long.toString(prod.getPlace()) + " " + prod.getName()+ " " + prod.getPrice();
            index++;
        }
        tfProductList.setListData(myList);

    }

}
