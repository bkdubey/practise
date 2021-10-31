package interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(list1);

        System.out.println("matrix search found "+new MatrixSearch().matrixSearch(matrix,1));
    }

    public int matrixSearch(ArrayList<ArrayList<Integer>> A, int B)
    {   int rowSize= A.size(); int colSize= A.get(0).size();
        if(rowSize==0) return 0;
        int low=0; int high= (rowSize* colSize)-1;

        while(low <= high)
        {   int mid = low + (high-low)/2;
           // System.out.println("low "+ low+" high "+ high+ " mid "+mid+ " rowsize" + rowSize);
        int actaulIndexValue=A.get(mid/colSize).get(mid%colSize);
            if( actaulIndexValue== B)
            {
                return 1 ;
            }
            else if(actaulIndexValue < B){
                low =mid +1;
            }  else  { high =mid-1;}


        }

        return 0;
    }
}

