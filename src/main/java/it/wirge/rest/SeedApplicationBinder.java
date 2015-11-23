package it.wirge.rest;

import it.wirge.data.dao.ISeedDao;
import it.wirge.data.dao.SeedDao;
import it.wirge.data.services.ISeedService;
import it.wirge.data.services.SeedService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class SeedApplicationBinder  extends AbstractBinder {
    @Override
    protected void configure() {
        // services
        bind(SeedService.class).to(ISeedService.class).in(Singleton.class);

        // dao's
        bind(SeedDao.class).to(ISeedDao.class).in(Singleton.class);

    }
}
