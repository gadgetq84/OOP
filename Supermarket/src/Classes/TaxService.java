package Classes;

import Interfaces.iActorBehaviuor;
import Interfaces.iReturnOrder;

public class TaxService implements iActorBehaviuor, iReturnOrder {
    private String name;
    private boolean isTakeOrder;
    private boolean isMakeOrder;
    private boolean isMakeReturnOrder;
    private boolean isReturnOreder;
    private boolean isReturnedOreder;

    public TaxService() {
        this.name = "Tax audit";
    }

    /**
     * @apiNote Функция возвращает имя клиента
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    
    /** 
     * @param makeOrder
     */
    @Override
    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    
    /** 
     * @param pickUpOrder
     */
    @Override
    public void setTakeOrder(boolean pickUpOrder) {
        isTakeOrder = pickUpOrder;
    }

    
    /** 
     * @return Actor
     */
    @Override
    public Actor getActor() {
        return new OrdinaryClient(name);
    }

    
    /**
   * @apiNote Функция возвращает значение isReturnOreder
   * @return boolean
   */
  @Override
  public boolean isReturnOrder() {
    return isReturnOreder;
  }

  /**
   * @apiNote Функция устанавливает значение isReturnOreder
   * @param isReturnOreder
   */
  @Override
  public void setReturnOrder(boolean isReturnOred) {
    isReturnOreder = isReturnOred;
  }

  /**
   * @apiNote Функция возвращает значение isMakeReturnOrder сделать заказ на возврат
   */

  @Override
  public boolean isMakeReturnOrder() {
    return isMakeReturnOrder;
  }

      /** 
     * @apiNote Функция возвращает значение isReturnedOreder 
     * 
     */
  @Override
  public boolean isReturnedOrder() {
    return isReturnedOreder;
  }

  
  /** @apiNote Функция устанавливает значение isMakeReturnOrder
   * @param isMakeReturnOrder
   */
  @Override
  public void setMakeReturnOrder(boolean isMakeReturnOrd) {
    isMakeReturnOrder = isMakeReturnOrd;
  }

  
  /** @apiNote Функция устанавливает значение isReturnedOreder
   * @param isReturnedOreder
   */
  @Override
  public void setReturnedOrder(boolean isReturnedOred) {
    isReturnedOreder = isReturnedOred;
  }


}
