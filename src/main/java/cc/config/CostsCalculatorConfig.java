package cc.config;

import cc.BusinessLogicLayer.factory.WalletFactory;
import cc.BusinessLogicLayer.factory.WalletFactoryImpl;
import cc.BusinessLogicLayer.obj.Wallet;
import cc.BusinessLogicLayer.obj.WalletImpl;
import cc.PercistanceLayer.dao.hibernate.users.UserDA;
import cc.PercistanceLayer.dao.hibernate.users.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public UserDA userDA() {
        //Таким образом, данное дао без аннотации компонент и объявлено тут.
        //А те, что с аннотацией компонент не нужнаются в таком объявлении, так как компонент скан сканирует пакет и сам их находит.
        return new UserDAO();
    }
}
