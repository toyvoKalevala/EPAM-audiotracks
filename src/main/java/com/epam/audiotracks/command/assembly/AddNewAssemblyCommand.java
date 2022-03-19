package com.epam.audiotracks.command.assembly;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.album.AlbumService;
import com.epam.audiotracks.service.assembly.AssemblyService;
import com.epam.audiotracks.service.assembly.AssemblyServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewAssemblyCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private final AssemblyService assemblyService;

    public AddNewAssemblyCommand(AssemblyServiceImpl assemblyService) {
        this.assemblyService = assemblyService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String assemblyName = request.getParameter("assemblyName");
        assemblyService.addAssembly(assemblyName);
        request.setAttribute("assemblyAdded", "label.assemblyAdded");
        return "controller?command=selectTracks";
    }

}
