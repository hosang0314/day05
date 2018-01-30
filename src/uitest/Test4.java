package uitest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test4 implements ActionListener{
	Frame frame;
	Panel p1,p2,p3,p4;
	Button b1, b2;
	TextField tf1, tf2;
	Label label, label2;
	
	public Test4() {
		frame = new Frame();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		b1 = new Button("Button1");
		b2 = new Button("Button2");
		tf1 = new TextField(10);
		label = new Label("Result : ");

		tf2 = new TextField(10);
		label2 = new Label("Result : ");
	}
	public void makeUi() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose(); //Frame ¥›±‚ ¿Ã∫•∆Æ
			}
		});
		
		b1.addActionListener(this);
		
		frame.setSize(600, 400);
		frame.setBackground(Color.PINK);
		frame.setTitle("New Window");
		
		p1.setBackground(Color.red);
		p1.setLayout(new GridLayout(2,1));
		p1.add(p3);
		p1.add(p4);
		p3.setBackground(Color.lightGray);
		p3.add(tf1);
		p3.add(b1);
		p4.setBackground(Color.orange);
		p4.add(tf2);
		p4.add(b2);
		
//		p1.setBackground(Color.CYAN);
//		p1.add(tf1);
//		p1.add(b1);
		
		//p1.setLayout(new BorderLayout());
		
		p2.setBackground(Color.gray);
		p2.add(label);
		
		frame.setLayout(new GridLayout(2, 1));
		
		frame.add(p1,"North");
		frame.add(p2, "South");
		frame.setLocation(500, 400);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			String s = tf1.getText();
			tf1.setText("");
			label.setText("Result : "+s);
			//label.setText(label.getText());
			//p2.add(label);
			//frame.add(p2,"South");
			//frame.setVisible(true);
		}
		
	}
}
