package learn.data;

import learn.models.Orbiter;
import learn.models.OrbiterType;

import java.util.List;

public interface OrbiterRepository {
    List<Orbiter> findAll() throws DataAccessException;

    Orbiter findById(int orbiterId) throws DataAccessException;

    List<Orbiter> findByType(OrbiterType type) throws DataAccessException;

    Orbiter add(Orbiter orbiter) throws DataAccessException;

    boolean update(Orbiter orbiter) throws DataAccessException;

    boolean deleteById(int orbiterId) throws DataAccessException;
}
