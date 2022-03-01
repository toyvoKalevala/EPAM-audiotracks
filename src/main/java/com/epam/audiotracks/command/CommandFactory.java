package com.epam.audiotracks.command;

import com.epam.audiotracks.dao.DaoHelperFactory;
import com.epam.audiotracks.service.UserServiceImpl;

public class CommandFactory {

    public Command createCommand(String command) {
        switch (command) {
            case "login":
                return new LoginCommand(new UserServiceImpl(new DaoHelperFactory()));
            case "changeLocale_ru":
                return new ChangeLocaleCommandRu();
            case "changeLocale_eng":
                return new ChangeLocaleCommandEng();
            case "changeLocale_by":
                return new ChangeLocaleCommandBy();
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }
}
