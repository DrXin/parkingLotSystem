package com.drx;

import org.springframework.web.context.ContextCleanupListener;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.DriverManager;
import java.sql.SQLException;

//@WebListener
public class AppContextListener extends ContextLoader implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
//        ServletContext servletContext = sce.getServletContext();
//        String realPath = servletContext.getRealPath("/");
//        System.setProperty("realPath",realPath);
        this.initWebApplicationContext(sce.getServletContext());
    }

    public void contextDestroyed(ServletContextEvent sce) {

//        this.closeWebApplicationContext(sce.getServletContext());
//        ContextCleanupListener.cleanupAttributes(sce.getServletContext());
        try {
            while(DriverManager.getDrivers().hasMoreElements()){
                DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
