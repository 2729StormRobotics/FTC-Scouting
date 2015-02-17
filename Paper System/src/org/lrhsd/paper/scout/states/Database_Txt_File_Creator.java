package org.lrhsd.paper.scout.states;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.lrhsd.paper.scout.states.*;
public class Database_Txt_File_Creator extends JTabbedPane {
	//Used to search for team name
		String fileinput = "";
		
		//Read-only data
		String data[] = new String[12];
		
		//Database txt files data
		String dbData[] = new String[13];
		
		File_directory fd = new File_directory();
		
		//Image for fun
		Icon icon = new ImageIcon("storm2.jpeg");
		
		//Help text
		JTextArea area = new JTextArea("This program is used to develop the drive team strategy\n");
		
		//Data Fields
		JTextField team = new JTextField("Team #"), ramp = new JTextField("ramp to floor?"), kick = new JTextField("kickstand?"), centerauto = new JTextField("center scored?"),
				   rollingauto = new JTextField("rgscore"), rgtopz = new JTextField("rolltopz?"), 
				   thirtycm = new JTextField("30 cm scored?"), thirtymiss = new JTextField("30 cm missed?"), sixtycm = new JTextField("60 cm scored?"),
				   sixtymiss = new JTextField("60 cm missed?"), nintycm = new JTextField("90 cm scored?"), nintymiss = new JTextField("90 cm missed?"),
				   botrgtopz = new JTextField("Botrgtopz?"), botrgoff = new JTextField("Bot/rg off floor?"), centerend = new JTextField("Center scored?");
	    
		//Buttons for creating and reading files
		JButton create = new JButton("Create file"), reset = new JButton("Reset Program"), zero = new JButton("Set Data to 0"), close = new JButton("Close");
		
		//containers for components
		JPanel helppanel = new JPanel(), datapanel = new JPanel();
		
