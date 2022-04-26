package com.epam.audiotracks.service.assembly;

import com.epam.audiotracks.entity.Assembly;
import com.epam.audiotracks.exeption.ServiceException;

import java.util.List;

public interface AssemblyService {

    void addAssembly(String name) throws ServiceException;

    List<Assembly> getAllAssemblies() throws ServiceException;

    void addTrackToAssembly(int trackId, int assemblyId) throws ServiceException;

}
