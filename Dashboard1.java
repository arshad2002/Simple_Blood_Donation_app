import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class Dashboard1  implements  ActionListener {
    private JFrame f;
    private JButton b1,b2;
    private JComboBox cb1,cb2;
    private JLabel l1,l2,l3;
    private int x=650,y=500;
    private String[] bloodGroup= {"A+","B+","AB+","O+","A-","B-","AB-","O-"};
    private String [] district={"Dhaka","jashore","comilla","dhaka","chittagog","Faridpur","Gazipur","Gopalgan","Kishorega","Madaripur","Manikganj","Munshiganj","Narayanganj","Narsingdi","Rajbari","hariatpur","angail","andarban","Brahmanbari","Chandpur","Chattogram","Cox’s Bazar","Cumilla","Feni","Khagrachhar","Lakshmipur","Noakhali","Rangamati"," Habiganj","Moulvibazar","Sunamganj","Sylhet","Barguna"," Barishal","Bhola","Jhalokati","Patuakhali","Pirojpur","Bagerhat","Chuadanga","Jashore","Jhenaidah","Jhenaidah","Khulna","Kushtia","Magura","Meherpur","Narail","Satkhira","Bogura","Joypurhat","Naogaon","Natore","Chapainawab"," Pabna","Rajshahi","Sirajganj"," Dinajpur","Gaibandha","Kurigram","Lalmonirhat","Nilphamari","Panchagarh","Rangpur","Thakurgaon","Jamalpur","Mymensing","Netrokona"};
    private String searchedbloodGroup, searchedArea;
    private ImageIcon logo = new ImageIcon("Pic_src\\blooddrop.png");


    Dashboard1() {
        showMessageDialog(null, "Welcome ");
        f = new JFrame();

        l2=new JLabel("Desire Blood Group: ");
        l2.setBounds(x-590, y-460, 120, 30);
        cb1 = new JComboBox(bloodGroup);
        cb1.setBounds(x-470,y-460,110,30);
        cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchedbloodGroup=cb1.getSelectedItem().toString();
            }
        });
        l3=new JLabel("Desire District: ");
        l3.setBounds(x-590, y-430, 90, 30);
        cb2 = new JComboBox(district);
        cb2.setBounds(x-470,y-430,110,30);
        cb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchedArea=cb2.getSelectedItem().toString();
            }
        });


        l1=new JLabel("Search Blood By: ");
        l1.setBounds(x-600, y-490, 120, 30);

        b1=new JButton("SEARCH");
        b1.setBounds(x-350, y-450, 90, 30);
        b1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if (e.getSource() == b1) {
                     new SearchResult(searchedbloodGroup,searchedArea); 
                     showMessageDialog(null, "Hope you find  what you need.\n Please treat everyone with good manner");


                 }
             }
         });

        b2 = new JButton("LOG OUT");
        b2.setBounds(x-600,y,90,30);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2) {
                    f.dispose();
                    new Login();

                }
            }
        });

    


//Componenet Add:
        f.add(b1);
        f.add(b2);

        f.add(cb1);
        f.add(cb2);
        f.add(l1);
        f.add(l2);
        f.add(l3);


//Frame Setting:
        f.setLayout(null);
        f.setVisible(true);
        f.setIconImage(logo.getImage());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("User Dash Board");
        f.setSize(450, 600);
        f.setLocationRelativeTo(null);
        //f.getContentPane().setBackground( Color.black );

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
