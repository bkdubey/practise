package interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBook {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12,34,67,90));
        System.out.println("allocation "+new AllocateBook().allocateBook(list,2));

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(5,17,100,11));
        System.out.println("allocation "+new AllocateBook().allocateBook(list2,4));


        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(5,17,11));
        System.out.println("allocation "+new AllocateBook().allocateBook(list3,4));

        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(73, 58, 30, 72, 44, 78, 23, 9));
        System.out.println("allocation "+new AllocateBook().allocateBook(list3,5));
        //o/p- 110 , mine return 233

    }

    public  int allocateBook(ArrayList<Integer> A , int B){
        int low=A.get(0); int high=0; int result =-1; int mid ;
        if(A.size() < B) {return -1;}
        for(int i : A)
        {
            if(i <low){low=i;}
            high=high+i;
        }
       // System.out.println("min "+low+"sum is "+high);
        while (low<=high){
            mid=(low+high)>>1;
            //time complexity - log(n)(for binary) * n(for allocation possible function )
            if(allocationPossible(mid,A,B) ){
                result=mid;
                high =mid-1;
            }
            else {
                low=mid+1;
            }

        }
        return result;
    }

    //time complexity = o(n)
    public boolean allocationPossible(int stopPoint , ArrayList<Integer> list, int totalStudent){
        int allotedStudent=1; int pages=0;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)>stopPoint) {return  false;}
            if(pages+list.get(i) > stopPoint){
                allotedStudent++;
                pages += list.get(i);
            }
            else pages += list.get(i);
        }

        if(allotedStudent > totalStudent ) return false;


        return true;
    }


}
