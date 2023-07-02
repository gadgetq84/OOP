package Classes;

public class PensionerClient extends Actor {
  private int pensID;

  public PensionerClient(String name, int pensID) {
    super(name + " - пенсионер");
    this.pensID = pensID;
  }

  /**
   * @return String
   */
  @Override
  public String getName() {
    return super.name;
  }

  /**
   * @return boolean
   */
  public boolean isTakeOrder() {
    return super.isTakeOrder;
  }

  public boolean isMakeOrder() {
    return super.isMakeOrder;
  }

  public void setTakeOrder(boolean makeOder) {
    super.isTakeOrder = makeOder;
  }

  public void setMakeOrder(boolean pikUpOrder) {
    super.isMakeOrder = pikUpOrder;
  }

  public Actor getActor() {
    return this;
  }

   /**
   * @apiNote Функция возвращает значение isReturnOreder
   * @return boolean
   */
  @Override
  public boolean isReturnOrder() {
    return super.isReturnOreder;
  }

  /**
   * @apiNote Функция устанавливает значение isReturnOreder
   * @param isReturnOreder
   */
  @Override
  public void setReturnOrder(boolean isReturnOreder) {
    super.isReturnOreder = isReturnOreder;
  }

  /**
   * @apiNote Функция возвращает значение isMakeReturnOrder сделать заказ на возврат
   */

  @Override
  public boolean isMakeReturnOrder() {
    return super.isMakeReturnOrder;
  }

      /** 
     * @apiNote Функция возвращает значение isReturnedOreder 
     * 
     */
  @Override
  public boolean isReturnedOrder() {
    return super.isReturnedOreder;
  }

  
  /** @apiNote Функция устанавливает значение isMakeReturnOrder
   * @param isMakeReturnOrder
   */
  @Override
  public void setMakeReturnOrder(boolean isMakeReturnOrder) {
    super.isMakeReturnOrder = isMakeReturnOrder;
  }

  
  /** @apiNote Функция устанавливает значение isReturnedOreder
   * @param isReturnedOreder
   */
  @Override
  public void setReturnedOrder(boolean isReturnedOreder) {
    super.isReturnedOreder = isReturnedOreder;
  }


}
