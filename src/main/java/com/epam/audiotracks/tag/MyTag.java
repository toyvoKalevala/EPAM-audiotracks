package com.epam.audiotracks.tag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTag extends SimpleTagSupport {

    private String dateTimeFormat;

    public void setDateTimeFormat(String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    public void doTag() throws IOException {

        JspWriter out = getJspContext().getOut();
        Date date = new Date();

        if (dateTimeFormat.equals("ruBy")) {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            out.println(dateFormat.format(date));
        } else if (dateTimeFormat.equals("eng")) {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            out.println(dateFormat.format(date));
        }
    }

}
