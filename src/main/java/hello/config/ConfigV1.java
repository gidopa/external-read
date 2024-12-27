package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.PropertiesV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableConfigurationProperties(PropertiesV1.class)
@RequiredArgsConstructor
public class ConfigV1 {

  private final PropertiesV1 properties;

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
