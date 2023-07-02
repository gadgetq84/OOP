package Classes;

public class PromoClient extends Actor {
    public static int countPromoClnt;
    static {
        countPromoClnt = 0;
    }
    private Integer promoClID;
    private String promoName;

    public PromoClient(String name, int promoClID, String PromoName) {
        super(name + " - По акции -" + PromoName);
        this.promoName = PromoName;
        this.promoClID = promoClID;
        this.addInCount();
    }

    private void addInCount() {
        countPromoClnt++;
    }
    public Integer GetPromoCount() {
        return countPromoClnt;
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
    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public void setTakeOrder(boolean makeOder) {
        super.isTakeOrder = makeOder;
    }

    @Override
    public void setMakeOrder(boolean pikUpOrder) {
        super.isMakeOrder = pikUpOrder;
    }

    @Override
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
