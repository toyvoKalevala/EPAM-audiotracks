package com.epam.audiotracks.dao.track;

import com.epam.audiotracks.dao.Dao;
import com.epam.audiotracks.entity.Track;
import com.epam.audiotracks.exeption.DaoException;

import java.util.List;

public interface TrackDao extends Dao<Track> {

    List<Track> getAll() throws DaoException;

}
