package it.wirge.data.services;

import it.wirge.rest.models.Seed;

/**
 * Created by enrico on 20/11/15.
 */
public interface ISeedService {
    Seed getSeed(int idSeed);

    void saveSeed(Seed seed);

    void deleteSeed(Seed seed);
}
