package com.example.stormscouter;
public class DataHandler {
	//bool to int converter, if true, number is 1, but if it is false, it is 0
	public static int booltoint(boolean istrue)
	{
		if(istrue)
	    
	    {
			return 1;
		}
		else
		{
			return 0;
		}
	}

	//Setup variables
	public static String team = "", match = "";
	public static boolean isRed = false;//Checks if alliance is red
	//Auto Bool handlers
	//whether they move to floor from ramp, if the kickstand is knocked, whether a ball is scored in the center goal 
	public static boolean isramptofloor = false, isknocked = false, centergoalisscored = false;
	//Auto integers 
	public static int autorollingscore = 0, rgtopz = 0;
	//Tele/Endgame rolling goal made variables
	public static int thirty = 0, sixty = 0, ninty = 0, thirtymiss = 0, sixtymiss = 0, nintymiss = 0;
	//Endgame integers
	public static int botrolltopz = 0, botrollofffloor = 0, centergoalend = 0; 

	public static void subint(int decrement){--decrement;}
	public static String getteam(){return team;}
	public static String getmatch(){return match;}
	public static boolean getisred(){return isRed;}
	public static String getmaindata(){String Main = getteam() + "," + getmatch() + "," + booltoint(getisred()) + ", "; return Main;}
	public static boolean isMoved(){return isramptofloor;}
	public static boolean isKnock(){return isknocked;}
	public static boolean getcentergoal(){return centergoalisscored;}
	public static int getautorollingscore(){return autorollingscore;}
	public static String getauto(){String auto = booltoint(isMoved()) + "," + booltoint(isKnock()) + "," + booltoint(getcentergoal()) + "," + getautorollingscore() + "," + getrgtopz() + ","; return auto;}
	public static void addautorollingscore(){++autorollingscore;}
	public static void subautorollingscore(){--autorollingscore;}
	public static int getrgtopz(){return rgtopz;}
	public static void addrgtopz(){++rgtopz;}
	public static void subrgtopz(){--rgtopz;}
	public static int getthirty(){return thirty;}
	public static void addthirty(){++thirty;}
	public static void subthirty(){--thirty;}
	public static int getsixty(){return sixty;}
	public static void addsixty(){++sixty;}
	public static void subsixty(){--sixty;}
	public static int getninty(){return ninty;}
	public static void addninty(){++ninty;}
	public static void subninty(){--ninty;}
	public static int getthirtymiss(){return thirtymiss;}
	public static void addthirtymiss(){++thirtymiss;}
	public static void subthirtymiss(){--thirtymiss;}
	public static int getsixtymiss(){return sixtymiss;}
	public static void addsixtymiss(){++sixtymiss;}
	public static void subsixtymiss(){--sixtymiss;}
	public static int getnintymiss(){return nintymiss;}
	public static void addnintymiss(){++nintymiss;}
	public static void subnintymiss(){--nintymiss;}
	public static String gettele(){String tele = getthirty() + "," + getthirtymiss() + "," + getsixty() + "," + getsixtymiss() + "," + getninty() + "," + getnintymiss() + ","; return tele;}
	public static int getbotrolltopz(){return botrolltopz;}
	public static void addbotrolltopz(){++botrolltopz;}
	public static void subbotrolltopz(){--botrolltopz;}
	public static int getbotrollofffloor(){return botrollofffloor;}
	public static void addbotrollofffloor(){++botrollofffloor;}
	public static void subbotrollofffloor(){--botrollofffloor;}
	public static int getcentergoalend(){return centergoalend;}
	public static void addcentergoalend(){++centergoalend;}
	public static void subcentergoalend(){--centergoalend;}
	public static String getend(){String end = getbotrolltopz() + "," + getbotrollofffloor() + "," + getcentergoalend(); return end;}
	public static String getQRdata(){String QR = getteam() + "," + getmatch() + "," + booltoint(getisred()) + "," + booltoint(isMoved()) + ", " + booltoint(isKnock()) +  "," + getautorollingscore() + "," + getrgtopz()
	+ "," + getthirty() + "," + getthirtymiss() + "," + getsixty() + "," + getsixtymiss() + "," + getninty() + "," + getnintymiss() 
	+ "," + getbotrolltopz() + "," + getbotrollofffloor() + "," + getcentergoalend();
	return QR;}
	public static String getQR(){String QRData = getauto() + gettele() + getend(); return QRData;}


	}


