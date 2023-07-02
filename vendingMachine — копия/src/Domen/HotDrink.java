package Domen;

public class HotDrink extends Product {
    private int temperature;

    public  HotDrink(int price, int place, String name, long id){
        super(price,place,name,id);
        this.temperature = 70;
    }

    public HotDrink (int price, int place, String name, long id, int temperature){
        super(price,place,name,id);
        this.temperature = temperature;
    }

        public void setHotDrinkTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return super.toString() + "temperature="+temperature +"\n";
    }

}
