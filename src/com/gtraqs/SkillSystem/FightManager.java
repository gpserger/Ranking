package com.gtraqs.SkillSystem;

import java.util.Arrays;
import java.util.Scanner;

public class FightManager
{
    private int numPlayers;
    private Player[] players;
    private Player[] team1;
    private Player[] team2;
    private Scanner input;
    
    public FightManager(int np)
    {
        numPlayers = np;
        players = new Player[np];
        for (int i = 0; i < numPlayers; i++)
        {
            players[i] = new Player(i + 1, 0, i + 1);
            players[i].report();
        }
        setup();
    }
    
    private void setup()
    {
        input = new Scanner(System.in);
        int choice = -1;
        while(choice != 0)
        {
            System.out.println("\nEnter command:\nExit: 1\nEdit skill for player: 2\nNew fight: 3");
            choice = input.nextInt();
            switch (choice)
            { 
                case 1: 
                    System.out.println("Exiting loop");
                    choice = 0;
                    break;
                case 2: 
                	//TODO Make this work
                    System.out.println("Enter player id");
                    int playerID = input.nextInt();
                    System.out.println("Player " + playerID + " has skill level: " + players[playerID].getSkill());
                    System.out.println("Enter player " + playerID + "'s new skill level");
                    players[playerID].setSkill(input.nextInt() + 1);
                    System.out.println("Player " + playerID + "'s skill level is now: " + players[playerID].getSkill());
                    break;
                case 3: 
                    allocatePlayers();
                    break;
            }
        }
    }
    
    private void sortPlayers()
    {
        //TODO Sort array team1 and team2 by "IRL" skill so that they can be balanced to create an even match.
        int team1Skill = 0, team2Skill = 0;
        String t1names = "", t2names = "";
        //this for loops can be joined into one if the teams are always even
        for (int i = 0; i < team1.length; i++)
        {
            team1Skill += team1[i].getExcellence();
            t1names += "" + (t1names.length() > 0 ? ", " : "") + team1[i].getId();
        }
        for (int i = 0; i < team2.length; i++)
        {
            team2Skill += team2[i].getExcellence();
            t2names += "" + (t2names.length() > 0 ? ", " : "") + team2[i].getId();
        }
        System.out.println("Team1 is: " + t1names + " and has the collected skill of: " + team1Skill);
        System.out.println("Team2 is: " + t2names + " and has the collected skill of: " + team2Skill);
        
        //do the sort
        Arrays.sort(team1);
        Arrays.sort(team2);
    }
    
    private void allocatePlayers()
    {
        //TODO fill teams to max and then stop filling. Should probably use while loop
        
        team1 = new Player[numPlayers / 2];//this assumes that it will be even teams, if uneven this needs to be fixed
        team2 = new Player[numPlayers / 2];
        int t1d = 0, t2d = 0;
        
        for(int i = 0; i < numPlayers; i++)//puts players in teams
        {
            System.out.println(i);
            if(i % 2 == 0)
            {
                team1[t1d] = players[i];
                System.out.println("Player " + team1[t1d].getId() + " is now in team 1 and is " + team1[t1d].getExcellence() + " good");
                t1d++;
            }
            else
            {
                team2[t2d] = players[i];
                System.out.println("Player " + team2[t2d].getId() + " is now in team 2 and is " + team2[t2d].getExcellence() + " good");
                t2d++;//Put next player going into this team in the next slot
            }
        }
        sortPlayers();
    }
    public void fight()
    {
        //Kick ass
        System.out.println("New fight started");
    }
}