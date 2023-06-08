package ru.shishkin.snake;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.event.*;
import java.io.*;

public class snake {
	public static void main(String[] args) {
			new myFrame();
	}
}

class myFrame extends JFrame
{
	public myFrame()
	{
		myPanel p = new myPanel();
		Container cont = getContentPane();
		cont.add(p);
		setTitle("Snake");
		setBounds(0,0,800,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class myPanel extends JPanel
{
	game myGame;
	Timer tmDrow, tmUpdate;
	Image fon, telo, golova,ob,endg;
	JLabel lb;
	JButton btn1, btn2;
	myPanel pan;
	
	private class myKey implements KeyListener  
	{
		    // �����, ������� ����������� ��� �������
	   	    public void keyPressed(KeyEvent e)
	   	    {
	   	    	// ��������� ���� ������� �������
	   	    	int key_ = e.getKeyCode();
	   	    	if (key_==KeyEvent.VK_KP_LEFT) myGame.new_napr = 0;
	   	    	if (key_==KeyEvent.VK_KP_RIGHT) myGame.new_napr = 2;
	   	    	if (key_==KeyEvent.VK_KP_UP) myGame.new_napr = 1;
	   	    	if (key_==KeyEvent.VK_KP_DOWN) myGame.new_napr = 3;
	   	    	
	   	    }
	   	    public void keyReleased(KeyEvent e) {}
	   	    public void keyTyped(KeyEvent e) {}
	   }
	
	public myPanel()
	{
		pan = this;
		addKeyListener(new myKey());
		setFocusable(true);
		
		myGame = new game();
		try 
		{
			fon=ImageIO.read(new File("./fon.png"));
			telo=ImageIO.read(new File("./telo.png"));
			golova=ImageIO.read(new File("./golova.png"));
			ob=ImageIO.read(new File("./ob.png"));
			endg=ImageIO.read(new File("./endg.png"));
		} 
		catch (Exception e) {}
		
		tmDrow = new Timer(20,new ActionListener() {				
			public void actionPerformed(ActionEvent e) 
			{
	           repaint();
			}
		});
		tmDrow.start();
	   
	   tmUpdate = new Timer(20,new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				if (myGame.endg==false)
				{
					myGame.perem();
				}
				lb.setText("Score: "+myGame.kol);
	        }
		});
		tmUpdate.start();

		setLayout(null);
		
		lb = new JLabel("Score: 0");
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("arial", 0, 20));
		lb.setBounds(630, 200, 150, 50);
		add(lb);
		
		btn1 = new JButton();
		btn1.setText("NEW GAME");
		btn1.setForeground(Color.BLUE);
		btn1.setBounds(630,30,150,50);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myGame.start();
				btn1.setFocusable(false);
				btn2.setFocusable(false);
				pan.setFocusable(true);
			}
		});
		add(btn1);
		
		btn2 = new JButton();
		btn2.setText("EXIT");
		btn2.setForeground(Color.RED);
		btn2.setBounds(630,100,150,50);
		btn2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(btn2);
		
	}
	
	public void paintComponent(Graphics gr)
	{
		super.paintComponent(gr);
		gr.drawImage(fon, 0, 0, null);
		
		for (int i=0; i<30; i++)
		{
			for (int j = 0; j<30; j++) 
			{
				if (myGame.mas[i][j]==1)
					gr.drawImage(golova, 10+j*20, 10+i*20, null);
				if (myGame.mas[i][j]==-1)
					gr.drawImage(ob, 10+j*20, 10+i*20, null);
				if (myGame.mas[i][j]>=2)
					gr.drawImage(telo, 10+j*20, 10+i*20, null);
				gr.setColor(Color.ORANGE);
				gr.setFont(new Font("arial",0,22));
				gr.drawString(""+myGame.mas[i][j], 12+j*20, 30+i*20);
			}
		}
		
		gr.setColor(Color.BLUE);
		for (int i=0; i<30; i++)
		{
			gr.drawLine(10+i*20, 10, 10+i*20, 610);
			gr.drawLine(10, 10+i*20, 610, 10+i*20);
		}
		
		if (myGame.endg == true)
			gr.drawImage(endg, 250, 200, 200, 100, null);
	}
	
}