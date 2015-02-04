package org.lrhsd.paper.scout.states;
import org.lrhsd.paper.scout.states.CascadeEffect;
/**
 * This is one of the calculator classes used for calculating efficiency of an alliance consisting of 2 teams
 * @author Storm 4390 and 7433
 *
 */
public class Alliance {
    //Team Datas
	private int TeamNum = 0; 
	private double matches = 0, Bottofloor = 0, kickstand = 0, 
	    	   centergoalauto = 0, rollinggoalauto = 0, rollinggoaltopz = 0,
	    	   thirty = 0, sixty = 0, ninty = 0,
	    	   botrolltopz = 0, botrollofffloor = 0, centergoalend = 0;
	
	private int TeamNum2 = 0; 
	private double matches2 = 0, Bottofloor2 = 0, kickstand2 = 0, 
	    	   centergoalauto2 = 0, rollinggoalauto2 = 0, rollinggoaltopz2 = 0,
	    	   thirty2 = 0, sixty2 = 0, ninty2 = 0,
	    	   botrolltopz2 = 0, botrollofffloor2 = 0, centergoalend2 = 0;
	//Percentages
	private double pBottofloor = 0, pkickstand = 0, 
	    	   pcentergoalauto = 0, prollinggoalauto = 0, prollinggoaltopz = 0,
	    	   pthirty = 0, psixty = 0, pninty = 0,
	    	   pbotrolltopz = 0, pbotrollofffloor = 0, pcentergoalend = 0;
	
	
	
	//Max Values some elements can occur in the match
	int MAX_RAMP_FLOOR = 1, MAX_KICK = 1, MAX_CENTER_GOAL_AUTO = 1, MAX_RG_PZ_AUTO = 3,  MAX_TEAM_BOTPZ = 4, MAX_TEAM_BOT_FLOOR = 4;
	/**
	 * This contructor is used to take in two teams input on the same alliance.  Input type: CascadeEffect
	 * @param one - first team for analysis
	 * @param two - seconde team for analysis
	 */
	public Alliance(CascadeEffect one, CascadeEffect two){
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
		
		this.TeamNum2 = two.getTeamNum();
		this.matches2 = two.getMatches();
		this.Bottofloor2 = two.getBottofloor();
		this.kickstand2 = two.getKickstand();
		this.centergoalauto2 = two.getCentergoalauto();
		this.rollinggoalauto2 = two.getRollinggoalauto();
		this.thirty2 = two.getThirty();
		this.sixty2 = two.getSixty();
		this.ninty2 = two.getNinty();
		this.botrolltopz2 = two.getBotrolltopz();
		this.botrollofffloor2 = two.getBotrollofffloor();
		this.centergoalend2 = two.getCentergoalend();
	}
	/**
	 * 
	 * @return Team one's number
	 */
	public int getTeamOne(){
		return TeamNum;
	}
	/**
	 * 
	 * @return Team two's number
	 */
	public int getTeamTwo(){
		return TeamNum2;
	}
	public double calculate_team_bot_to_floor_auto(){
		pBottofloor =  ((Bottofloor / matches)+(Bottofloor2/matches2))/2; 
		//pBottofloor+= (Bottofloor/matches2);
		return pBottofloor;
	}
	public double calculate_team_bot_kickstand(){
		
			pkickstand = ((kickstand/matches) + (kickstand2/matches2))/2;
			return pkickstand;
	}
	public double calculate_team_centergoal_auto(){
		pcentergoalauto = ((centergoalauto/matches) + (centergoalauto2/matches2))/2;
		return pcentergoalauto;
	}
	public double calculate_team_rolling_score_auto(){
		prollinggoalauto = ((rollinggoalauto/matches) + (rollinggoalauto2/matches2))/2;
		return prollinggoalauto;
	}
	public double calculate_team_rolling_goal_pz_auto(){
		prollinggoaltopz = ((rollinggoaltopz/(matches*3)) + (rollinggoaltopz2/(matches2*3)))/2;
		return prollinggoaltopz;
	}
	public double calculate_team_thirty_cm(){
		pthirty = ((thirty/matches) + (thirty2/matches2))/2;
		return pthirty;
	}
	public double calculate_team_sixty_cm(){
		psixty = ((sixty/matches) + (sixty2/matches2))/2;
		return psixty;
	}
	public double calculate_team_ninty_cm(){
		pninty = ((ninty/matches) + (ninty2/matches2))/2;
		return pninty;
	}
	public double calculate_team_bot_pz(){
		pbotrolltopz = ((botrolltopz/(matches*MAX_TEAM_BOTPZ))+(botrolltopz2/(matches2*MAX_TEAM_BOTPZ)))/2;
	    return pbotrolltopz;
	}
	public double calculate_team_bot_floor(){
		pbotrollofffloor = ((botrollofffloor/(matches*MAX_TEAM_BOT_FLOOR))+(botrollofffloor2/(matches2*MAX_TEAM_BOT_FLOOR)))/2;
		return pbotrollofffloor;
	}
	public double calculate_team_center_end(){
		pcentergoalend = ((centergoalend/matches)+(centergoalend2/matches2))/2;
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