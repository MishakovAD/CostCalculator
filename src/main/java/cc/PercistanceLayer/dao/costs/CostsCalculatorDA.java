package cc.PercistanceLayer.dao.costs;

import cc.PercistanceLayer.entity.Cost;
import cc.PercistanceLayer.entity.Income;
import cc.PercistanceLayer.entity.Money;

import java.util.List;

public interface CostsCalculatorDA {
    /**
     * Получение всех элементов "доходов" пользователя.
     * @param userId id пользователя
     * @return список объектов "доходов"
     */
    List<Income> getIncomesBasket(long userId);

    /**
     * Получение всех элементов "расходов" пользователя.
     * @param userId id пользователя
     * @return список объектов "расходов"
     */
    List<Cost> getCostsBasket(long userId);

    /**
     * Получение всех элементов "денег в 'кармане'" пользователя.
     * @param userId id пользователя
     * @return список объектов "денег в 'кармане'"
     */
    List<Money> getMoneyBasket(long userId);

    /**
     * Добавляем новый объект "доходов" пользователю.
     * @param income добавляемый объект "доходов" (пользователь зашит в сам объект)
     * @return true, если добавлено без ошибок
     */
    boolean addNewIncome(Income income);

    /**
     * Добавляем новый объект "денег в 'кармане'" пользователю.
     * @param money добавляемый объект "денег в 'кармане'" (пользователь зашит в сам объект)
     * @return true, если добавлено без ошибок
     */
    boolean addNewMoney(Money money);

    /**
     * Добавляем новый объект "расходов" пользователю.
     * @param cost добавляемый объект "расходов" (пользователь зашит в сам объект)
     * @return true, если добавлено без ошибок
     */
    boolean addNewCost(Cost cost);

    /**
     * Перенос денег из одной сущности в другую (возможен перевод между пользователями).
     * @param amount сумма
     * @param fromEntityId от какой сущности
     * @param toEntityId к какой сущности
     * @return true, если выполнено без ошибок
     */
    boolean transaction(int amount, long fromEntityId, long toEntityId);
}
