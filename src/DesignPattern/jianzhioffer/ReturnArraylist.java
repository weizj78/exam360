package DesignPattern.jianzhioffer;

import org.junit.Test;
import sun.awt.SunGraphicsCallback;
import java.util.Collections;
import java.util.*;
import java.util.LinkedList;
import java.util.stream.Stream;

public class ReturnArraylist {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        ListNode head = new ListNode(0);
        ListNode temp;
        while (listNode!=null){
            temp = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = temp;
        }


        listNode = head.next;
        while (listNode!=null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    /**
     * 判断是否为后续遍历结果
     * 递归方法
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0) return false;
        int len = sequence.length;
        return verifySq(sequence,len-1,0,len-2);
    }
    public boolean verifySq(int []arr,int index,int start,int end){

        if(start>=end) return true;
        int i ;
        for (i = start; i <= end; i++) {
            if(arr[index]<arr[i]) break;
        }
        int tmp = i;
        for (; i <=end ; i++) {
            if(arr[index]>arr[i]) return false;
        }
        return verifySq(arr,tmp-1,start,tmp-2)&&verifySq(arr,end-1,tmp,end-2);
    }


    @Test
    public void test01(){

       int []arr = {1,2,3,2,2,2,5,4};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        reverseTree(root,target,list,new ArrayList<Integer>());

        return list;
    }

    public void reverseTree(TreeNode root,int sum,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> tempList){

        if(root == null) return;
        if(root.left==null&&root.right==null) {
            if(sum -root.val == 0){
                tempList.add(root.val);
                ArrayList<Integer> isList = new ArrayList<>();
                isList.addAll(tempList);
                list.add(isList);
                tempList.remove(tempList.size()-1);
                return;
            }else return;
        }

        tempList.add(root.val);
        reverseTree(root.left,sum-root.val,list,tempList);
        reverseTree(root.right,sum-root.val,list,tempList);
        tempList.remove(tempList.size()-1);
    }


    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return null;
        RandomListNode p = pHead;
        //复制一个
        while (p!=null){
            RandomListNode temp = new RandomListNode(p.label);
            temp.next = p.next;
            p.next = temp;
            p = p.next.next;
        }

        RandomListNode p1 = pHead;
        RandomListNode p2;

        while (p1!=null){
            if(p1.random!=null)
                p1.next.random = p1.random.next;
            else p1.next.random = null;
            p1 = p1.next.next;
        }

        p1 = new RandomListNode(1);
        p2 = p1;
        while (pHead!=null){
            p2.next = pHead.next;
            p2 = p2.next;
            pHead.next = pHead.next.next;
            pHead = pHead.next;
        }
        return p1.next;
    }

    TreeNode pre = new TreeNode(1);
    TreeNode head = pre;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        Convert(pRootOfTree.left);
        pre.right = pRootOfTree;
        pRootOfTree.left = pre;
        pre = pre.right;
        Convert(pRootOfTree.right);
        head.right.left = null;
        return head.right;
    }

    
    public ArrayList<String> Permutation(String str) {
        int len = str.length();
        ArrayList<String> list = new ArrayList<>();
        if(len == 0) return list;
        allMysort("",str,list);
        return list;
    }

    public void allMysort(String head,String str,ArrayList<String> list){

        if(str.length() == 0) {
            list.add(head);
            return;
        };
        int len = str.length();
        String temp = "";
        for (int i = 0; i < len; i++) {
            if(temp.contains(str.charAt(i)+""))
                continue;
            temp+=str.charAt(i);
            String s = new StringBuilder(str).deleteCharAt(i).toString();
            allMysort(head+str.charAt(i),s,list);
        }
    }



    public int MoreThanHalfNum_Solution(int [] array) {

        int count= 0;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if(count==0){
                index = i;
                count ++;
            } else if(array[i]!=array[index]){
                count--;
                if(count == 0)
                index = -1;
            } else if(array[i] == array[index]){
                count++;
                index = i;
            }
        }

        if(index == -1) return 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[index]==array[i]) sum++;
        }
        return sum>(array.length/2)?array[index]:0;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            set.add(input[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = set.iterator();
        if(k>input.length) return list;
        int num = 0;
        while (iterator.hasNext()){
            if(num>k) break;
            list.add(iterator.next());
            num++;
        }
        return list;
    }


    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;

        return 1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
    }

    public int FindGreatestSumOfSubArray(int[] array) {

        int len = array.length;
        int []arr = new int[len];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if(i == 0){
                arr[i] = array[i];
                max = arr[i];
                continue;
            }else {
                arr[i] = Math.max(arr[i-1]+array[i],array[i]);
                max = Math.max(arr[i],max);
            }
        }
        return max;
    }
    @Test
    public void testSubArray(){
//        int []arr = {6,-3,-2,7,-15,1,2,2};
//        System.out.println(FindGreatestSumOfSubArray(arr));
//        System.out.println(NumberOf1Between1AndN_Solution(13));
        int []arr = {3,32,321};
        System.out.println(PrintMinNumber(arr));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for (int i = 111; i <= 111; i++) {
           int temp = i;
           while (temp!=0){
               if(temp%10 == 1)
                   sum++;
               temp/=10;
           }
        }
        return sum;
    }
    public String PrintMinNumber(int [] numbers) {
        int len  = numbers.length;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(Integer.toString(numbers[i]));
        }
        Collections.sort(list,(x,y)->{
            int xlen = x.length();
            int ylen = y.length();
            for (int i = 0; i < Math.min(xlen,ylen); i++) {
                if(x.charAt(i)>y.charAt(i))
                    return 1;
                else if(x.charAt(i)<y.charAt(i))
                    return -1;
            }
            if(xlen>ylen){
                return x.charAt(xlen-1)>y.charAt(0)?1:-1;
            }else {
                return y.charAt(ylen-1)>x.charAt(0)?-1:1;
            }
        });
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
        }
        return builder.toString();
    }

    public int GetUglyNumber_Solution(int index) {
        if(index==0) return 0;
        //2^x*3^y*5^z
        int []arr = new int[index];
        int x = 0;
        int y = 0;
        int z = 0;
        arr[0] = 1;
        for (int i = 1; i < index; i++) {
            arr[i] = Math.min(Math.min(arr[x]*2,arr[y]*3),arr[z]*5);
            if(arr[i]==arr[x]*2) x++;
            if(arr[i]==arr[y]*3) y++;
            if(arr[i]==arr[z]*5) z++;
        }

        return arr[index-1];
    }
    @Test
    public void test(){
        //System.out.println(Integer.MAX_VALUE);
        int []arr = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
    }

    public int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else {
                map.put(s,1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if(map.containsKey(s)&&map.get(s)==1){
                return i;
            }
        }
        return -1;
    }

    public int InversePairs(int [] array) {

        int sum = 0;
        int len = array.length;
        int []arr = new int[len];
        arr[len-1] = 0;
        for (int i = len-2; i >=0 ; i--) {
            for (int j = len-1; j >i; j--) {
                if(array[i]>array[j]) sum++;
            }
        }
        return sum%1000000007;
    }

    public long mergersort(int []arr,int left,int right,int []temarr){
        if(left>=right) return 0;
        long sum = 0;
        int mid = (left+right)/2;
        sum+=mergersort(arr,left,mid,temarr);
        sum+=mergersort(arr,mid+1,right,temarr);
        int i = mid;
        int j = right;
        int n = 0;
        while (i>=left||j>=mid+1){
            if(i<left){
                while (j>=mid+1){
                    temarr[n++] = arr[j--];
                }
            }else if(j<mid+1){
              while (i>=left){
                  temarr[n++] = arr[i--];
              }
            } else if(arr[i]<=arr[j]){
                temarr[n++] = arr[j--];
            }else {
                temarr[n++] = arr[i--];
                sum+=(j-mid);
                sum=sum%1000000007;
            }
        }
        while (left<=right){
            arr[left++] = temarr[--n];
        }
        System.out.println("==============");
        return sum;
    }
    @Test
    public void testMergeSSort(){
        int []arr = {1,2,3,3,5,5,5,6,7,8};
        System.out.println(GetNumberOfK(arr, 5));

    }


    public int GetNumberOfK(int [] array , int k) {
        if(array.length<=0) return 0;
        int left = 0;
        int right = array.length-1;
        int mid = (left+right)/2;
        while (left<=right){
            if(array[mid]>k){
                right = mid-1;
            }else if(array[mid]<k) {
                left = mid+1;
            }else {
                break;
            }
            mid = (left+right)/2;
        }
        int sum = 0;
        for (int i = mid; i >=0 ; i--) {
            if(array[i]==k) sum++;
            else break;
        }
        for (int i = mid+1; i < array.length; i++) {
            if(array[i]==k) sum++;
            else break;
        }
        return sum;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        System.out.println(!(IsBalanced_num(root)==-1));
        return !(IsBalanced_num(root)==-1);
    }

    public int IsBalanced_num(TreeNode root){
        if(root == null) return 0;
        System.out.println(root.val);
        int leftnum = IsBalanced_num(root.left);
        int rightnum= IsBalanced_num(root.right);
        System.out.println(leftnum+" "+rightnum);
        if(leftnum==-1||rightnum==-1) return -1;
        if(Math.abs(leftnum-rightnum)<=1){
            return 1+Math.max(leftnum,rightnum);
        }else return -1;
    }

    @Test
    public void testBalanceTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        IsBalanced_Solution(root);
    }

    public int arraysum(int start,int end){
        int n = end-start+1;
        return n*start + n*(n-1)/2;
    }

    @Test
    public void testSUm(){
        //System.out.println(sum(9,16));
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(100);
        arrayLists.get(0).forEach(System.out::println);
    }
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int left = 1;
        int right = 2;
        while (right<sum){
            if(arraysum(left,right)<sum){
                right++;
            }else if(arraysum(left,right)>sum){
                left++;
            }else {
                ArrayList<Integer> tempList = new ArrayList<>();
                for (int i = left; i <=right ; i++) {
                    tempList.add(i);
                }
                list.add(tempList);
                left++;
            }
        }
        return list;
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        int len = array.length;
        int left = 0;
        int right = len-1;
        int minvalue = Integer.MAX_VALUE;
        while (left<right){
            if(array[left]+array[right]<sum){
                left++;

            }else if(array[left]+array[right]>sum){
                right--;
            }else {
                if(left*right<minvalue){
                    if(list.size()==0){
                        list.add(array[left]);
                        list.add(array[right]);
                        minvalue = left*right;
                    }
                    else {
                        list.set(0,array[left]);
                        list.set(1,array[right]);
                        minvalue = left*right;
                    }
                }
                left++;
                right--;
            }
        }
        return list;
    }

    @Test
    public void FindNumbersWithSumTest(){

        String str = "123";
        System.out.println(StrToInt(str));
    }

    public String LeftRotateString(String str,int n) {

        if(n>str.length()) return "";
        StringBuilder builder = new StringBuilder(str);
        char []ch = new char[n];
        builder.getChars(0,n,ch,0);
        return builder.delete(0,n).append(ch).toString();
    }

    public String ReverseSentence(String str) {




        String[] s = str.split(" ");
        StringBuilder builder = new StringBuilder();
        int right = str.length()-1;



        for (int i = s.length-1; i >=0; i--) {
            builder.append(s[i]);
            if(i!=0) builder.append(" ");
        }
        return builder.toString();
    }

    public int Add(int num1,int num2) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        Stream<Integer> stream = list.stream();
        return 1;
    }

    public int StrToInt(String str) {
        if(str.length()==0) return 0;
        int len = str.length();
        int base = 1;
        int sum = 0;
        for (int i = len-1; i >=1 ; i--) {
            char s = str.charAt(i);
            if(s>='0'&&s<='9'){
                sum+=(s-'0')*base;
                base*=10;
            }else {
                return 0;
            }
        }
        if(str.charAt(0)=='+'){
            return sum;
        }else if(str.charAt(0)>='0'&&str.charAt(0)<=9){
            return sum+=(str.charAt(0)-'0')*base;
        }else if(str.charAt(0)=='-'){
            return -1*sum;
        }
        return sum;
    }


    public boolean duplicate(int numbers[],int length,int [] duplication) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if(map.containsKey(numbers[i])){
                map.put(numbers[i],map.get(numbers[i]));
                duplication[0] = numbers[i];
                return true;
            }else {
                map.put(numbers[i],1);
            }
        }
//        for (int i = 0; i < length; i++) {
//            if(map.get(numbers[i])>=2){
//                duplication[0] = numbers[i];
//                return true;
//            }
//        }
        return false;
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(size>num.length||size==0) return list;
        TreeSet<Integer> set = new TreeSet<Integer>((x,y)->{return -(x-y);});
        for (int i = 0; i < num.length; i++) {
            if(i>=size){
                list.add(set.iterator().next());
                set.remove(num[i-size]);
            }
            set.add(num[i]);
        }
        if(set.size()>0){
            list.add(set.iterator().next());
            set.remove(num[num.length-size]);
        }
        return list;
    }

    @Test
    public void testMaInwindow(){
        int []arr = {16,14,12,10,8,6,4};
        maxInWindows(arr,0).forEach(System.out::println);
    }


}
