package cn.tanlw.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 注意点：属性值的setter方法是注入属性的前提
 * @create 2018/7/10
 */
@Component
@ConfigurationProperties(prefix = "noa.govern")
public class PropertyTest {

    public String host;

    public String port;

    public String hostport;


    public void setHostport(String hostport) {
        this.hostport = hostport;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
