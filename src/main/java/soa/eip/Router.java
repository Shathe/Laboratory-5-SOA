package soa.eip;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Router extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:search")
			.to("twitter://search?consumerKey=PXeRHRonvGh6vpgixsWkUGTvH&"
					+ "consumerSecret=TefPRLLuKRycv6GgzUa5aZ1P1rtRyTMvbIfYq8S5mhLa77juKr&"
					+ "accessToken=325114315-oShji1k4caBgPy9YDV6Tqd8jfw1GCQwOafHydACX&"
					+ "accessTokenSecret=F1GMLHljHsSYvj4qZzjtivMXCrILpT1D4xXDDrEQio4u8");
	}

}
