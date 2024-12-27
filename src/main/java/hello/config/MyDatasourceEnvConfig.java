package hello.config;

import hello.datasource.MyDataSource;
import java.time.Duration;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class MyDatasourceEnvConfig {

  private final Environment env;

  @Bean
  public MyDataSource myDataSource() {
    String url = env.getProperty("my.datasource.url");
    String username = env.getProperty("my.datasource.username");
    String password = env.getProperty("my.datasource.password");
    Integer maxConnection = env.getProperty("my.datasource.etc.max-connection", Integer.class);
    Duration timeout = env.getProperty("my.datasource.etc.timeout", Duration.class);
    List<String> option = env.getProperty("my.datasource.etc.option", List.class);
    return new MyDataSource(url, username, password, maxConnection, timeout, option);
  }
}
