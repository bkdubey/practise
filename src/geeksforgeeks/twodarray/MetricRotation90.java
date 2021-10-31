package geeksforgeeks.twodarray;

import geeksforgeeks.utility.PrintArray;

public class MetricRotation90 {
    public static void main(String[] args) {
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
        /*Input:
        1 2 3
        4 5 6
        7 8 9
        Output:
        7 4 1
        8 5 2
        9 6 3*/
        PrintArray.print2dArray(arr);
        transpose(arr);
        PrintArray.print2dArray(arr);
        flip(arr);
        PrintArray.print2dArray(arr);
    }

    /*transpose Output: (its diagonal swapping from left to right like 2-4 & 3-7)
            1 4 7
            2 5 8
            3 6 9*/
    public static int[][] transpose(int arr[][]){
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i;j<arr.length;j++)
            {int temp=arr[i][j];
                arr[i][j]= arr[j][i];
                arr[j][i] = temp;
            }
        }
        return arr;
    }

    /* flip , transposed array
            7 4 1
            8 5 2
            9 6 3*/

    public static int[][] flip(int arr[][]){
        int size=arr.length;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length/2;j++)
            {
                int temp=arr[i][j];
                arr[i][j]= arr[i][size-1-j];
                System.out.println("temp & arr[i][j]"+temp+" "+arr[i][j]);
                arr[i][size-1-j] = temp;
            }
        }
        return arr;
    }

}
