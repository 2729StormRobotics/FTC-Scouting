package com.lrhsd.paper.scout;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class drivestrat extends JTabbedPane {
	//Used to search for team name
	String fileinput = "";
	
	String data[] = new String[15];
	
	
	
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
	JButton create = new JButton("Create file");
	
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
		thirtymiss.setBounds(400, 100, 100, 50);
		sixtycm.setBounds(550, 100, 100, 50);
		sixtymiss.setBounds(700, 100, 100, 50);
		nintycm.setBounds(100, 200, 100, 50);
		nintymiss.setBounds(250, 200, 100, 50);
		botrgtopz.setBounds(400, 200, 100, 50);
		botrgoff.setBounds(550, 200, 100, 50);
		centerend.setBounds(700, 200, 100, 50);
		create.setBounds(400, 300, 100, 50);
		
		//Button action
		action();
		
		datapanel.add(team);
		datapanel.add(ramp);
		datapanel.add(kick);
		datapanel.add(centerauto);
		datapanel.add(rgtopz);
		datapanel.add(rollingauto);
		datapanel.add(thirtycm);
		datapanel.add(thirtymiss);
		datapanel.add(sixtycm);
		datapanel.add(sixtymiss);
		datapanel.add(nintycm);
		datapanel.add(nintymiss);
		datapanel.add(botrgtopz);
		datapanel.add(botrgoff);
		datapanel.add(centerend);
		datapanel.add(create);
		
		this.addTab("Strategy", icon, datapanel, "Here is where the magic happens");
		
	}
	public void action () throws IOException
	{
		create.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				data[0] = "Team: " +team.getText().toString();
				data[1] = "Times ramp from floor" + ramp.getText().toString();
				data[2] = "Time kickstand knocked over" + kick.getText().toString();
				data[3] = "Times scored in center goal during autonoumus: " + centerauto.getText().toString();
				data[4] = "Times scored in the rolling goal during autonoumus: " + rollingauto.getText().toString();
				data[5] = "Times rolling goal to pz: " + rgtopz.getText().toString();
				data[6] = "Times scored in the 30cm rolling goal: " + thirtycm.getText().toString();
				data[7] = "Times missed the 30cm rolling goal: "+thirtymiss.getText().toString();
				data[8] = "Times scored in the 60cm rolling goal: " + sixtycm.getText().toString();
				data[9] = "Times missed the 60cm rolling goal: " + sixtymiss.getText().toString();
				data[10] = "Times scored in the 90cm rolling goal: " + nintycm.getText().toString();
				data[11] = "Times missed the 90cm rolling goal: " + nintymiss.getText().toString();
				data[12] = "Times Bot or rolling goal moved to pz: " + botrgtopz.getText().toString();
				data[13] = "Times Bot or rolling goal moved off of floor: " + botrgoff.getText().toString();
				data[14] = "Times scored in center goal: " + centerend.getText().toString();
				//File to create
				File file = new File(team.getText().toString() + ".txt");
				if(!file.exists()){
					try {
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try{
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter write = new BufferedWriter(fw);
					write.newLine();
					write.write(data[0]);
					write.newLine();
					write.newLine();
					write.append(data[1]);
					write.newLine();
					write.newLine();
					write.append(data[2]);
					write.newLine();
					write.newLine();
					write.append(data[3]);
					write.newLine();
					write.newLine();
					write.append(data[4]);
					write.newLine();
					write.newLine();
					write.append(data[5]);
					write.newLine();
					write.newLine();
					write.append(data[6]);
					write.newLine();
					write.newLine();
					write.append(data[7]);
					write.newLine();
					write.newLine();
					write.append(data[8]);
					write.newLine();
					write.newLine();
					write.append(data[9]);
					write.newLine();
					write.newLine();
					write.append(data[10]);
					write.newLine();
					write.newLine();
					write.append(data[11]);
					write.newLine();
					write.newLine();
					write.append(data[12]);
					write.newLine();
					write.newLine();
					write.append(data[13]);
					write.newLine();
					write.newLine();
					write.append(data[14]);
					write.flush();
					write.close();
					
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			
		});
	}
	
	public drivestrat() throws IOException
	{
		JFrame frame = new JFrame("Drive Strategy");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(900, 900);
		help();
		data();
		frame.add(this);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        new drivestrat();
	}

}
