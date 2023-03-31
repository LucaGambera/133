/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workers;

import java.util.ArrayList;


/**
 *
 * @author BuetschiD
 */
public class MainTest {
    public static void main(String[] args) {
        WrkDB wrkDB = new WrkDB("3306","mydb");

        ArrayList<String> lstUser = wrkDB.getUser();
        if (lstUser != null) {
            for (String user : lstUser) {
                System.out.println(user);
            }
        }
    }
    
}
