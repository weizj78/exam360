package NiuKe;

public class QingWa {
    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }
    public static int JumpFloor(int target) {

        if(target==1) return 1;
        if(target==2) return 2;
        if(target==0) return 0;

        return JumpFloor(target-1)+JumpFloor(target-2);


    }
}
