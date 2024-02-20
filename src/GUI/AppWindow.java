package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import TemperatureConvertor.TemperatureConvertor;

public class AppWindow extends JFrame implements ActionListener {
    private JLabel mainTitle, inputGuid, ans;
    private JComboBox<String> unitsList;
    private JTextArea temperatureBox;
    private JButton convertButton;
    private TemperatureConvertor convertor;

    public void showWindow(TemperatureConvertor convertor) {
        this.convertor = convertor;
        setWindowSettings();
        CreateComponents();
        setLayout(null);
        addComponents();
        adjustPostions();
        adjustFonts();
    }

    private void setWindowSettings() {
        setTitle("Temperature Convertor");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void CreateComponents() {
        mainTitle = new JLabel("Temperature Convertor");
        inputGuid = new JLabel("Enter temperature and choose its unit");
        temperatureBox = new JTextArea();

        char DEGREESYMBOL = '\u00B0';
        String[] options = { DEGREESYMBOL + "C", DEGREESYMBOL + "F", DEGREESYMBOL + "K" };
        unitsList = new JComboBox<>(options);

        convertButton = new JButton("convert");
        convertButton.addActionListener(this);

        ans = new JLabel("");
    }

    private void adjustPostions() {
        mainTitle.setBounds(140, 10, 500, 50);

        inputGuid.setBounds(125, 130, 500, 50);
        temperatureBox.setBounds(125, 200, 100, 40);
        unitsList.setBounds(300, 200, 100, 40);

        convertButton.setBounds(230, 300, 100, 30);
        ans.setBounds(20, 350, 500, 50);
    }

    private void addComponents() {
        add(mainTitle);
        add(inputGuid);
        add(temperatureBox);
        add(unitsList);
        add(convertButton);
        add(ans);
    }

    private void adjustFonts() {
        mainTitle.setFont(new Font("Serif", Font.BOLD, 30));
        inputGuid.setFont(new Font("Serif", Font.PLAIN, 25));

        temperatureBox.setFont(new Font("Serif", Font.PLAIN, 25));
        unitsList.setFont(new Font("Serif", Font.PLAIN, 25));
        convertButton.setFont(new Font("Serif", Font.PLAIN, 20));
        ans.setFont(new Font("Serif", Font.PLAIN, 25));

        Color windowColor = new Color(51, 153, 255);
        this.getContentPane().setBackground(windowColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            try {
                ans.setText(convertTemperature());
            } catch (Exception exception) {
                ans.setText("Invalid data entered");
            }
        }
    }

    private String convertTemperature() {
        float temperatue = Float.parseFloat(temperatureBox.getText());
        char unit = ((String) unitsList.getSelectedItem()).charAt(1);
        String conversionResult = this.convertor.convertTemperature(temperatue, unit);
        return conversionResult;
    }

}
