package com.example.ff.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

public class JdbcProperties {
    private String url ;
    private String driverclass;
    private String name ;
    private String password ;
    public String getName(){
        return name ;
    }
    public String getUrl(){
        return url ;
    }
    public String getDriverclass(){
        return driverclass ;
    }
    public String getPassword(){
        return password ;
    }

    public void setDriverclass(String driverclass) {
        this.driverclass = driverclass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
