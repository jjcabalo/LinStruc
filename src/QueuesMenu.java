import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

public class QueuesMenu extends JFrame {
    private Queues queues;

    public static QueuesMenu instance;

    private JLabel queueDisplay;

    public QueuesMenu(int arraySize) {
        queues = new Queues(arraySize);

        setSize(700, 500);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 700, 500);
        add(layeredPane);

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(getClass().getResource("/assets/queues_bg.png")));
        background.setBounds(0, 0, 700, 500);
        layeredPane.add(background, Integer.valueOf(0));

        queueDisplay = new JLabel(Arrays.toString(queues.getQueueArray()));
        queueDisplay.setBounds(50, 160, 600, 30);
        queueDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        queueDisplay.setForeground(Color.BLACK);
        queueDisplay.setFont(new Font(queueDisplay.getFont().getName(), Font.BOLD, 25));
        layeredPane.add(queueDisplay, Integer.valueOf(2));
        layeredPane.repaint();

        JButton enqueueButton = new JButton();
        enqueueButton.setContentAreaFilled(false);
        enqueueButton.setBorderPainted(false);
        enqueueButton.setIcon(new ImageIcon(QueuesMenu.class.getResource("/assets/Enqueue.png")));
        enqueueButton.setBounds(47, 235, 145, 113);
        layeredPane.add(enqueueButton, Integer.valueOf(1));

        JButton dequeueButton = new JButton();
        dequeueButton.setContentAreaFilled(false);
        dequeueButton.setBorderPainted(false);
        dequeueButton.setIcon(new ImageIcon(QueuesMenu.class.getResource("/assets/Dequeue.png")));
        dequeueButton.setBounds(202, 235, 145, 113);
        layeredPane.add(dequeueButton, Integer.valueOf(1));

        JButton isEmptyButton = new JButton();
        isEmptyButton.setContentAreaFilled(false);
        isEmptyButton.setBorderPainted(false);
        isEmptyButton.setIcon(new ImageIcon(QueuesMenu.class.getResource("/assets/IsEmpty.png")));
        isEmptyButton.setBounds(357, 235, 145, 113);
        layeredPane.add(isEmptyButton, Integer.valueOf(1));

        JButton isFullButton = new JButton();
        isFullButton.setContentAreaFilled(false);
        isFullButton.setBorderPainted(false);
        isFullButton.setIcon(new ImageIcon(QueuesMenu.class.getResource("/assets/IsFull.png")));
        isFullButton.setBounds(512, 235, 145, 113);
        layeredPane.add(isFullButton, Integer.valueOf(1));

        JButton peekButton = new JButton();
        peekButton.setContentAreaFilled(false);
        peekButton.setBorderPainted(false);
        peekButton.setIcon(new ImageIcon(QueuesMenu.class.getResource("/assets/Peek.png")));
        peekButton.setBounds(132, 350, 145, 113);
        layeredPane.add(peekButton, Integer.valueOf(1));

        JButton clearButton = new JButton();
        clearButton.setContentAreaFilled(false);
        clearButton.setBorderPainted(false);
        clearButton.setIcon(new ImageIcon(QueuesMenu.class.getResource("/assets/Clear.png")));
        clearButton.setBounds(287, 350, 145, 113);
        layeredPane.add(clearButton, Integer.valueOf(1));

        JButton backButton = new JButton();
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setIcon(new ImageIcon(QueuesMenu.class.getResource("/assets/Back.png")));
        backButton.setBounds(442, 350, 145, 113);
        layeredPane.add(backButton, Integer.valueOf(1));

        enqueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = JOptionPane.showInputDialog(null, "Enter number to enqueue:", "Enqueue", JOptionPane.QUESTION_MESSAGE);
                    int item = Integer.parseInt(input);
                    String result = queues.enqueue(item);
                    updateQueueDisplay();
                    JOptionPane.showMessageDialog(null, result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dequeueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = queues.dequeue();
                updateQueueDisplay();
                JOptionPane.showMessageDialog(null, result);
            }
        });

        isEmptyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isEmpty = queues.isEmpty();
                JOptionPane.showMessageDialog(null, "Is Queue Empty: " + isEmpty);
            }
        });

        isFullButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isFull = queues.isFull();
                JOptionPane.showMessageDialog(null, "Is Queue Full: " + isFull);
            }
        });

        peekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = queues.peek();
                JOptionPane.showMessageDialog(null, result);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queues.clear();
                updateQueueDisplay();
                JOptionPane.showMessageDialog(null, "Queue cleared.");
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            MainMenu mainMenu = new MainMenu(arraySize);
            mainMenu.setVisible(true);
        });

        setVisible(true);
    }

    private void updateQueueDisplay() {
        queueDisplay.setText(Arrays.toString(queues.getQueueArray()));
    }

    public static QueuesMenu getInstance(int arraySize) {
        if (instance == null) {
            instance = new QueuesMenu(arraySize);
        }
        return instance;
    }
}
