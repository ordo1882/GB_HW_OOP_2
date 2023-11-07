import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Market implements IQueueBehavior, IMarketBehavior {
    Queue<Customer> customers = new LinkedList<>();

    /**
     * Adding customer Object to Market Queue
     * @param customer Current customer
     */
    @Override
    public void acceptToMarket(Customer customer) {
        customers.add(customer);
        System.out.println(customer.getName() + " been accepted to Market.");
    }

    /**
     * Releasing customer Object from Market Queue
     */
    @Override
    public void releaseFromMarket() {
        if (!customers.element().isMakeOrder() && !customers.element().isTakeOrder()) {
            System.out.println(Objects.requireNonNull(customers.poll()).getName() + " has been released from Market.");
        } else {
            System.out.println(customers.element().getName() + " has to complete or cancel the order.");
        }
    }

    /**
     * Market updating
     */
    @Override
    public void update() {
        System.out.println("Market is updated.");
    }

    /**
     * Adding order Object to the Order Queue
     * @param customer Current customer
     * @param numberOrder Number of order
     */
    @Override
    public void takeInQueue(Customer customer, int numberOrder) {
        if (!customer.isMakeOrder() && !customer.isTakeOrder()) {
            customer.addOrderToList(numberOrder);
            System.out.println("Order #" + numberOrder + " added to queue.");
            customer.setMakeOrder(true);
        } else {
            System.out.println(customer.getName() + " has an incomplete order.");
        }
    }

    /**
     * Adding items to the Order object List
     * @param customer Current customer
     * @param item Name of item which is going to be added to the Order List
     */
    @Override
    public void takeOrders(Customer customer, String item) {
        if (customer.isMakeOrder()) {
            customer.orders.element().addItemToOrder(item);
            customer.setTakeOrder(true);
        } else {
            System.out.println("Not allowed to take any order.");
        }
    }

    /**
     * Getting items list from the Customer's order
     * @param customer Current customer
     */
    @Override
    public void giveOrders(Customer customer) {
        if (customer.isMakeOrder() && customer.isTakeOrder()) {
            System.out.println("The order #" + customer.orders.element().getOrderNumber()
                               + " has been processed: " + customer.orders.element().getOrderList());
            update();
            customer.setMakeOrder(false);
        } else {
            System.out.println(customers.element().getName() + " has no order.");
        }
    }

    /**
     * Releasing order Object from the Order Queue
     * @param customer Current customer
     */
    @Override
    public void releaseFromQueue(Customer customer) {
        if (!customer.isMakeOrder() && customer.isTakeOrder()) {
            System.out.println("The order #" + Objects.requireNonNull(customer.orders.poll()).getOrderNumber()
                               + " has been released from queue.");
            customer.setTakeOrder(false);
        } else if ((customer.isMakeOrder() && customer.isTakeOrder())
                   || (customer.isMakeOrder() && !customer.isTakeOrder())) {
            System.out.println("The order #" + Objects.requireNonNull(customer.orders.poll()).getOrderNumber()
                               + " has been canceled and released from queue.");
            customer.setMakeOrder(false);
            customer.setTakeOrder(false);
        } else {
            System.out.println(customer.getName() + " has no order.");
        }
    }
}
