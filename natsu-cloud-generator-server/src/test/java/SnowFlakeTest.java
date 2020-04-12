import com.natsucloud.common.utils.SnowFlake;

public class SnowFlakeTest {

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            long id = SnowFlake.generateId();
            long id2 = SnowFlake.generateId();
            System.out.println("数字1:"+id);
            System.out.println("数字2:"+id2);
        }
    }
}
