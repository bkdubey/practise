package geeksforgeeks.array.math;

import java.util.ArrayList;
import java.util.Collections;

public class AddNumberOne {
    public static void main(String[] args) {
        ArrayList ip =new ArrayList<>(); ip.add(999);

        ArrayList ip1 =new ArrayList<>(); ip1.add(1); ip1.add(2); ip1.add(3);

        ArrayList ip2 =new ArrayList<>(); ip.add(999);
        ip2.add(9); ip2.add(9); ip2.add(9); ip2.add(9);

        ArrayList ip3 =new ArrayList<>();
        ip3.add(6); ip3.add(4); ip3.add(7); ip3.add(7); ip3.add(8); ip3.add(9);

        ArrayList ip4 =new ArrayList<>();
        ip4.add(0); ip4.add(3); ip4.add(7); ip4.add(6);

        ArrayList ip5 =new ArrayList<>();
        ip5.add(0); ip5.add(6); ip5.add(0); ip5.add(6); ip5.add(4); ip5.add(8); ip5.add(8); ip5.add(1);

        ArrayList ip6 =new ArrayList<>();
        ip6.add(0); ip6.add(0); ip6.add(7); ip6.add(6);

        ArrayList ip7 =new ArrayList<>();
        ip7.add(0); ip7.add(0); ip7.add(4);


        ArrayList<Integer> op=plusOne(ip7);
        System.out.println("op is "+op);

    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry=0;
        int temp= A.get(A.size()-1)+1;
        ArrayList<Integer> op=new ArrayList<Integer>();
      //  System.out.println("temp-- "+ temp);

        for(int index=A.size()-1;index>=0;index--){

            if(index == A.size()-1 ){            temp=  A.get(index)+1;
            }
            else
            temp=  A.get(index)+carry;

            if(temp==10){carry=1;
          op.add(0);
          }
          else { op.add(temp); carry=0; }

        }
        if(temp==10){
            op.add(1);
        }

        Collections.reverse(op);

        //remove zero from starting
        for(int i=0;i<op.size();i++)
        {
            System.out.println("check zero");
            if(op.get(0)==0){ op.remove(0);}
            if(op.get(0)>0) break;
        }


        return op;
    }

}
