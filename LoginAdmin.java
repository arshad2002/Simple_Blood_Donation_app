import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;




public class LoginAdmin {
    private JFrame j;
    private JLabel l1,l2;
    private JButton b1,b2,b3;
    private JTextField t1;
    private JPasswordField pw;
    private int x=600,y=300;
    public String name;
    private ImageIcon logo = new ImageIcon("Pic_src\\blooddrop.png");
    private String admin1User="arshad",admin1Pw="0",admin2User="abir",admin2Pw="0";


    LoginAdmin(){

        j=new JFrame();
       // ImageIcon image = new ImageIcon("Login.jpg");
        showMessageDialog(null, "If you are not an admin please go to User login page");
//User id:
        l1=new JLabel("User Id :");
        l1.setBounds(x,y,100,20);
        l1.setForeground(Color.red);
        t1=new JTextField();
        t1.setBounds(x+60,y,190,20);
//Password:
        l2=new JLabel("Password:");
        l2.setBounds(x,y+30,100,20);
        l2.setForeground(Color.red);
        pw=new JPasswordField();
        pw.setBounds(x+60,y+30,190,20);


//Sign in button:
        b1=new JButton("Sign In");
        b1.setBounds(x,y+60,110,30);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    String foundUserName =new String(t1.getText());
                    String foundPassword = new String(pw.getText());
                    if ((foundUserName.equals(admin1User) && foundPassword.equals(admin1Pw))||(foundUserName.equals(admin2User) && foundPassword.equals(admin2Pw))){
                      new AdminDashboard();
                    }
                }
            }
            
        });
//User login button:
        b2=new JButton("User Login");
        b2.setBounds(x+90,y+95,100,30);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2) {

                    j.setVisible(false);
                    new Login();
                }

            }
        });
        
//Exit Button:
        b3=new JButton("Exit");
        b3.setBounds(x+150,y+60,100,30);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3) {
                    j.setVisible(false);
                }

            }
        });
//Frame setting:
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setTitle("-------ADMINS----------");
        j.setSize(1920,1080);
        j.setLayout(null);
        j.setIconImage(logo.getImage());
        j.getContentPane().setBackground(Color.BLACK);

//Componenet Add:
        j.add(l1);
        j.add(l2);

        j.add(b1);
        j.add(b2);
        j.add(b3);
    
        j.add(t1);

        j.add(pw);

    }
}
