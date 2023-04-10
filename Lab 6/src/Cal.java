import java.awt.*;
import java.io.*;
//import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;

public class Cal extends JFrame implements ActionListener  {
	
	JPanel panel;
	JButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttona,buttons,buttonm,buttond,buttone,buttonsave,buttonrecall,buttonc;
	JLabel label;
	JTextField text;
	
	File memories = new File("C:\\Users\\noriss\\Documents\\Brunel\\NC1601\\lab6_cal.txt");

	//ArrayList<String> formula = new ArrayList<String>(); 
	String temp="";
	int total=0,num1=0,num2=0,op=0;
		
	public Cal() {
		
		
		//define new object
		panel = new JPanel();
		label = new JLabel("Calculator");
		text = new JTextField(20);
		text.setEditable(false);
		
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttona = new JButton("+");
		buttons = new JButton("-");
		buttonm = new JButton("*");
		buttond = new JButton("/");
		buttone = new JButton("=");
		buttonc = new JButton("  cancel  ");
		buttonsave = new JButton("save");
		buttonrecall = new JButton("recall");
		
		//add panel to hold buttons
		add(panel);

		panel.add(label);
		panel.add(text);
		panel.add(buttonsave);
		panel.add(buttonrecall);
		panel.add(buttona);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);	
		
		panel.add(buttons);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		
		panel.add(buttonm);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(buttond);
		
		panel.add(button0);
		panel.add(buttonc);
		panel.add(buttone);
		
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		buttona.addActionListener(this);
		buttons.addActionListener(this);
		buttonm.addActionListener(this);
		buttond.addActionListener(this);
		buttone.addActionListener(this);
		buttonc.addActionListener(this);
		buttonsave.addActionListener(this);
		buttonrecall.addActionListener(this);
			
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button1) {
			temp+="1";
			text.setText(text.getText() + "1");
		}
		if(e.getSource()==button2) {
			temp+="2";
			text.setText(text.getText() + "2");
		}
		if(e.getSource()==button3) {
			temp+="3";
			text.setText(text.getText() + "3");
		}
		if(e.getSource()==button4) {
			temp+="4";
			text.setText(text.getText() + "4");
		}
		if(e.getSource()==button5) {
			temp+="5";
			text.setText(text.getText() + "5");
		}
		if(e.getSource()==button6) {
			temp+="6";
			text.setText(text.getText() + "6");
		}
		if(e.getSource()==button7) {
			temp+="7";
			text.setText(text.getText() + "7");
		}
		if(e.getSource()==button8) {
			temp+="8";
			text.setText(text.getText() + "8");
		}
		if(e.getSource()==button9) {
			temp+="9";
			text.setText(text.getText() + "9");
		}
		if(e.getSource()==button0) {
			temp+="0";
			text.setText(text.getText() + "0");
		}
		if(e.getSource()==buttona) {
			num1=Integer.parseInt(temp);
			text.setText("");
			text.setText(num1 + "+");
			op=1;
			temp="";
		}
		
		if(e.getSource()==buttons) {
			num1=Integer.parseInt(temp);
			text.setText("");
			text.setText(num1 + "-");
			op=2;
			temp="";
		}
		if(e.getSource()==buttonm) {
			num1=Integer.parseInt(temp);
			text.setText("");
			text.setText(num1 + "*");
			op=3;
			temp="";
		}
		if(e.getSource()==buttond) {
			num1=Integer.parseInt(temp);
			text.setText("");
			text.setText(num1 + "/");
			op=4;
			temp="";
		}
		if(e.getSource()==buttone) {
			num2=Integer.parseInt(temp);
			switch(op) {
			case 1: total=num1+num2;
					break;
			case 2: total=num1-num2;
					break;
			case 3: total=num1*num2;
					break;
			case 4: total=num1/num2;
					break;
			}
			
			text.setText(text.getText() + "=" + total);
			temp=String.valueOf(total);
		}
		
		if(e.getSource()==buttonc) {
			text.setText("");
			temp="";
		}
		
		if(e.getSource()==buttonsave) {
			try {
				FileWriter FW = new FileWriter(memories);
				BufferedWriter BW = new BufferedWriter(FW);
				//int to String
				BW.write(String.valueOf(total));
				BW.close();
			} catch (IOException ioe) {
				System.out.println("error");
			}
			
		}
		
		if(e.getSource()==buttonrecall) {
			try {
				FileReader FR = new FileReader(memories);
				BufferedReader BR = new BufferedReader(FR);
				num1=Integer.parseInt(BR.readLine());
				temp=String.valueOf(num1);
				text.setText(text.getText() + num1);
				BR.close();
			} catch (IOException ioe) {
				System.out.println("Error");
			}
			
		}
	}
	
	
	public static void main(String[] args) {		
		JFrame Cal = new Cal();
		//Classname objname = new contstructorname(parameter)
		Cal.setTitle("Calculator");
		Cal.setSize(200,260);
		Cal.setLocation(50,200);
		Cal.setVisible(true);
		Cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
