package ThinkingInJava.Annotation.DataBase;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class TableCreator {

    private MysqlConnector connector;


    String createTableString(){
        //for (String className : args){
        String className = "ThinkingInJava.Annotation.DataBase.Student";
        Class<?> annotatedClass = null;//获取Student的Class对象
        annotatedClass = getClazz(className);

        Table tableAnnotation = (Table) getClassTableAnnotation(annotatedClass);//获取Table类型的注解

        if (tableAnnotation == null){
            throw new RuntimeException("No Table annotations in class");
        }
        /*
        * 生成表名
        * */
        String tableName = tableAnnotation.name();
        //如果表名为空，表名用类名的大写代替
        if (tableName.length() < 1){
            tableName = annotatedClass.getName().toUpperCase();
        }

        /*
        * 查看Student有哪些字段
        * 并遍历所有字段，获取每个字段的注解
        * */
        List<String> columnFields = new ArrayList<>();
        for (Field field : annotatedClass.getDeclaredFields()){
            String columnName = null;
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations.length < 1){
                continue;//如果该字段没有注解，则继续查询下一位
            }
            //调查字段拥有的注解类型，也就是间接查询字段类型
            if (annotations[0] instanceof SQLInteger){
                SQLInteger intAnnotation = (SQLInteger)annotations[0];
                //如果注解的name()为默认值，就用字段名的大写代替
                if (intAnnotation.name().length() < 1){
                    columnName = field.getName().toUpperCase();
                }else {
                    columnName = intAnnotation.name();
                }
                columnFields.add(columnName + " INT" + getConstraints(intAnnotation.constraints()));
            }
            if (annotations[0] instanceof SQLString){
                SQLString stringAnnotation = (SQLString)annotations[0];
                if (stringAnnotation.name().length() < 1){
                    columnName = field.getName().toUpperCase();
                }else {
                    columnName = stringAnnotation.name();
                }
                columnFields.add(columnName + " VARCHAR(" + stringAnnotation.value() + ")" +
                        getConstraints(stringAnnotation.constraints()));
            }
        }
        StringBuilder command = new StringBuilder("CREATE TABLE " + tableName + "(");
        for (String columnField : columnFields){
            if (columnField.equals(columnFields.get(columnFields.size()-1))){
                command.append("\n    " + columnField + "\n )ENGINE=InnoDB DEFAULT CHARSET=utf8");
            }else {
                command.append("\n    " + columnField + ",");
            }
        }
        //System.out.println("Table Creation SQL for " + className + " is : \n" + command.toString());
        return command.toString();
    }

    private Class<?> getClazz(String className){
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    private Annotation getClassTableAnnotation(Class<?> type){
        Table tableAnnotation = type.getAnnotation(Table.class);
        if (tableAnnotation != null){
            return type.getAnnotation(Table.class);
        }
        throw new NullPointerException("No Table annotations in class " + type.getSimpleName());
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
