package test.importantTest;

import products.easyExcel.EasyExcelExportUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EasyExcelTest {
    public static void main(String[] args) throws IOException {
        //1.设置动态表头
        List<String> heads = new ArrayList<>();
        heads.add("第一个头");
        heads.add("第二个头");

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1= new LinkedHashMap<>();
        map1.put("第一个头","AAA");
        map1.put("第二个头","BBB");
        list.add(map1);

        Map<String, Object> map2= new LinkedHashMap<>();
        map2.put("第一个头","ccc");
        map2.put("第二个头","ddd");
        list.add(map2);

        EasyExcelExportUtils.easyUtil("导出excel的文件名",heads,list);

    }
}
