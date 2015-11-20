package it.wirge.data.dao;

import it.wirge.data.entities.Seed;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

/**
 * Created by enrico on 19/11/15.
 */

@Singleton
public class SeedDao implements ISeedDao {

    Logger logger = Logger.getLogger(this.getClass().getName());
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SeedPersistenceUnit");

    @Override
    public Seed getSeed(int idSeed) {
        logger.info("getSeed(" + idSeed + ")");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Seed seed = null;
        try {
            seed = entityManager.find(Seed.class, idSeed);
        } finally {
            entityManager.close();
        }
        return seed;
    }
    @Override
    public void saveSeed(Seed seed) {
        logger.info("saveSeed(" + seed.getIdSeed() + ")");
    }
    @Override
    public void deleteSeed(Seed seed) {
        logger.info("deleteSeed(" + seed.getIdSeed() + ")");
    }
}
