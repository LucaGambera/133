/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workers;

import beans.Avis;
import beans.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author BuetschiD
 */
public class WrkDB {

    private String port;
    private String dbName;

    public WrkDB(String port, String dbName) {
        this.port = port;
        this.dbName = dbName;
    }

    /**
     * Ouverture d'une connexion sur la base de données. Ajouter
     * mysql-connector-j-....jar dans les librairies.
     *
     * @return true si tout s'est bien passé, sinon false
     */
    private Connection dbConnexion;

    public boolean openConnexion() {

        final String url = "jdbc:mysql://5.182.248.183:" + port + "/" + dbName + "?serverTimezone=CET";
        final String user = "gamberal01_luca";
        final String pw = "--I+9IhP8?wh";
        boolean result = false;

        try {
            //nécessaire pour fonctionnement en web
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Connexion au driver JDBC à échoué!\n" + ex.getMessage());
        }
        try {
            dbConnexion = DriverManager.getConnection(url, user, pw);
            //System.out.println("Connection successfull");
            result = true;

        } catch (SQLException ex) {
            System.out.println("Connexion à la BD a échouée!\n" + ex.getMessage());
        }
        return result;
    }

    /**
     * Cette méthode permet de fermer la connexion à la base de données après
     * que la requête ait été envoyée.
     *
     * @return true si tout s'est bien passé, sinon false
     */
    public boolean closeConnexion() {
        boolean result = false;
        try {
            if (dbConnexion != null) {
                if (!dbConnexion.isClosed()) {
                    dbConnexion.close();
                } else {
                }
            } else {
            }
            result = true;
        } catch (SQLException e) {
        }
        return result;
    }

    public ArrayList<Avis> getAvis() {
        ArrayList<Avis> lstAvis = null;
        boolean result = openConnexion();
        if (result) {
            System.out.println("connection ok");
            PreparedStatement ps = null;

            lstAvis = new ArrayList<Avis>();
            try {
                ps = dbConnexion.prepareStatement("SELECT * FROM t_avis");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Avis avis = new Avis();
                    System.out.println(rs.getString(1));
                    
                    int pk = Integer.parseInt(rs.getString(1));
                    System.out.println(pk);
                    avis.setPKAvis(pk);
                    avis.setAvis(rs.getString(2));
                    System.out.println("idFilm");
                    int idFilm = Integer.parseInt(rs.getString(3));

                    avis.setIdFilm(idFilm);
                    int pkUser = Integer.parseInt(rs.getString(4));
                    avis.setFKUsers(pkUser);

                    lstAvis.add(avis);
                }
                rs.close();
                result = true;
                System.out.println("OK");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            if (result) {
                result = closeConnexion();
            }
        }
        return lstAvis;
    }

    public ArrayList<String> getUser(int PK) {
        ArrayList<String> lstUser = null;
        boolean result = openConnexion();
        if (result) {
            System.out.println("connection ok");
            PreparedStatement ps = null;
            String users = "";
            lstUser = new ArrayList<String>();
            try {
                ps = dbConnexion.prepareStatement("SELECT * FROM t_users where PK_Users = " + PK + ";");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Users user = new Users();
                    user.setAdmin(0);
                    user.setPKUsers(PK);
                    user.setUsername(users);
                    user.setPassword(port);
                    
                    
                    user = (String) rs.getString(1);
                    user += "," + (String) rs.getString(2);
                    user += "," + (String) rs.getString(3);

                    lstUser.add(user);
                }
                rs.close();
                result = true;
                System.out.println("OK");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            if (result) {
                result = closeConnexion();
            }
        }
        return lstUser;
    }

