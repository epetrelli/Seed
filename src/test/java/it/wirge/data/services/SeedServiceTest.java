package it.wirge.data.services;

import it.wirge.data.entities.SeedEntity;
import it.wirge.rest.models.Seed;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.logging.Logger;

public class SeedServiceTest {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @BeforeMethod
    public void setUp() throws Exception {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + "" + ")");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        //logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + "" + ")");
    }

    @Test(priority = 10)
    public void testEntityToObject(){
        //logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + "" + ")");
        SeedEntity seedEntity = new SeedEntity();
        Random r = new Random();
        seedEntity.setIdSeed(r.nextInt());
        seedEntity.setTxSeed("*" + System.currentTimeMillis() + "*");
        Seed seed = SeedService.entityToObject(seedEntity);
        assert seed.getIdSeed().equals(seedEntity.getIdSeed());
        assert seed.getTxSeed().equals(seedEntity.getTxSeed());
    }

    @Test(priority = 20)
    public void testObjectToEntity(){
        //logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + "" + ")");
        Seed seed = new Seed();
        Random r = new Random();
        seed.setIdSeed(r.nextInt());
        seed.setTxSeed("*" + System.currentTimeMillis() + "*");
        SeedEntity seedEntity = SeedService.objectToEntity(seed);
        assert seed.getIdSeed().equals(seedEntity.getIdSeed());
        assert seed.getTxSeed().equals(seedEntity.getTxSeed());
    }
}