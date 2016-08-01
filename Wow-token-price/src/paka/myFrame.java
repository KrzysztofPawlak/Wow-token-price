package paka;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class myFrame extends JFrame {

	private boolean working;

	public boolean getWorking() {
		return working;
	}
	
	public void setjBuy(JLabel jBuy) {
		this.jBuy = jBuy;
	}

	public void setjMin24(JLabel jMin24) {
		this.jMin24 = jMin24;
	}

	public void setjMax24(JLabel jMax24) {
		this.jMax24 = jMax24;
	}

	public void setjDate(JLabel jDate) {
		this.jDate = jDate;
	}

	public void setjAgo(JLabel jAgo) {
		this.jAgo = jAgo;
	}

	public int getJtext1() {
		if (jtext1.getText().isEmpty()) {
			return 0;
		}
		return Integer.parseInt(jtext1.getText());
	}
	
	public boolean getVoice() {
		return voice.isSelected();
	}

	public boolean getBeep() {
		return beep.isSelected();
	}

	public boolean getMute() {
		return mute.isSelected();
	}

	JLabel j1, j2, j3, j4, j5, j6, j7, jBuy, jMin24, jMax24, jDate, jAgo;
	JTextField jtext1;
	JButton jBut1, jBut2;
	JPanel controlPanel, controlPanel2, controlPanel3, controlPanel4, controlPanel5, controlPanel6, controlPanel7;
	JRadioButton voice, beep, mute;
	
	myFrame() {
		super("Token price scanner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(500, 400);
		setResizable(false);
		setSize(300, 350);
		setLayout(new GridLayout(7, 1));

		j1 = new JLabel("price you want: ", JLabel.CENTER);
		j2 = new JLabel("buy: ", JLabel.CENTER);
		j2.setFont(new Font("Arial", Font.BOLD, 24));
		j3 = new JLabel("min24: ", JLabel.CENTER);
		j4 = new JLabel("max24: ", JLabel.CENTER);
		j5 = new JLabel("time check: ", JLabel.CENTER);
		j6 = new JLabel("Alarm turn on when price will be lower. ");
		j6.setFont(new Font("Arial", Font.BOLD, 10));
		j6.setForeground(Color.GRAY);
		j7 = new JLabel("After Start next scan will be for 10 min");
		j7.setFont(new Font("Arial", Font.BOLD, 10));
		j7.setForeground(Color.GRAY);
		
		jtext1 = new JTextField(7);
		jBuy = new JLabel();
		jBuy.setFont(new Font("Arial", Font.BOLD, 24));
		jMin24 = new JLabel();
		jMax24 = new JLabel();
		jDate = new JLabel();
		jAgo = new JLabel();
		jBut1 = new JButton("Start");
		jBut2 = new JButton("Stop");
		
		voice = new JRadioButton("voice");
	    beep = new JRadioButton("beep");
	    mute = new JRadioButton("mute");	    
	    ButtonGroup group = new ButtonGroup();
	    group.add(voice);
	    group.add(beep);
	    group.add(mute);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		controlPanel2 = new JPanel();
		controlPanel2.setLayout(new FlowLayout());
		controlPanel3 = new JPanel();
		controlPanel3.setLayout(new FlowLayout());
		controlPanel4 = new JPanel();
		controlPanel4.setLayout(new FlowLayout());
		controlPanel5 = new JPanel();
		controlPanel5.setLayout(new FlowLayout());
		controlPanel6 = new JPanel();
		controlPanel6.setLayout(new FlowLayout());
		controlPanel7 = new JPanel();
		controlPanel7.setLayout(new FlowLayout());

		controlPanel.add(j1);
		controlPanel.add(jtext1);
		controlPanel.add(j6);
		controlPanel2.add(jBut1);
		controlPanel2.add(jBut2);
		controlPanel2.add(j7);	
		controlPanel3.add(j2);
		controlPanel3.add(jBuy);
		controlPanel4.add(j3);
		controlPanel4.add(jMin24);
		controlPanel5.add(j4);
		controlPanel5.add(jMax24);
		controlPanel6.add(j5);
		controlPanel6.add(jDate);
		controlPanel7.add(voice);
		controlPanel7.add(beep);
		controlPanel7.add(mute);
		
		add(controlPanel);
		add(controlPanel7);
		add(controlPanel2);
		add(controlPanel3);
		add(controlPanel4);
		add(controlPanel5);
		add(controlPanel6);
		
		jBut1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				working = true;
			}
		});
		
		jBut2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				working = false;
			}
		});
	}
}
