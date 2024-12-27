package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.PropertiesV2;
import hello.datasource.PropertiesV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@Slf4j
//@EnableConfigurationProperties(PropertiesV1.class)
@RequiredArgsConstructor
@ConfigurationPropertiesScan
public class ConfigV3 {

  private final PropertiesV3 properties;

  @Bean
  public MyDataSource myDataSource() {
    return new MyDataSource(
        properties.getUrl(),
        properties.getUsername(),
        properties.getPassword(),
        properties.getEtc().getMaxConnection(),
        properties.getEtc().getTimeout(),
        properties.getEtc().getOptions());
  }
}
