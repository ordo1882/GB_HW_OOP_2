public interface IMarketBehavior {
    void acceptToMarket(Customer customer);
    void releaseFromMarket();
    void update();
}
