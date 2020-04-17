import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CoreTest {

    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data", LocalDate.now());
        map.put("sss", LocalDateTime.now());

        for(Map.Entry<String,Object> model : map.entrySet()){
            String key = model.getKey();

            String Value = model.getValue().getClass().getTypeName();

            map.put("data","sdsdsds");

        }
    }

}
