import java.util.LinkedList;
import java.util.Queue;

public class Customer extends Market {
    /**Customer name*/
    private String name;
    /**Status if customer is making order*/
    private boolean isMakeOrder = false;
    /**Status if customer is taking order*/
    private boolean isTakeOrder = false;
    Queue<Order> orders = new LinkedList<>();

    /**
     * Adding order Object to Orders List
     * @param number Order's number
     */
    public void addOrderToList(int number){
        orders.add(new Order(number));
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    public void setTakeOrder(boolean takeOrder) {
        isTakeOrder = takeOrder;
    }

    public Customer(String name) {
        this.name = name;
    }
}
