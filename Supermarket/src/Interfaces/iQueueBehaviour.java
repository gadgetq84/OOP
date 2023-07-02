package Interfaces;


/**
 * @apiNote Интерфейс поведения в очереди
 */
public interface iQueueBehaviour {
    void takeInQueue(iActorBehaviuor actor);
    void releaseFromQueue();
    void takeOrder();
    void giveOrder();
}
