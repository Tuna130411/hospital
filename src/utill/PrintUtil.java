package utill;

import dto.HospitalInfo;

public class PrintUtil {

    public void printHospitals(){
        System.out.println("1. 조무사 병원");
        System.out.println("2. 가톨릭 병원");
        System.out.println("3. coma 병원");
        System.out.print("병원 번호를 입력하세요 : ");
    }

    public void printDisease(){
        System.out.println("[진료과목]\n" +
                "정형외과 | 골절, 골다공증, 관절질환\n" +
                "내과     | 감기, 천식, 당뇨\n" +
                "피부과   | 아토피, 백반증, 습진\n");
        System.out.print(">>> 병명을 입력하세요 : ");
    }

    public void printJomusa(HospitalInfo hospitalInfo, long price){
        System.out.println("┌───────────────────────┐\n" +
                "│\t" + "조무사 병원" +"\t\t    │\n" +
                "├───────────────────────┤\n" +
                "│ 이름 : " + hospitalInfo.getName() + "\t\t    │\n" +
                "│ 생년월일 : " + hospitalInfo.getBirth() + "\t│\n" +
                "│ 혈액형 : " + hospitalInfo.getBloodType() + "\t\t        │\n" +
                "├───────────────────────┤\n" +
                "│ 진료과 : " + hospitalInfo.getDepartment() + "\t\t│\n" +
                "│ 병명 : " + hospitalInfo.getDisease() + "\t\t    │\n" +
                "├───────────────────────┤\n" +
                "│ 진료비 : " + price + "\t\t|\n" +
                "│ 결제완료 : 미완\t\t    │\n" +
                "└───────────────────────┘\n");
    }

    //
    public void printCatholic(HospitalInfo hospitalInfo, long price){
        System.out.println("\t가톨릭 병원\t\t\n" +
                "--------------------------\n" +
                " 이름 : " + hospitalInfo.getName() + "\n" +
                " 생년월일 : " + hospitalInfo.getBirth() + "\n" +
                " 혈액형 : " + hospitalInfo.getBloodType() + "\n" +
                "----------진료정보-----------\n" +
                " 진료과 : " + hospitalInfo.getDepartment() + "\n" +
                " 병명 : " + hospitalInfo.getDisease() + "\n" +
                "----------진료비용-----------\n" +
                " 진료비 : " + price + "\n" +
                " 결제완료 : 미완");
    }

    public void printComa(HospitalInfo hospitalInfo, long price){
        System.out.println("[coma 병원]\n" +
                "|> 이름 - " + hospitalInfo.getName() + " |  혈액형 - " + hospitalInfo.getBloodType() + "\n" +
                "|> 생년월일 - " + hospitalInfo.getBirth() + "\n" +
                "[진료 정보]\n" +
                "|> 진료과 - " + hospitalInfo.getDepartment() + "\n" +
                "|> 병명 - " + hospitalInfo.getDisease() + "\n" +
                "[진료 비용]\n" +
                "|> 진료비 : " + price + "\n" +
                "|> 결제완료 : 완료");
    }
}
