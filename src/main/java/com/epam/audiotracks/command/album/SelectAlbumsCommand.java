package com.epam.audiotracks.command.album;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.entity.Album;
import com.epam.audiotracks.entity.Track;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.album.AlbumService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SelectAlbumsCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private final AlbumService albumService;

    public SelectAlbumsCommand(AlbumService albumService) {
        this.albumService = albumService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<Album> albums = albumService.getAllAlbums();
        request.setAttribute("albums", albums);
        return "/controller?command=selectAssemblies";
    }

}
