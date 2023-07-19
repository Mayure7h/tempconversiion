import java.awt.*;          
import java.awt.event.*;    
import javax.swing.*;   
 
public class TempConversion extends JFrame
{
    private JLabel celsiusLabel;        
    private JLabel fahrenheitLabel;
     
    private JTextField celsiusTF;       
    private JTextField fahrenheitTF;    
     
    private CelsHandler celsiusHandler;
    private FahrHandler fahrenheitHandler;
     
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 500;   
    private static final double FTOC = 5.0/9.0;
    private static final double CTOF = 9.0/5.0;
    private static final int OFFSET = 32;
     
    public TempConversion()
    {
        setTitle("Temperature Conversion");
        Container c = getContentPane();
        c.setLayout(new GridLayout(2,4));
         
        celsiusLabel = new JLabel("Temp in Celsius: ", SwingConstants.CENTER);
        fahrenheitLabel = new JLabel("Temp in Fahrenheit: ", SwingConstants.CENTER);
                                             
        celsiusTF = new JTextField(10);
        fahrenheitTF = new JTextField(10);
         
        c.add(celsiusLabel);
        c.add(celsiusTF);
        c.add(fahrenheitLabel);
        c.add(fahrenheitTF);
         
        celsiusHandler = new CelsHandler();
        fahrenheitHandler = new FahrHandler();
         
        celsiusTF.addActionListener(celsiusHandler);
        fahrenheitTF.addActionListener(fahrenheitHandler);
         
        setSize (500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
     
    private class CelsHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            double celsius, fahrenheit;
             
            celsius =
                    Double.parseDouble(celsiusTF.getText());
            fahrenheit = celsius * CTOF + OFFSET;
            fahrenheitTF.setText(String.format("%.2f", fahrenheit));
        }
    }
     
    private class FahrHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            double celsius, fahrenheit;
            fahrenheit = 
                    Double.parseDouble(fahrenheitTF.getText());
            celsius = (fahrenheit - OFFSET) * FTOC;
            celsiusTF.setText(String.format("%.2f", celsius));
        }
    }
             
     
    public static void main(String[] args)
    {
        TempConversion tempConv = new TempConversion();
        tempConv.setLocationRelativeTo(null);
    }
}