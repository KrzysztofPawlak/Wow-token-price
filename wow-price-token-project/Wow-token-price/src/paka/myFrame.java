package paka;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

	JLabel j1, j2, j3, j4, j5, j6, jBuy, jMin24, jMax24, jDate, jAgo;
	JTextField jtext1;
	JButton jBut1, jBut2;
	JPanel controlPanel, controlPanel2, controlPanel3, controlPanel4, controlPanel5, controlPanel6, controlPanel7;

	myFrame() {
		super("Token price scanner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(500, 400);
		setResizable(false);
		setSize(300, 200);
		setLayout(new GridLayout(7, 1));

		j1 = new JLabel("price you want: ", JLabel.CENTER);
		j2 = new JLabel("buy: ", JLabel.CENTER);
		j3 = new JLabel("min24: ", JLabel.CENTER);
		j4 = new JLabel("max24: ", JLabel.CENTER);
		j5 = new JLabel("time: ", JLabel.CENTER);
		j6 = new JLabel("min ago: ", JLabel.CENTER);

		jtext1 = new JTextField(7);
		jBuy = new JLabel();
		jMin24 = new JLabel();
		jMax24 = new JLabel();
		jDate = new JLabel();
		jAgo = new JLabel();
		jBut1 = new JButton("Start");
		jBut2 = new JButton("Stop");

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
		controlPanel2.add(jBut1);
		controlPanel2.add(jBut2);
		controlPanel3.add(j2);
		controlPanel3.add(jBuy);
		controlPanel4.add(j3);
		controlPanel4.add(jMin24);
		controlPanel5.add(j4);
		controlPanel5.add(jMax24);
		controlPanel6.add(j5);
		controlPanel6.add(jDate);
		controlPanel7.add(j6);
		controlPanel7.add(jAgo);

		add(controlPanel);
		add(controlPanel2);
		add(controlPanel3);
		add(controlPanel4);
		add(controlPanel5);
		add(controlPanel6);
		add(controlPanel7);
		
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
