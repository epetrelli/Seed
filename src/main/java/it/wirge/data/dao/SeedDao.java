package it.wirge.data.dao;

import it.wirge.data.entities.SeedEntity;

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
    public SeedEntity getSeedEntity(int idSeed) {
        logger.info("getSeedEntity(" + idSeed + ")");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        SeedEntity seedEntity = null;
        try {
            seedEntity = entityManager.find(SeedEntity.class, idSeed);
        } finally {
            entityManager.close();
        }
        return seedEntity;
    }
    @Override
    public void saveSeedEntity(SeedEntity seedEntity) {
        logger.info("saveSeed(" + seedEntity.getIdSeed() + ")");
    }
    @Override
    public void deleteSeedEntity(SeedEntity seedEntity) {
        logger.info("deleteSeed(" + seedEntity.getIdSeed() + ")");
    }
}
