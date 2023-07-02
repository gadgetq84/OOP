package Services;

import java.util.List;

import javax.swing.JLabel;

import Domen.Product;

public class VendingMachine {
      private Holder holder;
    private CoinDispenser dispenser;
    private List<Product> assort;
    private Display display;

    public VendingMachine(Holder holder, CoinDispenser dispenser, List<Product> assort, Display display) {
        this.holder = holder;
        this.dispenser = dispenser;
        this.assort = assort;
        this.display = display;
    }

    public List<Product> getProducts() {
        return assort;
    }

    public void buyProduct(Product p, JLabel lbMessage) {
        if (assort.contains(p)) {
            if (dispenser.dispense(p.getPrice())) {
                releaseProduct(p, holder);
                lbMessage.setText("Пи Па По Пу операция прошла успешно!!! " + p.getName() + ".");
            } else
            {
                 lbMessage.setText("Денег нехватат!!!");
            }
        } else {
             lbMessage.setText("Денет такого товара!!!");
        }
    }

    public void releaseProduct(Product p, Holder h) {
        h.release(0, 0);
        assort.remove(p);
    }

    public void cancel() {
        dispenser.giveChahge(0, 0);
    }

    public Holder getHolder() {
        return holder;
    }

    public CoinDispenser getDispenser() {
        return dispenser;
    }

    public List<Product> getAssort() {
        return assort;
    }

    public Display getDisplay() {
        return display;
    }
}
