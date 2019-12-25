package cc.BusinessLogicLayer.factory;

import cc.BusinessLogicLayer.Exceptions.UserNotFoundException;
import cc.BusinessLogicLayer.obj.Wallet;
import cc.PercistanceLayer.entity.users.User;

public interface WalletFactory {
    Wallet getWallet(User user) throws UserNotFoundException;

    Wallet getNewWallet();
}
