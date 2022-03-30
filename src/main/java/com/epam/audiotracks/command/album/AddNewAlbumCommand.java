package com.epam.audiotracks.command.album;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.album.AlbumService;
import com.epam.audiotracks.service.album.AlbumServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewAlbumCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private final AlbumService albumService;

    public AddNewAlbumCommand(AlbumServiceImpl albumService) {
        this.albumService = albumService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String albumName = request.getParameter("albumName");
        albumService.addAlbum(albumName);
        request.setAttribute("albumAdded", "label.albumAdded");
        request.setAttribute("redirect", "true");
        return "controller?command=selectTracks";
    }

}
