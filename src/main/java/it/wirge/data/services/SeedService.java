package it.wirge.data.services;

import it.wirge.data.dao.ISeedDao;
import it.wirge.data.entities.SeedEntity;
import it.wirge.rest.models.Seed;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.logging.Logger;

@ManagedBean
public class SeedService implements ISeedService {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private ISeedDao seedDao;

    @Override
    public Seed getSeed(Long idSeed) {
        logger.info("getSeed(" + idSeed + ")");
        SeedEntity seedEntity = seedDao.getSeedEntity(idSeed);
        return entityToObject(seedEntity);
    }
    @Override
    public Seed insertSeed(Seed seed) throws Exception {
        logger.info("insertSeed(" + "" + ")");
        SeedEntity seedEntity = objectToEntity(seed);
        SeedEntity seedEntityOut = seedDao.insertSeedEntity(seedEntity);
        logger.info("persisted3: " + seedEntityOut.getIdSeed());

        return entityToObject(seedEntityOut);
    }
    @Override
    public Seed saveSeed(Seed seed) throws Exception {
        logger.info("saveSeed(" + seed.getIdSeed() + ")");
        SeedEntity seedEntity = objectToEntity(seed);
        SeedEntity seedEntityOut = seedDao.saveSeedEntity(seedEntity);
        return entityToObject(seedEntityOut);
    }
    @Override
    public void deleteSeed(Seed seed) throws Exception {
        logger.info("deleteSeed(" + seed.getIdSeed() + ")");
        SeedEntity seedEntity = objectToEntity(seed);
        seedDao.deleteSeedEntity(seedEntity);
    }

    // Utilities / Business logic:

    public static Seed entityToObject(SeedEntity seedEntity){
        Seed seed = null;
        if(seedEntity!=null){
            seed = new Seed();
            seed.setIdSeed(seedEntity.getIdSeed());
            seed.setTxSeed(seedEntity.getTxSeed());
        }
        return seed;
    }
    public static SeedEntity objectToEntity(Seed seed){
        SeedEntity seedEntity = new SeedEntity();
        seedEntity.setIdSeed(seed.getIdSeed());
        seedEntity.setTxSeed(seed.getTxSeed());
        return seedEntity;
    }


}
