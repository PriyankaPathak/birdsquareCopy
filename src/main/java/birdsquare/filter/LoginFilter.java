package birdsquare.filter;


import com.google.code.facebookapi.FacebookXmlRestClient;
import com.google.code.facebookapi.IFacebookRestClient;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.w3c.dom.Document;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class LoginFilter extends GenericFilterBean {
    public static final String FACEBOOK_USER_CLIENT = "facebook.user.client";
    public static final String api_key = "454719261240892";
    private static final String secret = "745075547eca86a8c65fa082ed5cd486";
    private static final String SCOPE = "email,user_about_me,user_birthday,read_friendlists";
    private static final String REDIRECT_URI = "http://local.birdsquare.in:8080/home";
    private static final String DIALOG_OAUTH = "https://www.facebook.com/dialog/oauth";


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
        try {

            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;

//            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            response.sendRedirect(DIALOG_OAUTH+"? client_id="+api_key+ "&redirect_uri="+REDIRECT_URI+ "&scope="+SCOPE);
//            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

            HttpSession session = request.getSession(true);
            IFacebookRestClient<Document> userClient = getUserClient(session);
            if(userClient == null) {
                logger.debug("User session doesn't have a Facebook API client setup yet. Creating one and storing it in the user's session.");
                userClient = new FacebookXmlRestClient(api_key, secret);
                session.setAttribute(FACEBOOK_USER_CLIENT, userClient);
                System.out.println("@@@@@@@@@@@@@@@@@@@");
                System.out.println("appid: "+userClient.getApiKey());
                System.out.println("useId: "+userClient.getCacheUserId());
                System.out.println("@@@@@@@@@@@@@@@@@@@");
            }
//
////            logger.trace("Creating a FacebookWebappHelper, which copies fb_ request param data into the userClient");
//            FacebookWebappHelper<Document> facebook = new FacebookWebappHelper<Document>(request, response, api_key, secret, userClient);
//            String nextPage = request.getRequestURI();
//            nextPage = nextPage.substring(nextPage.indexOf("/", 1) + 1); //cut out the first /, the context path and the 2nd /
////            logger.trace(nextPage);
//            boolean redirectOccurred = facebook.requireLogin(nextPage);
//            if(redirectOccurred) {
//                return;
//            }
//            redirectOccurred = facebook.requireFrame(nextPage);
//            if(redirectOccurred) {
//                return;
//            }
//
//            long facebookUserID;
//
//            try {
//                facebookUserID = userClient.users_getLoggedInUser();
//            } catch(FacebookException ex) {
//                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while fetching user's facebook ID");
////                logger.error("Error while getting cached (supplied by request params) value " +
////                        "of the user's facebook ID or while fetching it from the Facebook service " +
////                        "if the cached value was not present for some reason. Cached value = {}", userClient.getCacheUserId());
//                logger.error("haha");
//                return;
//            }
//
////            MDC.put(facebookUserId, String.valueOf(facebookUserID));

            chain.doFilter(request, response);
        } finally {
//            MDC.remove(ipAddress);
//            MDC.remove(facebookUserId);
        }
    }

    public static FacebookXmlRestClient getUserClient(HttpSession session) {
        return (FacebookXmlRestClient)session.getAttribute(FACEBOOK_USER_CLIENT);
    }





    //{
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        Cookie[] cookies = request.getCookies();
//
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        if (isAnExcludeURL(request.getRequestURL().toString())) {
//            chain.doFilter(servletRequest, servletResponse);
//            return;
//        }
//        response.sendRedirect(String.format("%s/login", request.getContextPath()));
//    }
//
//    private boolean isAnExcludeURL(String requestURL) {
//        List<String> excludes = Arrays.asList("login", "javascript", "css", "jpeg", "jpg", "ico");
//        for (String exclude : excludes) {
//            if (requestURL.contains(exclude))
//                return true;
//        }
//        return false;
//    }
}
