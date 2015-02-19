package org.lrhsd.paper.scout.states;
import org.lrhsd.paper.scout.states.Alliance;
import org.lrhsd.paper.scout.states.CascadeEffect;

public class Predict {
	
	//Efficientcy varaiables for red alliance
	int[] TeamNumRed = new int[2];
	double ERbottofloor = 0, ERkickstand = 0, ERcenterscoredauto = 0, ERrollinggoalscore = 0,
		   ERrollinggoaltopz = 0, ERthirty = 0, ERsixty = 0, ERninty = 0, ERbotrolltopz = 0,
		   ERbotrollofffloor = 0, ERcenterscoredend = 0;
	//Effiecientcy variables for blue alliance
	int[] TeamNumBlue = new int[2];
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
		if(ERbottofloor < NO || (ERbottofloor > NO && ERbottofloor < MAYBE)){
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
		if(ERkickstand < NO || (ERkickstand > NO && ERkickstand < MAYBE)){
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
		if(ERrollinggoalscore < NO || (ERrollinggoalscore > NO && ERrollinggoalscore < MAYBE)){
			return 0;
			
		}
		else if((ERrollinggoalscore > LIKELY && ERrollinggoalscore < DEFINITE)
				|| (ERrollinggoalscore == DEFINITE) || (ERrollinggoalscore > DEFINITE)){
			return 30;
			
		}
		else{
			return 0;
		}
	}
	public double predict_red_rolling_pz_auto(){
		if(ERrollinggoaltopz < NO || (ERrollinggoaltopz > NO && ERrollinggoaltopz < MAYBE)){
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
		if(ERcenterscoredauto < NO || (ERcenterscoredauto > NO && ERcenterscoredauto < MAYBE)){
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
		if(ERthirty < NO || (ERthirty > NO && ERthirty < MAYBE)){
			return 0;
			
		}
		else if((ERthirty > LIKELY && ERthirty < DEFINITE)
				|| (ERthirty == DEFINITE) || (ERthirty > DEFINITE)){
		
			
				return Math.round(ERthirty);
			}
			
		
		else{
			return 0;
		}
	}
	public double predict_red_sixty(){
		if(ERsixty < NO || (ERsixty > NO && ERsixty < MAYBE)){
			return 0;
			
		}
		else if((ERsixty > LIKELY && ERsixty < DEFINITE)
				|| (ERsixty == DEFINITE) || (ERsixty > DEFINITE)){
	
				return Math.round(ERsixty);
			}
			else{
				return 0;
			}
		}
	
	
	public double predict_red_ninty(){
		if(ERninty < NO || (ERninty > NO && ERninty < MAYBE)){
			return 0;
			
		}
		else if((ERninty > LIKELY && ERthirty < DEFINITE)
				|| (ERninty == DEFINITE) || (ERninty > DEFINITE)){
		
				return Math.round(ERninty);
	   
		
		}
		else{
			return 0;
		}
	}
	public double predict_red_bot_pz(){
		if(ERbotrolltopz < NO || (ERbotrolltopz > NO && ERbotrolltopz < MAYBE)){
			return 0;
			
		}
		else if((ERbotrolltopz > LIKELY && ERbotrolltopz < DEFINITE)
				|| (ERbotrolltopz == DEFINITE) || (ERbotrolltopz > DEFINITE)){
			if(ERbotrolltopz == .25 || (ERbotrolltopz > .25 && ERbotrolltopz < .5)){
				return 1;
			}
			else if(ERbotrolltopz == .5 || (ERbotrolltopz > .5 && ERbotrolltopz < .75)){
				return 2;
			}
			else if(ERbotrolltopz == .75 || (ERbotrolltopz > .75 && ERbotrolltopz < 1)){
				return 3;
			}
			else if(ERbotrolltopz == 1){
				return 4;
			}
		}
		else{
			return 0;
		}
		return 0;
	}
	public double predict_red_bot_floor(){
		if(ERbotrolltopz < NO || (ERbotrollofffloor > NO && ERbotrollofffloor < MAYBE)){
			return 0;
			
		}
		else if((ERbotrollofffloor > LIKELY && ERbotrollofffloor < DEFINITE)
				|| (ERbotrollofffloor == DEFINITE) || (ERbotrollofffloor > DEFINITE)){
			if(ERbotrollofffloor == .25 || (ERbotrollofffloor > .25 && ERbotrollofffloor < .5)){
				return 1;
			}
			else if(ERbotrollofffloor == .5 || (ERbotrollofffloor > .5 && ERbotrolltopz < .75)){
				return 2;
			}
			else if(ERbotrollofffloor == .75 || (ERbotrollofffloor > .75 && ERbotrolltopz < 1)){
				return 3;
			}
			else if(ERbotrolltopz == 1){
				return 4;
			}
		}
		else{
			return ERbotrolltopz*4;
		}
			return 0;
		}
	public double predict_red_center_goal_end(){
		if(ERcenterscoredend < NO || (ERcenterscoredend > NO && ERcenterscoredend < MAYBE)){
			return 0;
			
		}
		else if((ERcenterscoredend > LIKELY && ERcenterscoredend < DEFINITE)
				|| (ERcenterscoredend == DEFINITE) || (ERcenterscoredend > DEFINITE)){
			return Math.round(ERcenterscoredend);
	    }
		return 0;
	}
	public double predict_red_score(){
		double score = 0;
		       score += predict_red_to_floor_auto() + predict_red_kickstand() + predict_red_center_auto() + predict_red_rolling_goal() + predict_red_rolling_pz_auto()
		       	     + predict_red_bot_pz() + predict_red_bot_floor() + predict_red_center_goal_end();
	           return score;
	}
	public double predict_blue_to_floor_auto(){
		if(EBbottofloor < NO || (EBbottofloor > NO && EBbottofloor < MAYBE)){
		
			return 0;
			
		}
		else if((EBbottofloor > LIKELY && EBbottofloor < DEFINITE)
				|| (EBbottofloor == DEFINITE) || (EBbottofloor > DEFINITE)){
			return 20;
			
		}
		else{
			return 0;
		}
	}
	public double predict_blue_kickstand(){
		if(EBkickstand < NO || (EBkickstand > NO && EBkickstand < MAYBE)){
			return 0;
			
		}
		else if((EBkickstand > LIKELY && EBkickstand < DEFINITE)
				|| (EBkickstand == DEFINITE) || (EBkickstand > DEFINITE)){
			return 30;
			
		}
		else{
			return 0;
		}
	}
	public double predict_blue_rolling_goal(){
		if(EBrollinggoalscore < NO || (EBrollinggoalscore > NO && EBrollinggoalscore < MAYBE)){
			return 0;
			
		}
		else if((EBrollinggoalscore > LIKELY && EBrollinggoalscore < DEFINITE)
				|| (EBrollinggoalscore == DEFINITE) || (EBrollinggoalscore > DEFINITE)){
			return 30;
			
		}
		else{
			return 0;
		}
	}
	public double predict_blue_rolling_pz_auto(){
		if(EBrollinggoaltopz < NO || (EBrollinggoaltopz > NO && EBrollinggoaltopz < MAYBE)){
			return 0;
			
		}
		else if((EBrollinggoaltopz > LIKELY && EBrollinggoaltopz < DEFINITE)
				|| (EBrollinggoaltopz == DEFINITE) || (EBrollinggoaltopz > DEFINITE)){
			if(EBrollinggoaltopz == .33 || (EBrollinggoaltopz > .33 && EBrollinggoaltopz < .66)){
				return 30;
			}
			else if(EBrollinggoaltopz == .66 || (EBrollinggoaltopz > .66 && ERrollinggoaltopz < 1)){
				return 30*2;
			}
			else if(EBrollinggoaltopz == 1 || EBrollinggoaltopz > 1){
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
	public double predict_blue_center_auto(){
		if(EBcenterscoredauto < NO || (EBcenterscoredauto > NO && EBcenterscoredauto < MAYBE)){
			return 0;
			
		}
		else if((EBcenterscoredauto > LIKELY && EBcenterscoredauto < DEFINITE)
				|| (EBcenterscoredauto == DEFINITE) || (EBcenterscoredauto > DEFINITE)){
			return 20;
			
		}
		else{
			return 0;
		}
	}
	public double predict_blue_thirty(){
		if(EBthirty < NO || (EBthirty > NO && EBthirty < MAYBE)){
			return 0;
			
		}
		else if((EBthirty > LIKELY && EBthirty < DEFINITE)
				|| (EBthirty == DEFINITE) || (EBthirty > DEFINITE)){
		
			
				return Math.round(EBthirty);
			}
			
		
		else{
			return 0;
		}
	}
	public double predict_blue_sixty(){
		if(EBsixty < NO || (EBsixty > NO && EBsixty < MAYBE)){
			return 0;
			
		}
		else if((EBsixty > LIKELY && EBsixty < DEFINITE)
				|| (EBsixty == DEFINITE) || (EBsixty > DEFINITE)){
	
				return Math.round(EBsixty);
			}
			else{
				return 0;
			}
		}
	
	
	public double predict_blue_ninty(){
		if(EBninty < NO || (EBninty > NO && EBninty < MAYBE)){
			return 0;
			
		}
		else if((EBninty > LIKELY && EBthirty < DEFINITE)
				|| (EBninty == DEFINITE) || (EBninty > DEFINITE)){
		
				return Math.round(EBninty);
	   
		
		}
		else{
			return 0;
		}
	}
	public double predict_blue_bot_pz(){
		if(EBbotrolltopz < NO || (EBbotrolltopz > NO && EBbotrolltopz < MAYBE)){
			return 0;
			
		}
		else if((EBbotrolltopz > LIKELY && EBbotrolltopz < DEFINITE)
				|| (EBbotrolltopz == DEFINITE) || (EBbotrolltopz > DEFINITE)){
			if(EBbotrolltopz == .25 || (EBbotrolltopz > .25 && EBbotrolltopz < .5)){
				return 1;
			}
			else if(EBbotrolltopz == .5 || (EBbotrolltopz > .5 && EBbotrolltopz < .75)){
				return 2;
			}
			else if(EBbotrolltopz == .75 || (EBbotrolltopz > .75 && EBbotrolltopz < 1)){
				return 3;
			}
			else if(EBbotrolltopz == 1){
				return 4;
			}
		}
		else{
			return Math.round(EBbotrolltopz);
		}
		return 0;
	}
	public double predict_blue_bot_floor(){
		if(EBbotrolltopz < NO || (EBbotrollofffloor > NO && EBbotrollofffloor < MAYBE)){
			return 0;
			
		}
		else if((EBbotrollofffloor > LIKELY && EBbotrollofffloor < DEFINITE)
				|| (EBbotrollofffloor == DEFINITE) || (EBbotrollofffloor > DEFINITE)){
			if(EBbotrollofffloor == .25 || (EBbotrollofffloor > .25 && EBbotrollofffloor < .5)){
				return 1;
			}
			else if(EBbotrollofffloor == .5 || (EBbotrollofffloor > .5 && EBbotrolltopz < .75)){
				return 2;
			}
			else if(EBbotrollofffloor == .75 || (EBbotrollofffloor > .75 && EBbotrolltopz < 1)){
				return 3;
			}
			else if(EBbotrolltopz == 1){
				return 4;
			}
		}
		else{
			return EBbotrolltopz*4;
		}
			return 0;
		}
	public double predict_blue_center_goal_end(){
		if(EBcenterscoredend < NO || (EBcenterscoredend > NO && EBcenterscoredend < MAYBE)){
			return 0;
			
		}
		else if((EBcenterscoredend > LIKELY && EBcenterscoredend < DEFINITE)
				|| (EBcenterscoredend == DEFINITE) || (EBcenterscoredend > DEFINITE)){
			return Math.round(EBcenterscoredend);
	    }
		return 0;
	}
	public double predict_blue_score(){
		double score = 0;
		       score += predict_blue_to_floor_auto() + predict_blue_kickstand() + predict_blue_center_auto() + predict_blue_rolling_goal() + predict_blue_rolling_pz_auto()
		       	     + predict_blue_bot_pz() + predict_blue_bot_floor() + predict_blue_center_goal_end();
	           return score;
	}
	public double predict_team_to_floor_auto(){
		if(Ebottofloor < NO || (Ebottofloor > NO && Ebottofloor < MAYBE)){
		
			return 0;
			
		}
		else if((Ebottofloor > LIKELY && Ebottofloor < DEFINITE)
				|| (Ebottofloor == DEFINITE) || (Ebottofloor > DEFINITE)){
			return 20;
			
		}
		else{
			return 0;
		}
	}
	public double predict_team_kickstand(){
		if(Ekickstand < NO || (Ekickstand > NO && Ekickstand < MAYBE)){
			return 0;
			
		}
		else if((Ekickstand > LIKELY && Ekickstand < DEFINITE)
				|| (Ekickstand == DEFINITE) || (Ekickstand > DEFINITE)){
			return 30;
			
		}
		else{
			return 0;
		}
	}
	public double predict_team_rolling_goal(){
		if(Erollinggoalscore < NO || (Erollinggoalscore > NO && Erollinggoalscore < MAYBE)){
			return 0;
			
		}
		else if((Erollinggoalscore > LIKELY && Erollinggoalscore < DEFINITE)
				|| (Erollinggoalscore == DEFINITE) || (Erollinggoalscore > DEFINITE)){
			return 30;
			
		}
		else{
			return 0;
		}
	}
	public double predict_team_rolling_pz_auto(){
		if(Erollinggoaltopz < NO || (Erollinggoaltopz > NO && Erollinggoaltopz < MAYBE)){
			return 0;
			
		}
		else if((Erollinggoaltopz > LIKELY && Erollinggoaltopz < DEFINITE)
				|| (Erollinggoaltopz == DEFINITE) || (Erollinggoaltopz > DEFINITE)){
			if(Erollinggoaltopz == .33 || (Erollinggoaltopz > .33 && Erollinggoaltopz < .66)){
				return 30;
			}
			else if(Erollinggoaltopz == .66 || (Erollinggoaltopz > .66 && Erollinggoaltopz < 1)){
				return 30*2;
			}
			else if(Erollinggoaltopz == 1 || Erollinggoaltopz > 1){
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
	public double predict_team_center_auto(){
		if(Ecenterscoredauto < NO || (Ecenterscoredauto > NO && Ecenterscoredauto < MAYBE)){
			return 0;
			
		}
		else if((Ecenterscoredauto > LIKELY && Ecenterscoredauto < DEFINITE)
				|| (Ecenterscoredauto == DEFINITE) || (Ecenterscoredauto > DEFINITE)){
			return 20;
			
		}
		else{
			return 0;
		}
	}
	public double predict_team_thirty(){
		if(Ethirty < NO || (Ethirty > NO && Ethirty < MAYBE)){
			return 0;
			
		}
		else if((Ethirty > LIKELY && Ethirty < DEFINITE)
				|| (Ethirty == DEFINITE) || (Ethirty < DEFINITE)){
		
			
				return Math.round(Ethirty);
			}
			
		
		else{
			return 0;
		}
	}
	public double predict_team_sixty(){
		if(Esixty < NO || (Esixty > NO && Esixty < MAYBE)){
			return 0;
			
		}
		else if((Esixty > LIKELY && Esixty < DEFINITE)
				|| (Esixty == DEFINITE) || (Esixty > DEFINITE)){
	
				return Math.round(Esixty);
			}
			else{
				return 0;
			}
		}
	
	
	public double predict_team_ninty(){
		if(Eninty < NO || (Eninty > NO && Eninty < MAYBE)){
			return 0;
			
		}
		else if((Eninty > LIKELY && Ethirty < DEFINITE)
				|| (Eninty == DEFINITE) || (Eninty > DEFINITE)){
		
				return Math.round(Eninty);
	   
		
		}
		else{
			return 0;
		}
	}
	public double predict_team_bot_pz(){
		if(Ebotrolltopz < NO || (Ebotrolltopz > NO && Ebotrolltopz < MAYBE)){
			return 0;
			
		}
		else if((Ebotrolltopz > LIKELY && Ebotrolltopz < DEFINITE)
				|| (Ebotrolltopz == DEFINITE) || (Ebotrolltopz > DEFINITE)){
			if(Ebotrolltopz == .25 || (Ebotrolltopz > .25 && Ebotrolltopz < .5)){
				return 1;
			}
			else if(Ebotrolltopz == .5 || (Ebotrolltopz > .5 && Ebotrolltopz < .75)){
				return 2;
			}
			else if(Ebotrolltopz == .75 || (Ebotrolltopz > .75 && Ebotrolltopz < 1)){
				return 3;
			}
			else if(Ebotrolltopz == 1){
				return 4;
			}
		}
		else{
			return Math.round(Ebotrolltopz);
		}
		return 0;
	}
	public double predict_team_bot_floor(){
		if(Ebotrolltopz < NO || (Ebotrollofffloor > NO && Ebotrollofffloor < MAYBE)){
			return 0;
			
		}
		else if((Ebotrollofffloor > LIKELY && Ebotrollofffloor < DEFINITE)
				|| (Ebotrollofffloor == DEFINITE) || (Ebotrollofffloor > DEFINITE)){
			if(Ebotrollofffloor == .25 || (Ebotrollofffloor > .25 && Ebotrollofffloor < .5)){
				return 1;
			}
			else if(Ebotrollofffloor == .5 || (Ebotrollofffloor > .5 && Ebotrolltopz < .75)){
				return 2;
			}
			else if(Ebotrollofffloor == .75 || (Ebotrollofffloor > .75 && Ebotrolltopz < 1)){
				return 3;
			}
			else if(Ebotrolltopz == 1){
				return 4;
			}
		}
		else{
			return Ebotrolltopz*4;
		}
			return 0;
		}
	public double predict_team_center_goal_end(){
		if(Ecenterscoredend < NO || (Ecenterscoredend > NO && Ecenterscoredend < MAYBE)){
			return 0;
			
		}
		else if((Ecenterscoredend > LIKELY && Ecenterscoredend < DEFINITE)
				|| (Ecenterscoredend == DEFINITE) || (Ecenterscoredend > DEFINITE)){
			return Math.round(ERcenterscoredend);
	    }
		return 0;
	}
	public double predict_team_score(){
		double score = 0;
		       score += predict_team_to_floor_auto() + predict_team_kickstand() + predict_team_center_auto() + predict_team_rolling_goal() + predict_team_rolling_pz_auto()
		       	     + predict_team_bot_pz() + predict_team_bot_floor() + predict_team_center_goal_end();
	           return score;
	}
	public String predict_winner(){
		if(predict_red_score() > predict_blue_score()){
			return "RED ALLIANCE";
		}
		else if(predict_red_score() < predict_blue_score()){
			return "BLUE ALLIANCE";
			
		}
		else{
			return "TIE";
		}
	}
	
}
