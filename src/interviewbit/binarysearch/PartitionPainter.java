package interviewbit.binarysearch;


import java.util.ArrayList;
import java.util.Arrays;


public class PartitionPainter {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1000000, 1000000));
        System.out.println(" o/p "+ new PartitionPainter().paint(1,1000000,list1)); // expected - 9400003

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(762, 798, 592, 899, 329));
        System.out.println(" o/p "+ new PartitionPainter().paint(6,10,list2)); // returned 9999993 , expected - 8990
    }


    public long paint(int A, int B, ArrayList<Integer> C) {
        long d=10000003; ;long tempResult=(long)allocateBook(C,A); long unit = B;
        System.out.println("tempResult "+tempResult );
        //return  tempResult*unit;
       return mod(mod(tempResult,d)* mod(unit,d),d);
    }
    public static long mod(long value , long d){
        return ((value%d)+d)%d;
    }

    public  int allocateBook(ArrayList<Integer> A , int B){
        int min=A.get(0); // max of array
        int max=0; //sum of array
        //int high=0;
        int result =-1; int mid ;
        //if(A.size() < B) {return -1;}
        for(int i : A)
        {
            if(i > min){min=i;}
            max=max+i;
        }
        //System.out.println("min "+min+"sum is "+max);
        while (min<=max){
            mid=(min+max)/2;
            //time complexity - log(n)(for binary) * n(for allocation possible function )
            if(allocationPossible(mid,A,B) ){
                result=mid;
                max =mid-1;
            }
            else {
                min=mid+1;
            }

        }
        return result;
    }

    //time complexity = o(n)
    public boolean allocationPossible(int stopPoint , ArrayList<Integer> list, int totalStudent){
        int allotedStudent=1; int pages=0;
        for(int i=0;i<list.size();i++)
        {
            if(pages+list.get(i) > stopPoint){
                allotedStudent++;
                pages = list.get(i);
            }
            else pages += list.get(i);
        }

        if(allotedStudent > totalStudent ) return false;
        else return true;

        // return true;
    }

}
