package it.wirge.data.dao;

import it.wirge.data.entities.SeedEntity;

/**
 * Created by enrico on 20/11/15.
 */
public interface ISeedDao {
    SeedEntity getSeedEntity(int idSeed);

    void saveSeedEntity(SeedEntity seedEntity);

    void deleteSeedEntity(SeedEntity seedEntity);
}
