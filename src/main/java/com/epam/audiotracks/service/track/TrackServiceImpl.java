package com.epam.audiotracks.service.track;

import com.epam.audiotracks.dao.DaoHelper;
import com.epam.audiotracks.dao.DaoHelperFactory;
import com.epam.audiotracks.dao.track.TrackDao;
import com.epam.audiotracks.dao.user.UserDao;
import com.epam.audiotracks.dto.AddTrackDto;
import com.epam.audiotracks.entity.Track;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.exeption.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TrackServiceImpl implements TrackService {

    private static final Logger logger = LogManager.getLogger();
    private final DaoHelperFactory daoHelperFactory;

    public TrackServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public List<Track> getAllTracks() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            TrackDao trackDao = daoHelper.createTrackDao();
            return trackDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addTrack(AddTrackDto newTrack) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            TrackDao trackDao = daoHelper.createTrackDao();
            trackDao.save(newTrack);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addTrackToAlbum(int trackId, int albumId) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            TrackDao trackDao = daoHelper.createTrackDao();
            trackDao.update(trackId, albumId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
