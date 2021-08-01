/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Hoang
 */
@Embeddable
public class BangdiemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_sv")
    private int idSv;
    @Basic(optional = false)
    @Column(name = "id_monhoc")
    private int idMonhoc;

    public BangdiemPK() {
    }

    public BangdiemPK(int idSv, int idMonhoc) {
        this.idSv = idSv;
        this.idMonhoc = idMonhoc;
    }

    public int getIdSv() {
        return idSv;
    }

    public void setIdSv(int idSv) {
        this.idSv = idSv;
    }

    public int getIdMonhoc() {
        return idMonhoc;
    }

    public void setIdMonhoc(int idMonhoc) {
        this.idMonhoc = idMonhoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSv;
        hash += (int) idMonhoc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BangdiemPK)) {
            return false;
        }
        BangdiemPK other = (BangdiemPK) object;
        if (this.idSv != other.idSv) {
            return false;
        }
        if (this.idMonhoc != other.idMonhoc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BangdiemPK[ idSv=" + idSv + ", idMonhoc=" + idMonhoc + " ]";
    }
    
}
