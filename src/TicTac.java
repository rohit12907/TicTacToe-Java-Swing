import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class TicTac implements ActionListener{
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;
	JFrame jf;
	
	Color clr ;
	String str = "";
	int count = 0 ;
	String lastMove;   // "X" or "O"

	boolean wins =  false ;
	String player1;
	String player2;
	
JLabel	turn;
	public TicTac(String player1,String player2) {
		this.player1 = player1;
		this.player2 = player2;
		
}
//	public static void main(String[] args) {
//		new TicTac();
//	}
//	@Override
	
	void open() {
  
		
//		System.out.println(player1);

		 jf = new JFrame();
		jf.setSize(500,500);
       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       GridLayout gd = new GridLayout(3,3);
        jf.setLayout(gd);            
       
       
       
       
       jb1 = new JButton();
       jb1.addActionListener(this);
       jf.add(jb1);
       
       jb2 = new JButton();
       jb2.addActionListener(this);
       jf.add(jb2);
       
       jb3 = new JButton();
       jb3.addActionListener(this);
       jf.add(jb3); 
       
       jb4 = new JButton();
       jb4.addActionListener(this);
       jf.add(jb4);
       
       jb5 = new JButton();
       jb5.addActionListener(this);
       jf.add(jb5);
       
       jb6 = new JButton();
       jb6.addActionListener(this);
       jf.add(jb6);
       
       jb7 = new JButton();
       jb7.addActionListener(this);
       jf.add(jb7);
       
       
       jb8 = new JButton();
       jb8.addActionListener(this);
       jf.add(jb8);
       
       
       jb9 = new JButton();
       jb9.addActionListener(this);
       jf.add(jb9);
       
       
       
       jf.setVisible(true);
       
       
       

	}
	public void actionPerformed(ActionEvent e) {
		
		
		Font f = new Font("Arial", 1, 60);
		
		// logoic for print x and 0 on the button
		count++;

		if (count % 2 != 0) {
		    str = "X";
		    lastMove = "X";
		    clr = Color.yellow;
		    jf.setTitle("Turn: " + player2 + " (O)");
		} else {
		    str = "O";
		    lastMove = "O";
		    clr = Color.red;
		    jf.setTitle("Turn: " + player1 + " (X)");
		}

		
		
		
		if(e.getSource()==jb1 ) {
			jb1.setText(str);
		    jb1.setFont(f);
		    jb1.setEnabled(false);
		    jb1.setBackground(clr);
		}
		
		
		if(e.getSource()==jb2) {
			jb2.setText(str);
			jb2.setFont(f);
			jb2.setEnabled(false);
			 jb2.setBackground(clr);
		}
		
		if(e.getSource()==jb3) {
			jb3.setText(str);
			jb3.setFont(f);
			jb3.setEnabled(false);
			 jb3.setBackground(clr);
		}
		
		if(e.getSource()==jb4) {
			jb4.setText(str);
			jb4.setFont(f);
			jb4.setEnabled(false);
			 jb4.setBackground(clr);
		}
		
		if(e.getSource()==jb5) {
			jb5.setText(str);
			jb5.setFont(f);
			jb5.setEnabled(false);
			 jb5.setBackground(clr);
		}
		
		
		if(e.getSource()==jb6) {
			jb6.setText(str);
			jb6.setFont(f);
			jb6.setEnabled(false);
			 jb6.setBackground(clr);
		}
		
		if(e.getSource()==jb7) {
			jb7.setText(str);
			jb7.setFont(f);
			jb7.setEnabled(false);
			 jb7.setBackground(clr);
		}
		
		if(e.getSource()==jb8) {
			jb8.setText(str);
			jb8.setFont(f);
			jb8.setEnabled(false);
			 jb8.setBackground(clr);
		}
		
		if(e.getSource()==jb9) {
			jb9.setText(str);
			jb9.setFont(f);
			jb9.setEnabled(false);
			 jb9.setBackground(clr);
		}
		//Method called 
		WinningPossibility();
		Winner();
		
	}
	
	
	void WinningPossibility() {
		
//Horizontaly winning possibility
		
if(jb1.getText()==jb2.getText()&&jb2.getText()==jb3.getText()&& jb1.getText()!="") {
		wins = true ;
}
	
else if(jb4.getText()==jb5.getText()&&jb5.getText()==jb6.getText()&& jb4.getText()!="") {
	wins = true ;
}
else if(jb7.getText()==jb8.getText()&&jb8.getText()==jb9.getText()&& jb8.getText()!="") {
	wins = true ;
}

//vertical winning possibility 
else if(jb1.getText()==jb4.getText()&&jb4.getText()==jb7.getText()&& jb1.getText()!="") {
	wins = true ;
}
else if(jb2.getText()==jb5.getText()&&jb5.getText()==jb8.getText()&& jb5.getText()!="") {
	wins = true ;
}
else if(jb3.getText()==jb6.getText()&&jb6.getText()==jb9.getText()&& jb9.getText()!="") {
	wins = true ;
}

//Diogonally winning possibility
else if(jb1.getText()==jb5.getText()&&jb5.getText()==jb9.getText()&& jb9.getText()!="") {
	wins = true ;
}
else if(jb3.getText()==jb5.getText()&&jb5.getText()==jb7.getText()&& jb7.getText()!="") {
	wins = true ;
}

//game draw 
else {
		wins = false ;
}


}
//	void Winner() {
//		if(wins==true) {
//			JOptionPane.showMessageDialog(jf, str + "Wins.");
//			restart();
//		}
//		else if(wins==false && count == 9){
//			JOptionPane.showMessageDialog(jf,  "Draw ");
//			restart();
//		}
//	}
//	
	
	
	void Winner() {
	    if (wins) {

	        String winnerName =
	                lastMove.equals("X") ? player1 : player2;
	        jf.setTitle( winnerName + ": Win");
	        JOptionPane.showMessageDialog(jf,
	                "🎉 Winner: " + winnerName);
//	        jf.setTitle( winnerName + ": Win");
	        saveResultToDB(winnerName); 
	        restart();
	    }
	    else if (!wins && count == 9) {
	        JOptionPane.showMessageDialog(jf, "🤝 Match Draw");
	        saveResultToDB("DRAW");
	        restart();
	    }
	}

	
	void restart() {
		int i = JOptionPane.showConfirmDialog(jf, "DO YOU WANT TO RESTART MATCH");
		if(i==0) {
			jb1.setText("");
			jb2.setText("");
			jb3.setText("");
			jb4.setText("");
			jb5.setText("");
			jb6.setText("");
			jb7.setText("");
			jb8.setText("");
			jb9.setText("");
			
			
			jb1.setEnabled(true);
			jb2.setEnabled(true);
			jb3.setEnabled(true);
			jb4.setEnabled(true);
			jb5.setEnabled(true);
			jb6.setEnabled(true);
			jb7.setEnabled(true);
			jb8.setEnabled(true);
			jb9.setEnabled(true);
			  
			
			jb1.setBackground(null);
			jb2.setBackground(null);
			jb3.setBackground(null);
			jb4.setBackground(null);
			jb5.setBackground(null);
			jb6.setBackground(null);
			jb7.setBackground(null);
			jb8.setBackground(null);
			jb9.setBackground(null);
			
			
			str = "";
			count = 0 ;
			wins = false ;
			jf.setTitle("");
			
		}
		else if(i==1) {
			System.exit(0);
			
		}
		else {
		btnsetEnable(false);
			
		}
	}
	
	void btnsetEnable(boolean b) {
		jb1.setEnabled(b);
		jb2.setEnabled(b);
		jb3.setEnabled(b);
		jb4.setEnabled(b);
		jb5.setEnabled(b);
		jb6.setEnabled(b);
		jb7.setEnabled(b);
		jb8.setEnabled(b);
		jb9.setEnabled(b);

	}

	void saveResultToDB(String winnerName) {

	    try {
	        Connection con = DBConnection.getConnection();

	        String sql =
	          "INSERT INTO game_result (player1, player2, winner) VALUES (?, ?, ?)";

	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, player1);
	        ps.setString(2, player2);
	        ps.setString(3, winnerName);

	        ps.executeUpdate();

	        ps.close();
	        con.close();

	        System.out.println("✅ Result saved to database");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}