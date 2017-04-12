package sample.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(SampleProperties.PREFIX)
@Getter
@Setter
public class SampleProperties {

    static final String PREFIX = "sample";

    private Inner inner = new Inner();

    @Getter
    @Setter
    public static class Inner {

        private boolean enabled;

    }

}
