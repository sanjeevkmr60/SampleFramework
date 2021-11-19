package main.java.com.fis.framework;

import java.util.Map;

public class User {
    private String name;
    private int age;
    private Map<String, String> address;
    private String[] roles;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Map<String, String> getAddress() {
        return address;
    }

    public void setAddress(final Map<String, String> address) {
        this.address = address;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(final String[] roles) {
        this.roles = roles;
    }
}
