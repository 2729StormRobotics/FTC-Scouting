package org.lrhsd.paper.scout.states;
import org.lrhsd.paper.scout.states.Alliance;
import org.lrhsd.paper.scout.states.CascadeEffect;

public class Predict {
	
	//Efficientcy varaiables for red alliance
	int[] TeamNumRed;
	double ERbottofloor = 0, ERkickstand = 0, ERcenterscoredauto = 0, ERrollinggoalscore = 0,
		   ERrollinggoaltopz = 0, ERthirty = 0, ERsixty = 0, ERninty = 0, ERbotrolltopz = 0,
		   ERbotrollofffloor = 0, ERcenterscoredend = 0;
	//Effiecientcy variables for blue alliance
	int[] TeamNumBlue;
	double EBbottofloor = 0, EBkickstand = 0, EBcenterscoredauto = 0, EBrollinggoalscore = 0,
			   EBrollinggoaltopz = 0, EBthirty = 0, EBsixty = 0, EBninty = 0, EBbotrolltopz = 0,
			   EBbotrollofffloor = 0, EBcenterscoredend = 0;
    //Effiecientcy variables for singular team
	int TeamNum;
	double Ebottofloor = 0, Ekickstand = 0, Ecenterscoredauto = 0, Erollinggoalscore = 0,
			   Erollinggoaltopz = 0, Ethirty = 0, Esixty = 0, Eninty = 0, Ebotrolltopz = 0,
			   Ebotrollofffloor = 0, Ecenterscoredend = 0;
	//Regular comparison variables
	double NO = .2, MAYBE = .5, LIKELY = .8, DEFINITE = 1;
	
