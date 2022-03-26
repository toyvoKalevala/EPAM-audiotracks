package com.epam.audiotracks.tag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class MyTag extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
//        out.println("Hello Custom Tag!");
    }

}
