package test.SF_X0603;

import java.util.*;

public class T4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        int goodVal = 0;
        List<Integer[]> listA = new ArrayList<>();
        List<Integer[]> listB = new ArrayList<>();

        in.nextLine();
        for (int i = 0; i < n; i++) {
            Integer[] tem = new Integer[2];
            String line = in.nextLine();
            String[] strArr = line.split(" ");
            tem[0] = Integer.valueOf(strArr[1]);
            tem[1] = Integer.valueOf(strArr[2]);
            if (strArr[0].equals("A")) listA.add(tem);
            else listB.add(tem);
        }

        Collections.sort(listB, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        //先把跨城运输任务全给B
        if (listB.size() <  y){
            //b人手不够
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < y; i++) {
            goodVal += listB.get(i)[1];
        }
        for (int i = y; i < listB.size(); i++) {
            Integer[] tem = new Integer[2];
            tem[0] = listB.get(i)[0];
            tem[1] = listB.get(i)[1];
            listA.add(tem);
        }


        Collections.sort(listA, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        if (listA.size() <  x){
            //a人手不够
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < x; i++) {
            goodVal += listA.get(i)[1];
        }
        System.out.println(goodVal);

    }
}
