package Services;

import java.util.ArrayList;
import java.util.List;

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
        this.venMachine = new VendingMachine(this.hold1, this.coinDesp, this.assort, this.disp);
    }

    public boolean setInList(Product item) {
        return assort.add(item);
    }

    public List<Product> getInList() {

        return this.assort;
    }

}
