package NiuKe;

import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        int []a = {1};
        int []b = {};
        merge(a,1,b,0);
        System.out.println(Arrays.toString(a));
    }
    public  static void merge(int A[], int m, int B[], int n) {
        int []c = new int[m+n];
        int i = 0;
        int j = 0;
        int t = 0;
        while (i<m||j<n){

            if(i>=m){

                for (; j < n; j++) {
                    c[t] = B[j];
                    t++;
                }
                break;
            }else if(j>=n){

                for (; i < m; i++) {
                    c[t] = A[i];
                    t++;
                }
                break;
            } else if(A[i]<B[j]){
                c[t] = A[i];
                i++;t++;
            }else {
               c[t] = B[j];
               t++;j++;
            }
        }
        for (int k = 0; k < m+n; k++) {
            A[k] = c[k];
        }
    }
}
