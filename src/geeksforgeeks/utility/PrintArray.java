package geeksforgeeks.utility;

public class PrintArray {
    public static void printArray(int arr[])
    {
        System.out.println("legnth of array is -"+arr.length);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void print2dArray(int arr[][])
    {
        System.out.println("legnth of array is -"+arr.length);
        for (int i = 0; i < arr.length; i++)
        {   for(int j=0;j< arr.length;j++)
            {System.out.print(arr[i][j] + " ");}
            System.out.println("");
        }
    }

    public static void printMatrix(int arr[][])
    {
        int rows=arr.length; int col=arr[0].length;
        System.out.println("legnth of array is -"+arr.length);
        System.out.println("no of row  "+ rows +"-- & col"+ col);

        for (int i = 0; i < rows; i++)
        {   for(int j=0;j< col;j++)
        {System.out.print(arr[i][j] + " ");}
            System.out.println("");
        }
    }
}
