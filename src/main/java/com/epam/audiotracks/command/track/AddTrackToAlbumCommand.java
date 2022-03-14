package com.epam.audiotracks.command.track;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.track.TrackService;
import com.epam.audiotracks.service.track.TrackServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTrackToAlbumCommand implements Command {

    private final TrackService trackService;
    private static final Logger logger = LogManager.getLogger();

    public AddTrackToAlbumCommand(TrackServiceImpl trackService) {
        this.trackService = trackService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        int trackId = Integer.parseInt(request.getParameter("trackId"));
        int albumId = Integer.parseInt(request.getParameter("albumId"));
        trackService.addTrackToAlbum(trackId, albumId);
        return "/controller?command=selectTracks";
    }

}
