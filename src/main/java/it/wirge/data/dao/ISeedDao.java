package it.wirge.data.dao;

import it.wirge.data.entities.SeedEntity;

/**
 * Created by enrico on 20/11/15.
 */
public interface ISeedDao {
    SeedEntity getSeedEntity(int idSeed);

    SeedEntity insertSeedEntity(SeedEntity seedEntity) throws Exception;

    SeedEntity saveSeedEntity(SeedEntity seedEntity) throws Exception;

    void deleteSeedEntity(SeedEntity seedEntity) throws Exception;
}
