package cc.InterfaceLayer.webUI.controller;

import cc.BusinessLogicLayer.factory.WalletFactory;
import cc.BusinessLogicLayer.obj.Wallet;
import cc.InterfaceLayer.Exceptions.UserUnsupportedException;
import cc.PercistanceLayer.entity.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CostsWebController {
    @Autowired
    private WalletFactory walletFactory;

    private Map<User, Wallet> cache = new HashMap<>();

    public String registration() {
//        cache.put(new User(), walletFactory.getNewWallet());
        return "";
    }

    public String login() {
        Wallet wallet;
//        if (cache.get(user) == null) {
//            wallet = walletFactory.getWallet(user);
//            cache.put(user, wallet);
//        } else {
//            wallet = cache.get(user);
//        }
        return "";
    }

    public String update() throws UserUnsupportedException {
        Wallet wallet;
//        if (cache.get(user) == null) {
//            throw new UserUnsupportedException();
//        } else {
//            wallet = cache.get(user);
//        }
        //update code
        return "";
    }

}
