import com.fasterxml.jackson.databind.ObjectMapper;
import jsonObj.Characters.Characters;
import jsonObj.Location.Location;
import jsonObj.Location.Result;
import org.json.JSONObject;
import org.junit.Test;
import rest.Rest;

import java.io.IOException;

public class RackAndMortyTestLocation {
    @Test
    public void test1() throws IOException {
        ObjectMapper om = new ObjectMapper();
        Location location=om.readValue(Rest.getRest("https://rickandmortyapi.com/api/location"),Location.class);
        do{
            for (Result l: location.results){
                System.out.print(l.name+" = "+l.type+": ");
                for (String resident : l.residents) {
                    System.out.print(new JSONObject(Rest.getRest(resident)).getString("name")+" ");
                }
                System.out.println();
            }
            if(location.info.next!=null){
                location=om.readValue(Rest.getRest(location.info.next),Location.class);
            }
        }while (location.info.next!=null);
    }

}
