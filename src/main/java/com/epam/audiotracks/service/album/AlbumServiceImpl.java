package com.epam.audiotracks.service.album;

import com.epam.audiotracks.dao.DaoHelper;
import com.epam.audiotracks.dao.DaoHelperFactory;
import com.epam.audiotracks.dao.album.AlbumDao;
import com.epam.audiotracks.entity.Album;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.exeption.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AlbumServiceImpl implements AlbumService {

    private static final Logger logger = LogManager.getLogger();
    private final DaoHelperFactory daoHelperFactory;

    public AlbumServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public List<Album> getAllAlbums() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            AlbumDao albumDao = daoHelper.createAlbumDao();
            return albumDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addAlbum(String name) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            AlbumDao albumDao = daoHelper.createAlbumDao();
            albumDao.save(name);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
