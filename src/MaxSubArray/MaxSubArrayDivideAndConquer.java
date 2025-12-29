package MaxSubArray;

public class MaxSubArrayDivideAndConquer {
    public static int maxSubArray (int [] array, int left, int right) {
        //Base case 1 element
        if (left == right){
            return 0;
        }
        //Base case 2 element
        if (left == right + 1){
            return Math.max(array[left]-array[right], 0);
        }

        //divide the array
        int middle = (left + right)/2;

        //Recursive calls
        int m1 = maxSubArray(array, left, middle);
        int m2 = maxSubArray(array, middle+1, right);

        //Straddling case
        int y1 = maxElement(array, middle+1, right);
        int x1 = minElement(array, left, middle);

        //Combine Step
        return Math.max(Math.max(m1, m2), y1-x1);
    }

    private static int maxElement(int[] array, int left, int right) {
        int maxElement = Integer.MIN_VALUE;
        for(int i=left; i<=right; i++) {
            maxElement = Math.max(maxElement, array[i]);
        }
        return maxElement;
    }
    private static int minElement(int[] array, int left, int right) {
        int minElement = Integer.MAX_VALUE;
        for(int i=left; i<=right; i++) {
            minElement = Math.min(minElement, array[i]);
        }
        return minElement;
    }

    public static void main(String[] args) {
        int [] array = {1,4,5,3,8,9,6};
        System.out.println(maxSubArray(array,0, array.length-1 ));
    }
}


