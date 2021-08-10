/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "sinhvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sinhvien.findAll", query = "SELECT s FROM Sinhvien s")
    , @NamedQuery(name = "Sinhvien.findByIdSv", query = "SELECT s FROM Sinhvien s WHERE s.idSv = :idSv")
    , @NamedQuery(name = "Sinhvien.findByHolot", query = "SELECT s FROM Sinhvien s WHERE s.holot = :holot")
    , @NamedQuery(name = "Sinhvien.findByTen", query = "SELECT s FROM Sinhvien s WHERE s.ten = :ten")
    , @NamedQuery(name = "Sinhvien.findByGioitinh", query = "SELECT s FROM Sinhvien s WHERE s.gioitinh = :gioitinh")
    , @NamedQuery(name = "Sinhvien.findByNgaysinh", query = "SELECT s FROM Sinhvien s WHERE s.ngaysinh = :ngaysinh")
    , @NamedQuery(name = "Sinhvien.findByDiachi", query = "SELECT s FROM Sinhvien s WHERE s.diachi = :diachi")
    , @NamedQuery(name = "Sinhvien.findByDienthoai", query = "SELECT s FROM Sinhvien s WHERE s.dienthoai = :dienthoai")
    , @NamedQuery(name = "Sinhvien.findByEmail", query = "SELECT s FROM Sinhvien s WHERE s.email = :email")})
public class Sinhvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sv")
    private Integer idSv;
    @Column(name = "holot")
    private String holot;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gioitinh")
    private String gioitinh;
    @Column(name = "ngaysinh")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "dienthoai")
    private String dienthoai;
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "id_lop", referencedColumnName = "id_lop")
    @ManyToOne
    private Lop idLop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhvien")
    private List<Bangdiem> bangdiemList;

    public Sinhvien() {
    }

    public Sinhvien(Integer idSv) {
        this.idSv = idSv;
    }

    public Integer getIdSv() {
        return idSv;
    }

    public void setIdSv(Integer idSv) {
        this.idSv = idSv;
    }

    public String getHolot() {
        return holot;
    }

    public void setHolot(String holot) {
        this.holot = holot;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Lop getIdLop() {
        return idLop;
    }

    public void setIdLop(Lop idLop) {
        this.idLop = idLop;
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
        hash += (idSv != null ? idSv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sinhvien)) {
            return false;
        }
        Sinhvien other = (Sinhvien) object;
        if ((this.idSv == null && other.idSv != null) || (this.idSv != null && !this.idSv.equals(other.idSv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sinhvien[ idSv=" + idSv + " ]";
    }
    
}
