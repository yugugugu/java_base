package test.pdd0418;

import java.util.*;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = scanner.nextInt();
            List<String> list = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                list.add(scanner.next());
            }
            map.put(i,list);
        }


    }
}
