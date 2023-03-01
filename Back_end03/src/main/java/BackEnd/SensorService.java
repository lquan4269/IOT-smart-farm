package BackEnd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@ApplicationPath("/")
public class SensorService {
	
	@GET
	@Path("/sensor")
	@Produces("application/json")
	public ArrayList<SensorData> getAllSensorData() {
		ArrayList<SensorData> lst = new ArrayList<SensorData>();
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"+ "databaseName=SmartFarms;";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl, "SA", "123456");
			String SQL = "select * from dbo.SensorData"; // TEN BANG TRONG CSDL
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			System.out.println("===Assets====");
			while (rs.next()) {
				int id = rs.getInt("id");
				String SensorKeyName = rs.getString("SensorKeyName");
				String AttributeName = rs.getString("AttributeName");
				String Value = rs.getString("Value");
				Date TimeAt = rs.getDate("TimeAt");
				int Assetid = rs.getInt("Assetid");
				lst.add(new SensorData(id, SensorKeyName, AttributeName, Value, TimeAt, Assetid ));

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return lst;
	}

	@POST
	@Path("/create")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces("application/json")
	public ArrayList<SensorData> AddSensor(SensorData new_SensorData) {
		ArrayList<SensorData> lst = new ArrayList<SensorData>();
		lst.add(new_SensorData);
		System.out.println("create successfully");
		return lst;
	}
}
