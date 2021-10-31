package interviewbit.binarysearch;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.ArrayList;
import java.util.Arrays;

@Ignore // kind of duplicate of rotated array
//but finding break point is little difficult... still pending for noting it down

public class SearchInBitonic {
    public static void main(String[] args) {
       // ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 2, 8, 10));
        //System.out.println("index is  "+new SearchInBitonic().searchInbitonic(list,1));
        //ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 8, 10));
        //System.out.println("index is  "+new SearchInBitonic().searchInbitonic(list,2));
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(-3, 9, 18, 20, 17, 5, 1));
        System.out.println("index is  "+new SearchInBitonic().searchInbitonic(list1,20));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10, 3, 2, 1));
        System.out.println("index is  "+new SearchInBitonic().searchInbitonic(list2,30));

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11));
        System.out.println("index is  "+new SearchInBitonic().searchInbitonic(list3,12));


    }

    public int searchInbitonic(ArrayList<Integer> A, int B){
        int size=A.size()-1;
        //findBreakpoint(A,B,size);
        int left=0; int right=size;
        while(left < right){
            int mid= left + ((right-left)/2);
            if(A.get(mid)> A.get(right)){
                left= mid+1;
            }else {right=mid;}
        }

        System.out.println("low"+left+" high "+right + "mid " ); // these are break point , left & right
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


    }

}
