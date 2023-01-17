public class Exercise14 {

    public static void main(String[] args) {
        int gradeLevel = 11;
        boolean isSenior = gradeLevel == 12;
        boolean isInterestedInVolunteering = true;
        boolean shouldSendVolunteerInfo = true;

        boolean result = isSenior && isInterestedInVolunteering && shouldSendVolunteerInfo;

        System.out.println(result);
    }
}
