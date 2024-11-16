import javax.swing.*;

public class MainMenu extends JFrame {
    
    private static MainMenu instance;

    public MainMenu(int arraySize) {
        setSize(450, 300);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 450, 300);
        add(layeredPane);

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(getClass().getResource("/assets/mainmenu_bg.png")));
        background.setBounds(0, 0, 450, 300);
        layeredPane.add(background, Integer.valueOf(0));

        JButton stacksButton = new JButton(new ImageIcon(getClass().getResource("/assets/Stacks.png")));
        stacksButton.setBounds(50, 150, 100, 100);
        stacksButton.setBorderPainted(false);
        stacksButton.setContentAreaFilled(false);
        layeredPane.add(stacksButton, Integer.valueOf(1));

        JButton queuesButton = new JButton(new ImageIcon(getClass().getResource("/assets/Queues.png")));
        queuesButton.setBounds(175, 150, 100, 100);
        queuesButton.setBorderPainted(false);
        queuesButton.setContentAreaFilled(false);
        layeredPane.add(queuesButton, Integer.valueOf(1));

        JButton exitButton = new JButton(new ImageIcon(getClass().getResource("/assets/Exit.png")));
        exitButton.setBounds(300, 150, 100, 100);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.addActionListener(e -> System.exit(0));
        layeredPane.add(exitButton, Integer.valueOf(1));

        stacksButton.addActionListener(e -> {
            dispose();
            new StacksMenu(arraySize).setVisible(true);
        });

        queuesButton.addActionListener(e -> {
            dispose();
            new QueuesMenu(arraySize).setVisible(true);
        });
    }

    public static MainMenu getInstance(int arraySize) {
        if (instance == null) {
            instance = new MainMenu(arraySize);
        }
        return instance;
    }
    
}
