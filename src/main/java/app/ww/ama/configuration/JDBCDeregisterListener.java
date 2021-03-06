package app.ww.ama.configuration;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JDBCDeregisterListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while(drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			try {
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e) {
				System.err.println("Error deregistering driver: " + driver.getClass().getName());
			}
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}
