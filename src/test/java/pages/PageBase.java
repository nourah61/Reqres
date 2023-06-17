package pages;

import io.restassured.response.Response;

public class PageBase {
    // check Response Status Code
    public static boolean checkResponseStatusCode(Response resp,int statusCode){
        if(resp.getStatusCode()==statusCode)
            return true;
        else return false;
    }
}
