package geeksforgeeks.array.rearrange;

public class FindMinSwap {
    public static void main(String[] args) {
        /*
        * Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
            Output: 1

            Explanation:
            To bring elements 2, 1, 3 together, swap
            element '5' with '3' such that final array
            will be-
            arr[] = {2, 1, 3, 6, 5}

            Input:  arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
            Output: 2
        *
        * */
       int arr[] = {2, 1, 5, 6, 3}; int k=3;
        System.out.println("min swap is "+minSwap(arr,k));
        int  arr1[] = {2, 7, 9, 5, 8, 7, 4} ; k = 5;
        System.out.println("min swap is "+minSwap(arr1,k));

    }

    public static int minSwap(int arr[], int k) {
        int minswap = 0;
        int temp;
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < k) {
                left++;
            } else if (arr[right] <= k) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                minswap++; left++;

            } else {
                right--;
            }

        }
        return minswap;

    }
}
