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

    private final static String FIND_ALL_TRACKS_JOIN_ALBUM = "SELECT tracks.id, tracks.name, albums.name as album, tracks.price, tracks.isBlocked " +
            "from tracks " +
            "inner join albums on album_id=albums.id";
    private static final String SAVE_TRACK = "INSERT tracks (name, album_id, price) VALUES(?, ?, ?)";
    private static final String UPDATE_TRACK = "UPDATE tracks SET album_id = ? WHERE id = ?";
    private static final String BLOCK_TRACK = "UPDATE tracks SET isBlocked = 1 WHERE id = ?";

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

    @Override
    public void update(int trackId, int albumId) throws DaoException {
        executeUpdate(UPDATE_TRACK, albumId, trackId);
    }

    @Override
    public void update(int trackId) throws DaoException {
        executeUpdate(BLOCK_TRACK, trackId);
    }

}
