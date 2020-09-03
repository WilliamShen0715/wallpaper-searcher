package hella;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class UI  {
	static TextField searchText, depth,dierectory;
	static TextArea dialog;
	static JFrame frame = new JFrame("WallPaper Searcher!!");
	static JButton[] pf = new JButton[31];
	static ImageIcon photo[] =new ImageIcon[31];  
//	static JCheckBox[] cb = new JCheckBox[31];
	static JButton lstbtn = new JButton();
	static JButton nstbtn = new JButton();
	static JButton delete = new JButton();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyButtonListener mblistener = new MyButtonListener();
		frame.setIconImage(frame.getToolkit().getImage("add.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//全螢幕
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle bounds = ge.getMaximumWindowBounds();
		frame.setBounds(bounds);//刪除被下方軟體列擋住的部分，並且讓frame有width和height
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//滿版

		//背景圖片
	    ImageIcon background = null;
        background = new ImageIcon(frame.getToolkit().getImage("back_image.jpg"));       // 背景圖片
        JLabel bgLabel = new JLabel();      // 把背景圖顯示在Label中
        background.setImage(background.getImage().getScaledInstance(frame.getWidth(),frame.getHeight(),Image.SCALE_DEFAULT ));//縮放背景圖片
        bgLabel.setIcon(background);
        bgLabel.setSize(bgLabel.getIcon().getIconWidth(),bgLabel.getIcon().getIconHeight());
        bgLabel.setLocation(0,0);	
        bgLabel.setHorizontalAlignment(0);
        bgLabel.setVerticalAlignment(0);
        //bgLabel.setOpaque(false);
		
        
        //預覽照片
        JButton look = new JButton("預覽");
		look.addActionListener(mblistener);
        look.setSize(100, 30);
        look.setLocation(300, 220);
        frame.add(look);
        
        //搜尋結果	
    	for(int i=1 ;i<7;i++) {
    		pf[i] = new JButton(""+i);
    		pf[i].addActionListener(mblistener);
    		photo[i] = new ImageIcon();  
    		pf[i].setSize(225,150);
    		if(20+200*(i-1)<500) {
    			pf[i].setLocation(700,20+200*(i-1));
    		}
    		else {
    			pf[i].setLocation(1000, 20+200*(i-4));
    		}
    		pf[i].setVisible(false);
//    		photo[i] = new ImageIcon(frame.getToolkit().getImage(Util.picDir+i+".jpg"));
//	    	photo[i].setImage(photo[i].getImage().getScaledInstance(pf[i].getWidth(),pf[i].getHeight(),Image.SCALE_DEFAULT ));//縮放背景圖片
	    	pf[i].setIcon(photo[i]);
	    	frame.add(pf[i]);
    	}
	    
        //搜尋
        JLabel searchlabel = new JLabel("主題:");
		searchlabel.setLocation(85,105);
		searchlabel.setSize(200, 50);
		
		searchText = new TextField("");
		searchText.setLocation(120,120);
		searchText.setSize(300, 20);
		
		JLabel depthlabel = new JLabel("搜尋深度:");
		depthlabel.setLocation(60, 135);
		depthlabel.setSize(200, 50);
		
		depth = new TextField("30");
		depth.setLocation(120, 150);
		depth.setSize(300, 20);
		
		JLabel dir = new JLabel("下載路徑:");
		dir.setLocation(60, 165);
		dir.setSize(200, 50);
		
		JButton search = new JButton("Search!");
		search.addActionListener(mblistener);
		search.setLocation(80,220);
		search.setSize(100, 30);
		
		dierectory =new TextField(Util.picDir);
		dierectory.setLocation(120, 180);
		dierectory.setSize(300, 20);
		
		dialog = new TextArea("");
		dialog.setLocation(40,300);
		dialog.setSize(500,450);
		dialog.setEditable(false);
		
		lstbtn = new JButton("上一頁");
		lstbtn.addActionListener(mblistener);
		lstbtn.setSize(100, 30);
		lstbtn.setLocation(800,620);
		lstbtn.setVisible(false);
		frame.add(lstbtn);

		nstbtn = new JButton("下一頁");
		nstbtn.addActionListener(mblistener);
		nstbtn.setSize(100, 30);
		nstbtn.setLocation(1030, 620);
		nstbtn.setVisible(false);
		frame.add(nstbtn);
        
		delete = new JButton("刪除");
		delete.addActionListener(mblistener);
		delete.setLocation(915,700);
		delete.setSize(100, 30);
		delete.setVisible(false);
		frame.add(delete);
		
		//標題
		Font font = new Font("華康鋼筆體W2",1,50);
		JLabel title = new JLabel("桌布下載器");
		title.setLocation(100, 0);
		title.setSize(1000, 100);
		title.setFont(font);
		
		
		//輸出畫面
		frame.setLayout(null);
		frame.add(search);
		frame.add(searchText);
		frame.add(title);
		frame.add(depth);
		frame.add(dierectory);
		frame.add(searchlabel);
		frame.add(dir);
		frame.add(depthlabel);
		frame.add(dialog);
		frame.add(bgLabel);
		
		frame.setVisible(true);
	}
	public static void photo(int page) {
    	for(int i=1 ;i<7;i++) {
    		photo[i] = new ImageIcon();  
    		photo[i] = new ImageIcon(frame.getToolkit().getImage(Util.picDir+(i+page*6-6)+".jpg"));
    		photo[i].setImage(photo[i].getImage().getScaledInstance(pf[i].getWidth(),pf[i].getHeight(),Image.SCALE_DEFAULT ));//縮放背景圖片
	    	pf[i].setIcon(photo[i]);
	}
}
}
