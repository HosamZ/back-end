package at.nacs.drhouseaccountancy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

import java.util.Map;

@ConfigurationProperties("costs")
@Repository
public class Configuration {
  @Setter
  @Getter
  Map<String, Double> prices;
//
//  Map<String, Double> getPrices() {
//    return prices;
//  }
}
