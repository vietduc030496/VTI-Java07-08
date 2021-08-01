/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hoang
 */
@Entity
@Table(name = "bangdiem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bangdiem.findAll", query = "SELECT b FROM Bangdiem b")
    , @NamedQuery(name = "Bangdiem.findByIdSv", query = "SELECT b FROM Bangdiem b WHERE b.bangdiemPK.idSv = :idSv")
    , @NamedQuery(name = "Bangdiem.findByIdMonhoc", query = "SELECT b FROM Bangdiem b WHERE b.bangdiemPK.idMonhoc = :idMonhoc")
    , @NamedQuery(name = "Bangdiem.findByDiem", query = "SELECT b FROM Bangdiem b WHERE b.diem = :diem")})
public class Bangdiem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BangdiemPK bangdiemPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "diem")
    private Float diem;
    @JoinColumn(name = "id_sv", referencedColumnName = "id_sv", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sinhvien sinhvien;
    @JoinColumn(name = "id_monhoc", referencedColumnName = "id_monhoc", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Monhoc monhoc;

    public Bangdiem() {
    }

    public Bangdiem(BangdiemPK bangdiemPK) {
        this.bangdiemPK = bangdiemPK;
    }

    public Bangdiem(int idSv, int idMonhoc) {
        this.bangdiemPK = new BangdiemPK(idSv, idMonhoc);
    }

    public BangdiemPK getBangdiemPK() {
        return bangdiemPK;
    }

    public void setBangdiemPK(BangdiemPK bangdiemPK) {
        this.bangdiemPK = bangdiemPK;
    }

    public Float getDiem() {
        return diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }

    public Sinhvien getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(Sinhvien sinhvien) {
        this.sinhvien = sinhvien;
    }

    public Monhoc getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bangdiemPK != null ? bangdiemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bangdiem)) {
            return false;
        }
        Bangdiem other = (Bangdiem) object;
        if ((this.bangdiemPK == null && other.bangdiemPK != null) || (this.bangdiemPK != null && !this.bangdiemPK.equals(other.bangdiemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bangdiem[ bangdiemPK=" + bangdiemPK + " ]";
    }
    
}
