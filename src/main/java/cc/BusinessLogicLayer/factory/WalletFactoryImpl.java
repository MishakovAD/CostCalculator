package cc.BusinessLogicLayer.factory;

import cc.BusinessLogicLayer.Exceptions.UserNotFoundException;
import cc.BusinessLogicLayer.obj.Wallet;
import cc.PercistanceLayer.entity.users.User;

public abstract class WalletFactoryImpl implements WalletFactory {

    @Override
    public Wallet getWallet(User user) throws UserNotFoundException {
        if (user == null) {
            throw new UserNotFoundException();
        }
        Wallet wallet = getNewWallet();
        wallet.fillBaskets(user);
        return wallet;
    }

    @Override
    public abstract Wallet getNewWallet(); //TODO учеба: Это лукап метод, для примера отлично.
}
