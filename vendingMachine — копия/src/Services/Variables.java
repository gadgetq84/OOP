package Services;

import java.util.ArrayList;
import java.util.List;

import Domen.Bottle;
import Domen.HotDrink;
import Domen.Product;

public class Variables {
    private List<Product> assort;
    public Holder hold1;
    public CoinDispenser coinDesp;
    public Display disp;
    public VendingMachine venMachine;

    public Variables() {
        this.assort = new ArrayList<>();
        this.hold1 = new Holder(4, 4);
        this.coinDesp = new CoinDispenser(0);
        this.disp = new Display();
        Product item1 = new Product(100, 1, "Lays");
        Product item2 = new Product(50, 2, "Cola");
        Product item3 = new Bottle(150, 3, "Mineral Water", 101, (float) 1.5);
        Product item4 = new HotDrink(45, 4, "Лате", 102, 75);
        Product item5 = new HotDrink(45, 5, "Чай черный", 103, 70);

        this.assort.add(item1);
        this.assort.add(item2);
        this.assort.add(item3);
        this.assort.add(item4);
        this.assort.add(item5);

        this.venMachine = new VendingMachine(this.hold1, this.coinDesp, this.assort, this.disp);
    }

    public boolean setInList(Product item) {
        return assort.add(item);
    }

    public List<Product> getInList() {

        return this.assort;
    }

}