		//Label to read 
		public void help()
		{
			area.append("For true or false statements in the data like ramp to floor, count how many times it was true\n");
			area.append("Use this to create data for the drive team");
			helppanel.add(area);
			this.addTab("Help", icon, helppanel, "If you need assistance come here");
			
		}
		public void data() throws IOException
		{
			datapanel.setLayout(null);
			datapanel.setBackground(Color.RED);
			
			team.setBounds(100, 10, 100, 50);
			ramp.setBounds(250, 10, 100, 50);
			kick.setBounds(400, 10, 100, 50);
			centerauto.setBounds(550, 10, 100, 50);
			rgtopz.setBounds(700, 10, 100, 50);
			rollingauto.setBounds(100, 100, 100, 50);
			thirtycm.setBounds(250, 100, 100, 50);
			sixtycm.setBounds(400, 100, 100, 50);
			nintycm.setBounds(550, 100, 100, 50);
			botrgtopz.setBounds(700, 100, 100, 50);
			botrgoff.setBounds(325, 200, 100, 50);
			centerend.setBounds(475, 200, 100, 50);
			create.setBounds(400, 275, 100, 50);
			reset.setBounds(400, 350, 100, 50);
			zero.setBounds(400, 425, 100, 50);
			close.setBounds(400, 500, 100, 50);
			
			//Button action
			action();
			
			datapanel.add(team);
			datapanel.add(ramp);
			datapanel.add(kick);
			datapanel.add(centerauto);
			datapanel.add(rgtopz);
			datapanel.add(rollingauto);
			datapanel.add(thirtycm);
			datapanel.add(sixtycm);
			datapanel.add(nintycm);
			datapanel.add(botrgtopz);
			datapanel.add(botrgoff);
			datapanel.add(centerend);
			datapanel.add(create);
			datapanel.add(reset);
			datapanel.add(zero);
			datapanel.add(close);
			this.addTab("Strategy", icon, datapanel, "Here is where the magic happens");
			
		}
		public void action () throws IOException
		{
			create.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//Stores Read-only memory
					data[0] = "Team: " +team.getText().toString();
					data[1] = "Times ramp from floor" + ramp.getText().toString();
					data[2] = "Time kickstand knocked over" + kick.getText().toString();
					data[3] = "Times scored in center goal during autonoumus: " + centerauto.getText().toString();
					data[4] = "Times scored in the rolling goal during autonoumus: " + rollingauto.getText().toString();
					data[5] = "Times rolling goal to pz: " + rgtopz.getText().toString();
					data[6] = "Times scored in the 30cm rolling goal: " + thirtycm.getText().toString();
					data[7] = "Times scored in the 60cm rolling goal: " + sixtycm.getText().toString();
					data[8] = "Times scored in the 90cm rolling goal: " + nintycm.getText().toString();
					data[9] = "Times Bot or rolling goal moved to pz: " + botrgtopz.getText().toString();
					data[10] = "Times Bot or rolling goal moved off of floor: " + botrgoff.getText().toString();
					data[11] = "Times scored in center goal: " + centerend.getText().toString();
					
					//Stores DB txt file data
					dbData[0] = team.getText().toString();
					dbData[1] = "1";
					dbData[2] = ramp.getText().toString();
					dbData[3] = kick.getText().toString();
					dbData[4] = centerauto.getText().toString();
					dbData[5] = rollingauto.getText().toString();
					dbData[6] = rgtopz.getText().toString();
					dbData[7] = thirtycm.getText().toString();
					dbData[8] = sixtycm.getText().toString();
					dbData[9] = nintycm.getText().toString();
					dbData[10] = botrgtopz.getText().toString();
					dbData[11] = botrgoff.getText().toString();
					dbData[12] = centerend.getText().toString();
					
				File file = new File(fd.getROFDirectory(), team.getText().toString() + ".txt");
				try{
					FileWriter f = new FileWriter(file);
					BufferedWriter writer = new BufferedWriter(f);
					
						writer.write(data[0]);
						writer.newLine();
						writer.newLine();
						writer.write(data[1]);
						writer.newLine();
						writer.newLine();
						writer.write(data[2]);
						writer.newLine();
						writer.newLine();
						writer.write(data[3]);
						writer.newLine();
						writer.newLine();
						writer.write(data[4]);
						writer.newLine();
						writer.newLine();
						writer.write(data[5]);
						writer.newLine();
						writer.newLine();
						writer.write(data[6]);
						writer.newLine();
						writer.newLine();
						writer.write(data[7]);
						writer.newLine();
						writer.newLine();
						writer.write(data[8]);
						writer.newLine();
						writer.newLine();
						writer.write(data[9]);
						writer.newLine();
						writer.newLine();
						writer.write(data[10]);
						writer.newLine();
						writer.newLine();
						writer.write(data[11]);
						writer.newLine();
						writer.newLine();
						writer.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				File db = new File(fd.getDBFDirectory(), team.getText().toString() + ".txt");
				 try {
					FileWriter fw = new FileWriter(db);
					BufferedWriter dbwriter = new BufferedWriter(fw);
					for(int i = 0; i < dbData.length; ++i){
						dbwriter.write(dbData[i] + ",");
					}
					dbwriter.write(dbData[11]);
					dbwriter.write(",");
					dbwriter.write("*");
					dbwriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  	
				}
				
			});
			reset.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
				  team.setText("Team #");
				  ramp.setText("ramp to floor?");
				  kick.setText("kickstand?");
				  centerauto.setText("center scored?");
				  rgtopz.setText("rolltopz");
				  rollingauto.setText("rgscore");
				  thirtycm.setText("30 cm scored?");
				  sixtycm.setText("60 cm scored?");
				  nintycm.setText("90 cm scored?");
				  botrgtopz.setText("Botrgtopz?");
				  botrgoff.setText("Bot/rg off floor?");
				  centerend.setText("Center scored?");
				  
				}
				
			});
			zero.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 ramp.setText("0");
					  kick.setText("0");
					  centerauto.setText("0");
					  rgtopz.setText("0");
					  rollingauto.setText("0");
					  thirtycm.setText("0");
					  sixtycm.setText("0");
					  nintycm.setText("0");
					  botrgtopz.setText("0");
					  botrgoff.setText("0");
					  centerend.setText("0");
				}
				
			});
			close.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
				System.exit(0);	
				}
				
			});
			
		}
		
		public Database_Txt_File_Creator() throws IOException
		{
			
			fd.create();
			JFrame frame = new JFrame("Drive Strategy File Maker");
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setSize(900, 900);
			help();
			data();
			frame.add(this);
			fd.create();
		}

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			new Database_Txt_File_Creator();
		}

	}