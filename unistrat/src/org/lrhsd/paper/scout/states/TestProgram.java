package org.lrhsd.paper.scout.states;

import org.lrhsd.paper.scout.states.CascadeEffect;
import org.lrhsd.paper.scout.states.Alliance;

public class TestProgram{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       CascadeEffect one = new CascadeEffect(2729, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 20, 5),
    		   		 two = new CascadeEffect(2729, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 20, 5);
       Alliance a = new Alliance(one, two);
       
       Team team = new Team(one);
       System.out.println("Average percentage the team can move from ramp to floor: " + a.calculate_team_bot_to_floor_auto());
       System.out.println(a.calculate_team_bot_pz());
       System.out.println(a.calculate_team_bot_floor());
       System.out.println(team.getTeam() + ": " + team.calculate_team_bot_floor());
	}

}
