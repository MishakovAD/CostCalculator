package cc.config;

import cc.BusinessLogicLayer.factory.WalletFactory;
import cc.BusinessLogicLayer.factory.WalletFactoryImpl;
import cc.PercistanceLayer.dao.costs.CostsCalculatorDA;
import cc.PercistanceLayer.dao.costs.CostsDAO;
import cc.PercistanceLayer.dao.users.UserDA;
import cc.PercistanceLayer.dao.users.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import cc.BusinessLogicLayer.obj.Wallet;
import cc.BusinessLogicLayer.obj.WalletImpl;
import org.springframework.context.annotation.Scope;

@Configuration
public class CostsCalculatorConfig {
    @Bean
    @Scope(value = "prototype")
    public Wallet wallet() {
        return new WalletImpl();
    }

    @Bean
    public WalletFactory walletFactory() {
        return new WalletFactoryImpl() {
            @Override
            public Wallet getNewWallet() {
                return wallet();
            }
        };
    }

    @Bean
    public UserDA userDAO() {
        return new UserDAO();
    }

    @Bean
    public CostsCalculatorDA costsDA() {
        return new CostsDAO();
    }
}
