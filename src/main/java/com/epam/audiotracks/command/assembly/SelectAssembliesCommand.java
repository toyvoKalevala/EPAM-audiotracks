package com.epam.audiotracks.command.assembly;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.entity.Album;
import com.epam.audiotracks.entity.Assembly;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.assembly.AssemblyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SelectAssembliesCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private final AssemblyService assemblyService;

    public SelectAssembliesCommand(AssemblyService assemblyService) {
        this.assemblyService = assemblyService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<Assembly> assemblies = assemblyService.getAllAssemblies();
        request.setAttribute("assemblies", assemblies);
        return "WEB-INF/view/pages/mainPage.jsp";
    }

}
