package com.epam.audiotracks.dao.album;

import com.epam.audiotracks.dao.Dao;
import com.epam.audiotracks.dto.AddTrackDto;
import com.epam.audiotracks.entity.Album;
import com.epam.audiotracks.exeption.DaoException;

public interface AlbumDao extends Dao<Album> {

    void save(String name) throws DaoException;

}
