import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FriendProblems {


    public static void main(String[] args)
    {
        System.out.println("start");
        String  list_a [] = {"Sam","Jack","Martin","Joe","Bill","John","Kim","Meg","Jimmy","Joe","Kim","Roger","Alex"};
        String list_b[] ={"John","Joe","Anna","Bill","Peter","Diana","Peter","Anna","David","Anthony","Roger","Alex","Kim"};


        String last=""; String  friendlist="";
        HashMap<String , List<String>> hmlist = new LinkedHashMap<String , List<String>>();
        List <String> ls = new ArrayList<String>();
        for (int i=0; i<list_a.length;i++)
        {
            ls=new ArrayList<String>();
            ls.add(list_b[i]);

            //last= list_b[i];  last =list_a[i]+last+","+friendlist;  ;

            for (int j=1; j<list_a.length;j++)
            {
                if(list_b[i].contains(list_a[j]))
                {
                    ls.add(list_b[j]); ls.add(list_a[j]);
                    //list_a[j]+","list_b[j];

                }
            }
            hmlist.put(list_a[i],ls);
//       	ls=null;

        }

        Iterator it = hmlist.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry flist = (Map.Entry)it.next();
            System.out.println(flist.getKey() + " = " + flist.getValue());
        }


        /**    tried below logic but not working     */

//
//    HashMap<String , String >  hm = new LinkedHashMap <String, String >();
//    for (int i=0 ; i< list_a.length;i++)
//    {
//    	if(!hm.containsKey(list_a[i]))
//    		hm.put(list_a[i],list_b[i]);
//    	else
//    		hm.put(list_a[i],hm.get(list_a[i])+","+list_b[i]);
//
//    }
//
//    HashMap <String, String> friendList = new LinkedHashMap<String,String>();
//
//
//    for(int i=0; i <list_a.length;i++ )
//    {
//      if(!friendList.containsKey(list_a[i]))
//    	friendList.put(list_a[i], list_b[i]);
//
//    }
//
//
//
//    Set <String > ks = hm.keySet();
//    Iterator<String > ite= ks.iterator(); List<String> ls_1= new ArrayList<String>();
//	while(ite.hasNext())
//	{
//		String temp = ite.next();
//		System.out.println(temp+"--->"+hm.get(temp));
////		System.out.println("check map value");
//
//
//
//
//	}

    }




}
