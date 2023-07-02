package Interfaces;

import Classes.Actor;
/**
 * @apiNote Интерфейс поведения наших клиентов
 */
public interface iActorBehaviuor {

    public boolean isTakeOrder() ;
    public boolean isMakeOrder() ;
    public void setTakeOrder(boolean takeOrder) ;
    public void setMakeOrder(boolean makeOrder) ;
    Actor getActor();
    ;
    
}
