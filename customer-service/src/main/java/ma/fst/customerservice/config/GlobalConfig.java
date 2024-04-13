package ma.fst.customerservice.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.param")
@Getter @Setter @NoArgsConstructor
public class GlobalConfig {
    int p1,p2;

}
