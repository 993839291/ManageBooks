package cn.lightina.managebooks.filter;



import cn.lightina.managebooks.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebFilter(filterName = "ApiFilter", urlPatterns = "/managebooks/*")
public class ApiFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(ApiFilter.class);

    protected static List<String> exceptValidateUrls = new ArrayList<>();

    static{
        exceptValidateUrls.add("/managebooks/login");
        exceptValidateUrls.add("/managebooks/detail");
        exceptValidateUrls.add("/managebooks/addUserInfo");
    }





    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String reqUrl = req.getServletPath();
        if(!exceptValidateUrls.contains(reqUrl)){
            User user = (User) req.getSession().getAttribute("user");
            if(user==null){
                res.sendRedirect("/managebooks/login");
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}

