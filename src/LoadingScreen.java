import java.awt.event.*;
import javax.swing.*;

public class LoadingScreen extends JFrame {

    public static LoadingScreen instance;
    private Timer timer;
    private boolean doubleClick = false;

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
        title.setBounds(35, 0, 643, 275);
        layeredPane.add(title, Integer.valueOf(1));

        JLabel subtitle = new JLabel();
        subtitle.setIcon(new ImageIcon(getClass().getResource("/assets/subtitle.png")));
        subtitle.setBounds(153, 400, 401, 30);
        layeredPane.add(subtitle, Integer.valueOf(1));

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(getClass().getResource("/assets/loading_bg.gif")));
        background.setBounds(0, 0, 700, 500);
        layeredPane.add(background, Integer.valueOf(0));

        Timer subtitleTimer = new Timer(750, new ActionListener() {
            private boolean visible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                visible = !visible;
                subtitle.setVisible(visible);
            }
        });
        subtitleTimer.start();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (timer == null) {
                    timer = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (!doubleClick) {
                                // Show input dialog to get array size
                                String input = JOptionPane.showInputDialog(
                                    LoadingScreen.this,
                                    "Enter array size:",
                                    "Input",
                                    JOptionPane.PLAIN_MESSAGE
                                );

                                if (input != null) {
                                    try {
                                        int arraySize = Integer.parseInt(input);
                                        MainMenu mainMenu = new MainMenu(arraySize);
                                        mainMenu.setVisible(true);
                                        dispose();
                                    } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(
                                            LoadingScreen.this,
                                            "Invalid input. Please enter a valid integer.",
                                            "Error",
                                            JOptionPane.ERROR_MESSAGE
                                        );
                                    }
                                }
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