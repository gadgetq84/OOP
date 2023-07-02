package Interfaces;

import Classes.Actor;

/**
 * Интерфейс возврата товара
 */
public interface iReturnOrder {
    /**
     * @apiNote True если клиент заполнил заказа на возврат
     * @return boolean
     */
    public boolean isMakeReturnOrder();

    /**
     * @apiNote Устанавливает значение isMakeReturnOrder заказа на возврат
     * @param isMakeReturnOrder
     */
    public void setMakeReturnOrder(boolean isMakeReturnOrder);

    /**
     * @apiNote True если клиент пришел вернуть заказ
     * @return boolean
     */
    public boolean isReturnOrder();

    /**
     * @apiNote True если клиент вернул заказ
     * @return boolean
     */
    public boolean isReturnedOrder();

    /**
     * @apiNote  Устанавливает значение isReturnedOreder клиент вернул заказ
     * @param isReturnedOreder
     */
    public void setReturnedOrder(boolean isReturnedOreder);

/**
 * @apiNote  Устанавливает значение isReturnOreder клиент пришел вернуть заказ
 * @param isReturnOreder
 */
    public void setReturnOrder(boolean isReturnOreder);
}
