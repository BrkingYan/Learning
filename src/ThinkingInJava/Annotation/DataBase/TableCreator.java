package ThinkingInJava.Annotation.DataBase;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        /*if (args.length < 1){
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }*/

        //for (String className : args){
        String className = "ThinkingInJava.Annotation.DataBase.Student";
            Class<?> clazz = Class.forName(className);
            Table table = clazz.getAnnotation(Table.class);
            if (table != null){
                System.out.println("No Table annotations in class " + className);

            }
            String tableName = table.name();
            if (tableName.length() < 1){
                tableName = clazz.getName().toUpperCase();
            }
            List<String> columnFields = new ArrayList<>();
            for (Field field : clazz.getDeclaredFields()){
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length < 1){
                    continue;
                }
                if (annotations[0] instanceof SQLInteger){
                    SQLInteger sqlInteger = (SQLInteger)annotations[0];
                    if (sqlInteger.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sqlInteger.name();
                    }
                    columnFields.add(columnName + " INT" + getConstraints(sqlInteger.constraints()));
                }
                if (annotations[0] instanceof SQLString){
                    SQLString sqlString = (SQLString)annotations[0];
                    if (sqlString.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sqlString.name();
                    }
                    columnFields.add(columnName + " VARCHAR(" + sqlString.value() + ")" + getConstraints(sqlString.constraints()));
                }

                StringBuilder command = new StringBuilder("CREATE TABLE " + tableName + "(");
                for (String columnField : columnFields){
                    command.append("\n    " + columnField + ",");
                }
                String tableCreate = command.substring(0,command.length()-1) + ");";
                System.out.println("Table Creation SQL for " + className + " is : \n" + tableCreate);
            }
        //}
    }

    private static String getConstraints(Constraints con){
        StringBuilder sb = new StringBuilder();
        if (!con.allowNull()){
            sb.append(" NOT NULL");
        }
        if (con.isPrimaryKey()){
            sb.append(" PRIMARY KEY");
        }
        if (con.unique()){
            sb.append(" UNIQUE");
        }
        return sb.toString();
    }
}
