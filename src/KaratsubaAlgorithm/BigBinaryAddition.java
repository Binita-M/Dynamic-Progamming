package KaratsubaAlgorithm;

import java.util.Arrays;

public class BigBinaryAddition {
    public int[] addBinaryNumbers(int[] array1, int[] array2) {

        int n = array1.length;
        int [] add = new int[n+1];
        int carry = 0;

        for (int i=n-1; i>=0; i--){
                int sum = array1[i]+array2[i]+carry;
                add[i+1] = sum%2; //Insight: sum%2 stored in i+1 position because i position is for carry
                carry = sum/2;
        }
        add[0] = carry; //Insight: Last carry stored in the first position ie i=0
        return add;
    }

    public static void main(String[] args) {
        BigBinaryAddition bigBinaryAddition = new BigBinaryAddition();
        int[] array1 = {1,0,1,0,0,1};
        int[] array2 = {0,0,1,1,0,1};
        int[] add = bigBinaryAddition.addBinaryNumbers(array1, array2);
        System.out.println(Arrays.toString(add));

    }
}
