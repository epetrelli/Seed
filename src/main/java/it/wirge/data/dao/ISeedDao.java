package it.wirge.data.dao;

import it.wirge.data.entities.Seed;

/**
 * Created by enrico on 20/11/15.
 */
public interface ISeedDao {
    Seed getSeed(int idSeed);

    void saveSeed(Seed seed);

    void deleteSeed(Seed seed);
}
