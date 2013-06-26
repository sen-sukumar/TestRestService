package com.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.OracleDao;
@Path("/MyServices")
public class Services {
	@GET
	@Produces("text/plain")
	public String getName(){
		return "sukumar sen";
	}
	@GET
	@Path("/subpath")
	public String getVersion(){
		return "version 1.2.3";
	}
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getDatabaseStatus()throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		String returnString = null;
		try{
			conn = OracleDao.getDataSource().getConnection();
			ps = conn.prepareStatement("select to_char(sysdate, 'yyyy-MM-dd HH24:MI:SS') DATETIME from sys.dual");
			rs = ps.executeQuery();
			if(rs.next()){
				String myString = rs.getString("DATETIME");
				returnString = "<p>Database Status</p>" + "<p>Database Date/Time return: " + myString + "</p>";
			}
			
		}
		catch(Exception e){
			
		}
		finally{
			if(conn != null) conn.close();
		}
		return returnString;
	}
}
