package interviewbit.binarysearch;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.ArrayList;
import java.util.Arrays;

@Ignore // level easy
@Deprecated
public class SmallerThanElement {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 8, 10));
        System.out.println("no of element small than B is- "+new SmallerThanElement().smallThanElement(list,9));
        ArrayList<Integer> list1= new ArrayList<>(Arrays.asList(1, 2, 2, 2, 5, 7, 9));
        System.out.println("no of element small than B is- "+new SmallerThanElement().smallThanElement(list1,2));
        ArrayList<Integer> list2= new ArrayList<>(Arrays.asList(1, 2, 2, 2, 2, 2, 9));
        System.out.println("no of element small than B is- "+new SmallerThanElement().smallThanElement(list2,2));
        ArrayList<Integer> list3= new ArrayList<>(Arrays.asList(1, 2, 2, 2, 2, 2, 9));
        System.out.println("no of element small than B is- "+new SmallerThanElement().smallThanElement(list3,0));
    }

    public int smallThanElement(ArrayList<Integer> A , int B){
        int size= A.size()-1; int low =0; int high=size; int result=-1;

        while (low<=high)
        {   int mid = low + (high-low)/2;
            if(A.get(mid)<= B){
                low= mid+1; result = Math.max(result, mid);
            }
            if(A.get(mid)>B) { high = mid-1 ;
            }
        }



        return result+1;
    }
}
