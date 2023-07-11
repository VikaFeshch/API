import com.fasterxml.jackson.databind.ObjectMapper;
import image.ImageDownload;
import jsonObj.Characters.Characters;
import jsonObj.Characters.Result;
import org.json.JSONObject;
import org.junit.Test;
import rest.Rest;

import java.io.IOException;

public class RickAndMortyTestCharacters {

    @Test
    public void printAllAlive() throws IOException {
        ObjectMapper om = new ObjectMapper();
        Characters characters=om.readValue(Rest.getRest("https://rickandmortyapi.com/api/character"),Characters.class);
        do{
            for (Result l:characters.results){
                if(l.status.equals("Alive")){
                    System.out.println(l.name);
                }
            }
            if(characters.info.next!=null){
                characters=om.readValue(Rest.getRest(characters.info.next),Characters.class);
            }
        }while (characters.info.next!=null);
    }
    @Test
    public void printAllAlive2() throws IOException {
        ObjectMapper om = new ObjectMapper();

        int amount = new JSONObject(Rest.getRest("https://rickandmortyapi.com/api/character")).getJSONObject("info").getInt("pages");
        for (int i = 1; i<amount; i++){
            Characters characters=om.readValue(Rest.getRest("https://rickandmortyapi.com/api/character?page="+i),Characters.class);
            for(Result l:characters.results){
                if(l.status.equals("Alive")){
                    System.out.println(l.name+" "+l.origin.name);
                }
            }
        }
    }

    @Test
    public void downLoadImDead() throws IOException {
        ObjectMapper om = new ObjectMapper();
        Characters characters=om.readValue(Rest.getRest("https://rickandmortyapi.com/api/character"),Characters.class);
        do{
            for (Result l:characters.results){
                if(l.status.equals("Dead")){
                    ImageDownload.domnloadIm(l.image,l.name);
                }
            }
            if(characters.info.next!=null){
                characters=om.readValue(Rest.getRest(characters.info.next),Characters.class);
            }
        }while (characters.info.next!=null);
    }
}
