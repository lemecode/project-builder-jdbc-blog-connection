package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	public Connection getConnection() throws SQLException, IOException, ClassNotFoundException {

		Properties prop = loadPropertiesFile();
		Connection con = null;

		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String driver = prop.getProperty("driver");

		Class.forName(driver);
		con = DriverManager.getConnection(url, username, password);

		return con;
	}

	public static Properties loadPropertiesFile() throws IOException {

		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;

	}

}
