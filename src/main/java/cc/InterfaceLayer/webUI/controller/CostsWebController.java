package cc.InterfaceLayer.webUI.controller;

import cc.BusinessLogicLayer.factory.WalletFactory;
import cc.BusinessLogicLayer.obj.Wallet;
import cc.InterfaceLayer.Exceptions.UserUnsupportedException;
import cc.PercistanceLayer.entity.users.User;
import java.util.HashMap;
import java.util.Map;
import logger.annotations.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Log
@Controller
public class CostsWebController {
    @Autowired
    private WalletFactory walletFactory;

    private Map<User, Wallet> cache = new HashMap<>();

    @RequestMapping("/index")
    public String index() {

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
