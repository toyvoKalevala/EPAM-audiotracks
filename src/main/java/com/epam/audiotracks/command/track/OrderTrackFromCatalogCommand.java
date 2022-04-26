package com.epam.audiotracks.command.track;

import com.epam.audiotracks.command.Command;
import com.epam.audiotracks.entity.Order;
import com.epam.audiotracks.entity.User;
import com.epam.audiotracks.exeption.ServiceException;
import com.epam.audiotracks.service.order.OrderService;
import com.epam.audiotracks.service.order.OrderServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderTrackFromCatalogCommand implements Command {

    private static final Logger logger = LogManager.getLogger();

    private final OrderService orderService;

    public OrderTrackFromCatalogCommand(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        User user = (User) request.getSession().getAttribute("user");
        int trackId = Integer.parseInt(request.getParameter("trackId"));
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = format.format(date);
        Order order = new Order(user.getId(), trackId, false, dateTime);
        orderService.createOrder(order);
        request.setAttribute("trackIsOrdered", "label.trackIsOrdered");
        request.setAttribute("redirect", "true");
        return "controller?command=trackCatalog";
    }

}
