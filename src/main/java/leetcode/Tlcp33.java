package leetcode;

public class Tlcp33 {
    public static void main(String[] args) {
        Tlcp33 tlcp33 = new Tlcp33();
        tlcp33.storeWater(new int[]{9,0,1},new int[]{0,2,2});
    }
    public int storeWater(int[] bucket, int[] vat) {

        int maxOPerateCount = Integer.MAX_VALUE;
        int[] pourCountArr = new int[bucket.length];

        int upBucket = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0){
                if (vat[i] != 0) upBucket += 1;
                bucket[i] +=1;
            }
            pourCountArr[i] = (int)Math.ceil((double)vat[i]/bucket[i]);
        }

        for (; upBucket < 1000; upBucket++) {
            int maxPourCount = pourCountArr[0];
            int maxOPeratePlace = 0;
            for (int j = 0; j < bucket.length; j++) {
                if (pourCountArr[j] > maxPourCount){
                    maxPourCount = pourCountArr[j];
                    maxOPeratePlace = j;
                }
            }
            if(maxPourCount+upBucket >= maxOPerateCount){
                return maxOPerateCount;
            }else{
                maxOPerateCount = maxPourCount+upBucket;
                bucket[maxOPeratePlace] += 1;
                pourCountArr[maxOPeratePlace] = (int)Math.ceil((double)vat[maxOPeratePlace]/bucket[maxOPeratePlace]);
            }
        }
        //我给升级桶的上限是1000，超过返回这个实际是处理不了的
        return maxOPerateCount;
    }
}
