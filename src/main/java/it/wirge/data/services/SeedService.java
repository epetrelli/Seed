package it.wirge.data.services;

import it.wirge.data.dao.ISeedDao;
import it.wirge.data.entities.SeedEntity;
import it.wirge.rest.models.Seed;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
public class SeedService implements ISeedService {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private ISeedDao seedDao;

    @Override
    public Seed getSeed(int idSeed) {
        logger.info("getSeedEntity(" + idSeed + ")");
        SeedEntity seedEntity = seedDao.getSeedEntity(idSeed);
        return entityToObject(seedEntity);
    }
    @Override
    public void saveSeed(Seed seed) {
        logger.info("saveSeed(" + seed.getIdSeed() + ")");
        SeedEntity seedEntity = objectToEntity(seed);
        seedDao.saveSeedEntity(seedEntity);
    }
    @Override
    public void deleteSeed(Seed seed) {
        logger.info("deleteSeed(" + seed.getIdSeed() + ")");
        SeedEntity seedEntity = objectToEntity(seed);
        seedDao.deleteSeedEntity(seedEntity);
    }

    // Utilities / Business logic:

    public static Seed entityToObject(SeedEntity seedEntity){
        Seed seed = new Seed();
        seed.setIdSeed(seedEntity.getIdSeed());
        seed.setTxSeed(seedEntity.getTxSeed());
        return seed;
    }
    public static SeedEntity objectToEntity(Seed seed){
        SeedEntity seedEntity = new SeedEntity();
        seedEntity.setIdSeed(seed.getIdSeed());
        seedEntity.setTxSeed(seed.getTxSeed());
        return seedEntity;
    }


}
