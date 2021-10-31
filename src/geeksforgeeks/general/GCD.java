package geeksforgeeks.general;

//greatest common divisor or HCF - highest common factor
public class GCD {
    public static void main(String[] args) { int a=36; int b=60;
       String t1= factor(36); //get factor and do intersection
        System.out.println("t1"+t1+" t1.chartAt"+t1.charAt(0));
        String t2=factor(60);
        int result=1; int temp;
        for(int i=0;i<t1.length();i++)
        {
            if(t1.charAt(i)==t2.charAt(i)){   temp=Integer.parseInt(t1.charAt(i)+"");
                System.out.println("result & temp is "+result + " " +temp);
            result=result*temp;
                System.out.println("result"+result);
            }
            else break;
        }
        System.out.println(result); // working

        // 2nd approch using recursion
        System.out.println("gcd using recur"+gcd(a,b));
        //awesome 2nd approch explanation
        /** gcd(b%a,a)   , Euclidean  - algo
         *gcd -> (36,60) ->
         * gcd(60%36,36) ->
         * gcd(24,36) ->
         *  gcd(36%24,24) ->
         *  gcd(12,24) ->
         *  gcd(24%12, 12) ->
         *  gcd(0,12)
         */

        //c-program-find-gcd-hcf-two-numbers/ - 3rd approch by substracting
    }

    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }

    public static String factor(int a ){
        int temp =2; String result="";
        while(a>1  ){
            //System.out.println(a);
            if(a%temp==0){
                System.out.println(temp);
                a=a/temp; result=result+""+temp;
            }
            else  ++temp;
                   // System.out.println(++temp);
        }

        return result;
    }
}
