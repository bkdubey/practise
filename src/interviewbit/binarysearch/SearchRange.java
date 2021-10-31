package interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRange {
    public static void main(String[] args) {
       // searchRange(arr);
        int arr1[]={5,7,7,8,8,10};
       //System.out.println(searchRange(arr1,8));
       // System.out.println(searchRange(arr1,11));
        int arr2[]={5,7,7,8,8,10};

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5,7,7,8,8,10));
       // System.out.println(new SearchRange().searchRange(arr,8));

        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(2,7,7,8,8,8));
        System.out.println(new SearchRange().searchRange(arr3,2));
        //min & max index need to search for given element

        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(2,8,8,8,8,8));
        //System.out.println(new SearchRange().searchRange(arr4,8));

    }

    public static int searchRange(int arr[] , int elementToSearch){
        int size=arr.length;
        int low=0; int high= size-1;
        int mid=low+(high-low)/2;
        System.out.println("left range is "+leftSearch(arr,elementToSearch));
        System.out.println("right range is "+rightSearch(arr,elementToSearch));

       return -100;
    }

    public  static int  leftSearch(int arr[] , int elementToSearch){
        int low=0; int high= arr.length-1;
        int mid; int counter=0; int index=-1;
        while(low<=high ){
            mid=low+(high-low)/2;
          // System.out.println("low "+low+"mid "+mid+" high "+high);

            if(arr[mid] >= elementToSearch) // note- equal condition is imp in case of duplicate
            {
                // low++; not required here to increase
                high=mid-1;
            }
            else if(arr[mid] < elementToSearch)
            {
                //high--;
                low=mid+1;
            }
            if(arr[mid]==elementToSearch ){  index=mid; }



        }

        return index;

    }

    public  static int  rightSearch(int arr[] , int elementToSearch){
        int low=0; int high= arr.length-1;
        int mid; int counter=0; int index=-1;
        while(low<=high ){
            mid=low+(high-low)/2;
            // System.out.println("low "+low+"mid "+mid+" high "+high);

            if(arr[mid] > elementToSearch)
            {
                high=mid-1;
            }
            else if(arr[mid] <= elementToSearch)  // note- equal condition is imp in case of duplicate
            {
                //high--;
                low=mid+1;
            }
            if(arr[mid]==elementToSearch ){  index=mid;
             //mid++;
            }



        }

        return index;

    }

    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        ArrayList<Integer> output= new ArrayList<Integer>();
        output.add(leftSearch(A,B));
        output.add(rightSearch(A,B));

        return output;
    }

    public   int  leftSearch(List<Integer> A , int elementToSearch){
        int low=0; int high= A.size()-1;
        int mid; int counter=0; int index=-1;
        while(low<=high ){
            mid=low+(high-low)/2;

            if(A.get(mid) >= elementToSearch) // note- equal condition is imp in case of duplicate
            {
                // low++; not required here to increase
                high=mid-1;
            }
            else if(A.get(mid) < elementToSearch)
            {
                //high--;
                low=mid+1;
            }
            if(A.get(mid)==elementToSearch ){  index=mid; }



        }

        return index;

    }

    public  static int  rightSearch(List<Integer> A , int elementToSearch){
        int low=0; int high= A.size()-1;
        int mid; int counter=0; int index=-1;
        while(low<=high ){
            mid=low+(high-low)/2;
            // System.out.println("low "+low+"mid "+mid+" high "+high);

            if(A.get(mid) > elementToSearch)
            {
                high=mid-1;
            }
            else if(A.get(mid) <= elementToSearch)  // note- equal condition is imp in case of duplicate
            {
                //high--;
                low=mid+1;
            }
            if(A.get(mid)==elementToSearch ){  index=mid;
            }



        }

        return index;

    }


}
