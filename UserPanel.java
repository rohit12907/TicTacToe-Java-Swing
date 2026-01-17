import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserPanel extends JFrame {

    JTextField p1Field, p2Field;
    JButton startBtn;

    public UserPanel() {

        setTitle("Tic Tac Toe");
        setSize(600, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== Gradient Background Panel =====
        JPanel bgPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(20, 20, 60),
                        0, getHeight(), new Color(0, 120, 200));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bgPanel.setLayout(null);
        setContentPane(bgPanel);

        // ===== 3D CARD PANEL =====
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(120, 50, 360, 400);
        card.setBackground(new Color(30, 30, 30));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createRaisedBevelBorder(),
                BorderFactory.createLoweredBevelBorder()
        ));
        bgPanel.add(card);

        // ===== TITLE =====
        JLabel title = new JLabel("TIC TAC TOE", SwingConstants.CENTER);
        title.setBounds(40, 20, 280, 40);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(Color.WHITE);
        card.add(title);

        // ===== GAME INFO =====
        JTextArea info = new JTextArea(
                "🎮 About the Game\n\n" +
                "• 2 Player strategy game\n" +
                "• Player-1 uses X\n" +
                "• Player-2 uses O\n" +
                "• First to match 3 wins\n" +
                "• Match results saved in DB"
        );
        info.setBounds(25, 70, 310, 110);
        info.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        info.setForeground(Color.LIGHT_GRAY);
        info.setBackground(new Color(30, 30, 30));
        info.setEditable(false);
        info.setFocusable(false);
        card.add(info);

        // ===== PLAYER 1 =====
        JLabel p1 = new JLabel("Player 1 [X]");
        p1.setBounds(40, 200, 150, 20);
        p1.setForeground(Color.WHITE);
        card.add(p1);

        p1Field = new JTextField();
        p1Field.setBounds(40, 225, 280, 28);
        card.add(p1Field);

        // ===== PLAYER 2 =====
        JLabel p2 = new JLabel("Player 2 [O]");
        p2.setBounds(40, 260, 150, 20);
        p2.setForeground(Color.WHITE);
        card.add(p2);

        p2Field = new JTextField();
        p2Field.setBounds(40, 285, 280, 28);
        card.add(p2Field);

        // ===== START BUTTON (3D LOOK) =====
        startBtn = new JButton("START GAME");
        startBtn.setBounds(90, 330, 180, 40);
        startBtn.setFont(new Font("Arial", Font.BOLD, 15));
        startBtn.setBackground(new Color(0, 160, 90));
        startBtn.setForeground(Color.WHITE);
        startBtn.setFocusPainted(false);
        startBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        card.add(startBtn);

        // Button action
        startBtn.addActionListener(e -> startGame());

        setVisible(true);
    }

    void startGame() {

        String p1 = p1Field.getText().trim();
        String p2 = p2Field.getText().trim();

        if (p1.isEmpty() || p2.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both player names!");
            return;
        }

        TicTac game = new TicTac(p1, p2);
        game.open();

        dispose();
    }

    public static void main(String[] args) {
        new UserPanel();
    }
}

