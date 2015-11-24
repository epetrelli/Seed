package it.wirge.data.entities;

/**
 * Created by enrico on 24/11/15.
 */
public class SeedEntity {
    private Long idSeed;
    private String txSeed;

    public Long getIdSeed() {
        return idSeed;
    }

    public void setIdSeed(Long idSeed) {
        this.idSeed = idSeed;
    }

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

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
