package org.lrhsd.paper.scout.states;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class File_directory extends JFrame {

	//Components
	JTextField ROF = new JTextField("Directory of Read-Only Files"), DBF = new JTextField("Directory of Database Files");
	JPanel panel = new JPanel();
	//Buttons for program
	JButton dir1 = new JButton("..."), dir2 = new JButton("..."), submit = new JButton("Submit");
	//Holds textfield values
	String S_ROF = "", S_DBF = "";
    //used to close window
	public void close(){
	this.dispose();
	}
	//method to add components to panel
	public void addComponents(){
	panel.setLayout(null);
	ROF.setBounds(50, 50, 300, 50);
	DBF.setBounds(50, 150, 300, 50);
	dir1.setBounds(350, 50, 50, 50);
	dir2.setBounds(350, 150, 50, 50);
	submit.setBounds(180, 230, 100, 50);
	actions();
	panel.add(ROF);
	panel.add(DBF);
	panel.add(dir1);
	panel.add(dir2);
	panel.add(submit);
}
	public void actions(){
		dir1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser choice = new JFileChooser();
				choice.setDialogTitle("Choose a directory");
				choice.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnval = choice.showOpenDialog(File_directory.this);
				if(returnval == JFileChooser.APPROVE_OPTION){
					ROF.setText(choice.getSelectedFile().toString());
				}
			}
			
		});
		dir2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser choice = new JFileChooser();
				choice.setDialogTitle("Choose a directory");
				choice.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnval = choice.showOpenDialog(File_directory.this);
				if(returnval == JFileChooser.APPROVE_OPTION){
					DBF.setText(choice.getSelectedFile().toString());
				}
			}
			
		});
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				S_ROF = ROF.getText().toString();
				S_DBF = DBF.getText().toString();
				close();
				
			}
		});
		
	}
	public String getROFDirectory(){
		return S_ROF;
	}
	public String getDBFDirectory(){
		return S_DBF;
	}
	public void create(){
		this.setVisible(true);
		   this.setSize(500,400);
		   this.setTitle("File directory chooser");
		   addComponents();
		   this.add(panel);
	}
   public File_directory(){
	   
   }
	
 public static void main(String[] args) {
   		// TODO Auto-generated method stub
        File_directory fd = new File_directory();
        fd.create();
	}

}
