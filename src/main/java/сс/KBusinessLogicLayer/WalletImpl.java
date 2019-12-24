package сс.KBusinessLogicLayer;

import org.springframework.stereotype.Component;
import сс.PercistanceLayer.entity.Entity;
import сс.PercistanceLayer.entity.users.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class WalletImpl implements Wallet {
    private User user;
    private List<Entity> incomeBasket;
    private List<Entity> walletBasket;
    private List<Entity> costBasket;

    public WalletImpl() {
        incomeBasket = new ArrayList<>();
        walletBasket = new ArrayList<>();
        costBasket = new ArrayList<>();
        //Получение данных для пользователя, после того, как он засетится сюда.
    }

    @Override
    public void expend(int amount) {

    }

    @Override
    public void receive(int amount) {

    }

    public void setUser(User user) {
        this.user = user;
    }
}
