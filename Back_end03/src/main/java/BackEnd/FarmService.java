package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;

@SuppressWarnings("unused")
@ApplicationPath("/")
public class FarmService {
	@GET
	@Path("/farms")
	@Produces("application/json")
	public ArrayList<Farm> getAllFarms() {
		ArrayList<Farm> lst = new ArrayList<Farm>();
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"+ "databaseName=SmartFarms;";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl, "SA", "123456");
			String SQL = "select * from dbo.Farm"; // TEN BANG TRONG CSDL
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			System.out.println("===Assets====");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String imageURL = rs.getString("imageURL");
				lst.add(new Farm(id, name, description, imageURL));

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
	public ArrayList<Farm> AddFarm(Farm new_farm) {
		ArrayList<Farm> lst = new ArrayList<Farm>();
		lst.add(new Farm(1, "Farm A", "abcd", "hinhanh1.jpg"));
		lst.add(new Farm(2, "Farm B", "abce", "hinhanh2.jpg"));
		lst.add(new_farm);
		System.out.println("create successfully");
		return lst;
	}
}
