/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LeonettiM
 */
@Entity
@Table(name = "t_avis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avis.findAll", query = "SELECT a FROM Avis a"),
    @NamedQuery(name = "Avis.findByPKAvis", query = "SELECT a FROM Avis a WHERE a.pKAvis = :pKAvis"),
    @NamedQuery(name = "Avis.findByIdFilm", query = "SELECT a FROM Avis a WHERE a.idFilm = :idFilm")})
public class Avis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_Avis")
    private Integer pKAvis;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    private String avis;
    @Basic(optional = false)
    @NotNull
    private int idFilm;
    @JoinColumn(name = "FK_Users", referencedColumnName = "PK_Users")
    @ManyToOne(optional = false)
    private int fKUsers;

    public Avis() {
    }

    public Avis(Integer pKAvis) {
        this.pKAvis = pKAvis;
    }

    public Avis(Integer pKAvis, String avis, int idFilm) {
        this.pKAvis = pKAvis;
        this.avis = avis;
        this.idFilm = idFilm;
    }

    public Integer getPKAvis() {
        return pKAvis;
    }

    public void setPKAvis(Integer pKAvis) {
        this.pKAvis = pKAvis;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getFKUsers() {
        return fKUsers;
    }

    public void setFKUsers(int fKUsers) {
        this.fKUsers = fKUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pKAvis != null ? pKAvis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avis)) {
            return false;
        }
        Avis other = (Avis) object;
        if ((this.pKAvis == null && other.pKAvis != null) || (this.pKAvis != null && !this.pKAvis.equals(other.pKAvis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Avis[ pKAvis=" + pKAvis + " ]";
    }
    
}
