package utils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: lishengxiang
 * Date: 2022/3/1
 * Time: 11:03
 * Description:
 */
public class ExcelUitls {
    public static void main(String[] args) throws Exception {
//        readAndWrite();
//        excelWrite();
    }

    private static void readAndWrite() throws IOException, BiffException, WriteException {
        File xlsFile = new File("111.xls");
        File outputFile = new File("细类.xls");
        // 获得工作簿对象
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        WritableWorkbook workbook2 = Workbook.createWorkbook(outputFile);
        // 创建一个工作表
        WritableSheet writeSheet = workbook2.createSheet("sheet1", 0);
        // 获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        // 遍历工作表
        if (sheets != null)
        {
            for (Sheet sheet : sheets)
            {
                // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                // 读取数据
                int countRow=0;
                for (int row = 0; row < rows; row++)
                {
                    if ("".equals(sheet.getCell(7, row).getContents())){
                        continue;
                    }
                    for (int col = 0; col < cols; col++) {
                        writeSheet.addCell(new Label(col, countRow, sheet.getCell(col, row).getContents()));
                    }


                    try{
                        String contents = sheet.getCell(0, row).getContents();
                        String sub = contents.substring(0, 6) + "00";
                        writeSheet.addCell(new Label(cols, countRow, sub));
                    } catch (Exception e) {
                        System.out.println("第几行"+row);
                    }

                    countRow++;
                }
            }
        }
        workbook2.write();
        workbook2.close();
        workbook.close();
    }

    private static void excelWrite(String excelName) throws IOException, WriteException {
        long first = System.currentTimeMillis();
//        File outputFile = File.createTempFile(excelName, ".xlsx");
        File outputFile = new File(excelName+".xlsx");
        // 创建一个工作簿
        WritableWorkbook outputbook = Workbook.createWorkbook(outputFile);

        // 创建一个工作表
        WritableSheet outputSheet = outputbook.createSheet("sheet1", 0);
        for (int row = 1; row <= 3000; row++)
        {

            for (int col = 0; col < 2; col++)
            {
                // 向工作表中添加数据
                outputSheet.addCell(new Label(col, row, "data" + row + col));
            }
        }
        outputbook.write();
        outputbook.close();
        System.out.println(System.currentTimeMillis() - first);
    }

    private static void excelRead(String fileName) throws Exception {
        File xlsFile = new File(fileName);
        // 获得工作簿对象

        Workbook workbook = Workbook.getWorkbook(xlsFile);
        // 获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        HashSet<String> set = new HashSet<>();
        // 遍历工作表
        if (sheets != null)
        {
            for (Sheet sheet : sheets)
            {
                // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                // 读取数据
                for (int row = 0; row < rows; row++)
                {
                    for (int col = 0; col < cols; col++)
                    {
                        System.out.printf("%10s", sheet.getCell(col, row).getContents());
                        set.add(sheet.getCell(col, row).getContents());
                    }
                    System.out.println();
                }
            }
        }
        workbook.close();
    }
}
