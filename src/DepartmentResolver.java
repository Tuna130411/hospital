// 보조 유틸: 병명으로 진료과 분류
class DepartmentResolver {
    public static String getDepartment(String disease) {
        String[][] list = HospitalRepository.getDiseaseList();
        String[] departments = HospitalRepository.getDepartments();
        for (int i = 0; i < list.length; i++) {
            for (String d : list[i]) {
                if (disease.equals(d)) return departments[i];
            }
        }
        return "일반";
    }
}