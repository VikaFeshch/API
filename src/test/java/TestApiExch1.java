import com.fasterxml.jackson.databind.ObjectMapper;
import jsonObj.Exchange;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.Rest;

import java.io.IOException;

public class TestApiExch1 {
    static Exchange[] exchanges;
    @BeforeClass
    public static void tt() throws IOException {
        ObjectMapper om = new ObjectMapper();
        exchanges = om.readValue(Rest.getRest("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json"),Exchange[].class);

    }
    @Test
    public void test1PrnForIndex(){
        System.out.println(exchanges[0].cc+" "+exchanges[0].rate);
    }
    @Test
    public void test2PrnAll(){
        for (Exchange l:exchanges){
            System.out.println(l.cc + " " + l.rate);
        }
    }
}
