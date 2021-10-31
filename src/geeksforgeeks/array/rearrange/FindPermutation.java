package geeksforgeeks.array.rearrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class FindPermutation {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        System.out.println(findPermuation("IDDDIID",8));
        //o/p- [1, 5, 4, 3, 2, 6, 8, 7]

        System.out.println(findPermuation("DDD",4));
        //        //o/p- 4 ,3 ,2,1

        System.out.println(findPermuation("III",7));
        //o/p- 1,2,3,4,5,6,7
        System.out.println(findPermuation("DI",5));
        //o/p- 2 ,1 ,3,4,5
        System.out.println(findPermuation("DIDD",10));
        //o/p- 2, 1, 5, 6, 7, 8, 9, 10, 4, 3
    }

    public static ArrayList<Integer> findPermuation(final String A, int B)

    {
        ArrayList<Integer> list = new ArrayList<>(B);
        for(int i = 1; i <= B; i++){
            list.add(i);
        }

        ArrayList<Integer> output= new ArrayList<Integer>();
        Stack<Integer> stack= new Stack<>(); //stack.push(A.get(0));
        int stringSize=A.length(); int size=list.size();
        for(int i=0,j=0;i<size;i++)
        {
            if(j< stringSize  )
            {   if(A.charAt(j)=='I')
                { j++;
                    stack.push(list.get(i));
                while(!stack.empty()) {output.add(stack.pop()); }  }
                else  { j++;
                   stack.push(list.get(i));}
            }
            else {output.add(list.get(i)); }

        }
        while(!stack.empty()) output.add(stack.pop());
        return output;
    }
}
