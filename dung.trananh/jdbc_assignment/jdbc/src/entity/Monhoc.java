/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "monhoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monhoc.findAll", query = "SELECT m FROM Monhoc m")
    , @NamedQuery(name = "Monhoc.findByIdMonhoc", query = "SELECT m FROM Monhoc m WHERE m.idMonhoc = :idMonhoc")
    , @NamedQuery(name = "Monhoc.findByTenmonhoc", query = "SELECT m FROM Monhoc m WHERE m.tenmonhoc = :tenmonhoc")
    , @NamedQuery(name = "Monhoc.findBySotinchi", query = "SELECT m FROM Monhoc m WHERE m.sotinchi = :sotinchi")})
public class Monhoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_monhoc")
    private Integer idMonhoc;
    @Column(name = "tenmonhoc")
    private String tenmonhoc;
    @Column(name = "sotinchi")
    private Integer sotinchi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monhoc")
    private List<Bangdiem> bangdiemList;

    public Monhoc() {
    }

    public Monhoc(Integer idMonhoc) {
        this.idMonhoc = idMonhoc;
    }

    public Integer getIdMonhoc() {
        return idMonhoc;
    }

    public void setIdMonhoc(Integer idMonhoc) {
        this.idMonhoc = idMonhoc;
    }

    public String getTenmonhoc() {
        return tenmonhoc;
    }

    public void setTenmonhoc(String tenmonhoc) {
        this.tenmonhoc = tenmonhoc;
    }

    public Integer getSotinchi() {
        return sotinchi;
    }

    public void setSotinchi(Integer sotinchi) {
        this.sotinchi = sotinchi;
    }

    @XmlTransient
    public List<Bangdiem> getBangdiemList() {
        return bangdiemList;
    }

    public void setBangdiemList(List<Bangdiem> bangdiemList) {
        this.bangdiemList = bangdiemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMonhoc != null ? idMonhoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monhoc)) {
            return false;
        }
        Monhoc other = (Monhoc) object;
        if ((this.idMonhoc == null && other.idMonhoc != null) || (this.idMonhoc != null && !this.idMonhoc.equals(other.idMonhoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Monhoc[ idMonhoc=" + idMonhoc + " ]";
    }
    
}
