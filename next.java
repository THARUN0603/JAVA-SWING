package newdb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.*;

public class next implements ActionListener {
	
	JButton b;
	JFrame f;
	public next()
	{
		f=new JFrame("My project");
		f.setSize(1500,800);
		f.setLayout(null);
		f.getContentPane().setBackground(Color.decode("#008080"));
		f.setVisible(true);
		
		JLabel l=new JLabel("Wlcome to my page");
		l.setBounds(500,20,500,50);
		l.setForeground(Color.white);
		l.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(l);
		
		JRadioButton rb=new JRadioButton("Male");
		rb.setBounds(50,120,200,50);
		rb.setForeground(Color.white);
		rb.setBackground(Color.decode("#008080"));
		rb.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(rb);
		
		JRadioButton rb1=new JRadioButton("Female");
		rb1.setBounds(250,120,200,50);
		rb1.setForeground(Color.white);
		rb1.setBackground(Color.decode("#008080"));
		rb1.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(rb1);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb);
		
		String a[]= {"Select","C++","JAVA","WEB DESIGN","PYTHON","OS"};
		JComboBox cb=new JComboBox(a);
		cb.setBounds(50,220,250,50);
		cb.setForeground(Color.white);
		cb.setBackground(Color.decode("#008080"));
		cb.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(cb);
		
		JList jl=new JList(a);
		jl.setBounds(50,320,250,350);
		jl.setForeground(Color.white);
		jl.setBackground(Color.decode("#008080"));
		jl.setFont(new Font("Arial",Font.ITALIC,30));
		jl.setSelectedIndex(2);
		f.add(jl);
		
		JSpinner js=new JSpinner();
		js.setBounds(450,120,100,50);
		js.setForeground(Color.white);
		js.setBackground(Color.decode("#008080"));
		js.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(js);
		
		JCheckBox ck=new JCheckBox("I am not Robot");
		ck.setBounds(450,220,300,50);
		ck.setForeground(Color.white);
		ck.setBackground(Color.decode("#008080"));
		ck.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(ck);
		
		JTextArea ta=new JTextArea();
		ta.setBounds(450,320,300,50);
		ta.setSize(500,300);
		ta.setLineWrap(true);
		ta.setForeground(Color.white);
		ta.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(ta);
		
		b=new JButton("Logout");
		b.setBounds(700,100,300,50);
		b.setForeground(Color.blue);
		b.setBackground(Color.decode("#FFDAB9"));
		b.setFont(new Font("Arial",Font.ITALIC,30));
		f.add(b);
		b.addActionListener(this);
		
	}
	
	public static void main(String[]args) {
		new next();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b) {
			JOptionPane.showMessageDialog(b, "Looged Out");
			f.setVisible(false);
			Register r=new Register();
			r.fun();
		}
		
	}
}
