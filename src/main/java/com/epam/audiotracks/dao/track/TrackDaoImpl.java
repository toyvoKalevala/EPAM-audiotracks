package com.epam.audiotracks.dao.track;

import com.epam.audiotracks.dao.AbstractDao;
import com.epam.audiotracks.dto.AddTrackDto;
import com.epam.audiotracks.entity.Track;
import com.epam.audiotracks.exeption.DaoException;
import com.epam.audiotracks.rowmapper.RowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class TrackDaoImpl extends AbstractDao<Track> implements TrackDao {

    private static final Logger logger = LogManager.getLogger();

    private final static String FIND_ALL_TRACKS_JOIN_ALBUM = "SELECT tracks.id, tracks.name, albums.name as album, tracks.price " +
            "from tracks " +
            "inner join albums on album_id=albums.id";
    private static final String SAVE_TRACK = "INSERT tracks (name, album_id, price) VALUES(?, ?, ?)";

    public TrackDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return Track.TABLE;
    }

    @Override
    public List<Track> findAll() throws DaoException {
        String table = getTableName();
        RowMapper<Track> mapper = (RowMapper<Track>) RowMapper.create(table);
        return executeQuery(FIND_ALL_TRACKS_JOIN_ALBUM, mapper);
    }

    @Override
    public void save(AddTrackDto newTrack) throws DaoException {
        executeUpdate(SAVE_TRACK, newTrack.getName(), newTrack.getAlbumId(), newTrack.getPrice());
    }

}
