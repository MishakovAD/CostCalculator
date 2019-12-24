package сс.KBusinessLogicLayer;

public interface Wallet {
    /**
     * Тратить деньги / расходы
     * @param amount
     */
    void expend(int amount);

    /**
     * Получать деньги / доходы
     * @param amount
     */
    void receive(int amount);
}
