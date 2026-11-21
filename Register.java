package newdb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;

public class Register implements ActionListener {
	JFrame f;
	JButton b1;
	JTextField t1,t2,t3;
	JPasswordField t;
	
	void fun() {
		f=new JFrame("My Register Page");
		f.setSize(1500,1000);
		f.setLayout(null);
//		ImageIcon icon=new ImageIcon()
		
//		f.setContentPane(new JLabel(icon));
//		f.getContentPane().setBackgroud(Color.black);
//		f.setBackground(null);
//		f.setForeground(null);
		f.setVisible(true);
		
		
		JLabel l=new JLabel("My Rgister Page");
		l.setBounds(600,20,300,50);
		l.setForeground(Color.decode("#87898"));
		l.setBackground(Color.white);
		l.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(l);
		
//		Username Label
		JLabel l1=new JLabel("Username");
		l1.setBounds(400,120,300,50);
		l1.setForeground(Color.green);
		l1.setBackground(Color.decode("#45687"));
		l1.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(l1);
		
//		User textfield
		t1=new JTextField();
		t1.setBounds(600,120,300,50);
		t1.setForeground(Color.decode("#87898"));
		t1.setBackground(Color.red);
		t1.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(t1);
		
//		Password label
		JLabel l2=new JLabel("Password");
		l2.setBounds(400,180,300,50);
		l2.setForeground(Color.green);
		l2.setBackground(Color.decode("#45687"));
		l2.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(l2);
		
//		Password field
		t=new JPasswordField();
		t.setBounds(600,180,300,50);
		t.setForeground(Color.pink);
		t.setBackground(Color.decode("#87898"));
		t.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(t);
		
//		Email label
		JLabel l3=new JLabel("Email");
		l3.setBounds(400,240,300,60);
		l3.setForeground(Color.green);
		l3.setBackground(Color.decode("#45687"));
		l3.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(l3);
		
//		Email field
		t2=new JTextField();
		t2.setBounds(600,240,300,50);
		t2.setForeground(Color.decode("#87898"));
		t2.setBackground(Color.red);
		t2.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(t2);
		
//		Phone label
		JLabel l4=new JLabel("Phone");
		l4.setBounds(400,300,300,50);
		l4.setForeground(Color.green);
		l4.setBackground(Color.decode("#45687"));
		l4.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(l4);
		
//		Phone field
		t3=new JTextField();
		t3.setBounds(600,300,300,50);
		t3.setForeground(Color.decode("#87898"));
		t3.setBackground(Color.red);
		t3.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(t3);
		
		b1=new JButton("Register Now");
		b1.setBounds(450,400,300,50);
		b1.setForeground(Color.red);
		b1.setBackground(Color.yellow);
		b1.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(b1);
		b1.addActionListener(this);
	
	}
	public static void main(String[]args) {
		Register r=new Register();
		r.fun();
	}

	public void actionPerformed(ActionEvent e) {
		String s1=new String(t.getPassword());
		String s2=t1.getText();
		String s3=t2.getText();
		String s4=t3.getText();
		
		if(e.getSource()==b1) {
			if(s1.trim().isEmpty()||s2.trim().isEmpty()||s3.trim().isEmpty()||s4.trim().isEmpty()) {
				JOptionPane.showMessageDialog(b1,"Please fill all the fields");
			}
			else {
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db","root","4004");
					PreparedStatement ps=con.prepareStatement("Insert into register values(?,?,?,?)");
					ps.setString(2, s1);
					ps.setString(1, s2);
					ps.setString(3, s3);
					ps.setString(4, s4);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(b1,"Registered Successfully");
					f.setVisible(false);
					Login l=new Login();
					l.demo();			
				   }
			
			catch (Exception e1){
				e1.printStackTrace();
			}
			}
		}
	}
}
