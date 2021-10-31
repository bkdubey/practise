package geeksforgeeks.array;

import java.util.ArrayList;

public class PrintPascal {
    public static void main(String[] args) {
        new PrintPascal().solve(1);
    }

    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> list2d= new ArrayList<ArrayList<Integer>>(A);
        int prefix=0;int suffix=0;

      /*  ArrayList<Integer> list=new ArrayList<>(); list.add(1);
        list2d.add(list);*/
        if(A==1)
        {
            System.out.println("A");
            ArrayList<Integer> list1=new ArrayList<>(); list1.add(1);
            list2d.add(list1);
        return list2d;
        }

        for(int i=0;i<A-1;i++)
        {
            if(i==0)
            {ArrayList<Integer> list1=new ArrayList<>(); list1.add(1);
                list2d.add(list1);}
            System.out.println(list2d);
            //if(i==0){ continue;}
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j=0;j<=i;j++)
            {
                System.out.println("i  "+i+"j"+j);
                if(j==0){ temp.add(list2d.get(i).get(j)+suffix); }
                if(j==i)
                  {temp.add(list2d.get(i).get(j)+suffix);}
                else {
                int var= list2d.get(i).get(j)+list2d.get(i).get(j+1);
                temp.add(var); }
            }
            list2d.add(temp);


        }
        System.out.println(list2d);
        return null;
    }

}
