import Classes.Actor;
import Classes.Market;
import Classes.OrdinaryClient;
import Classes.PensionerClient;
import Classes.PromoClient;
import Classes.SpecialClient;
import Classes.TaxService;
import Interfaces.iActorBehaviuor;

public class App {

  /**
   *
   * @param args
   * @throws Exception
   */
      public static void main(String[] args) throws Exception {
        //При создании экземпляра сразу указываем макс кол-во промо клиентов
        Market magnit = new Market(5);
        iActorBehaviuor client1 = new OrdinaryClient("Boris");
        iActorBehaviuor client2 = new SpecialClient("prezident", 1001);
        iActorBehaviuor client3 = new PensionerClient("Sergey Nikolay", 1111);
        iActorBehaviuor client4 = new PensionerClient("Denis Egorov", 1111);
        // этот дядя пришел в магазин делать возврат
        client3.getActor().setReturnOrder(true);
        client4.getActor().setReturnOrder(true);
        
        iActorBehaviuor tax = new TaxService();

        magnit.acceptToMarket(client1);
        magnit.acceptToMarket(client2);
        magnit.acceptToMarket(client3);
        magnit.acceptToMarket(client4);
        client3.getActor().setReturnOrder(false);
        magnit.acceptToMarket(client3);
        magnit.acceptToMarket(tax);



        iActorBehaviuor promoClnt1 = new PromoClient("Сигизмунд" + Integer.toString(1),
                1112,"Три по цене четырех");

        magnit.acceptToMarket(promoClnt1);
        iActorBehaviuor promoClnt2 = new PromoClient("Сигизмунд" + Integer.toString(2),
                1112,"Три по цене четырех");

        magnit.acceptToMarket(promoClnt2);
        iActorBehaviuor promoClnt3 = new PromoClient("Сигизмунд" + Integer.toString(3),
                1112,"Три по цене четырех");

        magnit.acceptToMarket(promoClnt3);
        iActorBehaviuor promoClnt4 = new PromoClient("Сигизмунд" + Integer.toString(4),
                1112,"Три по цене четырех");

        magnit.acceptToMarket(promoClnt4);
        iActorBehaviuor promoClnt5= new PromoClient("Сигизмунд" + Integer.toString(5),
                1112,"Три по цене четырех");

        magnit.acceptToMarket(promoClnt5);
        iActorBehaviuor promoClnt6 = new PromoClient("Сигизмунд" + Integer.toString(6),
                1112,"Три по цене четырех");

        magnit.acceptToMarket(promoClnt6);

        magnit.update();
    }
}
