package tungpzostar.springhibernatejsf;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.primefaces.webapp.filter.FileUploadFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SpringHibernateJsfApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateJsfApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] {SpringHibernateJsfApplication.class, Initializer.class});
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf", "*.xhtml");
		return servletRegistrationBean;
	}
	
	 @Bean
	    public FileUploadFilter fileUploadFilter() {
	        return new FileUploadFilter();
	}
	
	@Bean
	public FilterRegistrationBean facesUploadFilterRegistration() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(fileUploadFilter());
		registrationBean.setName("PrimeFaces FileUpload Filter");
		registrationBean.addServletNames("Faces Servlet");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setDispatcherTypes(DispatcherType.FORWARD);
		return registrationBean;
	}
	
	

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("primefaces.THEME", "Omega");
//		servletContext.setInitParameter("primefaces.THEME", "#{userSettings.currentTheme.name}");
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
		servletContext.setInitParameter("javax.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL",
				Boolean.TRUE.toString());
		servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING", Boolean.FALSE.toString());
		// servletContext.setInitParameter("com.sun.faces.expressionFactory",
		// "com.sun.el.ExpressionFactoryImpl");
		// Development
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Production");
		servletContext.setInitParameter("primefaces.UPLOADER", "commons");   
	}
	

}
