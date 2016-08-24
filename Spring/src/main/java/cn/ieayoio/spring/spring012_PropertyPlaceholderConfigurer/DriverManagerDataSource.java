package cn.ieayoio.spring.spring012_PropertyPlaceholderConfigurer;

/**
 * Created by ieayoio on 16-8-24.
 */
public class DriverManagerDataSource {
    private String driverClassName;
    private String url;
    private String username;
    private String password;


    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("DriverManagerDataSource[driverClassName:%s , url:%s , " +
                "username:%s , password:%s]", driverClassName, url, username, password);
    }
}
