package com.gtraqs.SkillSystem;

public class Player implements Comparable<Player>
{
    private int excellenceScore;
    private int skillScore;
    private int playerId;
    
    public Player(int excellenceScore, int skillScore, int playerId)
    {
        //This is only to show you you can have parameters/variables named the same as long as you reference the objects variables by the 'this' operator
        this.excellenceScore = excellenceScore;
        this.skillScore = skillScore;
        this.playerId = playerId;
        report();
    }
    
    public int getExcellence()
    {
        return excellenceScore;
    }
    
    public void setExcellence(int es)
    {
        excellenceScore = es;
    }
    
    public int getSkill()
    {
        return skillScore;
    }
    
    public void setSkill(int skill)
    {
        skillScore = skill;
    }
    
    public int getId()
    {
        return playerId;
    }
    
    public void setId(int id)
    {
        playerId = id;
    }
    
    public void report()
    {
        System.out.println("Player " + playerId + " now has skill level " + skillScore + " And has irl skill: " + excellenceScore);
    }
    
    public int compareTo(Player player)
    {
        //ascending order - lowest first
        //return excellenceScore - player.getExcellence();
        
        //descending order - highest first
        return player.getExcellence() - excellenceScore;
    }
}