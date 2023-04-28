/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LeonettiM
 */
@Entity
@Table(name = "t_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByPKUsers", query = "SELECT u FROM Users u WHERE u.pKUsers = :pKUsers"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByAdmin", query = "SELECT u FROM Users u WHERE u.admin = :admin")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_Users")
    private Integer pKUsers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String password;
    @Basic(optional = false)
    @NotNull
    private short admin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKUsers")
    private List<Avis> avisList;

    public Users() {
    }

    public Users(Integer pKUsers) {
        this.pKUsers = pKUsers;
    }

    public Users(Integer pKUsers, String username, String password, short admin) {
        this.pKUsers = pKUsers;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }



    public Users(String username, String password) {

        this.username = username;
        this.password = password;

    }

    public Integer getPKUsers() {
        return pKUsers;
    }

    public void setPKUsers(Integer pKUsers) {
        this.pKUsers = pKUsers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getAdmin() {
        return admin;
    }

    public void setAdmin(short admin) {
        this.admin = admin;
    }

    @XmlTransient
    public List<Avis> getAvisList() {
        return avisList;
    }

    public void setAvisList(List<Avis> avisList) {
        this.avisList = avisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pKUsers != null ? pKUsers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.pKUsers == null && other.pKUsers != null) || (this.pKUsers != null && !this.pKUsers.equals(other.pKUsers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Users[ pKUsers=" + pKUsers + " ]";
    }

}
