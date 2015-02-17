package org.lrhsd.paper.scout.states;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.DefaultRowSorter;
import javax.swing.SortOrder;
import javax.swing.RowSorter;
import javax.swing.JComboBox;

import java.awt.BorderLayout;


import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Master_Database_Program extends JTabbedPane{
	//Table model
	DefaultTableModel team = new DefaultTableModel(1,14);
	//Team manifest table
	JTable _team = new JTable(team);
	//Panels for tabs
	JPanel pTeam = new JPanel(), pSort = new JPanel(), pT = new JPanel(), pAlliance = new JPanel();
	//Jbuttons for programs
	JButton sort = new JButton("Sort"), find = new JButton("Choose team to add"),cT = new JButton("Choose team"), cTeam = new JButton("Create team analysis"), 
			cAll = new JButton("Create Alliance analysis"), cR1 = new JButton("Red 1"), cR2 = new JButton("Red 2"), cB1 =  new JButton("Blue 1"), cB2 = new JButton("Blue 2"),submit = new JButton("Submit"), 
			create = new JButton("Generate team files");
	//Frame
	JFrame frame = new JFrame("Team DB Analyizer");
	//Columns
	public String[] columnNames={"TeamNum","Number of Matches","Bot to floor","Kickstand knocked","Center Goal Scored","Rolling Goal scored","Rolling Goal to pz","Thirty cm scored","Sixty cm scored","Ninty cm scored","Bot or rolling to pz","Bot or rolling off floor","Center Goal End Scored", "Overall Efficientcy"};
	//DropDown for sort
	JComboBox<String> box = new JComboBox<String>(columnNames);
	//Strings
	String crit = "", sTeam = "";
	//Sorting index
	int sortIndex;
	//file chooser
	JFileChooser file;
	//boolean value is equal to if the team is regisitered 
	boolean isReg = false;
	
	//For alliance calculations, must be defined as global since used in loop
	CascadeEffect one, two, three, four;
	
	//Some titles used for JFileChooser
	String[] places = new String[]{"Red 1", "Red 2", "Blue 1", "Blue 2"};
	//Search Tab text fields
	JLabel eTeam = new JLabel("Choose Team"), eAl1 = new JLabel("Red alliance 1"), eAl2 = new JLabel("Red alliance 2"), 
			eAl3 = new JLabel("Blue Alliance 1"), eAl4 = new JLabel("Blue Alliance 2");
	//File string used to read analysis directory
	String fileDir = "";
	public void actions(){
		find.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			   	file = new JFileChooser();
			   	file.setDialogTitle("Choose team to add to Manifest");
			   	int returnval = file.showOpenDialog(Master_Database_Program.this);
			   	if(returnval == JFileChooser.APPROVE_OPTION){
			   		File fil = new File(file.getSelectedFile().toString());
			   		try{
			   			BufferedReader read = new BufferedReader(new FileReader(fil));
			   		    sTeam = read.readLine();
			   		    read.close();
			   		}catch(IOException e){
			   			e.printStackTrace();
			   		}
			   		CascadeEffect cas = new CascadeEffect(sTeam);
			   		Team team = new Team(cas);
			   		System.out.println(team.calculate_team_bot_to_floor_auto());
			   		for(int i = 0; i < _team.getModel().getRowCount(); ++i){
			   			if(_team.getValueAt(i, 0) == (Object)cas.getTeamNum()){
						DefaultTableModel mode = (DefaultTableModel)_team.getModel();
						
						double data = cas.getMatches(), 
							   data1 = cas.getBottofloor(), 
							   data2 = cas.getKickstand(),
							   data3 = cas.getCentergoalauto(),
							   data4 = cas.getRollinggoalauto(), 
							   data5 = cas.getRollinggoaltopz(), 
							   data6 = cas.getThirty(), 
							   data7 = cas.getSixty(), 
							   data8 = cas.getNinty(), 
							   data9 = cas.getBotrolltopz(), 
							   data10 = cas.getBotrollofffloor(), 
							   data11 = cas.getCentergoalend();
							   
							   data  += (double)mode.getValueAt(i, 1);
							   data1 += (double)mode.getValueAt(i, 2);
							   data2 += (double)mode.getValueAt(i, 3);
							   data3 += (double)mode.getValueAt(i, 4);
							   data4 += (double)mode.getValueAt(i, 5);
							   data5 += (double)mode.getValueAt(i, 6);
							   data6 += (double)mode.getValueAt(i, 7);
							   data7 += (double)mode.getValueAt(i, 8);
							   data8 += (double)mode.getValueAt(i, 9);
							   data9 += (double)mode.getValueAt(i, 10);
							   data10 += (double)mode.getValueAt(i, 11);
							   data11 += (double)mode.getValueAt(i, 12);
							   
							   mode.setValueAt((Object)data, i, 1);
							   mode.setValueAt((Object)data1, i, 2);
							   mode.setValueAt((Object)data2, i, 3);
							   mode.setValueAt((Object)data3, i, 4);
							   mode.setValueAt((Object)data4, i, 5);
							   mode.setValueAt((Object)data5, i, 6);
							   mode.setValueAt((Object)data6, i, 7);
							   mode.setValueAt((Object)data7, i, 8);
							   mode.setValueAt((Object)data8, i, 9);
							   mode.setValueAt((Object)data9, i, 10);
							   mode.setValueAt((Object)data10, i, 11);
							   mode.setValueAt((Object)data11, i, 12);
							   
							   CascadeEffect c = new CascadeEffect((int)mode.getValueAt(i, 0), (double)mode.getValueAt(i, 1),  (double)mode.getValueAt(i, 2), (double)mode.getValueAt(i, 3), 
										                           (double)mode.getValueAt(i, 4), (double)mode.getValueAt(i, 5), (double)mode.getValueAt(i, 6), (double)mode.getValueAt(i, 7), (double)mode.getValueAt(i, 8),
										                           (double)mode.getValueAt(i, 9), (double)mode.getValueAt(i, 10), (double)mode.getValueAt(i, 11), (double)mode.getValueAt(i, 12));
							   Team t = new Team(c);
							   double data12 = t.getTeamData();
							   mode.setValueAt((Object)data12, i, 13);
						       System.out.println(t.calculate_team_bot_to_floor_auto());
							   isReg = true;
							   break;
						
			   			}
			   			
			   		}
			   		if(!isReg){
			   			DefaultTableModel mode = (DefaultTableModel)_team.getModel();
			   			mode.addRow(new Object[]{cas.getTeamNum(), cas.getMatches(), cas.getBottofloor(), cas.getKickstand(), cas.getCentergoalauto(), cas.getRollinggoalauto(),
			   					    cas.getRollinggoaltopz(), cas.getThirty(), cas.getSixty(), cas.getNinty(), cas.getBotrolltopz(), cas.getBotrollofffloor(), cas.getCentergoalend(), team.getTeamData()});
			   			
			   		}
			   		else{
			   			isReg = false;
			   			
			   		}
			   	}
			}
			
		});
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				crit = (String)box.getSelectedItem();
				for(int i = 0; i < columnNames.length; ++i){
					if(columnNames[i] == crit){
						sortIndex = i;
						
						break;
						
					}
				}
			}
			
		});
		sort.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DefaultRowSorter sorter = (DefaultRowSorter)_team.getRowSorter();
				ArrayList list = new ArrayList();
				list.add(new RowSorter.SortKey(sortIndex, SortOrder.DESCENDING));
				sorter.setSortKeys(list);
				sorter.sort();
			}
			
		});
		create.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			    JFileChooser fil = new JFileChooser();
			    fil.setDialogTitle("Choose where to download team files to");
				fil.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = fil.showOpenDialog(Master_Database_Program.this);
				System.out.println("File directory is: " + fileDir);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					fileDir = fil.getSelectedFile().toString();
				for(int i = 0; i < _team.getModel().getRowCount(); ++i){
					DefaultTableModel mode = (DefaultTableModel)_team.getModel();
					File f = new File(fil.getSelectedFile().toString(), "Team " + mode.getValueAt(i, 0) + ".txt");
			        
					try{
			        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			        writer.write(mode.getValueAt(i, 0) + "," + mode.getValueAt(i, 1) + "," + mode.getValueAt(i, 2) + "," + mode.getValueAt(i, 3) + "," +  
			        		     mode.getValueAt(i, 4) + "," + mode.getValueAt(i, 5) + "," + mode.getValueAt(i, 6) + "," + mode.getValueAt(i, 7) + "," +
			        		     mode.getValueAt(i, 8) + "," + mode.getValueAt(i, 9) + "," + mode.getValueAt(i, 10) + "," + mode.getValueAt(i, 11) + "," + 
			        		     mode.getValueAt(i, 12) + "," + "*");
			        writer.close();
			        
			        
			        }catch(IOException e){
			        	e.printStackTrace();
			        }
			     }
			}
		}
			
		});
		cR1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser f = new JFileChooser();
				f.setDialogTitle(places[0]);
				int returnVal = f.showOpenDialog(Master_Database_Program.this);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File fi = new File(f.getSelectedFile().toString());
					try {
						BufferedReader read = new BufferedReader(new FileReader(fi));
						String text = read.readLine();
						read.close();
					    eAl1.setText("Team " + text.substring(0, text.indexOf(",")));
						
					} catch (IOException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
			
		});
		cR2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser f = new JFileChooser();
				f.setDialogTitle(places[1]);
				int returnVal = f.showOpenDialog(Master_Database_Program.this);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File fi = new File(f.getSelectedFile().toString());
					try {
						BufferedReader read = new BufferedReader(new FileReader(fi));
						String text = read.readLine();
					    read.close();
						eAl2.setText("Team " + text.substring(0, text.indexOf(",")));
						
					} catch (IOException eve) {
						// TODO: handle exception
						eve.printStackTrace();
					}
				}
			}
			
		});
		cB1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser f = new JFileChooser();
				f.setDialogTitle(places[2]);
				int returnVal = f.showOpenDialog(Master_Database_Program.this);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File fi = new File(f.getSelectedFile().toString());
					try {
						BufferedReader read = new BufferedReader(new FileReader(fi));
						String text = read.readLine();
						read.close();
					    eAl3.setText("Team " + text.substring(0, text.indexOf(",")));
						
					} catch (IOException ev) {
						// TODO: handle exception
						ev.printStackTrace();
					}
				}
			}
			
		});
		cB2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser f = new JFileChooser();
				f.setDialogTitle(places[3]);
				int returnVal = f.showOpenDialog(Master_Database_Program.this);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File fi = new File(f.getSelectedFile().toString());
					try {
						BufferedReader read = new BufferedReader(new FileReader(fi));
						String text = read.readLine();
						read.close();
					    eAl4.setText("Team " + text.substring(0, text.indexOf(",")));
						
					} catch (IOException ex) {
						// TODO: handle exception
						ex.printStackTrace();
					}
				}
			}
			
		});
		cAll.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        File fOne = new File(fileDir, eAl1.getText().toString()+ ".txt"),
		             fTwo = new File(fileDir, eAl2.getText().toString()+ ".txt"),
		             fThree = new File(fileDir, eAl3.getText().toString() + ".txt"),
		             fFour = new File(fileDir, eAl4.getText().toString()+ ".txt");
		        try{
		        	BufferedReader rOne = new BufferedReader(new FileReader(fOne)), rTwo = new BufferedReader(new FileReader(fTwo)), rThree = new BufferedReader(new FileReader(fThree)), rFour = new BufferedReader(new FileReader(fFour));
		        	String sOne = rOne.readLine(), sTwo = rTwo.readLine(), sThree = rThree.readLine(), sFour = rFour.readLine();
		            CascadeEffect one = new CascadeEffect(sOne), two = new CascadeEffect(sTwo), three = new CascadeEffect(sThree), four = new CascadeEffect(sFour);
		            rOne.close(); rTwo.close(); rThree.close(); rFour.close();
		            Alliance red = new Alliance(one, two), blue = new Alliance(three, four);
		            Predict predict = new Predict(red, blue);
		            
		            File f = new File(fileDir, "Red " + red.getTeamOne() + " and " + red.getTeamTwo() + "; " + "Blue " + blue.getTeamOne() + " and " + blue.getTeamTwo() + ".txt");
		            BufferedWriter match = new BufferedWriter(new FileWriter(f));
		            match.write("*************************RED Alliance*************************");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for bot from ramp to floor: " + (red.calculate_team_bot_to_floor_auto() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for kickstand being knocked over: " + (red.calculate_team_bot_kickstand() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for Center goal being scored in the auto: " + (red.calculate_team_centergoal_auto() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for the rolling goal being scored: " + (red.calculate_team_rolling_score_auto() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for the rolling goal being moved to pz: " + (red.calculate_team_rolling_goal_pz_auto() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for scoring in the thirty cm goal being scored: " + (red.calculate_team_thirty_cm() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for scoring in the sixty cm goal being scored: " + (red.calculate_team_sixty_cm() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for scoring in the ninty cm goal being scored: " + (red.calculate_team_ninty_cm() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for moving bot or rolling goal to pz during end game: " + (red.calculate_team_bot_pz() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for moving bot or rolling goal off floor during end game: " + (red.calculate_team_bot_floor() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall score: " + predict.predict_red_score());
		            match.newLine();
		            match.newLine();
		            match.write("Overall thirty cm scored: " + predict.predict_red_thirty());
		            match.newLine();
		            match.newLine();
		            match.write("Overall sixty cm scored: " + predict.predict_red_sixty());
		            match.newLine();
		            match.newLine();
		            match.write("Overall ninty cm scored: " + predict.predict_red_ninty());
		            match.newLine();
		            match.newLine();
		            match.write("*************************BLUE Alliance*************************");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for bot from ramp to floor: " + (blue.calculate_team_bot_to_floor_auto() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for kickstand being knocked over: " + (blue.calculate_team_bot_kickstand() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for Center goal being scored in the auto: " + (blue.calculate_team_centergoal_auto() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for the rolling goal being scored: " + (blue.calculate_team_rolling_score_auto() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for the rolling goal being moved to pz: " + (blue.calculate_team_rolling_goal_pz_auto() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for scoring in the thirty cm goal being scored: " + (blue.calculate_team_thirty_cm()  * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for scoring in the sixty cm goal being scored: " + (blue.calculate_team_sixty_cm() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for scoring in the ninty cm goal being scored: " + (blue.calculate_team_ninty_cm() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for moving bot or rolling goal to pz during end game: " + (blue.calculate_team_bot_pz() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall effciency for moving bot or rolling goal off floor during end game: " + (blue.calculate_team_bot_floor() * 10.0) + "%");
		            match.newLine();
		            match.newLine();
		            match.write("Overall score: " + predict.predict_blue_score());
		            match.newLine();
		            match.newLine();
		            match.write("Overall thirty cm scored: " + predict.predict_blue_thirty());
		            match.newLine();
		            match.newLine();
		            match.write("Overall sixty cm scored: " + predict.predict_blue_sixty());
		            match.newLine();
		            match.newLine();
		            match.write("Overall ninty cm scored: " + predict.predict_blue_ninty());
		            match.newLine();
		            match.newLine();
		            match.write("Prediction of winner: " + predict.predict_winner());
		            match.close();
		        }catch(IOException p){
		        	p.printStackTrace();
		        }
		        
			    
			}
		
			
		});
		cT.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser f = new JFileChooser();
				f.setDialogTitle("Choose team");
				int returnVal = f.showOpenDialog(Master_Database_Program.this);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File fi = new File(f.getSelectedFile().toString());
					try {
						BufferedReader read = new BufferedReader(new FileReader(fi));
						String text = read.readLine();
					    read.close();
						eTeam.setText("Team " + text.substring(0, text.indexOf(",")));
						
					} catch (IOException eve) {
						// TODO: handle exception
						eve.printStackTrace();
					}
				}
			}
			
		});
		cTeam.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File f = new File(fileDir, eTeam.getText().toString() + ".txt");
				try{
				BufferedReader read = new BufferedReader(new FileReader(f));
				String text = read.readLine();
				CascadeEffect cas = new CascadeEffect(text);
				Team opp = new Team(cas);
				Predict predict = new Predict(opp);
				File team = new File(fileDir, "Team " + cas.getTeamNum() + "Probability");
				BufferedWriter tm = new BufferedWriter(new FileWriter(team));
				
				    tm.write("*************************Team " +  cas.getTeamNum() + "*************************");
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall effciency for bot from ramp to floor: " + (opp.calculate_team_bot_to_floor_auto() * 10.0) + "%");
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall effciency for kickstand being knocked over: " + (opp.calculate_team_bot_kickstand() * 10.0) + "%");
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall effciency for Center goal being scored in the auto: " + (opp.calculate_team_centergoal_auto() * 10.0) + "%");
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall effciency for the rolling goal being scored: " + (opp.calculate_team_rolling_score_auto() * 10.0) + "%");
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall effciency for the rolling goal being moved to pz: " + (opp.calculate_team_rolling_goal_pz_auto() * 10.0) + "%");
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall effciency for scoring in the thirty cm goal being scored: " + (opp.calculate_team_thirty_cm()  * 10.0) + "%");
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall effciency for scoring in the sixty cm goal being scored: " + (opp.calculate_team_sixty_cm() * 10.0) + "%");
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall effciency for scoring in the ninty cm goal being scored: " + (opp.calculate_team_ninty_cm() * 10.0) + "%");
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall effciency for moving bot or rolling goal to pz during end game: " + (opp.calculate_team_bot_pz() * 10.0) + "%");
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall effciency for moving bot or rolling goal off floor during end game: " + (opp.calculate_team_bot_floor() * 10.0) + "%");
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall score: " + predict.predict_team_score());
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall thirty cm scored: " + predict.predict_team_thirty());
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall sixty cm scored: " + predict.predict_team_sixty());
		            tm.newLine();
		            tm.newLine();
		            tm.write("Overall ninty cm scored: " + predict.predict_team_ninty());
		            tm.newLine();
		            tm.newLine();
		            tm.close();
				}catch(IOException t){
					t.printStackTrace();
				}
			}
			
		});
	}
	public void Manifest(){
		actions();
		pTeam.setLayout(new BorderLayout());
		pTeam.add(_team, BorderLayout.CENTER);
		pTeam.add(new JLabel(columnNames[0] + " | " + columnNames[1] + " | " + columnNames[2] + " | " + columnNames[3] + " | " + columnNames[4]
				  + columnNames[5] + " | " + columnNames[6] + " | " + columnNames[7] + " | " + columnNames[8] + " | " + columnNames[9] + " | " + columnNames[10]
				  + " | " + columnNames[11] + " | " + columnNames[12]), BorderLayout.NORTH);
		pTeam.add(sort, BorderLayout.WEST);
		pTeam.add(find, BorderLayout.EAST);
		pTeam.add(create, BorderLayout.SOUTH); 
		this.addTab("Manifest", null, pTeam, "Manifest table of team");
		
	}
	public void sortTab(){
		actions();
		pSort.add(box);
		pSort.add(submit);
		this.addTab("Sort", null, pSort, "Select sort criteria");
	}
	public void allianceSearch(){
		pAlliance.setLayout(null);
		eAl1.setBounds(200, 10, 100, 50);
		eAl2.setBounds(350, 10, 100, 50);
		eAl3.setBounds(500, 10, 100, 50);
		eAl4.setBounds(650, 10, 100, 50);
		cR1.setBounds(190, 100, 100, 50);
		cR2.setBounds(340, 100, 100, 50);
		cB1.setBounds(490, 100, 100, 50);
		cB2.setBounds(640, 100, 100, 50);
		cAll.setBounds(365, 200, 200, 50);
		JLabel[] items= {eAl1, eAl2, eAl3, eAl4};
		
	    for(int i = 0; i < items.length; ++i){pAlliance.add(items[i]);}
		pAlliance.add(cAll);
	    pAlliance.add(cR1);
	    pAlliance.add(cR2);
	    pAlliance.add(cB1);
	    pAlliance.add(cB2);
		this.addTab("Alliance", null, pAlliance, "Choose an alliance to synthesize data from");
	}
	public void teamSearch(){
		actions();
		pT.setLayout(null);
		eTeam.setBounds(425, 10, 100, 50);
		cT.setBounds(415, 100, 100, 50);
		cTeam.setBounds(415, 200, 100, 50);
		pT.add(eTeam);
		pT.add(cT);
		pT.add(cTeam);
		this.addTab("Team", null, pT, "Choose a team to synthesize data from");
		
	}
	public Master_Database_Program() {
		// TODO Auto-generated constructor stub
		_team.setAutoCreateRowSorter(true);
		Manifest();
	    sortTab();
	    allianceSearch();
	    teamSearch();
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(this);
	}
	public static void main(String[] args){
		new Master_Database_Program();
	}
	
	
}