package com.epam.audiotracks.service.track;

import com.epam.audiotracks.dto.AddTrackDto;
import com.epam.audiotracks.entity.Track;
import com.epam.audiotracks.exeption.ServiceException;

import java.util.List;

public interface TrackService {

    List<Track> getAllTracks() throws ServiceException;

    void addTrack(AddTrackDto newTrack) throws ServiceException;

    void addTrackToAlbum(int trackId, int albumId) throws ServiceException;

}
