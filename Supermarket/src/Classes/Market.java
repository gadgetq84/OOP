package Classes;

import java.util.List;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.ArrayList;

import Interfaces.iActorBehaviuor;

import Interfaces.iMarketBehaviour;
import Interfaces.iQueueBehaviour;
import Interfaces.iReturnOrder;

public class Market implements iMarketBehaviour, iQueueBehaviour {

    private List<iActorBehaviuor> queue;
    private List<iActorBehaviuor> returnQueue;
    protected Integer maxCountPromoClient;
    Logging marketLogging;

    /**
     * @apiNote Конструктор.
     *          при вызов конструктора сразу указываем макс кол-во участников акции
     * @param maxCountPromoClient
     * @throws IOException
     * @throws SecurityException
     */
    public Market(int maxCountPromoClient) throws SecurityException, IOException {
        this.queue = new ArrayList<iActorBehaviuor>();
        this.returnQueue = new ArrayList<iActorBehaviuor>();
        this.maxCountPromoClient = maxCountPromoClient;
        marketLogging = new Logging(this.getClass().getSimpleName(), "log.txt");
    }

    /**
     * @apiNote Метод выводит информацию на экран и вызывает фунцию
     *          takeInQueue(actor);
     * @param actor
     */
    @Override
    public void acceptToMarket(iActorBehaviuor actor) {
        System.out.println(actor.getActor().getName() + " клиент пришел в магазин ");
        marketLogging.setInfoLog(actor.getActor().getName() + " клиент пришел в магазин ");
        takeInQueue(actor);
    }

    /**
     * @apiNote Проверяем в какую очередь отправить клиента
     *          А если прилетел класс PromoClient дополнительно проверяем сколько
     *          акционных человек пришло и сравниваем с
     *          максимальным кол-вом участников акции обьявленном в экземпляре
     *          магазина
     * @param actor
     */
    @Override
    public void takeInQueue(iActorBehaviuor actor) {

        if (actor.getActor().isReturnOrder() == false) {
            String className = (actor.getActor().getClass().getSimpleName());
            switch (className) {
                case "PromoClient":
                    if (((PromoClient) actor).GetPromoCount() <= maxCountPromoClient) {
                        this.queue.add(actor);
                        System.out.println(actor.getActor().getName() + " клиент добавлен в очередь ");
                        marketLogging.setInfoLog(actor.getActor().getName() + " клиент добавлен в очередь ");
                    } else {
                        System.out.println(actor.getActor().getName() + ". Клиент не добавлен в очередь превышен лимит");
                        marketLogging.logger
                                .info(actor.getActor().getName() + ". Клиент не добавлен в очередь превышен лимит");
                    }
                    break;
                default:
                    this.queue.add(actor);
                    System.out.println(actor.getActor().getName() + " клиент добавлен в очередь ");
                    marketLogging.setInfoLog(actor.getActor().getName() + " клиент добавлен в очередь ");
                    break;
            }

        } else {
            this.returnQueue.add(actor);
            System.out.println(actor.getActor().getName() + " опечален и хочет вернуть заказ");
            System.out.println(actor.getActor().getName() + " клиент добавлен в очередь на возврат");
            marketLogging.setInfoLog(actor.getActor().getName() + " опечален и хочет вернуть заказ");
            marketLogging.setInfoLog(actor.getActor().getName() + " клиент добавлен в очередь на возврат");
        }

    }

    /**
     * @apiNote Удаляем из листа всех кто уже получил заказ
     * @param actors
     */
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " клиент ушел из магазина ");
            marketLogging.setInfoLog(actor.getName() + " клиент ушел из магазина ");
            queue.remove(actor);
        }
    }

    /**
     * @apiNote Метод вызывает takeOrder(); makeReturnOrder();
     *          giveOrder();ReturnOrder(); releaseFromQueue();
     *          releaseFromReturnQueue(); После добавления клиента в очередь
     */
    @Override
    public void update() {
        takeOrder();
        makeReturnOrder();
        giveOrder();
        ReturnOrder();
        releaseFromQueue();
        releaseFromReturnQueue();
    }

    /**
     * @apiNote Метод помечает всех кто получил заказ actor.setTakeOrder(true);
     */
    public void giveOrder() {
        for (iActorBehaviuor actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getActor().getName() + " клиент получил свой заказ ");
                marketLogging.setInfoLog(actor.getActor().getName() + " клиент получил свой заказ ");
            }
        }

    }

    /**
     * @apiNote Метод помечает всех кто сдал товар ((iReturnOrder)
     *          actor).setReturnedOrder(true);
     */
    public void ReturnOrder() {
        for (iActorBehaviuor actor : returnQueue) {
            if (actor.getActor().isMakeReturnOrder()) {
                actor.getActor().setReturnedOrder(true);
                System.out.println(actor.getActor().getName() + " клиент вернул заказ");
                marketLogging.setInfoLog(actor.getActor().getName() + " клиент вернул заказ");
                // можно еще придумать метод возврат денег на карту
                // takeYourMoneyMan();
            }
        }

    }

    /**
     * @apiNote Метод записывает в лист List<Actor> releaseActors всех кто сделал
     *          возврат и передает на уничтожение функции
     *          releaseFromMarket(releaseActors)
     */
    public void releaseFromReturnQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviuor actor : returnQueue) {
            if (actor.getActor().isReturnedOrder()) {
                releaseActors.add(actor.getActor());
                System.out.println(actor.getActor().getName() + " клиент ушел из очереди на возврат");
                marketLogging.setInfoLog(actor.getActor().getName() + " клиент ушел из очереди на возврат");
            }
        }
        releaseFromMarket(releaseActors);
    }

    /**
     * @apiNote Метод записывает в лист List<Actor> releaseActors всех кто получил
     *          товар и передает на уничтожение функции
     *          releaseFromMarket(releaseActors)
     */
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviuor actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.getActor());
                System.out.println(actor.getActor().getName() + " клиент ушел из очереди ");
                marketLogging.setInfoLog(actor.getActor().getName() + " клиент ушел из очереди ");
            }

        }
        releaseFromMarket(releaseActors);
    }

    /**
     * @apiNote Метод Проверяет сделан ли заказ и если нет вызывает
     *          actor.setMakeOrder(true);
     */
    public void takeOrder() {
        for (iActorBehaviuor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getActor().getName() + " клиент сделал заказ ");
                marketLogging.setInfoLog(actor.getActor().getName() + " клиент сделал заказ ");

            }
        }
    }

    /**
     * @apiNote Метод Проверяет сделан ли заказ на возврат если нет вызывает
     *          setMakeReturnOrder(true)
     */
    public void makeReturnOrder() {
        for (iActorBehaviuor actor : returnQueue) {
            if (!actor.getActor().isMakeReturnOrder()) {
                actor.getActor().setMakeReturnOrder(true);
                System.out.println(actor.getActor().getName() + " клиент сделал заказ на возврат");
                marketLogging.setInfoLog(actor.getActor().getName() + " клиент сделал заказ на возврат");

            }
        }
    }

}
