package interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

// this solution is good and work for both sorted and unsorted array
public class AllocateBookUnSorted {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12,34,67,90));
        System.out.println("allocation "+new AllocateBookUnSorted().allocateBook(list,2));

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(5,17,100,11));
        System.out.println("allocation "+new AllocateBookUnSorted().allocateBook(list2,4));


        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(5,17,11));
        System.out.println("allocation "+new AllocateBookUnSorted().allocateBook(list3,4));

        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(73, 58, 30, 72, 44, 78, 23, 9));
        System.out.println("allocation "+new AllocateBookUnSorted().allocateBook(list4,5));
        //o/p- 110 , mine return 233

        ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        System.out.println("allocation "+new AllocateBookUnSorted().allocateBook(list5,2));

        ArrayList<Integer> list6 = new ArrayList<>(Arrays.asList(1,10));
        System.out.println("allocation "+new AllocateBookUnSorted().allocateBook(list6,2));


    }

    public  int allocateBook(ArrayList<Integer> A , int B){
        int min=A.get(0); // max of array
        int max=0; //sum of array
        //int high=0;
        int result =-1; int mid ;
        if(A.size() < B) {return -1;}
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
