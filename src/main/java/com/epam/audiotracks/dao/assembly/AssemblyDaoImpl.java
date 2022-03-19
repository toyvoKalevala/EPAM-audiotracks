package com.epam.audiotracks.dao.assembly;

import com.epam.audiotracks.dao.AbstractDao;
import com.epam.audiotracks.entity.Assembly;
import com.epam.audiotracks.exeption.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class AssemblyDaoImpl extends AbstractDao<Assembly> implements AssemblyDao {

    private static final Logger logger = LogManager.getLogger();

    private static final String SAVE_ASSEMBLY = "INSERT assemblies (name) VALUES(?)";
    private static final String SAVE_ASSEMBLY_TRACK = "INSERT tracks_assemblies (track_id, assembly_id) VALUES(?, ?)";

    public AssemblyDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return Assembly.TABLE;
    }

    @Override
    public void save(String name) throws DaoException {
        executeUpdate(SAVE_ASSEMBLY, name);
    }

    @Override
    public void save(int trackId, int assemblyId) throws DaoException {
        executeUpdate(SAVE_ASSEMBLY_TRACK, trackId, assemblyId);
    }

}
