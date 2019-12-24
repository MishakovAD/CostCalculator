package сс.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import сс.KBusinessLogicLayer.Wallet;
import сс.KBusinessLogicLayer.WalletImpl;

@Configuration
public class CostsCalculatorConfig {
    @Bean
    public Wallet wallet() {
        return new WalletImpl();
    }
}
