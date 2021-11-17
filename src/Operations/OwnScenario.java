package Operations;

import Utility.Deliveries;
import Utility.Matches;

import java.util.*;

public class OwnScenario {

    public static HashMap<String, Integer> createOwnScenario(HashMap<Integer, Matches> hm, ArrayList<Deliveries> aList){
        //How many legby runs were there in 2013
        Set<Map.Entry<Integer, Matches>> set = hm.entrySet();
        Iterator<Map.Entry<Integer, Matches>> itr = set.iterator();
        Map.Entry<Integer, Matches> entry = null;

        Matches match_obj = null;
        int season = 0;
        int id=0;
        ArrayList<Integer> arr = new ArrayList<>();

        while(itr.hasNext()){
            entry = itr.next();

            match_obj = entry.getValue();
            season = match_obj.getSeason();

            if(season == 2013){
                id = match_obj.getId();         //entry.getKey();
                arr.add(id);

            }

//            System.out.println(arr);
        }

        Iterator<Deliveries> itrList = null;
        Deliveries del_obj = null;

        int del_id=0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i=0;i<arr.size();i++){
            itrList = aList.iterator();
            del_id = arr.get(i);
            while(itrList.hasNext()){
                del_obj = itrList.next();
//                System.out.println(del_obj);
                if(del_id == del_obj.getMatch_id() ) {
                    if (hashMap.containsKey(del_obj.getBatting_team())) {
                        hashMap.put(del_obj.getBatting_team(), hashMap.get(del_obj.getBatting_team()) + del_obj.getLegbye_runs());
//                 System.out.print("count : "+count);
                    } else {
                        hashMap.put(del_obj.getBatting_team(), del_obj.getLegbye_runs());
                    }
                }
            }

        }
        return hashMap;
    }
}
