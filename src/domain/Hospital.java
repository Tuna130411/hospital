package domain;

import dto.HospitalInfo;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private final String name;
    private final String location;

    private final List<HospitalInfo> hospitalInfos = new ArrayList<>();



    public Hospital(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void addHospitalInfo(HospitalInfo info){
        hospitalInfos.add(info);
    }

    public List<HospitalInfo> getHospitalInfos() {
        return hospitalInfos;
    }
}
