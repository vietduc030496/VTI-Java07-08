/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "lop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lop.findAll", query = "SELECT l FROM Lop l")
    , @NamedQuery(name = "Lop.findByIdLop", query = "SELECT l FROM Lop l WHERE l.idLop = :idLop")
    , @NamedQuery(name = "Lop.findByTenlop", query = "SELECT l FROM Lop l WHERE l.tenlop = :tenlop")
    , @NamedQuery(name = "Lop.findByNienkhoa", query = "SELECT l FROM Lop l WHERE l.nienkhoa = :nienkhoa")})
public class Lop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lop")
    private Integer idLop;
    @Column(name = "tenlop")
    private String tenlop;
    @Column(name = "nienkhoa")
    private String nienkhoa;
    @OneToMany(mappedBy = "idLop")
    private List<Sinhvien> sinhvienList;

    public Lop() {
    }

    public Lop(Integer idLop) {
        this.idLop = idLop;
    }

    public Integer getIdLop() {
        return idLop;
    }

    public void setIdLop(Integer idLop) {
        this.idLop = idLop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getNienkhoa() {
        return nienkhoa;
    }

    public void setNienkhoa(String nienkhoa) {
        this.nienkhoa = nienkhoa;
    }

    @XmlTransient
    public List<Sinhvien> getSinhvienList() {
        return sinhvienList;
    }

    public void setSinhvienList(List<Sinhvien> sinhvienList) {
        this.sinhvienList = sinhvienList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLop != null ? idLop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lop)) {
            return false;
        }
        Lop other = (Lop) object;
        if ((this.idLop == null && other.idLop != null) || (this.idLop != null && !this.idLop.equals(other.idLop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lop[ idLop=" + idLop + " ]";
    }
    
}
