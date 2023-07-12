import com.fasterxml.jackson.databind.ObjectMapper;
import jsonObj.Episode.Episode;
import jsonObj.Episode.Result;
import org.junit.Test;
import rest.Rest;

import java.io.IOException;

public class HW17RickAndMortyApiTestEpisode {

    @Test
    public void test1() throws IOException {
        ObjectMapper om = new ObjectMapper();
        Episode episode =om.readValue(Rest.getRest("https://rickandmortyapi.com/api/episode"),Episode.class);
        do{
            for (Result l: episode.results){
                System.out.print(l.name+" -> "+l.air_date);
                System.out.println();
            }
            if(episode.info.next!=null){
                episode=om.readValue(Rest.getRest(episode.info.next),Episode.class);
            } else {
                break;
            }
        }while (true);
    }
}
