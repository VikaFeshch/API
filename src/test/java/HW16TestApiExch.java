import data.TypeCurrency;
import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.Rest;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HW16TestApiExch {

    static JSONArray jsonArray;
    TypeCurrency typeCur;

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList(TypeCurrency.values());
    }


    public HW16TestApiExch(TypeCurrency typeCur) {
        this.typeCur = typeCur;
        jsonArray = new JSONArray(Rest.getRest("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=" + typeCur.name() + "&json"));
    }

    @Test
    public void test1PrnForTypeCur() {
        System.out.println(jsonArray.getJSONObject(0).getString("cc") + " " + jsonArray.getJSONObject(0).getDouble("rate"));
    }
}
