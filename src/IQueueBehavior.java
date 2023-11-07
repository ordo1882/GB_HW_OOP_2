public interface IQueueBehavior {
    void takeInQueue(Customer customer, int numberOrder);
    void takeOrders(Customer customer, String item);
    void giveOrders(Customer customer);
    void releaseFromQueue(Customer customer);
}
