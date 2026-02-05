package test.yhTest;

import entity.People;

import java.lang.reflect.Field;

import static org.apache.ibatis.ognl.OgnlOps.convertValue;
import static sun.reflect.misc.FieldUtil.getField;

public class Md5Test {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(l);



        long ooooo = 1765764572670l;
        Double pppppp = 1765764572670D;

        System.out.println(ooooo==pppppp);
    }

    public static void setFieldValueByReflect(People people, String fieldName, Object value) {
        try {
            if (people == null || fieldName == null || value == null) {
                throw new IllegalArgumentException("参数不能为空");
            }
            Field field = getField(people.getClass(), fieldName);
            if (field == null) {
                throw new NoSuchFieldException("字段 " + fieldName + " 不存在");
            }
            // 设置字段可访问
            field.setAccessible(true);
            // 根据字段类型进行类型转换
            Class<?> type = field.getType();
            Object convertedValue = convertValue(value, type);

            // 设置字段值
            field.set(people, convertedValue);
        } catch (Exception e) {
            System.out.println("errorrrrrrrrrrrrrrrrrr");
        }
    }
}
