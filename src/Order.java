import java.util.ArrayList;

public class Order {
    /**Order's number*/
    private int orderNumber;
    /**List of ordered items*/
    private ArrayList<String> orderList;

    public ArrayList<String> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<String> orderList) {
        this.orderList = orderList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Order(int orderNumber, ArrayList<String> orderList) {
        this.orderNumber = orderNumber;
        this.orderList = orderList;
    }

    public Order(int orderNumber) {
        this(orderNumber, new ArrayList<String>());
    }

    /**
     * Adding item to list of ordered items
     * @param item Current item
     */
    public void addItemToOrder(String item){
        orderList.add(item);
        System.out.println(item + " added to Order #" + getOrderNumber());
    }
}
