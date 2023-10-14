import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Login implements ActionListener {
    private JFrame j;
    private JLabel l1,l2;
    private JButton b1,b2,b3,b4;
    private JTextField t1;
    private JPasswordField pw;
    private String [] UserInfoFiles;
    private String UserInfoFileName;
    private int x=600,y=300;
    private String password,mobileNumber;
    public String name;
    private ImageIcon logo = new ImageIcon("Pic_src\\blooddrop.png");


    Login(){

        j=new JFrame();
       // ImageIcon image = new ImageIcon("Login.jpg");
        showMessageDialog(null, "Welcome to Blood Donation");
        showMessageDialog(null, "Here User Name is your Mobile Number");
//User id:
        l1=new JLabel("User Id :");
        l1.setBounds(x,y,100,20);
        //l1.setForeground(Color.red);
        t1=new JTextField();
        t1.setBounds(x+60,y,190,20);
//Password:
        l2=new JLabel("Password:");
        l2.setBounds(x,y+30,100,20);
        //l2.setForeground(Color.red);
        pw=new JPasswordField();
        pw.setBounds(x+60,y+30,190,20);


//Sign in button:
        b1=new JButton("Sign In");
        b1.setBounds(x,y+60,120,30);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    String foundUserName =new String(t1.getText());
                    String foundPassword = new String(pw.getText());
                    //loop Throw files:
                    File User_infoFolder=new File("User_Info");
                    UserInfoFiles=User_infoFolder.list();
                    UserInfoFileName=new String();

                    for(int i=0;i<UserInfoFiles.length;i++){
                        if(UserInfoFiles[i].equals(foundUserName+".txt")){
                            UserInfoFileName=UserInfoFiles[i];
                            break;
                        }
                    }
                    //Reading:
                    try{
                        FileReader fr=new FileReader("User_Info\\"+UserInfoFileName);
                        Scanner sc =new Scanner(fr);

                        while(sc.hasNextLine()){
                            //nbgadmp
                            name=sc.nextLine();
                            sc.nextLine();sc.nextLine();sc.nextLine();sc.nextLine();
                            mobileNumber =sc.nextLine();
                            password =sc.nextLine();

                        }
                        fr.close();
                    }catch(IOException a) {

                    }
                    //Mataching:
                    int flag = 0;
                    for (int i = 0; i <UserInfoFiles.length; i++) {
                        if (foundUserName.equals(mobileNumber) && foundPassword.equals(password)) {
                            flag = 1;
                            break;
                        }
                    }

                    if (flag == 1) {
                        new Dashboard1();
                        j.setVisible(false);
                    } else {
                        showMessageDialog(null, "Invalid Username and password!");
                    }

                }
            }
        });
//Sign up button:
        b2=new JButton("Sign Up");
        b2.setBounds(x+150,y+60,100,30);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2) {

                    j.setVisible(false);
                    new SignUp();
                }

            }
        });
//Admins button:
        b4=new JButton("Admin");
        b4.setBounds(x,y+95,120,30);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b4) {

                    j.setVisible(false);
                    new LoginAdmin();
                }

            }
        });

//Exit Button:
        b3=new JButton("Exit");
        b3.setBounds(x+150,y+95,100,30);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3) {

                    j.setVisible(false);
                }

            }
        });
//bacground image:
        try {
            j.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Pic_src\\loginWallpaper.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        j.pack();
//Frame setting:
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setTitle("-------BLOOD DONATION----------");
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
        j.add(b4);

        j.add(t1);

        j.add(pw);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
