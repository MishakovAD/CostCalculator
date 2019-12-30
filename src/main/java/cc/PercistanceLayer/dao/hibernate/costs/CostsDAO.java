package cc.PercistanceLayer.dao.hibernate.costs;

import cc.PercistanceLayer.entity.Cost;
import cc.PercistanceLayer.entity.Income;
import cc.PercistanceLayer.entity.Money;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CostsDAO implements CostsCalculatorDA {
    @Override
    public List<Income> getIncomesBasket(long userId) {
        return new LinkedList<>();
    }

    @Override
    public List<Cost> getCostsBasket(long userId) {
        return new LinkedList<>();
    }

    @Override
    public List<Money> getMoneyBasket(long userId) {
        return new LinkedList<>();
    }

    @Override
    public boolean addNewIncome(Income income) {
        return false;
    }

    @Override
    public boolean addNewMoney(Money money) {
        return false;
    }

    @Override
    public boolean addNewCost(Cost cost) {
        return false;
    }

    @Override
    public boolean transaction(int amount, long fromEntityId, long toEntityId) {
        return false;
    }

}
