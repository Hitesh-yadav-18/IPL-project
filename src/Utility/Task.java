package Utility;

import File.CsvToArrayList;
import File.CsvToHashmap;
import Operations.*;

import java.io.IOException;
import java.util.Scanner;

public class Task {

    public static void main(String[] args) {
        int option;
        String matchfile = "./src/CSV/matches.csv";
        String  deliveryFile = "./src/CSV/deliveries.csv";

        try {
            CsvToHashmap.readCsvToHashmap(matchfile);
            CsvToArrayList.readCsvToArrayList(deliveryFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter the task number to perform the operation from following:\n" +
                "1. Number of matches played per year of all the years in IPL.\n" +
                "2. Number of matches won of all teams over all the years of IPL.\n" +
                "3. For the year 2016 get the extra runs conceded per team.\n" +
                "4. For the year 2015 get the top economical bowlers.\n" +
                "5. Create your own scenario.\n");
        // Create a Scanner object for keyboard input.
        Scanner console = new Scanner(System.in);

        option = console.nextInt();

        // start switch
        switch (option) {
            case 1:
                    MatchesPerYear.matchPerYear();
                break;

            case 2:
                WonByAllTeam.wonByAllTeamAllYear();

                break;

            case 3:
                ExtraRunsByTeam.extraRunsByTeamIn2016();

                break;

            case 4:
                TopBowlers.topBowlersIn2015();

                break;

            case 5:
                OwnScenario.createOwnScenario();

                break;

            default:
                System.out.println("Invalid input");
        }
    }
}

