package com.epam.audiotracks.dao.album;

import com.epam.audiotracks.dao.AbstractDao;
import com.epam.audiotracks.entity.Album;
import com.epam.audiotracks.entity.Track;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class AlbumDaoImpl extends AbstractDao<Album> implements AlbumDao {

    private static final Logger logger = LogManager.getLogger();

    public AlbumDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return Album.TABLE;
    }

}
