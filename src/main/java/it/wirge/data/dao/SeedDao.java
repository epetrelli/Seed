package it.wirge.data.dao;

import it.wirge.data.entities.SeedEntity;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Logger;

@ManagedBean
public class SeedDao implements ISeedDao {

    Logger logger = Logger.getLogger(ISeedDao.class.getName());
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SeedPersistenceUnit");

    @Override
    public SeedEntity getSeedEntity(Long idSeed) {
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
    public SeedEntity insertSeedEntity(SeedEntity seedEntity) throws Exception {
        logger.info("insertSeedEntity(" + seedEntity.getIdSeed() + ")");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(seedEntity);
            entityTransaction.commit();
        }
        catch (Exception e) {
            entityTransaction.rollback();
            throw e;
        }
        finally {
            entityManager.close();
        }
        return seedEntity;
    }
    @Override
    public SeedEntity saveSeedEntity(SeedEntity seedEntity) throws Exception {
        logger.info("saveSeed(" + seedEntity.getIdSeed() + ")");
        SeedEntity seedEntityOut;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            seedEntityOut = entityManager.merge(seedEntity);
            entityTransaction.commit();
        }
        catch (Exception e) {
            entityTransaction.rollback();
            throw e;
        }
        finally {
            entityManager.close();
        }
        return seedEntityOut;
    }
    @Override
    public void deleteSeedEntity(SeedEntity seedEntity) throws Exception {
        logger.info("deleteSeed(" + seedEntity.getIdSeed() + ")");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            if(!entityManager.contains(seedEntity)){
                seedEntity = entityManager.merge(seedEntity);
            }
//            else{
//                seedEntity = entityManager.find(SeedEntity.class, seedEntity.getIdSeed());
//            }
            entityManager.remove(seedEntity);
            entityTransaction.commit();
        }
        catch (Exception e) {
            entityTransaction.rollback();
            throw e;
        }
        finally {
            entityManager.close();
        }
    }
}
