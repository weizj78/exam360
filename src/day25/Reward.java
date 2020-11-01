package day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class Reward {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String start = null;
        while ((start = bf.readLine()) != null) {
            String[] s1 = start.split(" ");
            int n = Integer.parseInt(s1[0]);
            long r = Long.parseLong(s1[1]);
            long avg = Long.parseLong(s1[2]);
            long sum = 0;
            TreeSet<Node> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                String str = bf.readLine();
                String[] s = str.split(" ");
                Node node = new Node();
                node.ai = Integer.parseInt(s[0]);
                node.bi = Integer.parseInt(s[1]);
                sum += node.ai;
                set.add(node);
            }
            bf.close();
            sum = avg * n - sum;
            long time = 0;
            Iterator<Node> iterator = set.iterator();
            while (sum > 0 && iterator.hasNext()) {
                Node node = iterator.next();
                long temp = r - node.ai;
                if (sum > temp)
                    time += temp * node.bi;
                else time += sum * node.bi;
                sum -= temp;
            }
            System.out.println(time);
        }
    }

    static class Node implements Comparable<Node> {
        long ai;
        long bi;
        @Override
        public int compareTo(Node o) {
            if (this.bi == o.bi && this.ai == o.ai)
                return this.hashCode() - o.hashCode();
            else if (this.bi == o.bi)
                return -1;
            if (this.bi > o.bi) return 1;
            else return -1;
        }
    }
}
