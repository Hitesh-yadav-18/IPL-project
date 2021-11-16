package Operations;

import Utility.Matches;

import java.util.HashMap;
import java.util.Map;

public class WonByAllTeam {

    public static HashMap<String, HashMap<Integer, Integer>>  wonByAllTeamAllYear(HashMap<Integer, Matches> hm){

        int count=1;
        HashMap<String, HashMap<Integer, Integer>> result_map = new HashMap<String, HashMap<Integer, Integer>>();
        HashMap<Integer, Integer> subMap = null;
        for(Matches m : hm.values()){
//             System.out.println(result_map+" ");
            if (result_map.containsKey(m.getWinner())) {
                    subMap = result_map.get(m.getWinner());
//                System.out.println(subMap);

                        if (subMap.containsKey(m.getSeason())) {
                            subMap.put(m.getSeason(), subMap.get(m.getSeason())+1);
                            //                 System.out.print("count : "+count);
                        } else {
                            subMap.put(m.getSeason(), 1);
//                            count = 1;
                        }

                        result_map.put(m.getWinner(), subMap);
//                System.out.println("Map:" + result_map);
            } else {
                result_map.put(m.getWinner(), new HashMap<>(Map.of(m.getSeason(), 1)));

            }
        }

//        System.out.println(result_map);
        return result_map;
    }
}
