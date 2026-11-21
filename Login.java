package newdb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {
	
	JFrame f;
	JButton b,b1;
	JPasswordField t1;
	JTextField t;
	
	void demo() {
		f=new JFrame("Welcome to my Web page");
		f.setSize(1500,800);
		f.setLayout(null);
//		f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ASUS\\Downloads\\01 (2).jpg")));
		f.getContentPane().setBackground(Color.green);
		f.setVisible(true);
		
//		Login label
		JLabel l=new JLabel("Login Page");
		l.setBounds(500,20,300,50);
		l.setBackground(Color.white);
		l.setForeground(Color.blue);
		l.setFont(new Font("Arial",Font.BOLD,25));
		
		f.add(l);
		
//		Username label
		JLabel l1=new JLabel("Username");
		l1.setBounds(400,120,300,50);
		l1.setBackground(Color.pink);
		l1.setForeground(Color.red);
		l1.setFont(new Font("Arial",Font.BOLD,35));
		
		f.add(l1);
		
//		Textfield
		t=new JTextField();
		t.setBounds(600,120,300,50);
		t.setBackground(Color.blue);
		t.setForeground(Color.orange);
		t.setFont(new Font("Arial",Font.BOLD,35));
		
		f.add(t);
		
//		Password label
		JLabel l2=new JLabel("Password:");
		l2.setBounds(400,220,300,50);
		l2.setBackground(Color.pink);
		l2.setForeground(Color.red);
		l2.setFont(new Font("Arial",Font.BOLD,35));
		
		f.add(l2);
		
//		Password field
		t1=new JPasswordField();
		t1.setBounds(600,220,300,50);
		t1.setBackground(Color.cyan);
		t1.setForeground(Color.orange);
		
		f.add(t1);
		
//		login button
		b=new JButton("Login");
		b.setBounds(500,320,300,50);
		b.setBackground(Color.yellow);
		b.setForeground(Color.gray);
		b.setFont(new Font("Arial",Font.BOLD,35));
		
		f.add(b);
		b.addActionListener(this);
		
//		Register button
		b1=new JButton("Register");
		b1.setBounds(600,120,300,50);
		b1.setBackground(Color.cyan);
		b1.setForeground(Color.red);
		b1.setFont(new Font("Arial",Font.BOLD,35));
		
		f.add(b1);
		b1.addActionListener(this);
	}
	
	public static void main(String[]args) {
		Login log=new Login();
		log.demo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s1=t.getText();
		String s2=new String(t1.getPassword());
		if(e.getSource()==b) {
			if(s1.isEmpty()||s2.isEmpty()) {
				JOptionPane.showMessageDialog(b,"Kindly fill all fields");
			}
			else {
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db","root","4004");
					String sql="Select * from register where username=? and password=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, s1);
					ps.setString(2, s2);
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(b,"Login Successful");
						f.setVisible(false);
						new next();
					}
					else {
						JOptionPane.showMessageDialog(b,"Login Failed");
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
			else if(e.getSource()==b1) {
				f.setVisible(false);
			}
		}	
	}


	