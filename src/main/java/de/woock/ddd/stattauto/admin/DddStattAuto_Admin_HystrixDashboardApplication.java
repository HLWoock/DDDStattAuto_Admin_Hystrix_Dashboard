package de.woock.ddd.stattauto.admin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.woock.ddd.stattauto.admin.steam.MockStreamServlet;

@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
@Controller
public class DddStattAuto_Admin_HystrixDashboardApplication extends SpringBootServletInitializer {

	
	@RequestMapping("/")
	public String home() {
		return "forward:/hystrix";
	}
	
	   @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(DddStattAuto_Admin_HystrixDashboardApplication.class).web(true);
	    }

	    public static void main(String[] args) {
	        new SpringApplicationBuilder(DddStattAuto_Admin_HystrixDashboardApplication.class).web(true).run(args);
	    }

	    @Bean
	    public ServletRegistrationBean mockStreamServlet() {
	        return new ServletRegistrationBean(new MockStreamServlet(), "/mock.stream");
	    }

}
