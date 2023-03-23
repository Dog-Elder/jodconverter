package com.xxxxx.jodconverter;

import com.sun.star.awt.Size;
import com.sun.star.beans.PropertyValue;
import com.sun.star.lang.XComponent;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.view.PaperFormat;
import com.sun.star.view.XPrintable;
import org.jodconverter.core.office.OfficeContext;
import org.jodconverter.local.filter.Filter;
import org.jodconverter.local.filter.FilterChain;

public class MyFilter implements Filter {
    @Override
    public void doFilter(OfficeContext context, XComponent document, FilterChain chain) throws Exception {
        XPrintable xPrintable = UnoRuntime.queryInterface(XPrintable.class, document);
        PropertyValue[] props = new PropertyValue[2];

        PropertyValue p1 = new PropertyValue();
        p1.Name = "PaperFormat";
        p1.Value = PaperFormat.USER;
        props[0] = p1;

        PropertyValue p2 = new PropertyValue();
        p2.Name = "PaperSize";
        p2.Value = new Size(90000, 120000);  // width,height
        props[1] = p2;

        xPrintable.setPrinter(props);
        chain.doFilter(context, document);
    }
}