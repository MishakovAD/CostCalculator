package cc.BusinessLogicLayer.obj;

import static help.HelpUtils.uniqueId;

import cc.BusinessLogicLayer.Exceptions.UserNotFoundException;
import cc.PercistanceLayer.dao.costs.CostsCalculatorDA;
import cc.PercistanceLayer.entity.Cost;
import cc.PercistanceLayer.entity.Income;
import cc.PercistanceLayer.entity.Money;
import cc.PercistanceLayer.entity.users.User;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Lazy
public class WalletImpl implements Wallet {
    public static final String INCOME_PREFIX = "income_";
    public static final String MONEY_PREFIX = "money_";
    public static final String COST_PREFIX = "cost_";

    @Autowired
    private CostsCalculatorDA costsCalculatorDA;

    private List<Income> incomeBasket;
    private List<Money> moneyBasket;
    private List<Cost> costBasket;

    public WalletImpl() {
        incomeBasket = new ArrayList<>();
        moneyBasket = new ArrayList<>();
        costBasket = new ArrayList<>();
    }

    @Override
    public List<Income> getIncomeBasket() {
        return incomeBasket;
    }

    @Override
    public List<Money> getMoneyBasket() {
        return moneyBasket;
    }

    @Override
    public List<Cost> getCostBasket() {
        return costBasket;
    }

    @Override
    public boolean transact(int amount, long fromEntityId, long toEntityId) {
        return false;
    }

    @Override
    public void fillBaskets(User user) {
        long userId = user.getUserId();
        incomeBasket = costsCalculatorDA.getIncomesBasket(userId);
        moneyBasket = costsCalculatorDA.getMoneyBasket(userId);
        costBasket = costsCalculatorDA.getCostsBasket(userId);
    }

    @Override
    public void addNewEntity(User user, String description, WalletType type) throws UserNotFoundException {
        if (user == null) {
            throw new UserNotFoundException();
        }
        switch (type) {
            case INCOME:
                addNewIncome(user, description);
                break;
            case MONEY:
                addNewMoney(user, description);
                break;
            case COST:
                addNewCost(user, description);
                break;
        }

    }

    private void addNewIncome(User user, String description) {
        String incomeId = INCOME_PREFIX + uniqueId();
        Income income = Income.builder()
                .incomeId(incomeId)
                .user(user)
                .description(description)
                .amount(0)
                .deleted(false)
                .createdDate(LocalDateTime.now().toString())
                .deletedDate("")
                .build();
        costsCalculatorDA.addNewIncome(income);
        incomeBasket.add(income);
    }

    private void addNewMoney(User user, String description) {
        String moneyId = MONEY_PREFIX + uniqueId();
        Money money = Money.builder()
                .moneyId(moneyId)
                .user(user)
                .description(description)
                .amount(0)
                .deleted(false)
                .createdDate(LocalDateTime.now().toString())
                .deletedDate("")
                .build();
        costsCalculatorDA.addNewMoney(money);
        moneyBasket.add(money);

    }

    private void addNewCost(User user, String description) {
        String costId = COST_PREFIX + uniqueId();
        Cost cost = Cost.builder()
                .costId(costId)
                .user(user)
                .description(description)
                .amount(0)
                .deleted(false)
                .createdDate(LocalDateTime.now().toString())
                .deletedDate("")
                .build();
        costsCalculatorDA.addNewCost(cost);
        costBasket.add(cost);
    }
}
