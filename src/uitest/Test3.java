package uitest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Test3 implements ActionListener{
	Frame frame;
	Panel p1,p2;
	Button b1, b2;
	TextField tf1;
	Label label;
	List alist;
	ArrayList<UserVO> list ;
	
	public Test3() {
		frame = new Frame();
		p1 = new Panel();
		p2 = new Panel();
		b1 = new Button("Button1");
		b2 = new Button("delete");
		tf1 = new TextField(10);
		label = new Label("Result : ");
		alist = new List();
		list = new ArrayList<>();
	}
	public void makeUi() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose(); //Frame ´Ý±â ÀÌº¥Æ®
			}
		});
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		alist.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int position = (int) e.getItem();
				UserVO user = list.get(position);
				String result = user.getId()+" "+user.getPwd()+" "+user.getName();
				label.setText(result);
			}
		});
		
		frame.setSize(600, 400);
		frame.setBackground(Color.PINK);
		frame.setTitle("New Window");
				
		p1.setBackground(Color.CYAN);
		p1.add(tf1);
		p1.add(b1); 
		p1.add(b2);
		//p1.setLayout(new BorderLayout());
		
		p2.setBackground(Color.gray);
		p2.add(label);
		//---------------------------
		
		getdata();
		
		//---------------------------
		frame.add(p1,"North");
		frame.add(p2, "South");
		frame.add(alist, "Center");
		frame.setLocation(500, 400);
		frame.setVisible(true);
		
	}
	private void getdata() {
		list.clear();
		alist.removeAll();
		list.add(new UserVO("id01", "pwd01", "ÀÌ¸»¼÷"));
		list.add(new UserVO("id02", "pwd02", "±è¸»¼÷"));
		list.add(new UserVO("id03", "pwd03", "Á¤¸»¼÷"));
		list.add(new UserVO("id04", "pwd04", "Àå¸»¼÷"));
		list.add(new UserVO("id05", "pwd05", "È«¸»¼÷"));
		list.add(new UserVO("id06", "pwd06", "°ø¸»¼÷"));
		for(UserVO u:list) {
			//alist.add(u.getId()+" "+u.getPwd()+" "+u.getName());
			alist.add(u.getId()+" "+u.getName());
		}
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
		}else if(e.getSource() == b2) {
			int index = alist.getSelectedIndex();
			list.remove(index);
			// µ¥ÀÌÅÍ¸¦ ´Ù½Ã Ãâ·ÂÇÑ´Ù. 
			getdata();
		}
		
	}
}
