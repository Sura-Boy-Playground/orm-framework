package lk.ijse.dep.orm;

import lk.ijse.dep.orm.annotation.Column;
import lk.ijse.dep.orm.annotation.Entity;
import lk.ijse.dep.orm.annotation.Id;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Properties;

public class ORMUtil {

    public static void init(Properties dbProperties, Class... entities) {
        String username = dbProperties.getProperty("javax.persistence.jdbc.username");
        String password = dbProperties.getProperty("javax.persistence.jdbc.password");
        String url = dbProperties.getProperty("javax.persistence.jdbc.url");
        String driverClassName = dbProperties.getProperty("javax.persistence.jdbc.driver_class");

        if (username == null || password == null || url == null || driverClassName == null) {
            throw new RuntimeException("Unable to initialize ORM framework without user-name, password, url, and driver");
        }

        for (Class entity : entities) {
            Annotation entityAnnotation = entity.getDeclaredAnnotation(Entity.class);
            if (entityAnnotation == null) {
                throw new RuntimeException("Invalid entity class: " + entity.getName());
            }

            String ddl = "CREATE TABLE " + entity.getName() + " (\n";

            Field[] declaredFields = entity.getDeclaredFields();
            for (Field declaredField : declaredFields) {

                Column columnAnnotation = declaredField.getDeclaredAnnotation(Column.class);
                Id idAnnotation = declaredField.getDeclaredAnnotation(Id.class);

                if (columnAnnotation != null) {
                    String columnName = (columnAnnotation.name().trim().isEmpty()) ? declaredField.getName() : columnAnnotation.name();
                    String columnDef = null;
                    if (declaredField.getType() == String.class) {
                        columnDef = "VARCHAR(255)";
                    } else if (declaredField.getType() == int.class || declaredField.getType() == long.class ||
                            declaredField.getType() == short.class) {
                        columnDef = "INT";
                    }else if (declaredField.getType() == double.class || declaredField.getType() == float.class ||
                    declaredField.getType() == BigDecimal.class){
                        columnDef = "DECIMAL";
                    }else if (declaredField.getType() == boolean.class){
                        columnDef = "BOOLEAN";
                    }else{
                        throw new RuntimeException("Invalid data type; Supported Data Types are String, BigDecimal and primitive data types");
                    }
                    ddl += columnName + " " + columnDef;

                    if (idAnnotation != null){
                        ddl += " PRIMARY KEY";
                    }
                    ddl += ",\n";
                }
            }

            ddl += ");";
        }
    }

}
