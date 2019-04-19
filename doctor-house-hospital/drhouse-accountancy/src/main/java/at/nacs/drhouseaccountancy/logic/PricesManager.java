package at.nacs.drhouseaccountancy.logic;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@ConfigurationProperties("costs")
@Service
public class PricesManager {

  @Setter
  private Map<String, Double> prices;

  public Double calculate(String input) {
    return prices.get(input);
  }
}