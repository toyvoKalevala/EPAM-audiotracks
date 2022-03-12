package com.epam.audiotracks.service.album;

import com.epam.audiotracks.entity.Album;
import com.epam.audiotracks.exeption.ServiceException;

import java.util.List;

public interface AlbumService {

    List<Album> getAllAlbums() throws ServiceException;
}
