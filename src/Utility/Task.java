package Utility;

import File.CsvToArrayList;
import File.CsvToHashmap;
import Operations.*;

import java.io.IOException;
import java.util.*;

public class Task {

    public static void main(String[] args) {
        int option;
        String matchFile = "./src/CSV/matches.csv";
        String  deliveryFile = "./src/CSV/deliveries.csv";
        HashMap<Integer, Matches> hm = null;
        ArrayList<Deliveries> aList = null;

        try {
           hm = CsvToHashmap.readCsvToHashmap(matchFile);
           aList = CsvToArrayList.readCsvToArrayList(deliveryFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter the task number to perform the operation from following:\n" +
                "1. Number of matches played per year of all the years in IPL.\n" +
                "2. Number of matches won of all teams over all the years of IPL.\n" +
                "3. For the year 2016 get the extra runs conceded per team.\n" +
                "4. For the year 2015 get the top economical bowlers.\n" +
                "5. For the year 2013 get the legby runs conceded per team\n");
        // Create a Scanner object for keyboard input.
        Scanner console = new Scanner(System.in);

        option = console.nextInt();

        // start switch
        switch (option) {
            case 1:
                   HashMap<Integer, Integer> myMap = MatchesPerYear.matchPerYear(hm);
                    System.out.println(myMap);
                    MatchesPerYear.sortbykey(myMap);

                break;

            case 2:
                HashMap<String, HashMap<Integer, Integer>> wonAll =  WonByAllTeam.wonByAllTeamAllYear(hm);

                Set<Map.Entry<String, HashMap<Integer, Integer>>> set = wonAll.entrySet();
                Iterator<Map.Entry<String, HashMap<Integer, Integer>>> itr = set.iterator();
                while(itr.hasNext())
                    System.out.println(itr.next());

                break;

            case 3:
                HashMap<String, Integer> erun = ExtraRunsByTeam.extraRunsByTeamIn2016(hm, aList);

                Set<Map.Entry<String, Integer>> setExtraRun = erun.entrySet();
                Iterator<Map.Entry<String, Integer>> itrExtraRun = setExtraRun.iterator();

                while(itrExtraRun.hasNext())
                    System.out.println(itrExtraRun.next());


                break;

            case 4:
                HashMap<String, Double> economic_bowler_map = TopBowlers.topBowlersIn2015(hm, aList);
                TreeMap<String, Double> tree = new TreeMap<>();
                 tree.putAll(economic_bowler_map);
//                System.out.println(tree);
                 int top10 =0;
                 for (Map.Entry<String, Double> entry : tree.entrySet()) {
                    if(top10 <= 10)
                     System.out.println( entry.getKey() + " = " + entry.getValue());
                    else
                        break;
                    top10++;
                }

                break;

            case 5:

                HashMap<String, Integer> ownScenario = OwnScenario.createOwnScenario(hm, aList);

                Set<Map.Entry<String, Integer>> setOwn = ownScenario.entrySet();
                Iterator<Map.Entry<String, Integer>> itrOwn = setOwn.iterator();

                while(itrOwn.hasNext())
                    System.out.println(itrOwn.next());

                break;

            default:
                System.out.println("Invalid input");
        }
    }
}

