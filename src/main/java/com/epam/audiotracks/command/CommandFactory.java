package com.epam.audiotracks.command;

import com.epam.audiotracks.command.locale.ChangeLocaleCommandBy;
import com.epam.audiotracks.command.locale.ChangeLocaleCommandEng;
import com.epam.audiotracks.command.locale.ChangeLocaleCommandRu;
import com.epam.audiotracks.command.track.*;
import com.epam.audiotracks.command.user.*;
import com.epam.audiotracks.dao.DaoHelperFactory;
import com.epam.audiotracks.service.order.OrderServiceImpl;
import com.epam.audiotracks.service.user.UserServiceImpl;
import com.epam.audiotracks.service.track.TrackServiceImpl;

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
            case "logout":
                return new LogoutCommand();
            case "goOnMain":
                return new GoOnMainCommand();
            case "userManagement":
                return new UserManagementCommand(new UserServiceImpl(new DaoHelperFactory()));
            case "changeDiscount":
                return new ChangeDiscountCommand(new UserServiceImpl(new DaoHelperFactory()));
            case "selectTracks":
                return new SelectTracksCommand(new TrackServiceImpl(new DaoHelperFactory()));
            case "userOrders":
                return new UserOrdersCommand(new UserServiceImpl(new DaoHelperFactory()));
            case "userTracks":
                return new UserTracksCommand(new UserServiceImpl(new DaoHelperFactory()));
            case "orderTrack":
                return new OrderTrackCommand(new OrderServiceImpl(new DaoHelperFactory()));
            case "payForTracks":
                return new PayForTracksCommand(new OrderServiceImpl(new DaoHelperFactory()));
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }
}
