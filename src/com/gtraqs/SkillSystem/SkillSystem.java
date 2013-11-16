package com.gtraqs.SkillSystem;
import java.util.Arrays;
import java.util.Scanner;

public class SkillSystem {

	private static int playerSkillHeight=10;
	private static int playerSkillWidth=3;
	public static int[][] playerSkill = new int[playerSkillWidth][playerSkillHeight];
	private static Scanner input;
	
	public static void main(String[] args) {
		int excellenceLevel = 0;
		for(int i = 0; i < playerSkillHeight; i++)
		{
				excellenceLevel++;
				playerSkill[2][i]=excellenceLevel; //Set"IRL"Skill level
				playerSkill[1][i]=100;//Set in game skill tracking level
				playerSkill[0][i]=i+1;//set playerID
				System.out.println("Player " + playerSkill[0][i] + " now has skill level " + playerSkill[1][i] +
									" And has irl skill: " + playerSkill[2][i] );
			
		}
		
		input = new Scanner(System.in);
		int inputInt = -1;
		while(inputInt!=0)
		{
			System.out.println("\nEnter command:\nExit: 1\nEdit skill for player: 2\nNew fight: 3");
			inputInt = input.nextInt();
			switch (inputInt)
			{ 
			case 1: System.out.println("Exiting loop");
					inputInt = 0;
					break;
					
			case 2: System.out.println("Enter player id");
					Scanner skillEditInput = new Scanner(System.in);
					int playerID = skillEditInput.nextInt();
					System.out.println("Player " + playerID + " has skill level: " + playerSkill[1][playerID]);
					System.out.println("Enter player " + playerID + "'s new skill level");
					playerSkill[1][playerID] = skillEditInput.nextInt()+1;
					System.out.println("Player " + playerID + "'s skill level is now: " + playerSkill[1][playerID]);
					break;
					
			case 3: fight();
					break;
			}
		}	
	}
	/**
	 * Puts 10 players into 2 teams then prints players + how good the team is (kinda)
	 */
	private static void fight(){
		//TODO fill teams to max and then stop filling. Should probably use while loop
		System.out.println("New fight started");
		
		int[][] team1 = new int[3][6];
		int[][] team2 = new int[3][6];
		boolean whichTeam = true;
		int t1d=0, t2d=0, teamSize1=0,teamSize2=0;
		
		for(int i = 0;i < 10; i++)//puts players in teams
		{
			System.out.println(i);
			if(whichTeam==true){
				if(teamSize1<5)team1[0][t1d]=playerSkill[0][i];//set playerID
					team1[1][t1d]=0;//Set players points
					team1[2][t1d]=playerSkill[2][i];//Set "IRL" skill of player.
					System.out.println("Player " + playerSkill[0][i] + " is now in team 1 and is " + playerSkill[2][i] + " good");
					t1d++;
					whichTeam=false;
					teamSize1++;
			}else{
				if(teamSize2<5){
					team2[0][t2d]=playerSkill[0][i];//set playerID
					team2[1][t2d]=0;//Set players points
					team2[2][t2d]=playerSkill[2][i];//Set "IRL" skill of player.
					System.out.println("Player " + playerSkill[0][i] + " is now in team 2 and is " + playerSkill[2][i] + " good");
					t2d++;//Put next player going into this team in the next slot
					whichTeam=true;//Put next player in other team because of if statement
					teamSize2++;
			}}
		
		}
		//TODO Sort array team1 and team2 by "IRL" skill so that they can be balanced to create an even match.
		int team1Skill = team1[2][0] + team1[2][1] + team1[2][2] + team1[2][3] + team1[2][4];//Sum the collective "IRL"
		int team2Skill = team2[2][0] + team2[2][1] + team2[2][2] + team2[2][3] + team2[2][4];//skill of both teams.
		System.out.println("Team1 is: " + team1[0][0] + ", " + team1[0][1] + ", " + team1[0][2] + ", " + team1[0][3] + ", " + team1[0][4] + " and has the collected skill of: " + team1Skill);
		System.out.println("Team2 is: " + team2[0][0] + ", " + team2[0][1] + ", " + team2[0][2] + ", " + team2[0][3] + ", " + team2[0][4] + " and has the collected skill of: " + team2Skill);	
		
	}
}
