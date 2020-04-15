import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.natsucloud.generator.service.GenerateConfig;
import com.natsucloud.generator.service.GeneratorService;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.Scanner;

public class GeneratorMain {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        String outputDir = System.getProperty("user.dir") + File.separator + "natsu-cloud-base-server/src/main/java";
        GenerateConfig config = new GenerateConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:5831/natsucloud?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        config.setJdbcUserName("root");
        config.setJdbcPassword("Keytop:wabjtam!");
        //config.setJdbcPassword("123456");
        config.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        config.setAuthor("moqishu");
        config.setParentPackage("com.natsucloud");
        //config.setModuleName("appshop");
        config.setModuleName(scanner("模块名"));
        //config.setIncludeTables(new String[]{"appshop_order"});
        config.setIncludeTables(scanner("表名，多个英文逗号分割").split(","));
        // 去掉表前缀
        //config.setTablePrefix(new String[]{"t_"});例如:t_carcome=TCarcome去掉Carcome
        config.setTablePrefix(scanner("表名前缀去除").split(","));
        config.setOutputDir(outputDir);
        // xml路径
        String xmlPath = System.getProperty("user.dir") + File.separator + "natsu-cloud-base-server/src/main/resources/mapper";
        config.setXmlPath(xmlPath);
        config.setServiceClassNameStartWithI(true);
        GeneratorService.execute(config);
    }

}
