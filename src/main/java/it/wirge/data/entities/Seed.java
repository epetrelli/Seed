package it.wirge.data.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by enrico on 20/11/15.
 */
@Entity
public class Seed {
    private Integer idSeed;
    private String txSeed;

    @Id
    @Column(name = "idSeed", nullable = false, insertable = true, updatable = true)
    public Integer getIdSeed() {
        return idSeed;
    }

    public void setIdSeed(Integer idSeed) {
        this.idSeed = idSeed;
    }

    @Basic
    @Column(name = "txSeed", nullable = true, insertable = true, updatable = true, length = 256)
    public String getTxSeed() {
        return txSeed;
    }

    public void setTxSeed(String txSeed) {
        this.txSeed = txSeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seed seed = (Seed) o;

        if (idSeed != null ? !idSeed.equals(seed.idSeed) : seed.idSeed != null) return false;
        if (txSeed != null ? !txSeed.equals(seed.txSeed) : seed.txSeed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSeed != null ? idSeed.hashCode() : 0;
        result = 31 * result + (txSeed != null ? txSeed.hashCode() : 0);
        return result;
    }
}
