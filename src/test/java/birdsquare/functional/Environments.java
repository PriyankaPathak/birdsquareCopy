package birdsquare.functional;

public class Environments {

    public static String getHomePageUrl() {

        String homePageUrlOverride = System.getenv("BS_HOME_PAGE_URL");

        if (homePageUrlOverride != null) {
            return homePageUrlOverride;
        }

        return "http://localhost:8080";
    }
}
