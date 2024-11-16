import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private static MainMenu instance;

    public static MainMenu getInstance() {
        if (instance == null) {
            return new MainMenu();
        }
        return instance;
    }
    
}
