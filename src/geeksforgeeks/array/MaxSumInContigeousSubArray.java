package geeksforgeeks.array;

import java.math.BigInteger;

public class MaxSumInContigeousSubArray {

    public static void main(String[] args) {
    int arr []={5,-4,-2,6,-1};
        System.out.println("sum is "+maxSumContiguousSubArray(arr));
        int arr2 []={-5001}; // if all -ve
        System.out.println("sum  is "+maxSumContiguousSubArray(arr2));

        int arr3 []={-5,-3,-2}; // if all -ve
        System.out.println("sum  is "+maxSumContiguousSubArray(arr3));
    }

    // store rolling sum in current sum .
    public static int maxSumContiguousSubArray(int arr[]){
        int maxSum=(int)Double.NEGATIVE_INFINITY ; // or can do -> int i =-1/0 or int maxSum=Integer.MIN_VALUE
        int currSum=0;

        for(int i=0;i<arr.length;i++)
        {
            currSum=currSum+arr[i];

            if(currSum > maxSum)
                maxSum=currSum;
            if(currSum<0)
            {
                currSum=0;
            }
        }

        return  maxSum;
    }
}
