package storm.ftc.stormradar.DataHandler;

/**
 * Created by Tommy on 1/21/2015.
 */
public class Datahandler {
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
    //Team one variables
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

    //Team 2 variables
    public static String team2 = "", match2 = "";
    public static boolean isRed2 = false;

    public static boolean isramptofloor2 = false, isknocked2 = false, centergoalisscored2 = false;
    public static int autorollingscore2 = 0, rgtopz2 = 0;
    public static int thirty2 = 0, sixty2 = 0, ninty2 = 0, thirtymiss2 = 0, sixtymiss2 = 0, nintymiss2 = 0;

    public static int botrolltopz2 = 0, botrollofffloor2 = 0, centergoalend2 = 0;

    public static String getTeam() {
        return team;
    }

    public static String getMatch() {
        return match;
    }

    public static boolean isRed() {
        return isRed;
    }

    public static boolean isramptofloor() {
        return isramptofloor;
    }

    public static boolean isknocked() {
        return isknocked;
    }

    public static boolean isCentergoalisscored() {
        return centergoalisscored;
    }

    public static int getAutorollingscore() {
        return autorollingscore;
    }

    public static int getRgtopz() {
        return rgtopz;
    }

    public static int getThirty() {
        return thirty;
    }

    public static int getSixty() {
        return sixty;
    }

    public static int getNinty() {
        return ninty;
    }

    public static int getThirtymiss() {
        return thirtymiss;
    }

    public static int getSixtymiss() {
        return sixtymiss;
    }

    public static int getNintymiss() {
        return nintymiss;
    }

    public static int getBotrolltopz() {
        return botrolltopz;
    }

    public static int getBotrollofffloor() {
        return botrollofffloor;
    }

    public static int getCentergoalend() {
        return centergoalend;
    }

    public static String getTeam2() {
        return team2;
    }

    public static String getMatch2() {
        return match2;
    }

    public static boolean isRed2() {
        return isRed2;
    }

    public static boolean isramptofloor2() {
        return isramptofloor2;
    }

    public static boolean isknocked2() {
        return isknocked2;
    }

    public static boolean isCentergoalisscored2() {
        return centergoalisscored2;
    }

    public static int getAutorollingscore2() {
        return autorollingscore2;
    }

    public static int getRgtopz2() {
        return rgtopz2;
    }

    public static int getThirty2() {
        return thirty2;
    }

    public static int getSixty2() {
        return sixty2;
    }

    public static int getNinty2() {
        return ninty2;
    }

    public static int getThirtymiss2() {
        return thirtymiss2;
    }

    public static int getSixtymiss2() {
        return sixtymiss2;
    }

    public static int getNintymiss2() {
        return nintymiss2;
    }

    public static int getBotrolltopz2() {
        return botrolltopz2;
    }

    public static int getBotrollofffloor2() {
        return botrollofffloor2;
    }

    public static int getCentergoalend2() {
        return centergoalend2;
    }


    public static void subAutorollingscore() {
        --autorollingscore;
    }

    public static void subRgtopz() {
        --rgtopz;
    }

    public static void subThirty() {
        --thirty;
    }

    public static void subSixty() {
        --sixty;
    }

    public static void subNinty() {
        --ninty;
    }

    public static void subThirtymiss() {
        --thirtymiss;
    }

    public static void subSixtymiss() {
        --sixtymiss;
    }

    public static void subNintymiss() {
        --nintymiss;
    }

    public static void subBotrolltopz() {
        --botrolltopz;
    }

    public static void subBotrollofffloor() {
        --botrollofffloor;
    }

    public static void subCentergoalend() {
        --centergoalend;
    }



    public static void subAutorollingscore2() {
        --autorollingscore2;
    }

    public static void subRgtopz2() {
        --rgtopz2;
    }

    public static void subThirty2() {
        --thirty2;
    }

    public static void subSixty2() {
        --sixty2;
    }

    public static void subNinty2() {
        --ninty2;
    }

    public static void subThirtymiss2() {
        --thirtymiss2;
    }

    public static void subSixtymiss2() {
        --sixtymiss2;
    }

    public static void subNintymiss2() {
        --nintymiss2;
    }

    public static void subBotrolltopz2() {
        --botrolltopz2;
    }

    public static void subBotrollofffloor2() {
        --botrollofffloor2;
    }

    public static void subCentergoalend2() {
        --centergoalend2;
    }

        public static void addAutorollingscore() {
        ++autorollingscore;
    }

    public static void addRgtopz() {
        ++rgtopz;
    }

    public static void addThirty() {
        ++thirty;
    }

    public static void addSixty() {
        ++sixty;
    }

    public static void addNinty() {
        ++ninty;
    }

    public static void addThirtymiss() {
        ++thirtymiss;
    }

    public static void addSixtymiss() {
        ++sixtymiss;
    }

    public static void addNintymiss() {
        ++nintymiss;
    }

    public static void addBotrolltopz() {
        ++botrolltopz;
    }

    public static void addBotrollofffloor() {
        ++botrollofffloor;
    }

    public static void addCentergoalend() {
        ++centergoalend;
    }



    public static void addAutorollingscore2() {
        ++autorollingscore2;
    }

    public static void addRgtopz2() {
        ++rgtopz2;
    }

    public static void addThirty2() {
        ++thirty2;
    }

    public static void addSixty2() {
        ++sixty2;
    }

    public static void addNinty2() {
        ++ninty2;
    }

    public static void addThirtymiss2() {
        ++thirtymiss2;
    }

    public static void addSixtymiss2() {
        ++sixtymiss2;
    }

    public static void addNintymiss2() {
        ++nintymiss2;
    }

    public static void addBotrolltopz2() {
        ++botrolltopz2;
    }

    public static void addBotrollofffloor2() {
        ++botrollofffloor2;
    }

    public static void addCentergoalend2() {
        ++centergoalend2;
    }

    public static String getTeamOneData(){
        String Qr = "";
        Qr += getTeam() + "," + getMatch() + "," + booltoint(isRed()) + "," + getAutorollingscore() + ","+
               "," + booltoint(isramptofloor()) + "," + booltoint(isknocked()) + "," + booltoint(isCentergoalisscored()) + "," + getThirty() + "," +
               getThirtymiss() + "," + getSixty() + "," + getSixtymiss() + "," + getNinty() + "," + getNintymiss() +
               "," + getBotrolltopz() + "," + getBotrollofffloor() + "," + getCentergoalend();
        return Qr;
    }
    public static String getTeamTwoData(){
        String Qr = "";
        Qr += getTeam2() + "," + getMatch2() + "," + booltoint(isRed2()) + "," + getAutorollingscore2() + ","+
                booltoint(isramptofloor2()) + "," + booltoint(isknocked2()) + "," + booltoint(isCentergoalisscored2()) + "," + getThirty2() + "," +
                getThirtymiss2() + "," + getSixty2() + "," + getSixtymiss2() + "," + getNinty2() + "," + getNintymiss2() + "," +
                getBotrolltopz2() + "," + getBotrollofffloor2() + "," + getCentergoalend2();
        return Qr;
    }


}



