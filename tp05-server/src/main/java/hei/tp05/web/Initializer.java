package hei.tp05.web;

import hei.tp05.core.config.AppConfig;
import hei.tp05.core.config.DBConfig;
import hei.tp05.web.config.WSConfig;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by pic on 31/01/2017.
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { AppConfig.class, DBConfig.class, WSConfig.class };
    }


    protected Class<?>[] getServletConfigClasses() {
        //WebConfig.class
        return new Class<?>[] { };
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        ServletRegistration.Dynamic cfxServlet = servletContext.addServlet("cxfServlet", new CXFServlet());
        cfxServlet.addMapping("/services/*");
    }

    protected String[] getServletMappings() {
        return new String[0];
    }

}