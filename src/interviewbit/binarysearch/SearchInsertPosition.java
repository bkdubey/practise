package interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

// note , i am able to do it by my own
public class SearchInsertPosition {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        System.out.println(" insert index is  "+new SearchInsertPosition().insertPosition(list1,5));

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        System.out.println(" insert index is  "+new SearchInsertPosition().insertPosition(list2,2));

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1,2, 3,4, 5, 6,8));
        System.out.println(" insert index is  "+new SearchInsertPosition().insertPosition(list3,7));

        ArrayList<Integer> list4= new ArrayList<>(Arrays.asList(1,2, 2,2, 3, 4,5));
        System.out.println(" insert index is  "+new SearchInsertPosition().insertPosition(list4,2));

        ArrayList<Integer> list5= new ArrayList<>(Arrays.asList(1,2, 2,2, 3, 4,4,6));
        System.out.println(" insert index is  "+new SearchInsertPosition().insertPosition(list5,5));

        ArrayList<Integer> list6= new ArrayList<>(Arrays.asList(1,2,2,2,3,4,4,6));
        System.out.println(" insert index is  "+new SearchInsertPosition().insertPosition(list6,4));


        ArrayList<Integer> list7= new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        System.out.println(" insert index is  "+new SearchInsertPosition().insertPosition(list7,7));

        ArrayList<Integer> list8= new ArrayList<>(Arrays.asList(1, 3, 5, 6));
        System.out.println(" insert index is  "+new SearchInsertPosition().insertPosition(list8,0));
    }

    public int insertPosition(ArrayList<Integer> A , int B ){
        int size=A.size()-1; int low=0; int high= size; int elementToSearch=B;
        int index1=0; int index2=size;

        if(B > A.get(size)){return size+1;}
        if(B < A.get(0)){return 0;}
        while (low<=high){
            int mid = low + (high-low)/2;
            if(A.get(mid) < elementToSearch){
                low= mid+1; index1= Math.max(index1,mid);
            }else if(A.get(mid) == elementToSearch){index1= Math.max(index1,low); // this is imp condition
                low= low+1;
            }
            if(A.get(mid) >= elementToSearch ){
                high=mid-1; index2= Math.min(index2,mid);
            }

        }
      //  System.out.println("index1 "+index1+ " index2 "+index2);

        return  Math.max(index1,index2);
    }

}
