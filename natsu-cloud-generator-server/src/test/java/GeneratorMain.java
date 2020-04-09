import com.natsucloud.generator.service.GenerateConfig;
import com.natsucloud.generator.service.GeneratorService;

import java.io.File;

public class GeneratorMain {

    public static void main(String[] args) {
        String outputDir = System.getProperty("user.dir") + File.separator + "natsu-cloud-generator-server";
        GenerateConfig config = new GenerateConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/demo?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        config.setJdbcUserName("root");
        config.setJdbcPassword("123456");
        config.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        config.setAuthor("moQiShu");
        config.setParentPackage("com.natsucloud");
        config.setModuleName("appshop");
        config.setIncludeTables(new String[]{"appshop_order"});
        config.setTablePrefix(new String[]{"appshop_"});
        config.setOutputDir(outputDir);
        GeneratorService.execute(config);
    }

}
