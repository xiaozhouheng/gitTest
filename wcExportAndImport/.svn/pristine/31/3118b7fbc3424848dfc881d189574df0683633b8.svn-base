package cn.abl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelimgUtil {

public static Map<Integer, Object[]> getDataFromExcel(String filePath) throws IOException{
        
        //判断是否为excel类型文件
        if(!filePath.endsWith(".xls")&&!filePath.endsWith(".xlsx")){
            System.out.println("文件不是excel类型");
        }
        
        FileInputStream fis =null;
        Workbook wookbook = null;
        Sheet sheet =null;
        try{
            //获取一个绝对地址的流
            fis = new FileInputStream(filePath);
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        try {
            //2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(fis);//得到工作簿
        } 
        catch (Exception ex) {
            //ex.printStackTrace();
            try{
                //2007版本的excel，用.xlsx结尾
            	 fis = new FileInputStream(filePath);
                wookbook = new XSSFWorkbook(fis);//得到工作簿
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        

        Map<Object, PictureData>  maplist=null;
        Map<Object, String> map = null;
        //得到一个工作表
        sheet = wookbook.getSheetAt(0);  
        // 判断用07还是03的方法获取图片  
        if (filePath.endsWith(".xls")) {  
            maplist = getPictures1((HSSFSheet) sheet);  
        } else if(filePath.endsWith(".xlsx")){  
            maplist = getPictures2((XSSFSheet) sheet);  
        }  
        try {
			 map = printImg(maplist);
		} catch (IOException e) {
			e.printStackTrace();
		}  
        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();
        
        int cellNum = 0;
        // 存放一行数据
        Map<Integer, Object[]> items = new HashMap<Integer, Object[]>();
        //获得所有数据
        boolean firstRows = true;
        int k = 0;
        for(int i = 0 ; i <= totalRowNum ; i++){
            //获得第i行对象
            Row row = sheet.getRow(i);
            if (row == null) {
				continue;
			}
            if (i == 0) {
				 cellNum = row.getLastCellNum();
			}
            Object[] item = new Object[cellNum];
            if (firstRows) {
            	firstRows = false;
				continue;
			}
            item[16] = map.get(k++);
            for (int j = 0; j < cellNum; j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					item[j] = getValue(cell);
				}
			}
            items.put(i, item);
        }
		return items;
    }
  /**
   * 获取图片和位置 (xls)
   * @param sheet
   * @return
   * @throws IOException
   */
  public static Map<Object, PictureData> getPictures1 (HSSFSheet sheet) throws IOException {
	    Map<Object, PictureData> map = new HashMap<Object, PictureData>();
	    List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
	    for (HSSFShape shape : list) {
	        if (shape instanceof HSSFPicture) {
	            HSSFPicture picture = (HSSFPicture) shape;
	            HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
	            PictureData pdata = (PictureData) picture.getPictureData();
	            // String key = cAnchor.getRow1() + "-" + cAnchor.getCol1(); // 行号-列号
	            int key = cAnchor.getRow1();
	            map.put(key, pdata);
	        }
	    }
	    return map;
	}
   
  /**
   * 获取图片和位置 (xlsx)
   * @param sheet
   * @return
   * @throws IOException
   */
  public static Map<Object, PictureData> getPictures2 (XSSFSheet sheet) throws IOException {
      Map<Object, PictureData> map = new HashMap<Object, PictureData>();
      List<POIXMLDocumentPart> list = sheet.getRelations();
      for (POIXMLDocumentPart part : list) {
          if (part instanceof XSSFDrawing) {
              XSSFDrawing drawing = (XSSFDrawing) part;
              List<XSSFShape> shapes = drawing.getShapes();
              for (XSSFShape shape : shapes) {
                  XSSFPicture picture = (XSSFPicture) shape;
                  XSSFClientAnchor anchor = picture.getPreferredSize();
                  org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker marker = anchor.getFrom();
                  // String key = marker.getRow() + "-" + marker.getCol();
                  int key = marker.getRow();
                  map.put(key, (PictureData) picture.getPictureData());
              }
          }
      }
      return map;
  }
  //图片写出
  public static Map<Object, String> printImg(Map<Object, PictureData> maplist) throws IOException {  
      		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
	  		HashMap<Object,String> map = new HashMap<>();
            Object keys[] = maplist.keySet().toArray();
            Arrays.sort(keys);
            int i = 0;
            for (Object key : keys) {
                // 获取图片流  
                PictureData pic = maplist.get(key);  
                // 获取图片索引  
                String picName = key.toString();  
                // 获取图片格式  
                String ext = pic.suggestFileExtension();  
                  
                byte[] data = pic.getData();  
                 
                //图片保存路径 
                String path = "C://wc//CCommodityFiling//" + dateFormat.format(new Date()) + "//";
                File files = new File(path);
        		if (!files.exists()) {
        			files.mkdirs();
        		}
                long currentTimeMillis = System.currentTimeMillis();
                String filepath = path + picName + "-" + currentTimeMillis + "." + ext;
                // System.out.println(file);
                map.put(i++, filepath);
                FileOutputStream out = new FileOutputStream(filepath);  
                out.write(data);  
                out.close();  
  			}
           /* for(Object key:map.keySet()){//keySet获取map集合key的集合  然后在遍历key即可
                String value = map.get(key).toString();//
                System.out.println("key:"+key+" vlaue:"+value);
            }*/
			return map;
          
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
		DecimalFormat df = new DecimalFormat("0");
		if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
			return String.valueOf(df.format(cell.getNumericCellValue()));
		} else if(cell.getCellType()==cell.CELL_TYPE_BLANK){
			return null;
		}else{
			return String.valueOf(cell.getStringCellValue());
		}
	}
}
