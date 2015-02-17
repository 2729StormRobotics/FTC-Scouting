package org.lrhsd.paper.scout.states;

public class CascadeEffect {
	//Team Data Columns
	public String[] columnNames={
	    	"TeamNum",
	    	"Number of Matches",
	    	"Bot to floor",
	    	"Kickstand knocked",
	    	"Center Goal Scored",
	    	"Rolling Goal scored",
	    	"Rolling Goal to pz",
	    	"Thirty cm scored",
	    	"Sixty cm scored",
	    	"Ninty cm scored",
	    	"Bot or rolling to pz",
	    	"Bot or rolling off floor",
	    	"Center Goal End Scored"
	    };
	//Variables of team data
	String in = "";
	int TeamNum = 0; 
	double Bottofloor = 0, kickstand = 0, 
	    	   centergoalauto = 0, rollinggoalauto = 0, rollinggoaltopz = 0,
	    	   thirty = 0, sixty = 0, ninty = 0,
	    	   botrolltopz = 0, botrollofffloor = 0, centergoalend = 0;
	 //Used to autoincrement number of matches
    double match_num = 1;
    double matches = 0;
	public CascadeEffect(){
		
	}
	public CascadeEffect(String input){
		this.in = input;
    String[] decodedData = new String[this.columnNames.length];
    for(int i = 0; i < decodedData.length; ++i){
    	decodedData[i] = in.substring(0, in.indexOf(","));
    	in = in.substring(in.indexOf(",")+1, in.length());
    	
        
    }
    TeamNum = Integer.parseInt(decodedData[0]);
    matches = Double.parseDouble(decodedData[1]);
    Bottofloor = Double.parseDouble(decodedData[2]);
    kickstand = Double.parseDouble(decodedData[3]);
    centergoalauto = Double.parseDouble(decodedData[4]);
    rollinggoalauto = Double.parseDouble(decodedData[5]);
    rollinggoaltopz = Double.parseDouble(decodedData[6]);
    thirty = Double.parseDouble(decodedData[7]); 
    sixty = Double.parseDouble(decodedData[8]); 
    ninty = Double.parseDouble(decodedData[9]);
    botrolltopz = Double.parseDouble(decodedData[10]);
    botrollofffloor = Double.parseDouble(decodedData[11]);
    centergoalend = Double.parseDouble(decodedData[12]);
    
}
	public CascadeEffect(int Teamnum, double matches, double Bottofloor, double kickstand, double centergoalauto,
						double rollinggoalauto, double rollinggoaltopz, double thirty, double sixty, double ninty,
						double botrolltopz, double botrollofffloor, double centergoalend){
		this.TeamNum = Teamnum;
		this.matches = matches;
		this.Bottofloor = Bottofloor;
		this.kickstand = kickstand;
		this.centergoalauto = centergoalauto;
		this.rollinggoalauto = rollinggoalauto;
		this.rollinggoaltopz = rollinggoaltopz;
		this.thirty = thirty;
		this.sixty = sixty;
		this.ninty = ninty;
		this.botrolltopz = botrolltopz;
		this.botrollofffloor = botrollofffloor;
		this.centergoalend = centergoalend;
	}
	public String[] getColumnNames(){
		return columnNames;
	}

	public Object[] getTeamData(){
		Object[] teamdata = {getTeamNum(), getMatches(), getBottofloor(), getKickstand(), getCentergoalauto(), getRollinggoalauto(), getRollinggoaltopz(),
				             getThirty(), getSixty(), getNinty(), getBotrolltopz(), getBotrollofffloor(), getCentergoalend()};
		return teamdata;
	}
	public int getTeamNum() {
		return TeamNum;
	}
	public double getMatch_num(){
		return match_num;
	}
	public double getBottofloor() {
		return Bottofloor;
	}
	public double getKickstand() {
		return kickstand;
	}
	public double getCentergoalauto() {
		return centergoalauto;
	}
	public double getRollinggoalauto() {
		return rollinggoalauto;
	}
	public double getRollinggoaltopz() {
		return rollinggoaltopz;
	}
	public double getThirty() {
		return thirty;
	}
	public double getSixty() {
		return sixty;
	}
	public double getNinty() {
		return ninty;
	}
	public double getBotrolltopz() {
		return botrolltopz;
	}
	public double getBotrollofffloor() {
		return botrollofffloor;
	}
	public double getCentergoalend() {
		return centergoalend;
	}
	public double getMatches(){
		return matches;
	}
}
