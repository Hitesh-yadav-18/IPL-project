package Operations;

import Utility.Bowler;
import Utility.Deliveries;
import Utility.Matches;

import java.util.*;
import java.util.Map.Entry;

public class TopBowlers {

    public static HashMap<String, Bowler> topBowlersIn2015(HashMap<Integer, Matches> hm, ArrayList<Deliveries> aList){
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

            if(season == 2015){
                id = match_obj.getId();         //entry.getKey();
                arr.add(id);

            }

//            System.out.println(arr);
        }

        Iterator<Deliveries> itrList = null;
        Deliveries del_obj = null;

        int del_id=0;

        int economicalValue = 0;

        HashMap<String, Bowler> hashMap = new HashMap<>();
        Bowler bowler = null;
        int run = 0;
        int totalruns = 0;
        int ball = 0;
        for(int i=0;i<arr.size();i++){
            itrList = aList.iterator();
            del_id = arr.get(i);
            while(itrList.hasNext()){
                del_obj = itrList.next();
//                System.out.println(del_obj);
                if(del_id == del_obj.getMatch_id() ) {
                    if (hashMap.containsKey(del_obj.getBowler())) {
                        bowler = hashMap.get(del_obj.getBowler());
                        bowler.setBalls(bowler.getBalls()+1);
                        bowler.setTotalRun(bowler.getTotalRun() + del_obj.getTotal_runs());
                        hashMap.put(del_obj.getBowler(), bowler);
//                 System.out.print("count : "+count);
                    } else {
                        totalruns = del_obj.getTotal_runs();
                        ball = 1;
                        bowler = new Bowler();
                        bowler.setTotalRun(totalruns);
                        bowler.setBalls(ball);
                        hashMap.put(del_obj.getBowler(), bowler);
                    }
                }
            }

        }

//

        return hashMap;
    }
}
