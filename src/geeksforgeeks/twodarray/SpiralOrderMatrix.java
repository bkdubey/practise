package geeksforgeeks.twodarray;

import geeksforgeeks.utility.PrintArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SpiralOrderMatrix {
    public static void main(String[] args) {
        generateSpiralMetric(6);

    }

    public static void generateSpiralMetric(int n){
            int arr[][]= new int[n][n];
            int size=arr.length;
            int lastC=size; int lastR=size; int firstC=size-1; int firstCIndex=0; int value=0;
            for(int i=0;i<=n/2;i++)
            {
                lastC--; lastR--; firstC--;
                for(int j=i;j<=lastC;j++)
                {
                    arr[i][j]=++value;
                }
                for(int k=i+1;k<=lastC;k++)
                {
                    arr[k][lastC]=++value;
                }

                for(int l=lastR-1;l>=i;l--)
                {
                    arr[lastR][l]=++value;
                }

                for(int m=firstC;m>=i+1;m--)
                {
                    arr[m][firstCIndex]=++value;
                }
                firstCIndex++;

                PrintArray.print2dArray(arr);
            }

            // converting into list
        System.out.println( Arrays.asList(arr));


    }

}


 class Solution {
     public static void main(String[] args) {
         generateMatrix(3);
     }
    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(A);
        for(int i = 0; i < A; i++)  {
            list.add(new ArrayList<Integer>(Collections.nCopies(A, 0)));
        }
        System.out.println("list"+list);
        //int arr[][]= new int[n][n];
        int size=A;
        int lastC=size; int lastR=size; int firstC=size-1; int firstCIndex=0; int value=0;
        for(int i=0;i<=A/2;i++)
        {
            lastC--; lastR--; firstC--;
            for(int j=i;j<=lastC;j++)
            {
                list.get(i).set(j,++value);
            }
            for(int k=i+1;k<=lastC;k++)
            {
                list.get(k).set(lastC,++value);
            }

            for(int l=lastR-1;l>=i;l--)
            {
                list.get(lastR).set(l,++value);
            }

            for(int m=firstC;m>=i+1;m--)
            {
                list.get(m).set(firstCIndex,++value);
            }
            firstCIndex++;
            System.out.println("list is "+list);
        }
        return  list;
    }
}