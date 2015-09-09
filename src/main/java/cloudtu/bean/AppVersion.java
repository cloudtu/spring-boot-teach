package cloudtu.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppVersion {
    // application.properties 裡的 appVersion 設定會自動綁定到 appVersion 變數
    @Value("${appVersion}") String appVersion;
    
    @Override
    public String toString() {
        return appVersion;
    }
}
