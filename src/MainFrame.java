import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        this.add(new JScrollPane(new TeamListPanel()));
        this.setTitle("Project Management App");
        this.setJMenuBar(new MainMenu());
        this.setSize(600, 400);
        this.setVisible(true);
    }
}
