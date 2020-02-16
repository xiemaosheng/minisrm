package com.minisrm.admin.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = AppProperties.PREFIX)
public class AppProperties {
    
    public static final String PREFIX = "app";

    private Boolean kaptchaOpen = false;

    private Boolean swaggerOpen = false;

    private Integer sessionInvalidateTime = 30 * 60;  //session 失效时间（默认为30分钟 单位：秒）

    private Integer sessionValidationInterval = 15 * 60;  //session 验证失效时间（默认为15分钟 单位：秒）
    
    private String ehcachePath = "cache/ehcache.xml";
    
    public Boolean getKaptchaOpen() {
        return kaptchaOpen;
    }
    
    public void setKaptchaOpen(Boolean kaptchaOpen) {
        this.kaptchaOpen = kaptchaOpen;
    }
    
    public Boolean getSwaggerOpen() {
        return swaggerOpen;
    }
    
    public void setSwaggerOpen(Boolean swaggerOpen) {
        this.swaggerOpen = swaggerOpen;
    }
    
    public Integer getSessionInvalidateTime() {
        return sessionInvalidateTime;
    }
    
    public void setSessionInvalidateTime(Integer sessionInvalidateTime) {
        this.sessionInvalidateTime = sessionInvalidateTime;
    }

    public Integer getSessionValidationInterval() {
        return sessionValidationInterval;
    }
    
    public void setSessionValidationInterval(Integer sessionValidationInterval) {
        this.sessionValidationInterval = sessionValidationInterval;
    }

    
    public String getEhcachePath() {
        return ehcachePath;
    }

    public void setEhcachePath(String ehcachePath) {
        this.ehcachePath = ehcachePath;
    }
}