    public ArrayList<String> getUnAvis(int idFilm) {
        ArrayList<String> lstAvis = null;
        boolean result = openConnexion();
        if (result) {
            System.out.println("connection ok");
            PreparedStatement ps = null;
            String avis = "";
            lstAvis = new ArrayList<String>();
            try {
                ps = dbConnexion.prepareStatement("SELECT * FROM t_avis where IdFilm=" + idFilm);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    avis = "pk:";
                    avis += (String) rs.getString(1);
                    avis += ", avis:";
                    avis += (String) rs.getString(2);
                    avis += ", idfilm:";
                    avis += (String) rs.getString(3);
                    avis += ", pkuser:";
                    avis += (String) rs.getString(4);
                    lstAvis.add(avis);
                }
                rs.close();
                result = true;
                System.out.println("OK");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            if (result) {
                result = closeConnexion();
            }
        }
        System.out.println(lstAvis);
        return lstAvis;
    }

    public boolean addAvis(String avis, int idfilm, int fkuser) {
        boolean succes = false;
        boolean result = openConnexion();
        if (result) {
            PreparedStatement ps = null;
            try {
                ps = dbConnexion.prepareStatement("INSERT INTO t_avis(Avis, IdFilm, FK_Users) VALUES(?,?,?)");
                ps.setString(1, avis);
                ps.setInt(2, idfilm);
                ps.setInt(3, fkuser);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    succes = true;
                    System.out.println("New entry added to t_user table.");
                } else {
                    System.out.println("No rows affected when adding new entry to t_user table.");
                }
            } catch (Exception ex) {
                System.out.println("Error executing insert statement: " + ex.getMessage());
            }
            if (succes) {
                result = closeConnexion();
            }
        }
        return succes;
    }

    public boolean adduser(String username, String password) {
        boolean succes = false;
        boolean result = openConnexion();
        if (result) {
            PreparedStatement ps = null;
            try {
                ps = dbConnexion.prepareStatement("INSERT INTO t_users(username, password, admin) VALUES(?,?,?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setInt(3, 0);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    succes = true;
                    System.out.println("New entry added to t_user table.");
                } else {
                    System.out.println("No rows affected when adding new entry to t_user table.");
                }
            } catch (Exception ex) {
                System.out.println("Error executing insert statement: " + ex.getMessage());
            }
            if (succes) {
                result = closeConnexion();
            }
        }
        return succes;
    }

    public String checkLogin(String username, String password) {
        ArrayList<Users> lstUsers = null;

        boolean result = openConnexion();
        int pk_Retour = 0;
        short admin_retour = 0;
        String resultat = "false";
        if (result) {

            System.out.println("connection ok");

            PreparedStatement ps = null;
            String pk_user = "";
            String username_user = "";
            String password_user = "";
            Short admin_user = 0;
            lstUsers = new ArrayList<Users>();
            try {
                ps = dbConnexion.prepareStatement("SELECT * FROM t_users WHERE Username like (?) ");
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    pk_user = rs.getString("PK_Users");
                    System.out.println("pk");
                    username_user = (String) rs.getString("Username");
                    password_user = (String) rs.getString("Password");
                    admin_user = Short.parseShort(rs.getString("admin"));
                    int pk = Integer.parseInt(pk_user);
                    Users user = new Users(pk, username_user, password_user, admin_user);
                    lstUsers.add(user);

                }
                rs.close();
                for (Users lstUser : lstUsers) {
                    if (lstUser.getPassword().equals(password)) {
                        admin_retour = lstUser.getAdmin();
                        pk_Retour = lstUser.getPKUsers();
                        resultat = pk_Retour + "," + admin_retour;

                    }
                }
                result = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            if (result) {
                result = closeConnexion();
            }
        }
        return resultat;
    }

    public boolean deletAvis(int pk) {
        boolean succes = false;
        boolean result = openConnexion();
        if (result) {
            PreparedStatement ps = null;
            try {
                ps = dbConnexion.prepareStatement("DELETE FROM t_avis WHERE PK_Avis= " + pk);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    succes = true;
                    System.out.println("New entry deleted to t_avis table.");
                } else {
                    System.out.println("No rows affected when deleting new entry to t_avis table.");
                }
            } catch (Exception ex) {
                System.out.println("Error executing insert statement: " + ex.getMessage());
            }
            if (succes) {
                result = closeConnexion();
            }
        }
        return succes;
    }

}
