package cc.BusinessLogicLayer.obj;

import cc.BusinessLogicLayer.Exceptions.UserNotFoundException;
import cc.PercistanceLayer.entity.Cost;
import cc.PercistanceLayer.entity.Income;
import cc.PercistanceLayer.entity.Money;
import cc.PercistanceLayer.entity.users.User;

import java.util.List;

public interface Wallet {
    List<Income> getIncomeBasket();
    List<Money> getMoneyBasket();
    List<Cost> getCostBasket();

    boolean transact(int amount, long fromEntityId, long toEntityId);

    void fillBaskets(User user);

    void addNewEntity(User user, String description, WalletType type) throws UserNotFoundException;

}
