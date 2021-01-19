package lk.ijse.dep.orm;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class ORMUtilTest {

    @Test
    public void init() {
        ORMUtil.init(new Properties(), Customer.class, Item.class);
    }
}
