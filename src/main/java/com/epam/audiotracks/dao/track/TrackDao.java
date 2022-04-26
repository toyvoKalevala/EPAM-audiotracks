package com.epam.audiotracks.dao.track;

import com.epam.audiotracks.dao.Dao;
import com.epam.audiotracks.dto.AddTrackDto;
import com.epam.audiotracks.entity.Track;
import com.epam.audiotracks.exeption.DaoException;

public interface TrackDao extends Dao<Track> {

    void save(AddTrackDto newTrack) throws DaoException;

    void update(int trackId, int albumId) throws DaoException;

    void update(int trackId) throws DaoException;

}
