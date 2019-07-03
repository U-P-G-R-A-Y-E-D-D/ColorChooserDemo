import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class ColorChooserDemo extends JPanel

        implements ChangeListener {

    protected JColorChooser Jcc;
    protected JLabel label;

    public ColorChooserDemo()
    {
        super(new BorderLayout());

        // Set up the Label at the top of the window
        label = new JLabel("Welcome to GeeksforGeeks",
                JLabel.CENTER);

        // set the foreground color of the text
        label.setForeground(Color.green);

        // set background color of the field
        label.setBackground(Color.WHITE);
        label.setOpaque(true);

        // set font type and size of the text
        label.setFont(new Font("SansSerif", Font.BOLD, 30));

        // set size of the label
        label.setPreferredSize(new Dimension(100, 65));

        // create a Panel and set its layout
        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.add(label, BorderLayout.CENTER);
        bannerPanel.setBorder(BorderFactory.createTitledBorder("Label"));

        // Set up color chooser for setting text color
        Jcc = new JColorChooser(label.getForeground());
        Jcc.getSelectionModel().addChangeListener(this);
        Jcc.setBorder(BorderFactory.createTitledBorder(
                "Choose Text Color"));

        add(bannerPanel, BorderLayout.CENTER);
        add(Jcc, BorderLayout.PAGE_END);
    }

    public void stateChanged(ChangeEvent e)
    {
        Color newColor = Jcc.getColor();
        label.setForeground(newColor);
    }

    // Create the GUI and show it.  For thread safety,
    // this method should be invoked from the
    // event-dispatching thread.
    private static void createAndShowGUI()
    {

        // Create and set up the window.
        JFrame frame = new JFrame("ColorChooserDemo");

        // set default close operation of the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        JComponent newContentPane = new ColorChooserDemo();

        // content panes must be opaque
        newContentPane.setOpaque(true);

        // add content pane to the frame
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    // Main Method
    public static void main(String[] args)
    {

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run()
            {

                createAndShowGUI();
            }
        });
    }
}
