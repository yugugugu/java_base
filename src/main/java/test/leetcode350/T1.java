package test.leetcode350;

public class T1 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int count = 0;
        while (true){
            if (mainTank >= 5){
                count += 5;
                mainTank -= 5;
                if (additionalTank > 0){
                    additionalTank -= 1;
                    mainTank += 1;
                }
            }else {
                count += mainTank;
                break;
            }
        }
        return count*10;
    }
}
