package KaratsubaAlgorithm;

import java.util.Arrays;

public class GradeSchoolMultiplication {

    //add temp to res(binary addition
    public static void addTo(int[] res, int[] temp) {
        int carry = 0;
        for (int i = res.length - 1; i >= 0; i--) {
            int sum = res[i] + temp[i] + carry;
            res[i] = sum % 2;
            carry = sum / 2;
        }
    }

    //shift left: append 0 at the end
    public static void shiftLeft(int[]temp) {
        for(int i=0; i<temp.length-1; i++) {
            temp[i]=temp[i+1];
        }
        temp[temp.length-1]  = 0;
    }

    //grade school multiply
    public static int[] multiply(int[] A, int[] B) {
        int m=A.length;
        int n=B.length;

        //res = [0.....0] (m+n zeroes)
        int[] res = new int[m+n];

        //temp = [0.....0]
        int [] temp = new int[m+n];

        //copy A into rightmost m positions
        for (int i=0; i<m; i++) {
            temp[n+i] = A[i];
        }

        //for j=m down to 1
        for(int j=n-1; j>=0; j--) {
            if(B[j]==1) {
                addTo(res, temp);
            }
            shiftLeft(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,0,1};
        int[] B = {1,1};

        int[] result = multiply(A,B);
        System.out.println(Arrays.toString(result));
    }

}
