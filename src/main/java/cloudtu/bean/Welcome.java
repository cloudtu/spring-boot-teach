package cloudtu.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// application.properties 裡的 welcome.* 設定會自動綁定到 welcome bean
@ConfigurationProperties(prefix="welcome")
public class Welcome {
    private String firstMessage;
    private String secondMessage;
    
    public String getFirstMessage() {
        return firstMessage;
    }    
    // application.properties 裡的 welcome.first-message 設定綁定到 firstMessage instance variable
    public void setFirstMessage(String firstMessage) {
        this.firstMessage = firstMessage;
    }
    public String getSecondMessage() {
        return secondMessage;
    }
    // application.properties 裡的 welcome.secondMessage 設定綁定到 secondMessage instance variable
    public void setSecondMessage(String secondMessage) {
        this.secondMessage = secondMessage;
    }
    
    @Override
    public String toString() {        
        return String.format("{firstMessage: '%s', secondMessage: '%s'}", firstMessage, secondMessage);
    }
}
