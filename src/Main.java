
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if(n==0) {System.out.println(0); return;}
            if(n==1){
                sc.nextInt();
                System.out.println(1);
                return;
            }
            List<Integer> list = new ArrayList<>();
            int index = 1;
            int maxlen = 0;
            list.add(sc.nextInt());
            for (int i = 1; i < n; i++) {
                int temp = sc.nextInt();
                if(temp>list.get(list.size()-1)){
                    list.add(temp);
                    index++;
                    maxlen = Math.max(index,maxlen);
                }else{
                    list.clear();
                    list.add(temp);
                    index = 1;
                    maxlen = Math.max(index,maxlen);
                }
            }
            System.out.println(n-maxlen);
        }
    }
}
class t{
    public void t(){

    }
}