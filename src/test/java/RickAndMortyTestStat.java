import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.Rest;

public class RickAndMortyTestStat {
    static JSONObject jsonObject=null;
    @BeforeClass
    public static void bc(){
       if(Rest.getStatusCode("https://rickandmortyapi.com/api")==200){
           jsonObject=new JSONObject(Rest.getRest("https://rickandmortyapi.com/api"));
       }
    }

    @Test
    public void test1(){
        Assert.assertEquals(200,Rest.getStatusCode(jsonObject.getString("characters")));
    }
    @Test
    public void test2(){
        Assert.assertEquals(200,Rest.getStatusCode(jsonObject.getString("locations")));
    }
    @Test
    public void test3(){
        Assert.assertEquals(200,Rest.getStatusCode(jsonObject.getString("episodes")));
    }

}
