package KaratsubaAlgorithm;

import java.util.Arrays;

public class BinaryAdditionDifferentLength {
    public int[] zeroPad(int[]array, int newLength) {
        int[] padded = new int[newLength];
        int diff = newLength - array.length;
        for (int i=0; i<array.length; i++) {
            padded[i+diff] = array[i];
        }
        return padded;
    }

    public int[] binaryAdditionDifferentLength(int[] array1, int[] array2) {
        int n = Math.max(array1.length, array2.length);
        int [] add = new int[n+1];
        int carry = 0;

        array1 = zeroPad(array1, n);
        array2 = zeroPad(array2, n);

        for (int i=n-1; i>=0; i--) {
            int sum = array1[i] + array2[i] + carry;
            add[i+1] = sum%2;
            carry = sum/2;
        }
        add[0] = carry;
        return add;
        }

    public static void main(String[] args) {
        BinaryAdditionDifferentLength badl = new BinaryAdditionDifferentLength();

       int[] array1 = {1,0,0,0,1,1};
       int[] array2 = {0,1,1,0};

       int[] add = badl.binaryAdditionDifferentLength(array1, array2);

        //System.out.println("Sum: " + Arrays.toString(add));
        //int[] array = badl.zeroPad(array2, 6);
        System.out.println(Arrays.toString(add));
    }

    }

