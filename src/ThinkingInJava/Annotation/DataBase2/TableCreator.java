package ThinkingInJava.Annotation.DataBase2;

import ThinkingInJava.Exception.Throws.Throws;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class TableCreator {
    public static void main(String[] args) {
        String className = "ThinkingInJava.Annotation.DataBase2.Person";
        Class<?> annotatedClass = null;
        try {
            annotatedClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (annotatedClass == null){
            throw new NullPointerException("����ʧ��");
        }
        Table tableAnnotation = annotatedClass.getAnnotation(Table.class);

        if (tableAnnotation == null){
            throw new RuntimeException("No Table annotations in class");
        }
        
        /*
         * ���ɱ���
         * */
        String tableName = tableAnnotation.tableName();
        //�������Ϊ�գ������������Ĵ�д����
        if (tableName.length() < 1){
            tableName = annotatedClass.getName().toUpperCase();
        }

        /*
         * �鿴Student����Щ�ֶ�
         * �����������ֶΣ���ȡÿ���ֶε�ע��
         * */
        List<String> columnInfos = new ArrayList<>();
        for (Field field : annotatedClass.getDeclaredFields()){
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations.length < 1){
                continue;//������ֶ�û��ע�⣬�������ѯ��һλ
            }

            ColumnInfo columnInfo = (ColumnInfo) annotations[0];
            StringBuilder sb = new StringBuilder();
            String columnName = null;
            columnName = field.getName().toUpperCase();
            sb.append(columnName);
            switch (columnInfo.dataType()){
                case SQLSTRING:sb.append(" varchar(10)");
                    break;
                case SQLINTEGER:sb.append(" INT");
                    break;
                default:
                    break;
            }

            if (!columnInfo.allowNull()){
                sb.append(" NOT NULL");
            }
            if (columnInfo.isPrimaryKey()){
                sb.append(" PRIMARY KEY");
            }
            if (columnInfo.unique()){
                sb.append(" UNIQUE");
            }
            columnInfos.add(sb.toString());
        }
        StringBuilder command = new StringBuilder("CREATE TABLE " + tableName + "(");
        for (String columnField : columnInfos){
            if (columnField.equals(columnInfos.get(columnInfos.size()-1))){
                command.append("\n    " + columnField + "\n )ENGINE=InnoDB DEFAULT CHARSET=utf8");
            }else {
                command.append("\n    " + columnField + ",");
            }
        }
        System.out.println(command);
    }
}
