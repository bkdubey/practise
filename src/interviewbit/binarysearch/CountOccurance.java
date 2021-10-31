
package interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOccurance {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 10));
        System.out.println(" occurance  is  "+new CountOccurance().countOccurance(list1,8));


    }

    /*public int countOccurance(ArrayList<Integer> A , int B)
    {  int low=0; int high=A.size()-1; int result = -1;

        while(low<=high){
            int mid= low+(high-low)/2;
            if(mid==B){
                result = mid ;;
                low = mid+1;
            }
            else if (B < A.get(mid)){high = mid -1; }
            else low = mid +1;
        }

        return  result;
    }*/


    public int countOccurance(ArrayList<Integer> A , int B)
    {  int count =0;
        for(int i=0;i<A.size();i++){
            if(A.get(i)==B){count++;}
        }
        return  count;
    }
}
