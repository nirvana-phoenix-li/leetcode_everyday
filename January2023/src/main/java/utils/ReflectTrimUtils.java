package utils;

import cn.hutool.core.util.ReflectUtil;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class ReflectTrimUtils {

    /**
     * String类型 CanonicalName
     */
    private static final String STRING_TYPE_NAME = "java.lang.String";

    public static void trimData(Object object) {
        // 获取实体中所有属性字段
        Field[] fields = ReflectUtil.getFields(object.getClass());
        for (Field field : fields) {
            // 获取属性字段类型
            String canonicalName = field.getType().getCanonicalName();
            // 如果字段是String类型,则去除此字段数据的空格
            if (STRING_TYPE_NAME.equals(canonicalName)) {
                // 获取字段值
                String fieldValue = (String) ReflectUtil.getFieldValue(object, field);
                if (StringUtils.isNotBlank(fieldValue)) {
                    // 去掉换行
                    String fieldValueStr = fieldValue.replaceAll("\r|\n| ", "");
                    // 将去除空格后的数据 替换 原数据
                    ReflectUtil.setFieldValue(object, field, fieldValueStr.trim());
                } else {
                    // 将去除空格后的数据 替换 原数据
                    ReflectUtil.setFieldValue(object, field, null);
                }
            }
        }
    }
}
