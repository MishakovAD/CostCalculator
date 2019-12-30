package cc.InterfaceLayer.webUI.controller;

import cc.BusinessLogicLayer.factory.WalletFactory;
import cc.BusinessLogicLayer.obj.Wallet;
import cc.InterfaceLayer.Exceptions.UserUnsupportedException;
import cc.PercistanceLayer.dao.hibernate.users.UserDA;
import cc.PercistanceLayer.entity.users.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CostsWebController {
    @Autowired
    private WalletFactory walletFactory;

    @Autowired
    private UserDA userDA;

    private Map<User, Wallet> cache = new HashMap<>();

    @RequestMapping("/index")
    public String index() {
        userDA.getUserById(1);
        userDA.registration(new User());
        return "index";
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
