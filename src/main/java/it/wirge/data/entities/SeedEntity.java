package it.wirge.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "seed", schema = "", catalog = "SeedDB")
public class SeedEntity {
    private Long idSeed;
    private String txSeed;

    @Id
    @Column(name = "idSeed", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdSeed() {
        return idSeed;
    }
    public void setIdSeed(Long idSeed) {
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

        SeedEntity that = (SeedEntity) o;

        if (idSeed != null ? !idSeed.equals(that.idSeed) : that.idSeed != null) return false;
        if (txSeed != null ? !txSeed.equals(that.txSeed) : that.txSeed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSeed != null ? idSeed.hashCode() : 0;
        result = 31 * result + (txSeed != null ? txSeed.hashCode() : 0);
        return result;
    }
}
