package com.coolway.service.impl;

import com.coolway.entity.Student;
import com.coolway.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    /**
     * 导出计划数据到excel
     *
     * @param fileName excel名称
     */
    public void exportExcel(HttpServletResponse response, String fileName) {
        //获取数据
        List<Student> productInfoPos = this.getAllPlan();
        //获取表头信息
//
        //获取格式化信息
//
//        //组织生成excel
//        Workbook workbook = getWorkbook();
//        ExcelUtils excelUtils = new ExcelUtils(productInfoPos, getHeaderInfo(), getFormatInfo());
//        //发送响应
//        excelUtils.sendHttpResponse(response, fileName, workbook);
//    }
//
//    private Workbook getWorkbook() {
//        Workbook workbook = new SXSSFWorkbook();
//        String[][] datas = transformData();
//        Field[] fields = list.get(0).getClass().getDeclaredFields();
//        CellStyle style = setCellStyle(workbook);
//        int pageRowNum = 0;
//        Sheet sheet = null;
//
//        long startTime = System.currentTimeMillis();
////        LOGGER.info("开始处理excel文件。。。");
//
//        for (int i = 0; i < datas.length; i++) {
//            // 如果是每个sheet的首行
//            if (i % SHEET_MAX_ROW == 0) {
//                // 创建新的sheet
//                sheet = createSheet(workbook, i);
//                pageRowNum = 0; // 行号重置为0
//                for (int j = 0; j < getHeaderRowNum(excelHeaderInfos); j++) {
//                    sheet.createRow(pageRowNum++);
//                }
//                createHeader(sheet, style);
//            }
//            // 创建内容
//            Row row = sheet.createRow(pageRowNum++);
//            createContent(row, style, datas, i, fields);
//        }
//        LOGGER.info("处理文本耗时" + (System.currentTimeMillis() - startTime) + "ms");
//        return workbook;
//
//        return workbook;
//    }
//
//    private List<ExcelHeaderInfo> getHeaderInfo() {
//        return Arrays.asList(
//            new ExcelHeaderInfo(1, 1, 0, 0, "id"),
//            new ExcelHeaderInfo(1, 1, 1, 1, "商品名称"),
//
//            new ExcelHeaderInfo(0, 0, 2, 3, "分类"),
//            new ExcelHeaderInfo(1, 1, 2, 2, "类型ID"),
//            new ExcelHeaderInfo(1, 1, 3, 3, "分类名称"),
//
//            new ExcelHeaderInfo(0, 0, 4, 5, "品牌"),
//            new ExcelHeaderInfo(1, 1, 4, 4, "品牌ID"),
//            new ExcelHeaderInfo(1, 1, 5, 5, "品牌名称"),
//
//            new ExcelHeaderInfo(0, 0, 6, 7, "商店"),
//            new ExcelHeaderInfo(1, 1, 6, 6, "商店ID"),
//            new ExcelHeaderInfo(1, 1, 7, 7, "商店名称"),
//
//            new ExcelHeaderInfo(1, 1, 8, 8, "价格"),
//            new ExcelHeaderInfo(1, 1, 9, 9, "库存"),
//            new ExcelHeaderInfo(1, 1, 10, 10, "销量"),
//            new ExcelHeaderInfo(1, 1, 11, 11, "插入时间"),
//            new ExcelHeaderInfo(1, 1, 12, 12, "更新时间"),
//            new ExcelHeaderInfo(1, 1, 13, 13, "记录是否已经删除")
//        );
    }
}
