package Controller;

import java.util.Comparator;

import Model.Toy;

public class WeightComparator implements Comparator<Toy> {

    @Override
    public int compare(Toy arg0, Toy arg1) {
         return (int) (arg1.getWeight() - arg0.getWeight());
    }

}
