package com.epam.audiotracks.command.assembly;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.assembly.AssemblyService;
import com.epam.audiotracks.service.assembly.AssemblyServiceImpl;
import com.epam.audiotracks.service.track.TrackService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTrackToAssemblyCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private final AssemblyService assemblyService;

    public AddTrackToAssemblyCommand(AssemblyServiceImpl assemblyService) {
        this.assemblyService = assemblyService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        int trackId = Integer.parseInt(request.getParameter("trackId"));
        int assemblyId = Integer.parseInt(request.getParameter("assemblyId"));
        assemblyService.addTrackToAssembly(trackId, assemblyId);
        request.setAttribute("successAdding", "label.successAdding");
        return "/controller?command=selectTracks";
    }

}
