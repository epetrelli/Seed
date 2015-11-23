package it.wirge.data.dao;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class SeedDaoTest {
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
    public void testSaveSeedEntity() throws Exception {
        //logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + "" + ")");
        //logger.info("Non-sense to test dao's");
    }

    @Test(priority = 20)
    public void testGetSeedEntity() throws Exception {
        //logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + "" + ")");
        //logger.info("Non-sense to test dao's");
    }

    @Test(priority = 30)
    public void testDeleteSeedEntity() throws Exception {
        //logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + "" + ")");
        //logger.info("Non-sense to test dao's");
    }
}