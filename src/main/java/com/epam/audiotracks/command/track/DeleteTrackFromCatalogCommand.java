package com.epam.audiotracks.command.track;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.dto.AddTrackDto;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.track.TrackService;
import com.epam.audiotracks.service.track.TrackServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class DeleteTrackFromCatalogCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private final TrackService trackService;

    public DeleteTrackFromCatalogCommand(TrackServiceImpl trackService) {
        this.trackService = trackService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        int trackId = Integer.parseInt(request.getParameter("trackId"));
        trackService.deleteTrack(trackId);
        request.setAttribute("successDelete", "label.successDelete");
        return "controller?command=trackCatalog";
    }

}
