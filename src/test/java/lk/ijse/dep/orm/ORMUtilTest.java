package lk.ijse.dep.orm;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

public class ORMUtilTest {

    private static Properties properties = new Properties();

    @BeforeClass
    public static void beforeClass() throws Exception {
        properties.load(ORMUtilTest.class.getResourceAsStream("/application.properties"));
    }

    @Test
    public void init() {
        ORMUtil.init(properties, Customer.class, Item.class);
    }
}