	//Comparison for the rolling goal stuff
	double TWO = 2, THREE = 3, FOUR = 4, FIVE = 5;	
	public Predict(Alliance red, Alliance blue){
		TeamNumRed[0] = red.getTeamOne();
		TeamNumRed[1] = red.getTeamTwo();
		ERbottofloor = red.calculate_team_bot_to_floor_auto();
		ERkickstand = red.calculate_team_bot_kickstand();
		ERcenterscoredauto = red.calculate_team_centergoal_auto();
		ERrollinggoalscore = red.calculate_team_rolling_score_auto();
		ERrollinggoaltopz = red.calculate_team_rolling_goal_pz_auto();
		ERthirty = red.calculate_team_thirty_cm();
		ERsixty = red.calculate_team_sixty_cm();
		ERninty = red.calculate_team_ninty_cm();
		ERbotrolltopz = red.calculate_team_bot_pz();
		ERbotrollofffloor = red.calculate_team_bot_to_floor_auto();
		ERbotrollofffloor = red.calculate_team_center_end();
		
		TeamNumBlue[0] = blue.getTeamOne();
		TeamNumBlue[1] = blue.getTeamTwo();
		EBbottofloor = blue.calculate_team_bot_to_floor_auto();
		EBkickstand = blue.calculate_team_bot_kickstand();
		EBcenterscoredauto = blue.calculate_team_centergoal_auto();
		EBrollinggoalscore = blue.calculate_team_rolling_score_auto();
		EBrollinggoaltopz = blue.calculate_team_rolling_goal_pz_auto();
		EBthirty = blue.calculate_team_thirty_cm();
		EBsixty = blue.calculate_team_sixty_cm();
		EBninty = blue.calculate_team_ninty_cm();
		EBbotrolltopz = blue.calculate_team_bot_pz();
		EBbotrollofffloor = blue.calculate_team_bot_to_floor_auto();
		EBbotrollofffloor = blue.calculate_team_center_end();
		
	}
	public Predict(Team team){
		TeamNum = team.getTeam();
		Ebottofloor = team.calculate_team_bot_to_floor_auto();
		Ekickstand = team.calculate_team_bot_kickstand();
		Ecenterscoredauto = team.calculate_team_centergoal_auto();
		Erollinggoalscore = team.calculate_team_rolling_score_auto();
		Erollinggoaltopz = team.calculate_team_rolling_goal_pz_auto();
		Ethirty = team.calculate_team_thirty_cm();
		Esixty = team.calculate_team_sixty_cm();
		Eninty = team.calculate_team_ninty_cm();
		Ebotrolltopz = team.calculate_team_bot_pz();
		Ebotrollofffloor = team.calculate_team_bot_to_floor_auto();
		Ebotrollofffloor = team.calculate_team_center_end();
	}
	public double predict_red_to_floor_auto(){
		if(ERbottofloor < NO || (ERbottofloor > NO && ERbottofloor > MAYBE)){
			return 0;
			
		}
		else if((ERbottofloor > LIKELY && ERbottofloor < DEFINITE)
				|| (ERbottofloor == DEFINITE) || (ERbottofloor > DEFINITE)){
			return 20;
			
		}
		else{
			return 0;
		}
	}
	public double predict_red_kickstand(){
		if(ERkickstand < NO || (ERkickstand > NO && ERkickstand > MAYBE)){
			return 0;
			
		}
		else if((ERkickstand > LIKELY && ERkickstand < DEFINITE)
				|| (ERkickstand == DEFINITE) || (ERkickstand > DEFINITE)){
			return 30;
			
		}
		else{
			return 0;
		}
	}
	public double predict_red_rolling_goal(){
		if(ERrollinggoalscore < NO || (ERrollinggoalscore > NO && ERrollinggoalscore > MAYBE)){
			return 0;
			
		}
		else if((ERrollinggoalscore > LIKELY && ERrollinggoalscore < DEFINITE)
				|| (ERrollinggoalscore == DEFINITE) || (ERrollinggoalscore > DEFINITE)){
			return 30 * (ERrollinggoalscore * 10.0);
			
		}
		else{
			return 0;
		}
	}
	public double predict_red_rolling_pz_auto(){
		if(ERrollinggoaltopz < NO || (ERrollinggoaltopz > NO && ERrollinggoaltopz > MAYBE)){
			return 0;
			
		}
		else if((ERrollinggoaltopz > LIKELY && ERrollinggoaltopz < DEFINITE)
				|| (ERrollinggoaltopz == DEFINITE) || (ERrollinggoaltopz > DEFINITE)){
			if(ERrollinggoaltopz == .33 || (ERrollinggoaltopz > .33 && ERrollinggoaltopz < .66)){
				return 30;
			}
			else if(ERrollinggoaltopz == .66 || (ERrollinggoaltopz > .66 && ERrollinggoaltopz < 1)){
				return 30*2;
			}
			else if(ERrollinggoaltopz == 1 || ERrollinggoaltopz > 1){
			  return 30*3;	
			}
			else{
				return 0;
			}
			
		}
		else{
			return 0;
		}
	}
	public double predict_red_center_auto(){
		if(ERcenterscoredauto < NO || (ERcenterscoredauto > NO && ERcenterscoredauto > MAYBE)){
			return 0;
			
		}
		else if((ERcenterscoredauto > LIKELY && ERcenterscoredauto < DEFINITE)
				|| (ERcenterscoredauto == DEFINITE) || (ERcenterscoredauto > DEFINITE)){
			return 20;
			
		}
		else{
			return 0;
		}
	}
	public double predict_red_thirty(){
		if(ERthirty < NO || (ERthirty > NO && ERthirty > MAYBE)){
			return 0;
			
		}
		else if((ERthirty > LIKELY && ERthirty < DEFINITE)
				|| (ERthirty == DEFINITE) || (ERthirty > DEFINITE)){
			if(ERthirty == 1 || (ERthirty > 1 && ERthirty < 2)){
				return 1;
			}
			else if(ERthirty == 2 || (ERthirty > 2 && ERthirty < 3)){
				return 2;
			}
			else if(ERthirty == 3 || (ERthirty > 3 && ERthirty < 4)){
				return 3;
			}
			else if(ERthirty == 4 || (ERthirty > 4 && ERthirty < 5)){
				return 4;
			}
			else if(ERthirty == 5){
				return 5;
			}
			else if(ERthirty > 5){
				return Math.round(ERthirty);
			}
			else{
				return 0;
			}
		}
		else{
			return 0;
		}
	}
	public double predict_red_sixty(){
		if(ERsixty < NO || (ERsixty > NO && ERsixty > MAYBE)){
			return 0;
			
		}
		else if((ERsixty > LIKELY && ERsixty < DEFINITE)
				|| (ERsixty == DEFINITE) || (ERsixty > DEFINITE)){
			if(ERsixty == 1 || (ERsixty > 1 && ERsixty < 2)){
				return 1;
			}
			else if(ERsixty == 2 || (ERsixty > 2 && ERsixty < 3)){
				return 2;
			}
			else if(ERsixty == 3 || (ERsixty > 3 && ERsixty < 4)){
				return 3;
			}
			else if(ERsixty == 4 || (ERsixty > 4 && ERsixty < 5)){
				return 4;
			}
			else if(ERsixty == 5){
				return 5;
			}
			else if(ERsixty > 5){
				return Math.round(ERsixty);
			}
			else{
				return 0;
			}
		}
		else{
			return 0;
		}
	}
	public double predict_red_ninty(){
		if(ERninty < NO || (ERninty > NO && ERninty > MAYBE)){
			return 0;
			
		}
		else if((ERninty > LIKELY && ERthirty < DEFINITE)
				|| (ERninty == DEFINITE) || (ERninty > DEFINITE)){
			if(ERninty == 1 || (ERninty > 1 && ERninty < 2)){
				return 1;
			}
			else if(ERninty == 2 || (ERninty > 2 && ERninty < 3)){
				return 2;
			}
			else if(ERninty == 3 || (ERninty > 3 && ERninty < 4)){
				return 3;
			}
			else if(ERninty == 4 || (ERninty > 4 && ERninty < 5)){
				return 4;
			}
			else if(ERninty == 5){
				return 5;
			}
			else if(ERninty > 5){
				return Math.round(ERninty);
			}
			else{
				return 0;
			}
		}
		else{
			return 0;
		}
	}
	public double predict_red_bot_pz(){
		if(ERbotrolltopz < NO || (ERbotrolltopz > NO && ERbotrolltopz > MAYBE)){
			return 0;
			
		}
		else if((ERbotrolltopz > LIKELY && ERbotrolltopz < DEFINITE)
				|| (ERbotrolltopz == DEFINITE) || (ERbotrolltopz > DEFINITE)){
			if(ERbotrolltopz == .25 || (ERbotrolltopz > .25 && ERbotrolltopz < .5)){
				return 1;
			}
			else if(ERbotrolltopz == .5 || (ERbotrolltopz > .5 && ERbotrolltopz < .75)){
				
			}
		}
		else{
			return 0;
		}
	}
}
