package interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianOfArray {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(7,12,14,15,16));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,9,11));
        System.out.println(" median is  "+new MedianOfArray().medianOfArray(list1,list2));

        ArrayList<Integer> list1_1 = new ArrayList<>(Arrays.asList(7,12,14,15));
        ArrayList<Integer> list2_1 = new ArrayList<>(Arrays.asList(1,2,3,4,9,11));
        System.out.println(" median is  "+new MedianOfArray().medianOfArray(list1_1,list2_1));


        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1,2));
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(3,4,5));
        System.out.println(" median is  "+new MedianOfArray().medianOfArray(list3,list4));

        ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> list6 = new ArrayList<>(Arrays.asList(3,4,5));
        System.out.println(" median is  "+new MedianOfArray().medianOfArray(list5,list6));

        ArrayList<Integer> list7 = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> list8 = new ArrayList<>(Arrays.asList(1));
        System.out.println(" median is  "+new MedianOfArray().medianOfArray(list7,list8));

        ArrayList<Integer> list9 = new ArrayList<>();
        ArrayList<Integer> list10 = new ArrayList<>(Arrays.asList(20));
        System.out.println("list9 "+list9+ "list10 "+list10);
        System.out.println(" median is  "+new MedianOfArray().medianOfArray(list9,list10));
    }

    public double medianOfArray(ArrayList<Integer> A , ArrayList<Integer> B){
        if(B.size() < A.size()) return  medianOfArray(B,A);

        if(A.size()==1 && B.size()==0){ return  A.get(0)/1.0 ;} // good base condition, for 1 element

        int sizeA= A.size();
        int low=0 ; int high=sizeA; int sizeB= B.size();

        while(low <= high){
            int cut1= low + (high-low)/2;
            int cut2= (sizeA+sizeB+1)/2-cut1; // for handling even/odd case

            int left1= cut1==0 ? Integer.MIN_VALUE : A.get(cut1-1); //for comparing when there is no element in left
            int left2= cut2==0 ? Integer.MIN_VALUE : B.get(cut2-1);

            int right1= cut1==sizeA ? Integer.MAX_VALUE : A.get(cut1);
            int right2= cut2==sizeB ? Integer.MAX_VALUE : B.get(cut2);

            if(left1 <= right2 && left2 <= right1){ // take care of equal condition
                if((sizeA+sizeB)%2==0){
                    return  (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                    // note median will be in double for even number of array .
                }
                else return Math.max(left1,left2); // for odd one

            }
           else  if(left1 > right2) { high = cut1-1; }
            else  {  low = cut1+1; } //or can be written if(left1 < right2)
        }

        return -1.0;
    }


}
