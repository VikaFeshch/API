import data.TypeCurrency;
import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.Rest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HW16TestApiExchDraft {

    static JSONArray jsonArray;
    TypeCurrency typeCur;
//    TypeCur typeCur;

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList(TypeCurrency.values());
    }


    public HW16TestApiExchDraft(TypeCurrency typeCur) {
        this.typeCur = typeCur;
        System.out.println("&&&&&&"+typeCur.name());
        jsonArray = new JSONArray(Rest.getRest("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=" + typeCur.name() + "&json"));
        System.out.println(jsonArray);
     /*   Iterator<String> iterator = typeCurrentcy.getKeys().asIterator();
        while (iterator.hasNext()) {
            jsonArray = new JSONArray(Rest.getRest("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=" + iterator.next() + "&json"));
            System.out.println(jsonArray.get(0));
//            System.out.println(")))))"+iterator.next());
        }*/

    }

    @Test
    public void test1PrnForIndex() {
        System.out.println(jsonArray.getJSONObject(0).getString("cc") + " " + jsonArray.getJSONObject(0).getDouble("rate"));
    }
}
