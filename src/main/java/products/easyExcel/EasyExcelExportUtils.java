package products.easyExcel;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 导出工具类：可以通过easyUtil方法进行导出
 */
public class EasyExcelExportUtils {


    /**
     * [response, fileName:文件名称, heads：excel表头, list：数据体]
     */
    public static void easyUtil(String fileName, List<String> heads, List<Map<String, Object>> list)
            throws IOException {

        if (StringUtils.isEmpty(fileName)) { //文件名称也可以动态获取
            fileName = System.currentTimeMillis() + ".xlsx";
        } else {
            fileName = fileName + ".xlsx";
        }

        if (heads == null || heads.size() == 0) {
            heads = makeHeads();
        }
        if (list == null || list.size() == 0) {
            list = makeData();
        }
        // 调用responseInfo方法
//        OutputStream os = responseInfo(response, fileName);
        OutputStream os = new FileOutputStream(fileName);

        List<List<String>> hs = new ArrayList<>();
        for (String s : heads) {
            hs.add(Arrays.asList(s));
        }
        List<List<Object>> list2 = new ArrayList<>();
        for (Map<String, Object> map : list) {
            List<Object> objects = new ArrayList<>();
            for (String head : heads) {
                Object value = map.get(head);
                if (value != null) {
                    objects.add(value.toString());
                } else {
                    objects.add(null);
                }
            }
            list2.add(objects);
        }
        EasyExcel.write(os).head(hs).sheet("导出的excel文件名称").doWrite(list2);
        System.out.println("导出成功");
    }


    public static void easyUtil(HttpServletResponse response, String fileName, List<String> heads, List<Map<String, Object>> list)
            throws IOException {

        if (StringUtils.isEmpty(fileName)){ //文件名称也可以动态获取
            fileName = System.currentTimeMillis() + ".xlsx";
        } else {
            fileName = fileName + ".xlsx";
        }

        if(heads == null || heads.size() == 0){
            heads = makeHeads();
        }
        if(list == null || list.size() == 0){
            list = makeData();
        }
        // 调用responseInfo方法
        OutputStream os= responseInfo(response, fileName);

        List<List<String>> hs = new ArrayList<>();
        for (String s : heads) {
            hs.add(Arrays.asList(s));
        }
        List<List<Object>> list2 = new ArrayList<>();
        for (Map<String, Object> map : list) {
            List<Object> objects = new ArrayList<>();
            for (String head : heads) {
                Object value = map.get(head);
                if (value != null){
                    objects.add(value.toString());
                }else {
                    objects.add(null);
                }
            }
            list2.add(objects);
        }
        EasyExcel.write(os).head(hs).sheet("导出的excel文件名称").doWrite(list2);
        System.out.println("导出成功");
    }


    private static List<String> makeHeads() {

        return null;
    }

    private static List<Map<String, Object>> makeData() {

        return null;
    }


    /**
     * 功能：公用方法，写回浏览器
     */
    public static OutputStream responseInfo(HttpServletResponse response, String fileName) throws IOException {
        // 这里注意有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment; filename*=utf-8''" + fileName);
        OutputStream os = response.getOutputStream();
        return os;
    }

    /**
     * 如果要兼容swagger用这个，上面的注释掉
     * 功能：公用方法
     * 参数：fileName 文件名称, 如：123.xlsx

     public static OutputStream responseInfo(HttpServletResponse response, String fileName) throws IOException {
     response.setCharacterEncoding("utf-8");
     response.setContentType("APPLICATION/OCTET-STREAM");
     response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
     OutputStream os=response.getOutputStream();
     return os;
     }
     */
}
