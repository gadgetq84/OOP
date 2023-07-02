package Classes;

public class SpecialClient extends Actor {
  private int idVip;

  public SpecialClient(String name, Integer id) {
    super(name);
    idVip = id;
  }

  /**
   * @apiNote Функция возвращает имя клиента
   * @return String
   */
  @Override
  public String getName() {
    return super.name;
  }

  /**
   * @apiNote Функция возвращает статус принять заказ isTakeOrder
   * @return boolean
   */
  public boolean isTakeOrder() {
    return super.isTakeOrder;
  }

  /**
   * @apiNote Функция возвращает статус сделан заказ isMakeOrder
   * @return boolean
   */
  public boolean isMakeOrder() {
    return super.isMakeOrder;
  }

  /**
   * @apiNote Функция меняет значение isMakeOrder
   * @param makeOder
   * @return void
   */
  public void setTakeOrder(boolean makeOder) {
    super.isTakeOrder= makeOder;
  }

  /**
   * @apiNote Функция меняет значение isTakeOrder
   * @param pikUpOrder
   */
  public void setMakeOrder(boolean pikUpOrder) {
    super.isMakeOrder = pikUpOrder;
  }

  /**
   * @apiNote Функция возвращает указатель на текущий экземпляр класса
   *
   *
   * @return Actor
   */
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
