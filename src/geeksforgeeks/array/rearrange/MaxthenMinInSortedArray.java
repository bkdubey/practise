package geeksforgeeks.array.rearrange;

import geeksforgeeks.utility.PrintArray;

public class MaxthenMinInSortedArray {
    public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7};
    /**
     * Input: arr[] = {1, 2, 3, 4, 5, 6, 7}
     * Output: arr[] = {7, 1, 6, 2, 5, 3, 4}
     * */

        getMinMax(arr); // o(n^2) complexity

    }

    public static void getMinMax(int arr[])
    {
        for(int i=0;i<=(arr.length/2)+1;i=i+2)
        {


            PrintArray.printArray(rotateby(i,arr));
            System.out.println();
        }
    }

    public  static  int [] rotateby(int pointer,int a[]){
        int length=a.length-1;         int temp=a[length];
        for(int i=0;i<a.length-pointer-1;i++){
            a[length-i]=a[length-i-1];
        }
        a[pointer]=temp;

        return a;
    }

}
