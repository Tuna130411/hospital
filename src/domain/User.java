package domain;

import java.util.Arrays;

public class User {
    private final String name;
    private final String birth;

    public User(String name, String birth, char bloodType) {
        this.name = name;
        this.birth = birth;
    }

    public int getAge() {
        int year = Integer.parseInt(birth.split("-")[0]);
        return 2025 - year;
    }



}
