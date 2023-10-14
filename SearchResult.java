import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class SearchResult extends JFrame {
    
    private String area="",bloodGroup="";
    private ImageIcon logo = new ImageIcon("Pic_src\\blooddrop.png");

    public SearchResult(String givenBloodGroup,String givenArea) {

//Same blood group:
        File User_infoFolder=new File("User_info");
        String []UserInfoFiles=User_infoFolder.list();
        String[] sameBloodUser=new String[UserInfoFiles.length];
        for(int i=0;i<UserInfoFiles.length;i++){

            try{
                FileReader fr=new FileReader("User_Info\\"+UserInfoFiles[i]);
                Scanner sc =new Scanner(fr);
                while(sc.hasNextLine()){
                    //nbgadmp
                    sc.nextLine();
                    bloodGroup=sc.nextLine();
                    sc.nextLine();sc.nextLine();
                    area=sc.nextLine();
                    sc.nextLine();sc.nextLine();
                }
                fr.close();
            }catch(IOException a) { }

            for ( int j=0; j<UserInfoFiles.length; j++){
                if (givenArea.equals(area) && givenBloodGroup.equals(bloodGroup)&& sameBloodUser[j]==null){
                    sameBloodUser[j]=UserInfoFiles[i];

                    break;



                }
            }




        }
//Search throw same blood group:
        int rows=sameBloodUser.length;
        int columns=6;
        String[][] tableData=new String[rows][columns];
        for(int i=0; i<rows;i++){


            try{
                FileReader fr=new FileReader("User_Info\\"+sameBloodUser[i]);
                Scanner sc =new Scanner(fr);
                int j=0;
                while(sc.hasNextLine()&&j<columns){
                    tableData[i][j]=sc.nextLine();
                    j++;
                }
                fr.close();
            }catch(IOException a) { }


        }
//add to tabel:
        String[] tableColumn = {"NAME", "Blood Group", "Gender", "Age", "Area", "Mobile Number"};
        JTable jTable = new JTable(tableData, tableColumn);
        jTable.setBounds(0, 0, 600, 50);
        jTable.setEnabled(false);
        jTable.setBackground(Color.LIGHT_GRAY);
        jTable.setForeground(Color.black);
        Font font = new Font("",1,11);
        jTable.setFont(font);
        jTable.setRowHeight(30);
        JScrollPane jScrollPane = new JScrollPane(jTable);

//Component add:
        add(jScrollPane);
//Frame Setting:
        setVisible(true);
        setTitle("INFORMATION OF BLOOD DONER");
        setSize(500, 600);
        setIconImage(logo.getImage());
        setLocationRelativeTo(null);

    }
}
