package birdsquare.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

public class HomeControllerTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private AnnotationMethodHandlerAdapter handlerAdapter;
    private HomeController controller;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        handlerAdapter = new AnnotationMethodHandlerAdapter();
        controller = new HomeController();
    }


    @Test
    public void shouldRenderHomePageAsLandingPage() throws Exception {
        request.setRequestURI("/");
        request.setMethod("GET");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "home/home");
    }

    @Test
    public void shouldRenderHomePageAfterClickingHomeButton() throws Exception {
        request.setRequestURI("/home");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "home/home");
    }

    @Test
    public void shouldRenderCheckInPageAfterClickingCheckInButtonFromHomePage() throws Exception {
        request.setRequestURI("/checkinlocations");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "checkin/checkinlocations");
    }

    @Test
    public void shouldRenderSearchPageAfterClickingSearchButton() throws Exception {
        request.setRequestURI("/search");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "search/search");
    }

    @Test
    public void shouldRenderProfilePageAfterClickingProfileButton() throws Exception {
        request.setRequestURI("/profile");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "profile/profile");
    }



}