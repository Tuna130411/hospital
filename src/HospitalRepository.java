import domain.Hospital;

import java.util.List;

// 병원, 질병 리스트 보관용 클래스
class HospitalRepository {
    public static List<Hospital> getHospitals() {
        return List.of(
                new Hospital("조무사 병원", "부천"),
                new Hospital("가톨릭 병원", "서울"),
                new Hospital("coma 병원", "수원")
        );
    }

    public static String[][] getDiseaseList() {
        return new String[][] {
                {"골절", "골다공증", "관절질환"},
                {"감기", "천식", "당뇨"},
                {"아토피", "백반증", "습진"}
        };
    }

    public static String[] getDepartments() {
        return new String[] {"정형외과", "내과", "피부과"};
    }
}