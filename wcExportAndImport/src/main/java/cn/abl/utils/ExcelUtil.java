package cn.abl.utils;

/*
 * 2014-12-8
 * author:hanbaojun
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel 文件操作的工具类
 * 
 * @author Administrator
 * 
 */
public class ExcelUtil {

	/**
	 * 从EXCEL文件中读取数据
	 * 
	 * @param xlsPath
	 *            EXCEL文件路径，EXCEL表格的行列需工整
	 * @return 数据行的集合
	 * @throws IOException
	 */
	
	public static Map<Integer, Object[]> read(String xlsPath){
		//判断是否为excel类型文件
        if(!xlsPath.endsWith(".xls")&&!xlsPath.endsWith(".xlsx")){
            System.out.println("文件不是excel类型");
        }
        
        FileInputStream is =null;
        Workbook wookbook = null;
        try{
            //获取一个绝对地址的流
        	is = new FileInputStream(xlsPath);
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        try {
            //2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(is);//得到工作簿
        } 
        catch (Exception ex) {
            //ex.printStackTrace();
            try{
                //2007版本的excel，用.xlsx结尾
            	is = new FileInputStream(xlsPath);
                wookbook = new XSSFWorkbook(is);//得到工作簿
            } catch (IOException e){
                e.printStackTrace();
            }
        }
		try{
		Map<Integer, Object[]> items = new HashMap<Integer, Object[]>();
		int cellNum = 0;
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < wookbook.getNumberOfSheets(); numSheet++) {

			Sheet hssfSheet = wookbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}

			// 循环行Row
			for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {

				try {
					Row row = hssfSheet.getRow(rowNum);

					if (row == null) {
						continue;
					}
					if(rowNum == 0) {
						cellNum = row.getLastCellNum();
					}
					Object[] item = new Object[cellNum];

					// 循环列Cell
					for (int i = 0; i < cellNum; i++) {

						Cell cell = row.getCell(i);
						if(cell != null) {
							item[i] = getValue(cell);
						} 
					} 

					items.put(rowNum, item);
				} catch (Exception e) {
					e.printStackTrace();
					throw new IllegalArgumentException("第"+rowNum+"行数据格式错误！");
				}
			}
		}
		
		return items;
		}catch(Exception e){
			throw new IllegalArgumentException("读取Excel文件失败，请确保格式正确工整！");
		}
	}

	/**
	 * 得到Excel表中的值
	 * 
	 * @param cell
	 *            Excel中的单元格
	 * @return Excel单元格中的值
	 */
	@SuppressWarnings("static-access")
	public static String getValue(Cell cell) {
		if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
			double value = cell.getNumericCellValue();
			String string = customExcelNumericFormat(value);
			return string;
		} else if(cell.getCellType()==cell.CELL_TYPE_BLANK){
			return null;
		}else{
			return String.valueOf(cell.getStringCellValue());
		}
	}
	
	private static String customExcelNumericFormat(double d) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		String temp = d + "";
		int n = 0;
		int a = 0;
		if (temp.indexOf("E") >= 0) {
			String auxiliaryStr  = temp.split("E")[1];
			String realStr  = temp.split("E")[0];
			n = Integer.valueOf(auxiliaryStr);
			a = (realStr).length() - (realStr).indexOf(".") - 1 - n;
		} else {
            a = (d + "").length() - (d + "").indexOf(".") - 1;
		}
		
		if (a == 1 && (d + "").endsWith(".0")) {
            nf.setMinimumFractionDigits(0);
		} else {
            nf.setMinimumFractionDigits(a);
		}
		  String s = nf.format(d);
	        if (s.indexOf(",") >= 0) {
	            s = s.replace(",", "");
	        }
	   return s;
    }
	
	/**
	 * 写入Excel表格中
	 * @param configNames Excel表名
	 * @param list  导出数据
	 * @param response
	 * @throws IOException 
	 */
	public static void createWorkbook(String configNames, List list, HttpServletResponse response) throws IOException{

	    //创建工作表
	    Workbook wb = new HSSFWorkbook();

	    //设置内容格式，样式垂直居中
	    CellStyle cellCS = wb.createCellStyle();
	    // cellCS.setAlignment(CellStyle.ALIGN_CENTER);
	    //  cellCS.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

	    //创建sheet
	    Sheet sheet = wb.createSheet();
	    //设置第一行，第二行为标题及说明字段
	    Row row1 = sheet.createRow(0);
	    Row row2 = sheet.createRow(1);
	    //得到最后一行，表格标题信息
	    Map<String, Object> map = (Map)list.get(list.size()-1);
	  //循环写人标题和说明信息
	    int k = 0;
	    for(String key : map.keySet()) {
	        //写入第一行标题信息
	        Cell c1 = row1.createCell(k);
	        c1.setCellValue(key);
	        c1.setCellStyle(cellCS);
	        sheet.setDefaultColumnWidth(15);
	         //写入第二行说明文字
	        Cell c2 = row2.createCell(k);
	        c2.setCellValue(String.valueOf(map.get(key)));
	        c2.setCellStyle(cellCS);
	        sheet.setDefaultColumnWidth(15);

	        k++;
	    }
	    //循环写入数据
	    for (int j = 0; j < list.size()-1; j++) {
	         Map<String, Object> data = (Map)list.get(j);
	        Row row3 = sheet.createRow(j+2);
	        int i = 0;
	        for(String key : map.keySet()) {
	            //写入导出数据
	            Cell c3 = row3.createCell(i);
	            c3.setCellValue(String.valueOf(data.get(key)==null?"":data.get(key)));
	            c3.setCellStyle(cellCS);
	            sheet.setDefaultColumnWidth(15);
	            i++;
	        }
	    }
	    //设置导出Excel名称
	    String filename = configNames + ".xls";
	    response.setContentType("application/ms-excel;charset=UTF-8");
	    response.setHeader("Content-Disposition", "attachment;filename="
	            .concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));
	    OutputStream out = response.getOutputStream();
	    response.getOutputStream().flush();
	    wb.write(out);// 将数据写出去
	    out.close();//关闭输出流

	}

}
