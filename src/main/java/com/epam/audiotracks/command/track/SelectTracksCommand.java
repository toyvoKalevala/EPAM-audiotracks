package com.epam.audiotracks.command.track;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.entity.Track;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.track.TrackService;
import com.epam.audiotracks.service.track.TrackServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SelectTracksCommand implements Command {

    private final TrackService trackService;
    private static final Logger logger = LogManager.getLogger();

    public SelectTracksCommand(TrackServiceImpl trackService) {
        this.trackService = trackService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<Track> tracks = trackService.getAllTracks();
        request.setAttribute("tracks", tracks);
        return "WEB-INF/view/mainPage.jsp";
    }

}
