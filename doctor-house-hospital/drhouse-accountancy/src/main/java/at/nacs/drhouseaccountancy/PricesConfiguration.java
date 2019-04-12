package at.nacs.drhouseaccountancy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@ConfigurationProperties("costs")
@Configuration
public class PricesConfiguration {
  @Setter
  @Getter
  private Map<String, Double> prices;
//
//  Map<String, Double> getPrices() {
//    return prices;
//  }
}
