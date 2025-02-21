package hello.datasource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties("my.datasource")
public class PropertiesV2 {

  private String url;
  private String username;
  private String password;
  private Etc etc;

  public PropertiesV2(String url, String username, String password, Etc etc) {
    this.url = url;
    this.username = username;
    this.password = password;
    this.etc = etc;
  }

  @Getter
  public static class Etc {
    private int maxConnection;
    private Duration timeout;
    private List<String> options = new ArrayList<>();

    public Etc(int maxConnection, Duration timeout, List<String> options) {
      this.maxConnection = maxConnection;
      this.timeout = timeout;
      this.options = options;
    }
  }
}
