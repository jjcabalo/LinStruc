import javax.swing.*;
import java.awt.event.*;

public class LoadingScreen extends JFrame {

    public static LoadingScreen instance;

    public LoadingScreen() {
        setSize(700, 500);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 700, 500);
        add(layeredPane);

        JLabel title = new JLabel();
        title.setIcon(new ImageIcon(getClass().getResource("/assets/title.png")));
        title.setBounds(150, 50, 400, 100);
        layeredPane.add(title, Integer.valueOf(1));

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(getClass().getResource("/assets/loading_bg.gif")));
        background.setBounds(0, 0, 700, 500);
        layeredPane.add(background, Integer.valueOf(0));

        background.addMouseListener(new MouseAdapter() {
            private Timer timer;
            private boolean doubleClick = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (timer == null) {
                    timer = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (!doubleClick) {
                                MainMenu mainMenu = new MainMenu();
                                mainMenu.setVisible(true);
                                dispose();
                            }
                            doubleClick = false;
                            timer.stop();
                        }
                    });
                    timer.setRepeats(false);
                }

                if (e.getClickCount() == 2) {
                    doubleClick = true;
                    System.exit(0);
                } else {
                    timer.restart();
                }
            }
        });

        setVisible(true);
    }

    public static LoadingScreen getInstance() {
        if (instance == null) {
            instance = new LoadingScreen();
        }
        return instance;
    }
}