import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HouseGui extends JFrame implements ActionListener, KeyListener {
    private JPanel mainpanel;
    private JTextArea textArea1;
    private JTextField zipcode;
    private JButton searchButton;
    private JLabel hey;

    // search bar with text enter 5-digit zipcode
    //underneath stock image of home with people
    //search icon next to text of search bar
    //we'll loop through arrayList of houses
    //display certain info --price, addy, bed, bath etc
    //maybe image of random house
    // if they click on a specific house display prev info with score metric

    public HouseGui(){
        run();
    }

    public void run(){
        makecomponents();
    }

    public void makecomponents(){
        setContentPane(mainpanel);
        setTitle("Welcome to my real estate searcher!");
        setSize(900, 500);
        setLocation(450,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        mainpanel = new JPanel();
        hey = new JLabel("Enter a Valid Zip Code: ");
        mainpanel.add(hey);
        zipcode = new JTextField(5);
        mainpanel.add(zipcode);
        textArea1 = new JTextArea();
        mainpanel.add(textArea1);
        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(300,300));
        mainpanel.add(searchButton);
        mainpanel.setLayout((new GridLayout(3,1)));


        searchButton.addActionListener(this);
        zipcode.addActionListener(this);
         actionPerformed();
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source instanceof JButton){
            JButton button = (JButton) source;
            String text= button.getText();

            if(text.equals("Search")){
                String textboxtext = zipcode.getText();
                textArea1.append(textboxtext);
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e){
      //
    }
    @Override
    public void keyPressed(KeyEvent e){
        textArea1.append("key pressed! ");

    }
    @Override
    public void keyReleased(KeyEvent e){

    }



}