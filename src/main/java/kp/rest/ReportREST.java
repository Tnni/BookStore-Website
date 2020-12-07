package kp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import kp.model.Models;

@Path("report") // this is the path of the resource
public class ReportREST {

	@GET
	@Path("/monthly/")
	@Produces("text/xml")
	public String getReport(@QueryParam("reportMonth") String month) throws Exception {
		if(month.matches("^[012]?[0-9]$"))
			month = "2020-"+month;
        return Models.getInstance().restReport(month);
		//return "getReport:"+month;
	}

	@GET
	@Path("/top10/")
	@Produces("text/xml")
	public String getTop10() throws Exception {
        return Models.getInstance().restTop10();
		//return "getTop10";
	}

}