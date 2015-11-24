package it.wirge.data.services;

import it.wirge.rest.models.Seed;

/**
 * Created by enrico on 20/11/15.
 */
public interface ISeedService {
    Seed getSeed(int idSeed);

    Seed insertSeed(Seed seed) throws Exception;

    Seed saveSeed(Seed seed) throws Exception;

    void deleteSeed(Seed seed) throws Exception;
}
