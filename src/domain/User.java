package domain;

import java.util.Arrays;

public class User {
    private String name;
    private String birth;
    private char bloodType;

    public User(String name, String birth, char bloodType) {
        this.name = name;
        this.birth = birth;
        this.bloodType = bloodType;
    }

    public char getBloodType() {
        return bloodType;
    }

    public String getBirth() {
        return birth;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        int year = Integer.parseInt(birth.split("-")[0]);
        return 2025 - year;
    }



}
