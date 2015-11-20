package it.wirge.data.services;

import it.wirge.data.dao.ISeedDao;
import it.wirge.data.dao.SeedDao;
import it.wirge.data.entities.Seed;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

/**
 * Created by enrico on 20/11/15.
 */
@Singleton
public class SeedService implements ISeedService {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private ISeedDao seedDao;

    @Override
    public Seed getSeed(int idSeed) {
        logger.info("getSeed(" + idSeed + ")");
        return seedDao.getSeed(idSeed);
    }
    @Override
    public void saveSeed(Seed seed) {
        logger.info("saveSeed(" + seed.getIdSeed() + ")");
        seedDao.saveSeed(seed);
    }
    @Override
    public void deleteSeed(Seed seed) {
        logger.info("deleteSeed(" + seed.getIdSeed() + ")");
        seedDao.deleteSeed(seed);
    }


}
