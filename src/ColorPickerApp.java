import javax.swing.*;
import java.awt.*;

public class ColorPickerApp extends JFrame {

    private JPanel colorDisplayPanel;

    public ColorPickerApp() {
        setTitle("Color Picker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel to display the selected color
        colorDisplayPanel = new JPanel();
        colorDisplayPanel.setPreferredSize(new Dimension(200, 200));
        colorDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        updateColorDisplay(Color.WHITE);

        // Create a button to trigger the color chooser dialog
        JButton pickColorButton = new JButton("Pick Color");
        pickColorButton.addActionListener(e -> pickColor());

        // Set up the layout
        setLayout(new FlowLayout());
        add(colorDisplayPanel);
        add(pickColorButton);

        setVisible(true);
    }

    private void pickColor() {
        // Show the color chooser dialog
        Color selectedColor = JColorChooser.showDialog(this, "Choose a Color", colorDisplayPanel.getBackground());

        // Update the color display panel with the selected color
        if (selectedColor != null) {
            updateColorDisplay(selectedColor);
        }
    }

    private void updateColorDisplay(Color color) {
        colorDisplayPanel.setBackground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorPickerApp::new);
    }
}
