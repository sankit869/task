package apiservice;

public class FisdomService {
    public String payload(){
        String str = "{\n" +
                "    \"firstname\" : \"Test\",\n" +
                "    \"lastname\" : \"Automation\",\n" +
                "    \"totalprice\" : 1000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2020-05-01\",\n" +
                "        \"checkout\" : \"2020-05-03\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        return str;
    }
    public String payloadUpdate(){
        String str = "{\n" +
                "    \"firstname\" : \"Testing\",\n" +
                "    \"lastname\" : \"Automation Selenium\",\n" +
                "    \"totalprice\" : 10000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2020-05-02\",\n" +
                "        \"checkout\" : \"2020-05-04\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Dinner\"\n" +
                "}";
        return str;
    }
    public String payloadUpdatePartial(){
        String str = "{\n" +
                "    \"firstname\" : \"Test\",\n" +
                "    \"lastname\" : \"Automation\",\n" +
                "    \"totalprice\" : 10000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2020-05-02\",\n" +
                "        \"checkout\" : \"2020-05-04\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        return str;
    }
    public String authPaylod(){
        String auth = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        return auth;
    }
    public String payloadWithoutAdditionalneeds(){
        String str = "{\n" +
                "    \"firstname\" : \"Test\",\n" +
                "    \"lastname\" : \"Automation\",\n" +
                "    \"totalprice\" : 1000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2020-05-01\",\n" +
                "        \"checkout\" : \"2020-05-03\"\n" +
                "    }\n" +
                "}";
        return str;
    }


}
