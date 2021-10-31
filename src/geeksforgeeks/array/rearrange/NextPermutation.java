package geeksforgeeks.array.rearrange;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>(Arrays.asList(1,3,5,4,2));
        //o/p should be 1 4 2  3 5
        System.out.println(nextPermutation(list));
        ArrayList<Integer> list1= new ArrayList<>(Arrays.asList(3,2,1));
        //o/p should be 1 2 3
        System.out.println(  nextPermutation(list1));

        ArrayList<Integer> list2= new ArrayList<>(Arrays.asList(1,2,3));
        //o/p should be 1 3 2
        System.out.println(  nextPermutation(list2));

        ArrayList<Integer> list3= new ArrayList<>(Arrays.asList(1,1,5));
        //o/p should be 1 5 1
        System.out.println(  nextPermutation(list3));
        ArrayList<Integer> list4= new ArrayList<>(Arrays.asList(20,50,113));
        //o/p should be 20,113, 50
        System.out.println(  nextPermutation(list4));
        ArrayList<Integer> list5= new ArrayList<>(Arrays.asList(1,2));
        //o/p should be 2,1
        System.out.println(  nextPermutation(list5));
        ArrayList<Integer> list6= new ArrayList<>(Arrays.asList(1));
        //o/p should be 1
        System.out.println(  nextPermutation(list6));
    }

    public static ArrayList<Integer>   nextPermutation(ArrayList<Integer> A)
    {   int size=A.size();  int index1=-1; int index2=-1;
        if(size==1 || size ==0 || A ==null){return A; }
        for(int i=size-1;i>0;i--)
        {   //list(i) < list(i+1)
            if(! (A.get(i) < A.get(i-1))){ index1=i-1; break;}
        }
        //System.out.println("index1 is "+index1);
        for(int i=size-1;i>0;i--)
        {   //  list(read from back) > list(index1)
            if( index1!=-1 && A.get(i) > A.get(index1) ){ index2=i; break;}
        }
       // System.out.println("index2 is "+index2);
        int temp;
        if(index1!=-1)
        {  temp=A.get(index1);
        A.set(index1,A.get(index2));
        A.set(index2,temp);}

        int loopNeedtoRun=(size-(index1+1))/2;
        //System.out.println("after swap"+A+"and index1 is "+index1+"loop run "+loopNeedtoRun);

        for(int i=index1+1,j= size-1; loopNeedtoRun>0;i++,j--, loopNeedtoRun--)
        {
             temp=A.get(i);
            A.set(i,A.get(j));
            A.set(j,temp);
        }
        return A;
    }
}
