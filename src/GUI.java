import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements ActionListener, KeyListener {
    private JPanel mainpanel;
    private JTextArea textArea1;
    private JTextField zipcode;
    private JButton searchButton;
    private JLabel hey;

    public MainGui(){
        makecompoents();
    }

    public void makecompoents(){
        setContentPane(mainpanel);
        setTitle("Welcome to my real estate searcher!");
        setSize(900, 500);
        setLocation(450,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        mainpanel = new JPanel();
        hey = new JLabel("Enter a Valid Zip Code: ");
        mainpanel.add(hey);
        zipcode = new JTextField();
        mainpanel.add(zipcode);
        textArea1 = new JTextArea();
        mainpanel.add(textArea1);
        searchButton = new JButton("Search");
        mainpanel.add(searchButton);
        mainpanel.setLayout((new GridLayout(3,1)));
        add(mainpanel);


        setVisible(true);
    }


}

