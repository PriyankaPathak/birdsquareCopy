package birdsquare.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

public class LoginControllerTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private AnnotationMethodHandlerAdapter handlerAdapter;
    private LoginController controller;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        handlerAdapter = new AnnotationMethodHandlerAdapter();
        controller = new LoginController();
    }

//    @Test
//    public void shouldRenderHomePageAsLandingPage() throws Exception {
//        request.setRequestURI("/");
//        request.setMethod("GET");
//
//        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
//        assertViewName(mav, "home/login");
//    }

    @Test
    public void shouldRenderHomePageAfterClickingHomeButton() throws Exception {
        request.setRequestURI("/login");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "home/login");
    }

}