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

public class AddNewTrackCommand implements Command {

    private final TrackService trackService;
    private static final Logger logger = LogManager.getLogger();

    public AddNewTrackCommand(TrackServiceImpl trackService) {
        this.trackService = trackService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String trackName = request.getParameter("trackName");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(request.getParameter("trackPrice")));
        AddTrackDto newTrack = new AddTrackDto(trackName, 1, price);
        trackService.addTrack(newTrack);
        request.setAttribute("successAdding", "label.successAdding");
        return "WEB-INF/view/mainPage.jsp";
    }

}
