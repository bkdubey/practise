package geeksforgeeks.array.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortArrayWithSquare {
    public static void main(String[] args) {
    //int arr[]={-4,-1,0,3,10};
    ArrayList<Integer> arr= new ArrayList<>(Arrays.asList(-4,-1,0,3,10));
        sortArrayWithSquare(arr);
    }

    public static ArrayList<Integer> sortArrayWithSquare(ArrayList<Integer> A)
    {   int size=A.size();
        for(int i=0;i<size;i++)
        {   int square=Math.abs(A.get(i));
            A.set(i,square*square);
        }
        Collections.sort(A);

        return A;
    }
}
