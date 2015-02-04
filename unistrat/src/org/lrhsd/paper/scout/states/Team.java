package org.lrhsd.paper.scout.states;
import org.lrhsd.paper.scout.states.CascadeEffect;
public class Team {
	//Data Variables
	int TeamNum = 0; 
	double matches = 0, Bottofloor = 0, kickstand = 0, 
	    	   centergoalauto = 0, rollinggoalauto = 0, rollinggoaltopz = 0,
	    	   thirty = 0, sixty = 0, ninty = 0,
	    	   botrolltopz = 0, botrollofffloor = 0, centergoalend = 0;
	//Percentage variables
	//Percentages
		double pBottofloor = 0, pkickstand = 0, 
		    	   pcentergoalauto = 0, prollinggoalauto = 0, prollinggoaltopz = 0,
		    	   pthirty = 0, psixty = 0, pninty = 0,
		    	   pbotrolltopz = 0, pbotrollofffloor = 0, pcentergoalend = 0;
	public Team(CascadeEffect one){
		this.TeamNum = one.getTeamNum();
		this.matches = one.getMatches();
		this.Bottofloor = one.getBottofloor();
		this.kickstand = one.getKickstand();
		this.centergoalauto = one.getCentergoalauto();
		this.rollinggoalauto = one.getRollinggoalauto();
		this.thirty = one.getThirty();
		this.sixty = one.getSixty();
		this.ninty = one.getNinty();
		this.botrolltopz = one.getBotrolltopz();
		this.botrollofffloor = one.getBotrollofffloor();
		this.centergoalend = one.getCentergoalend();
	}
	public int getTeam(){
		return TeamNum;
	}
	public double calculate_team_bot_to_floor_auto(){
		pBottofloor =  (Bottofloor / matches); 
		return pBottofloor;
	}
	public double calculate_team_bot_kickstand(){
		
			pkickstand = (kickstand/matches);
			return pkickstand;
	}
	public double calculate_team_centergoal_auto(){
		pcentergoalauto = (centergoalauto/matches);
		return pcentergoalauto;
	}
	public double calculate_team_rolling_score_auto(){
		prollinggoalauto = (rollinggoalauto/matches);
		return prollinggoalauto;
	}
	public double calculate_team_rolling_goal_pz_auto(){
		prollinggoaltopz = (rollinggoaltopz/(matches*3));
		return prollinggoaltopz;
	}
	public double calculate_team_thirty_cm(){
		pthirty = (thirty/matches);
		return pthirty;
	}
	public double calculate_team_sixty_cm(){
		psixty = (sixty/matches);
		return psixty;
	}
	public double calculate_team_ninty_cm(){
		pninty = (ninty/matches);
		return pninty;
	}
	public double calculate_team_bot_pz(){
		pbotrolltopz = (botrolltopz/(matches*4));
	    return pbotrolltopz;
	}
	public double calculate_team_bot_floor(){
		pbotrollofffloor = (botrollofffloor/(matches*4));
		return pbotrollofffloor;
	}
	public double calculate_team_center_end(){
		pcentergoalend = (centergoalend/matches);
		return pcentergoalend;
	}
	
    public double getAllianceData(){
		double data=0;
		data += calculate_team_bot_to_floor_auto() + calculate_team_bot_kickstand() + calculate_team_centergoal_auto()+
				calculate_team_rolling_score_auto() + calculate_team_rolling_goal_pz_auto() + calculate_team_thirty_cm()+
				calculate_team_sixty_cm() + calculate_team_ninty_cm() + calculate_team_bot_pz() + calculate_team_bot_floor()+
				calculate_team_center_end();
		return data/10;
	}
}
