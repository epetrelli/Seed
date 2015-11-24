package it.wirge.data.dao;

import it.wirge.data.entities.SeedEntity;


public interface ISeedDao {
    SeedEntity getSeedEntity(Long idSeed);

    SeedEntity insertSeedEntity(SeedEntity seedEntity) throws Exception;

    SeedEntity saveSeedEntity(SeedEntity seedEntity) throws Exception;

    void deleteSeedEntity(SeedEntity seedEntity) throws Exception;
}
