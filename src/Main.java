
public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Customer customer1 = new Customer("John");
        Customer customer2 = new Customer("Theresa");

        market.acceptToMarket(customer1);
        market.acceptToMarket(customer2);

        market.takeInQueue(customer1, 101);
        market.takeInQueue(customer2, 102);

        market.takeOrders(customer1,"Cheeseburger");
        market.takeOrders(customer1,"Fries");
        market.takeOrders(customer1,"Orange juice");
        market.giveOrders(customer1);
        market.releaseFromQueue(customer1);


        market.takeOrders(customer2,"Sandwich");
        market.takeOrders(customer2,"Salad");
        market.takeOrders(customer2,"Coffee");
        market.giveOrders(customer2);
        market.releaseFromQueue(customer2);
        market.releaseFromMarket();
        market.releaseFromMarket();
    }
}