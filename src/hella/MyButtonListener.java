package hella;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;


public class MyButtonListener implements ActionListener{
	boolean press = false;
	public void actionPerformed(ActionEvent e){
		String action = e.getActionCommand();
		if(action.equals("Search!")) {

			hello.search = UI.searchText.getText();
			if (!hello.search.equals(UI.searchText.getText())) {
				hello.set=0;
				hello.page=0;
				hello.lastpage=0;
			}
			hello.depth = Integer.parseInt(UI.depth.getText());
			Util.picDir = UI.dierectory.getText();
			UI.dialog.setText("");
			if (hello.search.equals("")||hello.depth<=0||Util.picDir.equals("")) {
				return;
			}
			for (int i = 1; i < 7; i++) {
				UI.pf[i].setVisible(true);
				UI.photo[i] = new ImageIcon(UI.frame.getToolkit().getImage("loading.gif"));
				UI.pf[i].setIcon(UI.photo[i]);
			}
			UI.nstbtn.setVisible(true);
			UI.lstbtn.setVisible(true);

			try {
				hello.searchStart(hello.set);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    	hello.lastpage++;
			UI.nstbtn.setEnabled(false);
			UI.lstbtn.setEnabled(false);
			UI.delete.setEnabled(true);
			UI.delete.setVisible(true);
	    	if(hello.page!=hello.lastpage) {
				UI.nstbtn.setEnabled(true);
			}
			if(hello.page!=1) {
				UI.lstbtn.setEnabled(true);
			}
		}
		if(action.equals("預覽")) {
			UI.photo(hello.page); 
			UI.nstbtn.setEnabled(false);
			UI.lstbtn.setEnabled(false);
	    	if(hello.page!=hello.lastpage) {
				UI.nstbtn.setEnabled(true);
			}
			if(hello.page!=1) {
				UI.lstbtn.setEnabled(true);
			}
		}
		if(action.equals("上一頁")) {
			hello.page--;
			UI.nstbtn.setEnabled(true);
			UI.lstbtn.setEnabled(false);
			if(hello.page!=1) {
				UI.lstbtn.setEnabled(true);
			}
			UI.photo(hello.page);
		}
		if(action.equals("下一頁")) {
			hello.page++;
			UI.lstbtn.setEnabled(true);
			UI.nstbtn.setEnabled(false);
	    	if(hello.page!=hello.lastpage) {
				UI.nstbtn.setEnabled(true);
			}
			UI.photo(hello.page);
		}
		//按鈕地獄
		if(action.equals("1")) {
			if(press==false) {
				UI.pf[1].setLocation(460, 20);
				UI.pf[1].setSize(972, 648);
				UI.pf[2].setVisible(false);
				UI.pf[3].setVisible(false);
				UI.pf[4].setVisible(false);
				UI.pf[5].setVisible(false);
				UI.pf[6].setVisible(false);
	    		UI.photo[1] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(1+hello.set-6)+".jpg"));
		    	UI.pf[1].setIcon(UI.photo[1]);
	    		UI.photo[1].setImage(UI.photo[1].getImage().getScaledInstance(UI.pf[1].getWidth(),
	    				UI.pf[1].getHeight(),Image.SCALE_DEFAULT ));
	    		press=true;
			}
			else {
				UI.pf[1].setLocation(700, 20);
				UI.pf[1].setSize(225, 150);
				UI.pf[2].setVisible(true);
				UI.pf[3].setVisible(true);
				UI.pf[4].setVisible(true);
				UI.pf[5].setVisible(true);
				UI.pf[6].setVisible(true);
	    		UI.photo[1] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(1+hello.set-6)+".jpg"));
		    	UI.pf[1].setIcon(UI.photo[1]);
				UI.photo[1].setImage(UI.photo[1].getImage().getScaledInstance(UI.pf[1].getWidth(),
						UI.pf[1].getHeight(),Image.SCALE_DEFAULT ));
				press=false;
			}
		}
		if(action.equals("2")) {
			if(press==false) {
				UI.pf[2].setLocation(460, 20);
				UI.pf[2].setSize(972, 648);
				UI.pf[1].setVisible(false);
				UI.pf[3].setVisible(false);
				UI.pf[4].setVisible(false);
				UI.pf[5].setVisible(false);
				UI.pf[6].setVisible(false);
	    		UI.photo[2] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(2+hello.set-6)+".jpg"));
		    	UI.pf[2].setIcon(UI.photo[2]);
	    		UI.photo[2].setImage(UI.photo[2].getImage().getScaledInstance(UI.pf[2].getWidth(),
	    				UI.pf[2].getHeight(),Image.SCALE_DEFAULT ));
	    		press=true;
			}
			else {
				UI.pf[2].setLocation(700, 220);
				UI.pf[2].setSize(225, 150);
				UI.pf[1].setVisible(true);
				UI.pf[3].setVisible(true);
				UI.pf[4].setVisible(true);
				UI.pf[5].setVisible(true);
				UI.pf[6].setVisible(true);
	    		UI.photo[2] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(2+hello.set-6)+".jpg"));
		    	UI.pf[2].setIcon(UI.photo[2]);
				UI.photo[2].setImage(UI.photo[2].getImage().getScaledInstance(UI.pf[2].getWidth(),
						UI.pf[2].getHeight(),Image.SCALE_DEFAULT ));
				press=false;
			}
		}
		if(action.equals("3")) {
			if(press==false) {
				UI.pf[3].setLocation(460, 20);
				UI.pf[3].setSize(972, 648);
				UI.pf[1].setVisible(false);
				UI.pf[2].setVisible(false);
				UI.pf[4].setVisible(false);
				UI.pf[5].setVisible(false);
				UI.pf[6].setVisible(false);
	    		UI.photo[3] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(3+hello.set-6)+".jpg"));
		    	UI.pf[3].setIcon(UI.photo[3]);
	    		UI.photo[3].setImage(UI.photo[3].getImage().getScaledInstance(UI.pf[3].getWidth(),
	    				UI.pf[3].getHeight(),Image.SCALE_DEFAULT ));
	    		press=true;
			}
			else {
				UI.pf[3].setLocation(700, 420);
				UI.pf[3].setSize(225, 150);
				UI.pf[2].setVisible(true);
				UI.pf[1].setVisible(true);
				UI.pf[4].setVisible(true);
				UI.pf[5].setVisible(true);
				UI.pf[6].setVisible(true);
	    		UI.photo[3] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(3+hello.set-6)+".jpg"));
		    	UI.pf[3].setIcon(UI.photo[3]);
				UI.photo[3].setImage(UI.photo[3].getImage().getScaledInstance(UI.pf[3].getWidth(),
						UI.pf[3].getHeight(),Image.SCALE_DEFAULT ));
				press=false;
			}
		}
		if(action.equals("4")) {
			if(press==false) {
				UI.pf[4].setLocation(460, 20);
				UI.pf[4].setSize(972, 648);
				UI.pf[2].setVisible(false);
				UI.pf[3].setVisible(false);
				UI.pf[1].setVisible(false);
				UI.pf[5].setVisible(false);
				UI.pf[6].setVisible(false);
	    		UI.photo[4] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(4+hello.set-6)+".jpg"));
		    	UI.pf[4].setIcon(UI.photo[4]);
	    		UI.photo[4].setImage(UI.photo[4].getImage().getScaledInstance(UI.pf[4].getWidth(),
	    				UI.pf[4].getHeight(),Image.SCALE_DEFAULT ));
	    		press=true;
			}
			else {
				UI.pf[4].setLocation(1000, 20);
				UI.pf[4].setSize(225, 150);
				UI.pf[2].setVisible(true);
				UI.pf[3].setVisible(true);
				UI.pf[1].setVisible(true);
				UI.pf[5].setVisible(true);
				UI.pf[6].setVisible(true);
	    		UI.photo[4] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(4+hello.set-6)+".jpg"));
		    	UI.pf[4].setIcon(UI.photo[4]);
				UI.photo[4].setImage(UI.photo[4].getImage().getScaledInstance(UI.pf[4].getWidth(),
						UI.pf[4].getHeight(),Image.SCALE_DEFAULT ));
				press=false;
			}
		}
		if(action.equals("5")) {
			if(press==false) {
				UI.pf[5].setLocation(460, 20);
				UI.pf[5].setSize(972, 648);
				UI.pf[2].setVisible(false);
				UI.pf[3].setVisible(false);
				UI.pf[4].setVisible(false);
				UI.pf[1].setVisible(false);
				UI.pf[6].setVisible(false);
	    		UI.photo[5] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(5+hello.set-6)+".jpg"));
		    	UI.pf[5].setIcon(UI.photo[5]);
	    		UI.photo[5].setImage(UI.photo[5].getImage().getScaledInstance(UI.pf[5].getWidth(),
	    				UI.pf[5].getHeight(),Image.SCALE_DEFAULT ));
	    		press=true;
			}
			else {
				UI.pf[5].setLocation(1000, 220);
				UI.pf[5].setSize(225, 150);
				UI.pf[2].setVisible(true);
				UI.pf[3].setVisible(true);
				UI.pf[4].setVisible(true);
				UI.pf[1].setVisible(true);
				UI.pf[6].setVisible(true);
	    		UI.photo[5] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(5+hello.set-6)+".jpg"));
		    	UI.pf[5].setIcon(UI.photo[5]);
				UI.photo[5].setImage(UI.photo[5].getImage().getScaledInstance(UI.pf[5].getWidth(),
						UI.pf[5].getHeight(),Image.SCALE_DEFAULT ));
				press=false;
			}
		}
		if(action.equals("6")) {
			if(press==false) {
				UI.pf[6].setLocation(460, 20);
				UI.pf[6].setSize(972, 648);
				UI.pf[2].setVisible(false);
				UI.pf[3].setVisible(false);
				UI.pf[4].setVisible(false);
				UI.pf[5].setVisible(false);
				UI.pf[1].setVisible(false);
	    		UI.photo[6] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(6+hello.set-6)+".jpg"));
		    	UI.pf[6].setIcon(UI.photo[6]);
	    		UI.photo[6].setImage(UI.photo[6].getImage().getScaledInstance(UI.pf[6].getWidth(),
	    				UI.pf[6].getHeight(),Image.SCALE_DEFAULT ));
	    		press=true;
			}
			else {
				UI.pf[6].setLocation(1000, 420);
				UI.pf[6].setSize(225, 150);
				UI.pf[2].setVisible(true);
				UI.pf[3].setVisible(true);
				UI.pf[4].setVisible(true);
				UI.pf[5].setVisible(true);
				UI.pf[1].setVisible(true);
	    		UI.photo[6] = new ImageIcon(UI.frame.getToolkit().getImage(Util.picDir+(6+hello.set-6)+".jpg"));
		    	UI.pf[6].setIcon(UI.photo[6]);
				UI.photo[6].setImage(UI.photo[6].getImage().getScaledInstance(UI.pf[6].getWidth(),
						UI.pf[6].getHeight(),Image.SCALE_DEFAULT ));
				press=false;
			}
		}
		if(action.equals("刪除")) {
			File[] f = new File[7];
			for(int i =1;i<7;++i) {
				f[i] = new File(Util.picDir+(i+hello.page*6-6)+".jpg");
				f[i].delete();
			}
			UI.photo(hello.set);
		}
//			System.out.println(e.getSource());
	}
}