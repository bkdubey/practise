package geeksforgeeks.twodarray;

import java.util.ArrayList;

public class AntiDiagonal {
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},{5,6,7,8} , {9,10,11,12},{13,14,15,16}};
        //antidiagonal(arr);

        int arr1[][]={{1}};
       // antidiagonal(arr1);

        int arr2[][]={{1,2,3},{5,6,7} , {9,10,11}};
        antidiagonal(arr2);

        ArrayList<ArrayList<Integer>> list2d = new  ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list= new ArrayList<Integer>();
        list.add(1); list2d.add(list);
        System.out.println("op is --"+new AntiDiagonal().diagonal(list2d));
    }
    public static void antidiagonal(int arr[][])
    {   int size=arr.length;
        for(int level=0;level<size;level++)
        {
             for(int j=0, k=level;j<=level;j++,k--){
                    System.out.print(j+" "+k+" ");
                }
            System.out.println();
        }
        System.out.println("next");
        int verticalCOunter=size-1; int checkEndcondition=size;
        for(int column=1;column<=verticalCOunter;column++)
        {   checkEndcondition--;
            for(int i=column, j=verticalCOunter,k=checkEndcondition; k > 0 ; i++,j--,k--)
            {
                System.out.print(i+" "+j+" ");
            }
            System.out.println();
        }

    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int size=A.size();
        ArrayList<ArrayList<Integer>> output= new ArrayList<ArrayList<Integer>>();

        for(int level=0;level<size;level++)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=0, k=level;j<=level;j++,k--){

                list.add(A.get(j).get(k));
                //System.out.print(j+" "+k+" ");
            }
            output.add(list);
        }
        int verticalCOunter=size-1; int checkEndcondition=size;
        for(int column=1;column<=verticalCOunter;column++)
        {   checkEndcondition--;
            ArrayList<Integer> list = new ArrayList<Integer>();

            for(int i=column, j=verticalCOunter,k=checkEndcondition; k > 0 ; i++,j--,k--)
            {
                //System.out.print(i+" "+j+" ");
                list.add(A.get(i).get(j));
            }
            output.add(list);

        }
        return output;
    }

}
