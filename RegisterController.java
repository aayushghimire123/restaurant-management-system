/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.*;
import View.*;
import database.myConnection;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


/**
 *
 * @author asism
 */
public class RegisterController {
    
    RegisterModel model;
    RegisterView view;
    ResultSet rs;
    PreparedStatement pst=null;
    
    public RegisterController(RegisterView view)
    {
        this.view = view;
        
        new registerListener().actionPerformed();
    }
    
    class registerListener
    {
        public void actionPerformed(){
        
            try
            {
                model=view.getUser();
                if (checkUser(model))
                {
                    view.setMessage("Registered Successfully!");
                    
                }
//                else
//                {
//                    view.setMessage("Invalid");
//                }
            }
            catch (Exception e1)
            {
                
            }
        }
        
        public boolean checkUser(RegisterModel user) throws Exception
        {
            
            try
            {
                Connection conn= myConnection.myDatabase();
                String sql="insert into EMPLOYEE (username,pass,email,sec_ans) values (?,?,?,?)";
                pst = conn.prepareStatement(sql);
                
                pst.setString(1,user.getUname());
                pst.setString(2,user.getPass());
                pst.setString(3,user.getEmail());
                pst.setString(4,user.getSec_ans());

                pst.executeUpdate();
                System.out.println("Data Inserted");
                JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                
                 view.dispose();
            }
            catch (Exception e2)
            {
                
                System.out.println(e2.getMessage());
                
            }
            return false;
            
        }

        
    }
    

    
}
