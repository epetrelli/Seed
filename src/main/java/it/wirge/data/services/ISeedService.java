package it.wirge.data.services;

import it.wirge.rest.models.Seed;


public interface ISeedService {
    Seed getSeed(Long idSeed);

    Seed insertSeed(Seed seed) throws Exception;

    Seed saveSeed(Seed seed) throws Exception;

    void deleteSeed(Seed seed) throws Exception;
}
