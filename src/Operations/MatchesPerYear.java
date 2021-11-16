package Operations;

import Utility.Matches;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MatchesPerYear {

    public static HashMap<Integer, Integer>  matchPerYear(HashMap<Integer, Matches> hm){

        int count=1;
         HashMap<Integer,Integer> result_map = new HashMap<Integer, Integer>();

         for(Matches m : hm.values()){
//             System.out.println(result_map+" ");
             if (result_map.containsKey(m.getSeason())) {
                 result_map.put(m.getSeason(), count+=1);
//                 System.out.print("count : "+count);
             } else {
                 result_map.put(m.getSeason(), 1);
                 count=1;
             }
         }

//        System.out.println(result_map);
        return result_map;
    }

    public static void sortbykey(HashMap <Integer, Integer>map)
    {
        // TreeMap to store values of HashMap
        TreeMap<Integer, Integer> sorted = new TreeMap<>();

        // Copy all data from hashMap into TreeMap
        sorted.putAll(map);

//        for (Map.Entry<Integer, Matches> entry : sorted.entrySet())
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
        System.out.println("sorted by key:"+sorted);
    }
}
