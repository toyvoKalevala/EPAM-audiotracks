package com.epam.audiotracks.service.assembly;

import com.epam.audiotracks.dao.DaoHelper;
import com.epam.audiotracks.dao.DaoHelperFactory;
import com.epam.audiotracks.dao.assembly.AssemblyDao;
import com.epam.audiotracks.dao.track.TrackDao;
import com.epam.audiotracks.entity.Assembly;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.exeption.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AssemblyServiceImpl implements AssemblyService {

    private static final Logger logger = LogManager.getLogger();

    private final DaoHelperFactory daoHelperFactory;

    public AssemblyServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void addAssembly(String name) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            AssemblyDao assemblyDao = daoHelper.createAssemblyDao();
            assemblyDao.save(name);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Assembly> getAllAssemblies() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            AssemblyDao assemblyDao = daoHelper.createAssemblyDao();
            return assemblyDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addTrackToAssembly(int trackId, int assemblyId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            AssemblyDao assemblyDao = daoHelper.createAssemblyDao();
            assemblyDao.save(trackId, assemblyId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
