package com.fly.crmanagement.util;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * EasyExcel工具类
 */
public class EasyExcelUtil {

    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel    文件
     * @param rowModel 实体类映射，继承 BaseRowModel 类
     * @param sheetNo  sheet 的序号 从1开始
     * @return Excel 数据 list
     */
    public static List<Object> readExcel(MultipartFile excel, BaseRowModel rowModel) throws IOException {
        return readExcel(excel, rowModel, 1, 1);
    }

    /**
     * 读取某个 sheet 的 Excel
     * @param excel       文件
     * @param rowModel    实体类映射，继承 BaseRowModel 类
     * @param sheetNo     sheet 的序号 从1开始
     * @param headLineNum 表头行数，默认为1
     * @return Excel 数据 list
     */
    public static List<Object> readExcel(MultipartFile excel, BaseRowModel rowModel, int sheetNo, int headLineNum) throws IOException {
        ExcelListener excelListener = new ExcelListener();
        ExcelReader reader = getReader(excel, excelListener);
        if (reader == null) {
            return null;
        }
        reader.read(new Sheet(sheetNo, headLineNum, rowModel.getClass()));
        return excelListener.getDatas();
    }

    /**
     * 读取指定sheetName的Excel(多个 sheet)
     * @param excel    文件
     * @param rowModel 实体类映射，继承 BaseRowModel 类
     * @return Excel 数据 list
     * @throws IOException
     */
    public static List<Object> readExcel(MultipartFile excel, BaseRowModel rowModel, String sheetName) throws IOException {
        ExcelListener excelListener = new ExcelListener();
        ExcelReader reader = getReader(excel, excelListener);
        if (reader == null) {
            return null;
        }
        for (Sheet sheet : reader.getSheets()) {
            if (rowModel != null) {
                sheet.setClazz(rowModel.getClass());
            }
            //读取指定名称的sheet
            if(sheet.getSheetName().contains(sheetName)){
                reader.read(sheet);
                break;
            }
        }
        return excelListener.getDatas();
    }

    /**
     * 返回 ExcelReader
     * @param excelFile 需要解析的 Excel 文件
     * @param excelListener new ExcelListener()
     * @throws IOException
     */
    private static ExcelReader getReader(MultipartFile excelFile, ExcelListener excelListener) throws IOException {
        String filename = excelFile.getOriginalFilename();
        if(filename != null && (filename.toLowerCase().endsWith(".xls") || filename.toLowerCase().endsWith(".xlsx"))){
            InputStream is = null;
            if (!excelFile.isEmpty()) {
                File file = new File("C:\\Users\\fly\\Documents\\MyUpload", filename);
                try {
                    excelFile.transferTo(file);
                    is = new BufferedInputStream(new FileInputStream(file));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return new ExcelReader(is, null, excelListener, false);
        }else{
            return null;
        }
    }

}
