package online.shixun.hpeu.filter;

/*import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class FilterServlet implements Filter {

  
	public void destroy() {
		// TODO Auto-generated method stub
	}

	*//**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 *//*
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  httpServletRequest=(HttpServletRequest)request;
		
		String requestURI=httpServletRequest.getRequestURI();
		HttpSession session=httpServletRequest.getSession();
		if(requestURI.contains("login.jsp")){
			chain.doFilter(request, response);
		}else{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}	
	}

	*//**
	 * @see Filter#init(FilterConfig)
	 *//*
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}*/

