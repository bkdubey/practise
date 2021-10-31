package interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInUnsortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(30,35, 40, 50, 10, 15,20));
        System.out.println("found value "+new SearchInUnsortedArray().searchInSortedArray(list,10));
        System.out.println("found value "+new SearchInUnsortedArray().searchInSortedArray(list,35));

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3,4,5,1,2));
        System.out.println("found value "+new SearchInUnsortedArray().searchInSortedArray(list2,4));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(7,6,1,2,3,4,5));
        System.out.println("found value "+new SearchInUnsortedArray().searchInSortedArray(list3,4));
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("found value "+new SearchInUnsortedArray().searchInSortedArray(list4,10));
    }
    public int searchInSortedArray(ArrayList<Integer> A , int B){
        int size=A.size()-1;
        //findBreakpoint(A,B,size);
        int left=0; int right=size;
        while(left < right){
            int mid= left + ((right-left)/2);
            if(A.get(mid)> A.get(right)){
                left= mid+1;
            }else {right=mid;}
        }

        //System.out.println("low"+left+" high "+right); // theese are break point , left & right
        int start=left; int low=0; int high=size;
        if(B >=A.get(start) && B <=A.get(high)){
            low=start;
        }else { high =start;  }

        while(low<=high){
            int mid=low+(high-low)/2;

            if(A.get(mid)==B ){ return mid;}
            else if(A.get(mid) > B)
            {
                // low++; not required here to increase
                high=mid-1;
            }
            else if(A.get(mid) < B)
            {
                low=mid+1;
            }
        }

        return -1;



        //System.out.println("breakpoint is "+findBreakpoint(A,B,size));


    }

    public  int binarySearch(ArrayList<Integer> lists , int elementToSearch){
        int size=lists.size()-1;
        int low=0; int high= size;
        int mid;
        while(low<=high){
            mid=low+(high-low)/2;
            //if(arr[low]==elementToSearch ){ return low;}
            //if(arr[high]==elementToSearch ){ return high;}

            if(lists.get(mid)==elementToSearch ){ return mid;}
            else if(lists.get(mid) > elementToSearch)
            {
                // low++; not required here to increase
                high=mid-1;
            }
            else if(lists.get(mid) < elementToSearch)
            {
                //high--;
                low=mid+1;
            }
        }

        return -1;
    }

    private int findBreakpoint(ArrayList<Integer> a, int b,int size) {
        int result=-1; int low=0; int high=size; int mid=-1;
        while(low<=high)
        {
            mid=low+((high-low)/2);
            if(a.get(mid)< a.get(high))
            {
                high=mid-1;            } else { low= mid+1 ; high--;}
            if(a.get(mid)<=a.get(low)){
                 low++; high=mid-1;
            }
           // System.out.println("low"+low+"mid "+mid+" high "+high);
        }

        return mid;
    }

}
