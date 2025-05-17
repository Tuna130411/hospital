package domain;

import java.util.Arrays;

public class User {
    private final String name;
    private final String birth;

    public User(String name, String birth) {
        this.name = name;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public int getAge() {
        int year = Integer.parseInt(birth.split("-")[0]);
        return 2025 - year;
    }



}
