package geeksforgeeks.twodarray;

import geeksforgeeks.utility.PrintArray;

import java.util.ArrayList;

public class SetMatrixZero {
    public static void main(String[] args) {

        int arr[][]= {{1,1,1},{1,0,1},{1,1,1}};
        //settingZero(arr); // greatly explained in array way
        int arr1[][]= {{1,0,1},{1,1,1},{1,0,1}};
        //settingZero(arr1);
        int arr2[][]= {{1,0},{1,1}};
        settingZero(arr2);

        int arr3[][]={
                {1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0},
                {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1},
                {0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1},
                {0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1}
        };
        //settingZero(arr3);


    }
    public static void settingZero(int arr[][]){
        int col0=1; // set zero if any where column you find zero
        int colLenght=arr[0].length;
        int size= arr.length; //int col= arr[0].length;
        //System.out.println("szie"+size+"col length"+col);
        for(int i=0;i<size;i++) // traversing row level
        {   if(arr[i][0]==0) col0=0; // if any value in 1st column , mark this flag =0
            for(int j=1;j<colLenght;j++)
            {
                if(arr[i][j]==0) {
                    arr[i][0]= arr[0][j]=0; // setting left & top most to zero
                }
            }

        }
        System.out.println("you can see inline dummay array updated------");
        PrintArray.printMatrix(arr);

        // now check if any dummy row or col =0 then mark zero
        //reading in reverse direction so it can not update dummy array falsely .
        //dummy array is - first row & first column
        for(int i=size-1;i>=0;i--)
        {
            for(int j=colLenght-1;j>=1;j--)
            {

                if(arr[i][0]==0 || arr[0][j]==0)
                {arr[i][j]=0;
                }
            }
            if(col0 ==0) // if any of first column had zero value , then set to zero while reading in reverse
            {
                arr[i][0]=0;
            }
        }
        System.out.println("o/p array-----");

        PrintArray.printMatrix(arr);

    }


    public static void settingZero(ArrayList<ArrayList<Integer>> a){
        int col0=1; // set zero if any where in first column you find zero
        int size= a.size();
        int colLength=a.get(0).size();

        for(int i=0;i<size;i++) // traversing row level
        {   if(a.get(i).get(0)==0) col0=0; // if any value in 1st column , mark this flag =0
            for(int j=1;j<colLength;j++)
            {
                if(a.get(i).get(j)==0) {
                    // setting left & top most to zero
                    a.get(i).set(0,0);
                    a.get(0).set(j,0);
                }
            }

        }

        // now check if any dummy row or col =0 then mark zero
        //reading in reverse direction so it can not update dummy array falsely .
        //dummy array is - first row & first column
        for(int i=size-1;i>=0;i--)
        {
            for(int j=colLength-1;j>=1;j--)
            {
                if(a.get(i).get(0)==0 || a.get(0).get(j)==0)
                {  a.get(i).set(j,0);
                }
            }
            if(col0 ==0) // if any of first column had zero value , then set to zero while reading in reverse
            {
                a.get(i).set(0,0);
            }
        }
        System.out.println(a);
    }
}
