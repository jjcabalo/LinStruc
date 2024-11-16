import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

public class StacksMenu extends JFrame {
    private Stacks Stacks;

    public static StacksMenu instance;
    
    private JLabel stackDisplay;

    public StacksMenu(int arraySize) {
        Stacks = new Stacks(arraySize);
        
        setSize(700, 500);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 700, 500);
        add(layeredPane);

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(getClass().getResource("/assets/stacks_bg.png")));
        background.setBounds(0, 0, 700, 500);
        layeredPane.add(background, Integer.valueOf(0));

        stackDisplay = new JLabel(Arrays.toString(Stacks.getStackArray()));
        stackDisplay.setBounds(50, 160, 600, 30);
        stackDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        stackDisplay.setForeground(Color.BLACK);
        stackDisplay.setFont(new Font(stackDisplay.getFont().getName(), Font.BOLD, 25));
        layeredPane.add(stackDisplay, Integer.valueOf(2));
        layeredPane.repaint();

        JButton pushButton = new JButton();
        pushButton.setContentAreaFilled(false);
        pushButton.setBorderPainted(false);
        pushButton.setIcon(new ImageIcon(StacksMenu.class.getResource("/assets/Push.png")));
        pushButton.setBounds(47, 235, 145, 113);
        layeredPane.add(pushButton, Integer.valueOf(1));

        JButton popButton = new JButton();
        popButton.setContentAreaFilled(false);
        popButton.setBorderPainted(false);
        popButton.setIcon(new ImageIcon(StacksMenu.class.getResource("/assets/Pop.png")));
        popButton.setBounds(202, 235, 145, 113);
        layeredPane.add(popButton, Integer.valueOf(1));

        JButton isEmptyButton = new JButton();
        isEmptyButton.setContentAreaFilled(false);
        isEmptyButton.setBorderPainted(false);
        isEmptyButton.setIcon(new ImageIcon(StacksMenu.class.getResource("/assets/IsEmpty.png")));
        isEmptyButton.setBounds(357, 235, 145, 113);
        layeredPane.add(isEmptyButton, Integer.valueOf(1));

        JButton isFullButton = new JButton();
        isFullButton.setContentAreaFilled(false);
        isFullButton.setBorderPainted(false);
        isFullButton.setIcon(new ImageIcon(StacksMenu.class.getResource("/assets/IsFull.png")));
        isFullButton.setBounds(512, 235, 145, 113);
        layeredPane.add(isFullButton, Integer.valueOf(1));

        JButton peekButton = new JButton();
        peekButton.setContentAreaFilled(false);
        peekButton.setBorderPainted(false);
        peekButton.setIcon(new ImageIcon(StacksMenu.class.getResource("/assets/Peek.png")));
        peekButton.setBounds(132, 350, 145, 113);
        layeredPane.add(peekButton, Integer.valueOf(1));

        JButton clearButton = new JButton();
        clearButton.setContentAreaFilled(false);
        clearButton.setBorderPainted(false);
        clearButton.setIcon(new ImageIcon(StacksMenu.class.getResource("/assets/Clear.png")));
        clearButton.setBounds(287, 350, 145, 113);
        layeredPane.add(clearButton, Integer.valueOf(1));

        JButton backButton = new JButton();
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setIcon(new ImageIcon(StacksMenu.class.getResource("/assets/Back.png")));
        backButton.setBounds(442, 350, 145, 113);
        layeredPane.add(backButton, Integer.valueOf(1));

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = JOptionPane.showInputDialog(null, "Enter number to push:", "Push", JOptionPane.QUESTION_MESSAGE);
                    int item = Integer.parseInt(input);
                    String result = Stacks.push(item);
                    updateStackDisplay();
                    JOptionPane.showMessageDialog(null, result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = Stacks.pop();
                updateStackDisplay();
                JOptionPane.showMessageDialog(null, result);
            }
        });

        isEmptyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isEmpty = Stacks.isEmpty();
                JOptionPane.showMessageDialog(null, "Is Stack Empty: " + isEmpty);
            }
        });

        isFullButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isFull = Stacks.isFull();
                JOptionPane.showMessageDialog(null, "Is Stack Full: " + isFull);
            }
        });

        peekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = Stacks.peek();
                JOptionPane.showMessageDialog(null, result);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stacks.clear();
                updateStackDisplay();
                JOptionPane.showMessageDialog(null, "Stack cleared.");
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            MainMenu mainMenu = new MainMenu(arraySize);
            mainMenu.setVisible(true);
        });

        setVisible(true);
    }

    private void updateStackDisplay() {
        stackDisplay.setText(Arrays.toString(Stacks.getStackArray()));
    }

    public static StacksMenu getInstance(int arraySize) {
        if (instance == null) {
            instance = new StacksMenu(arraySize);
        }
        return instance;
    }
}
