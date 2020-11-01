package day18;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            int maxlen = 0;
            HashMap<Work, Integer> map = new HashMap<>();
            HashMap<Work, Integer> tempMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int workNum = sc.nextInt();
                for (int k = 0; k < workNum; k++) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    Work work = new Work(a, b);
                    tempMap.put(work, map.containsKey(work) ? map.get(work)+1 : 1);
                    maxlen = Math.max(maxlen, tempMap.get(work));
                }
                HashMap<Work,Integer> temp = map;
                map = tempMap;
                tempMap = temp;
                tempMap.clear();
            }
            System.out.println(maxlen);

        }
    }
    static class Work {
        int x;
        int y;

        public Work(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Work work = (Work) o;
            return x == work.x &&
                    y == work.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
