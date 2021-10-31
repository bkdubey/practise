package interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixMedian {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(list1);
        System.out.println("matrix median  "+new MatrixMedian().MatrixMedian(matrix));

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1));
        ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<>();
        matrix2.add(list2);
        System.out.println("matrix median  "+new MatrixMedian().MatrixMedian(matrix2));

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(3, 7, 7));
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(2, 9, 9));
        ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(3,3,4));
        ArrayList<Integer> list6 = new ArrayList<>(Arrays.asList(2,7,10));
        ArrayList<Integer> list7 = new ArrayList<>(Arrays.asList(1,7,7));
        ArrayList<Integer> list8 = new ArrayList<>(Arrays.asList(4,9,10));
        ArrayList<Integer> list9 = new ArrayList<>(Arrays.asList(5, 7, 10));
        ArrayList<Integer> list10 = new ArrayList<>(Arrays.asList(5, 6, 9));
        ArrayList<Integer> list11 = new ArrayList<>(Arrays.asList(1, 1, 2));
        ArrayList<ArrayList<Integer>> matrix3 = new ArrayList<>();
        matrix3.add(list3);matrix3.add(list4);matrix3.add(list5);matrix3.add(list6);matrix3.add(list7);
        matrix3.add(list8);matrix3.add(list9);matrix3.add(list10);matrix3.add(list11);
        System.out.println("matrix median  "+new MatrixMedian().MatrixMedian(matrix3));
    }


    public  int MatrixMedian(ArrayList<ArrayList<Integer>> A){
       // if(A.get(0).size()==0)          return A.get(0).get(0);
        int rowSize=A.size(); int colSize=A.get(0).size();
        //int size=A.size()-1;
        int low=Integer.MAX_VALUE;
        int high=A.get(rowSize-1).get(colSize-1); // max element of matrix
        //high=10^9;
        //low=Integer.MIN_VALUE; high=Integer.MAX_VALUE;
        // System.out.println("high is "+high);

        for(int i=0;i<rowSize;i++){
            low=Math.min(A.get(i).get(0),low);
            high= Math.max(A.get(i).get(colSize-1),high);
        }


        while (low <= high){
            int mid= low+ (high-low)/2;
            int count=0; // count number which is  <=mid
            for(int i=0;i< rowSize;i++){ // need to run for each row
                count = count+ this.countSmallerThanMid(A.get(i),mid);
            }
            if(count <= (rowSize*colSize)/2){  // get mid element of matrix using -(rowSize*colSize)/2
                low=mid+1;}
            else high=mid-1;

        }
        return low;
    }

    public int countSmallerThanMid(ArrayList<Integer> rowlist, int midElement ){
        int low=0; int size=rowlist.size()-1; int high=size;
        while (low<=high){
            int mid= low+(high-low)/2;
            if(rowlist.get(mid) <= midElement){low=mid+1;}
            else {high =mid-1; }
        }

        return low;
    }
}
