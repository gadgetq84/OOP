package Classes;

import Interfaces.iActorBehaviuor;
import Interfaces.iReturnOrder;
/**
 *  @apiNote Абстрактный класс для создания клиентов 
 */
public abstract class Actor implements iActorBehaviuor, iReturnOrder {
    protected String name;
    protected boolean isTakeOrder;
    public boolean isMakeOrder;
    public boolean isMakeReturnOrder;
    public boolean isReturnOreder;
    public boolean isReturnedOreder;

/**
 * @apiNote метод принимает строковое значение и переделает его в поле класса с именем name
 * @param name
 * */
    public Actor(String name) {
        this.name = name;
    }

    abstract public String getName();

    // public boolean isTakeOrder() {
    // return isTakeOrder;
    // }

    // public boolean isMakeOrder() {
    // return isMakeOrder;
    // }

    // public void setTakeOrder(boolean takeOrder) {
    // isTakeOrder = takeOrder;
    // }

    // public void setMakeOrder(boolean makeOrder) {
    // isMakeOrder = makeOrder;
    // }
}
