package com.hitesh.iplproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static final int MATCH_ID = 0;
    public static final int INNING = 1;
    public static final int BATTING_TEAM = 2;
    public static final int BOWLING_TEAM = 3;
    public static final int OVER = 4;
    public static final int BALL = 5;
    public static final int BATSMAN = 6;
    public static final int NON_STRIKER = 7;
    public static final int BOWLER = 8;
    public static final int IS_SUPER_OVER = 9;
    public static final int WIDE_RUNS = 10;
    public static final int BYE_RUNS = 11;
    public static final int LEGBYE_RUNS = 12;
    public static final int NO_BALL_RUNS = 13;
    public static final int PANELTY_RUNS = 14;
    public static final int BATSMAN_RUNS = 15;
    public static final int EXTRA_RUNS = 16;
    public static final int TOTAL_RUNS = 17;
    public static final int PLAYER_DISMISSED = 18;
    public static final int DISMISSAL_KIND = 19;
    public static final int FIELDER = 20;

    public static final int ID = 0;
    public static final int SEASON = 1;
    public static final int CITY = 2;
    public static final int DATE = 3;
    public static final int TEAM_1 = 4;
    public static final int TEAM_2 = 5;
    public static final int TOSS_WINNER = 6;
    public static final int TOSS_DECISION = 7;
    public static final int RESULT = 8;
    public static final int DL_APPLIED = 9;
    public static final int WINNER = 10;
    public static final int WIN_BY_RUNS = 11;
    public static final int WIN_BY_WICKETS = 12;
    public static final int PLAYER_OF_MATCH = 13;
    public static final int VENUE = 14;
    public static final int UMPIRE_1 = 15;
    public static final int UMPIRE_2 = 16;
    public static final int UMPIRE_3 = 17;

    public static void main(String[] args) throws IOException {
        List<Match> matches = getMatchesData();
        List<Delivery> deliveries = getDeliveriesData();

        findNumberOfMatchesPlayed(matches);
        findNumberOfMatchesWonPerTeam(matches);
        findExtraRunsConcededPerTeamIn2016(matches, deliveries);
        findTheMostEconomicalBowlerIn2015(matches, deliveries);
        findLegbyeRunsConcededPerTeamin2013(matches, deliveries);
    }

    private static void findNumberOfMatchesPlayed(List<Match> matches) {
        HashMap<Integer, Integer> matchBySeason = new HashMap<Integer, Integer>();

        for (Match match : matches) {
            if (matchBySeason.containsKey(match.getSeason())) {
                matchBySeason.put(match.getSeason(), matchBySeason.get(match.getSeason()) + 1);
            } else {
                matchBySeason.put(match.getSeason(), 1);
            }
        }
        System.out.println(matchBySeason);
    }

    private static void findNumberOfMatchesWonPerTeam(List<Match> matches) {
        HashMap<String, HashMap<Integer, Integer>> matchWonPerTeam = new HashMap<String, HashMap<Integer, Integer>>();

        for (Match match : matches) {
            if (matchWonPerTeam.containsKey(match.getWinner())) {
                HashMap<Integer, Integer> subMap = matchWonPerTeam.get(match.getWinner());
                if (subMap.containsKey(match.getSeason())) {
                    subMap.put(match.getSeason(), subMap.get(match.getSeason()) + 1);
                } else {
                    subMap.put(match.getSeason(), 1);
                }
                matchWonPerTeam.put(match.getWinner(), subMap);
            } else {
                HashMap<Integer, Integer> yearCount = new HashMap<>();
                yearCount.put(match.getSeason(), 1);
                matchWonPerTeam.put(match.getWinner(), yearCount);
            }
        }
        System.out.println(matchWonPerTeam);
    }

    private static void findExtraRunsConcededPerTeamIn2016(List<Match> matches, List<Delivery> deliveries) {
        List<Integer> matchesIdList = findIdOfMatchesOfYear(matches, 2015);
        HashMap<String, Integer> teamExtraRuns = new HashMap<>();

        for (int i = 0; i < matchesIdList.size(); i++) {
            int deliveriesId = matchesIdList.get(i);
            Iterator<Delivery> deliveriesIterator = deliveries.iterator();

            while (deliveriesIterator.hasNext()) {
                Delivery delivery = deliveriesIterator.next();
                if (deliveriesId == delivery.getMatchId()) {
                    if (teamExtraRuns.containsKey(delivery.getBattingTeam())) {
                        teamExtraRuns.put(delivery.getBattingTeam(),
                                teamExtraRuns.get(delivery.getBattingTeam()) + delivery.getExtraRuns());
                    } else {
                        teamExtraRuns.put(delivery.getBattingTeam(), delivery.getExtraRuns());
                    }
                }
            }
        }
        System.out.println(teamExtraRuns);
    }

    private static void findTheMostEconomicalBowlerIn2015(List<Match> matches, List<Delivery> deliveries) {
        List<Integer> match = findIdOfMatchesOfYear(matches, 2015);
        HashMap<String, Bowler> bowlerTotalBallsRuns = new HashMap<>();

        Bowler bowler = null;
        int totalRuns = 0;
        int totalBalls = 0;
        for (int i = 0; i < match.size(); i++) {
            Iterator<Delivery> deliveryIterator = deliveries.iterator();
            int deliveryId = match.get(i);
            while (deliveryIterator.hasNext()) {
                Delivery delivery = deliveryIterator.next();
                if (deliveryId == delivery.getMatchId()) {
                    if (bowlerTotalBallsRuns.containsKey(delivery.getBowler())) {
                        bowler = bowlerTotalBallsRuns.get(delivery.getBowler());
                        bowler.setBalls(bowler.getBalls() + 1);
                        bowler.setTotalRun(bowler.getTotalRun() + delivery.getTotalRuns());
                        bowlerTotalBallsRuns.put(delivery.getBowler(), bowler);
                    } else {
                        totalRuns = delivery.getTotalRuns();
                        totalBalls = 1;
                        bowler = new Bowler();
                        bowler.setTotalRun(totalRuns);
                        bowler.setBalls(totalBalls);
                        bowlerTotalBallsRuns.put(delivery.getBowler(), bowler);
                    }
                }
            }
        }

        HashMap<String, Double> economicBowler = new HashMap<>();

        Double economicValue = 0.0;
        Set<Map.Entry<String, Bowler>> setHashMap = bowlerTotalBallsRuns.entrySet();
        Iterator<Map.Entry<String, Bowler>> itrHashMap = setHashMap.iterator();
        Map.Entry<String, Bowler> entryHashMap = null;

        Bowler bowler_obj = null;

        while (itrHashMap.hasNext()) {
            entryHashMap = itrHashMap.next();
            bowler_obj = entryHashMap.getValue();

            economicValue = (bowler_obj.getTotalRun() / (bowler_obj.getBalls() / 6d));
            economicBowler.put(entryHashMap.getKey(), economicValue);
        }
        System.out.println(economicBowler);
    }

    private static void findLegbyeRunsConcededPerTeamin2013(List<Match> matches, List<Delivery> deliveries) {
        List<Integer> matchesIdList = findIdOfMatchesOfYear(matches, 2013);
        HashMap<String, Integer> teamLegbyeRuns = new HashMap<>();

        for (int i = 0; i < matchesIdList.size(); i++) {
            Iterator<Delivery> itrList = deliveries.iterator();
            int deliveriesId = matchesIdList.get(i);

            while (itrList.hasNext()) {
                Delivery delivery = itrList.next();
                if (deliveriesId == delivery.getMatchId()) {
                    if (teamLegbyeRuns.containsKey(delivery.getBattingTeam())) {
                        teamLegbyeRuns.put(delivery.getBattingTeam(),
                                teamLegbyeRuns.get(delivery.getBattingTeam()) + delivery.getLegbyeRuns());
                    } else {
                        teamLegbyeRuns.put(delivery.getBattingTeam(), delivery.getLegbyeRuns());
                    }
                }
            }
        }
        System.out.println(teamLegbyeRuns);
    }

    public static List<Integer> findIdOfMatchesOfYear(List<Match> matches, int givenYear) {
        List<Integer> matchYearIDs = new ArrayList<>();
        Iterator<Match> itr = matches.iterator();
        int season = 0;
        int id = 0;
        while (itr.hasNext()) {
            Match match = itr.next();
            season = match.getSeason();

            if (season == givenYear) {
                id = match.getId();
                matchYearIDs.add(id);
            }
        }
        return matchYearIDs;
    }

    public static List<Delivery> getDeliveriesData() throws IOException {
        String line = "";
        String[] data = null;
        List<Delivery> deliveries = new ArrayList<>();
        BufferedReader bufferedReader =
                new BufferedReader(new FileReader("src/com/hitesh/iplproject/Datasource/deliveries.csv"));

        bufferedReader.readLine();

        while ((line = bufferedReader.readLine()) != null) {
            data = line.split(",");
            Delivery del_obj = new Delivery();
            del_obj.setMatchId(Integer.parseInt(data[MATCH_ID]));
            del_obj.setInning(Integer.parseInt(data[INNING]));
            del_obj.setBattingTeam(data[BATTING_TEAM]);
            del_obj.setBowlingTeam(data[BOWLING_TEAM]);
            del_obj.setOver(Integer.parseInt(data[OVER]));
            del_obj.setBall(Integer.parseInt(data[BALL]));
            del_obj.setBatsman(data[BATSMAN]);
            del_obj.setNonStriker(data[NON_STRIKER]);
            del_obj.setBowler(data[BOWLER]);
            del_obj.setIsSuperOver(Integer.parseInt(data[IS_SUPER_OVER]));
            del_obj.setWideRuns(Integer.parseInt(data[WIDE_RUNS]));
            del_obj.setByeRuns(Integer.parseInt(data[BYE_RUNS]));
            del_obj.setLegbyeRuns(Integer.parseInt(data[LEGBYE_RUNS]));
            del_obj.setNoballRuns(Integer.parseInt(data[NO_BALL_RUNS]));
            del_obj.setPaneltyRuns(Integer.parseInt(data[PANELTY_RUNS]));
            del_obj.setBatsmanRuns(Integer.parseInt(data[BATSMAN_RUNS]));
            del_obj.setExtraRuns(Integer.parseInt(data[EXTRA_RUNS]));
            del_obj.setTotalRuns(Integer.parseInt(data[TOTAL_RUNS]));
            if (data.length > 18)
                del_obj.setPlayerDismissed(data[PLAYER_DISMISSED]);
            if (data.length > 19)
                del_obj.setDismissalKind(data[DISMISSAL_KIND]);
            if (data.length > 20)
                del_obj.setFielder(data[FIELDER]);

            deliveries.add(del_obj);
        }
        bufferedReader.close();
        return deliveries;
    }

    public static List<Match> getMatchesData() throws IOException {
        String line = "";
        String[] data = null;
        List<Match> matches = new ArrayList<>();
        BufferedReader bufferedReader =
                new BufferedReader(new FileReader("src/com/hitesh/iplproject/Datasource/matches.csv"));

        bufferedReader.readLine();

        while ((line = bufferedReader.readLine()) != null) {
            data = line.split(",");
            int id = Integer.parseInt(data[ID]);
            Match match = new Match();

            match.setId(Integer.parseInt(data[ID]));
            match.setSeason(Integer.parseInt(data[SEASON]));
            match.setCity(data[CITY]);
            match.setDate(data[DATE]);
            match.setTeam1(data[TEAM_1]);
            match.setTeam2(data[TEAM_2]);
            match.setTossWinner(data[TOSS_WINNER]);
            match.setTossDecision(data[TOSS_DECISION]);
            match.setResult(data[RESULT]);
            match.setDlApplied(Integer.parseInt(data[DL_APPLIED]));
            match.setWinner(data[WINNER]);
            match.setWinByRuns(Integer.parseInt(data[WIN_BY_RUNS]));
            match.setWinByWickets(Integer.parseInt(data[WIN_BY_WICKETS]));
            match.setPlayerOfMatch(data[PLAYER_OF_MATCH]);
            match.setVenue(data[VENUE]);
            if (data.length > 15)
                match.setUmpire1(data[UMPIRE_1]);
            if (data.length > 16)
                match.setUmpire2(data[UMPIRE_2]);
            if (data.length > 17)
                match.setUmpire3(data[UMPIRE_3]);

            matches.add(id, match);
        }
        bufferedReader.close();
        return matches;
    }

}
