package cn.abl.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.CCommodityFilingCustom;
import cn.abl.dao.CCommodityFilingMapper;
import cn.abl.pojo.CCommodityFiling;
import cn.abl.pojo.THscode;
import cn.abl.service.CommodityFilingService;
import cn.abl.utils.E3Result;
import cn.abl.utils.ExcelUtil;
import cn.abl.utils.ExcelimgUtil;
import cn.abl.utils.PageBean;

@Service
public class CommodityFilingServiceImpl implements CommodityFilingService {
	
	@Autowired
	private CCommodityFilingCustom cCommodityFilingCustom;
	@Autowired
	private CCommodityFilingMapper cCommodityFilingMapper;
	

	@Override
	public PageBean getAllcommodityFiling(int page, int limit, CCommodityFiling commodityFiling, String userId) {
		PageHelper.startPage(page, limit);
		commodityFiling.setUserId(Integer.valueOf(userId));
		List<CCommodityFiling> allcommodityFiling = cCommodityFilingCustom.getAllcommodityFiling(commodityFiling);
		PageInfo<CCommodityFiling> pageInfo = new PageInfo<>(allcommodityFiling);
		long total = pageInfo.getTotal();
		List<CCommodityFiling> list = pageInfo.getList();
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setTotal(total);
		return pageBean;
	}

	@Override
	public E3Result insertAllcommodityFiling(String path, String userId) throws Exception {
		Map<Integer, Object[]> items = ExcelimgUtil.getDataFromExcel(path);
		boolean firstRows = true;
		int dataTotal = items.entrySet().size();
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		StringBuffer buffer = new StringBuffer();
		ArrayList<CCommodityFiling> list = new ArrayList<>();
		aa:for (Entry<Integer, Object[]> entry : items.entrySet()) {
			/*if (firstRows) {
				firstRows = false;
				continue;
			}*/
			Object[] rowData =(Object[]) entry.getValue();
			// int row = entry.getKey() + 1 ;
			int row = entry.getKey();
			Object data1 = rowData[1];
			if (null == data1 || StringUtils.isEmpty(data1.toString().trim())) {
				buffer.append("导入第" + row + "行货号失败!<br>");
				continue;
			}
			
			Object data2 = rowData[2];
			if (null == data2 || StringUtils.isEmpty(data2.toString().trim())) {
				buffer.append("导入第" + row + "行条形码失败!<br>");
				continue;
			}
			
			Object data3 = rowData[3];
			if (null == data3 || StringUtils.isEmpty(data3.toString().trim())) {
				buffer.append("导入第" + row + "行产品中文名称失败!<br>");
				continue;
			}
			
			Object data4 = rowData[4];
			if (null == data4 || StringUtils.isEmpty(data4.toString().trim())) {
				buffer.append("导入第" + row + "行产品英文名称失败!<br>");
				continue;
			}
			
			Object data5 = rowData[5];
			/*if (null == data5 || StringUtils.isEmpty(data5.toString().trim())) {
				buffer.append("导入第" + row + "行HS编码失败!");
				continue;
			}*/
			
			Object data6 = rowData[6];
			if (null == data6 || StringUtils.isEmpty(data6.toString().trim())) {
				buffer.append("导入第" + row + "行单个净重失败!<br>");
				continue;
			}
			
			Object data7 = rowData[7];
			if (null == data7 || StringUtils.isEmpty(data7.toString().trim())) {
				buffer.append("导入第" + row + "行品牌失败!<br>");
				continue;
			}
			
			Object data8 = rowData[8];
			if (null == data8 || StringUtils.isEmpty(data8.toString().trim())) {
				buffer.append("导入第" + row + "行品牌类型失败!<br>");
				continue;
			}
			
			Object data9 = rowData[9];
			if (null == data9 || StringUtils.isEmpty(data9.toString().trim())) {
				buffer.append("导入第" + row + "行用途失败!<br>");
				continue;
			}
			
			Object data10 = rowData[10];
			if (null == data10 || StringUtils.isEmpty(data10.toString().trim())) {
				buffer.append("导入第" + row + "行功能失败!<br>");
				continue;
			}
			
			Object data11 = rowData[11];
			if (null == data11 || StringUtils.isEmpty(data11.toString().trim())) {
				buffer.append("导入第" + row + "行材质失败!<br>");
				continue;
			}
			
			Object data12 = rowData[12];
			if (null == data12 || StringUtils.isEmpty(data12.toString().trim())) {
				buffer.append("导入第" + row + "行型号失败!<br>");
				continue;
			}
			
			Object data13 = rowData[13];
			if (null == data13 || StringUtils.isEmpty(data13.toString().trim())) {
				buffer.append("导入第" + row + "行包装失败!<br>");
				continue;
			}
			
			Object data14 = rowData[14];
			if (null == data14 || StringUtils.isEmpty(data14.toString().trim())) {
				buffer.append("导入第" + row + "行规格尺寸失败!<br>");
				continue;
			}
			
			Object data15 = rowData[15];
			if (null == data15 || StringUtils.isEmpty(data15.toString().trim())) {
				buffer.append("导入第" + row + "行其他失败!<br>");
				continue;
			}
			
			Object data16 = rowData[16];
			if (null == data16 || StringUtils.isEmpty(data16.toString().trim())) {
				buffer.append("导入第" + row + "行图片失败!<br>");
				continue;
			}
			
			CCommodityFiling commodityFiling = new CCommodityFiling();
			commodityFiling.setItemNumber(data1.toString().trim());
			commodityFiling.setBarCode(data2.toString().trim());
			commodityFiling.setItemChName(data3.toString().trim());
			commodityFiling.setItemEnName(data4.toString().trim());
			if (null == data5 || StringUtils.isEmpty(data5.toString().trim())) {
				commodityFiling.setHsCodeStatus(0);
				buffer.append("导入第" + row + "行税号异常!<br>");
			}else {
				THscode hscode = cCommodityFilingCustom.findHscodeByItemName(data5.toString().trim());
				commodityFiling.setHsCode(data5.toString().trim());
				if (null != hscode) {
					if (hscode.getHcode().equals(data5.toString().trim())) {
						commodityFiling.setHsCodeStatus(1);
					} else {
						commodityFiling.setHsCodeStatus(0);
						buffer.append("导入第" + row + "行税号异常!<br>");
					}
				} else {
					commodityFiling.setHsCodeStatus(0);
					buffer.append("导入第" + row + "行税号异常!<br>");
				}
			}
			commodityFiling.setNetWeight(data6.toString().trim());
			commodityFiling.setBrand(data7.toString().trim());
			commodityFiling.setBrandType(data8.toString().trim());
			commodityFiling.setUses(data9.toString().trim());
			commodityFiling.setFeatures(data10.toString().trim());
			commodityFiling.setMaterial(data11.toString().trim());
			commodityFiling.setModel(data12.toString().trim());
			commodityFiling.setPackageType(data13.toString().trim());
			commodityFiling.setStandardSizes(data14.toString().trim());
			commodityFiling.setOther(data15.toString().trim());
			commodityFiling.setImage(data16.toString().trim());
			commodityFiling.setUserId(Integer.valueOf(userId));
			commodityFiling.setCreateTime(new Date());
			list.add(commodityFiling);
		}
		
		E3Result result = new E3Result();
		if (list.size() == dataTotal) {
			cCommodityFilingCustom.insertAllCommodityFiling(list);
			buffer.append("总共" + dataTotal + "条数据,导入成功" + list.size() + "条!<br>");
			result.setStatus(200);
			result.setMsg(buffer.toString());
		} else {
			result.setMsg(buffer.toString());
		}
		return result;
	}

	@Override
	public PageBean findAfterCommodityFiling(int page, int limit, CCommodityFiling commodityFiling,
			String dataPrivilege) {
		PageHelper.startPage(page, limit);
		StringBuffer buffer = new StringBuffer();
		if (dataPrivilege.indexOf(",") != -1) {
			String[] split = dataPrivilege.split(",");
			for (int i = 0; i < split.length; i++) {
				if (buffer == null || buffer.length() == 0) {
					buffer.append("'" + split[i] + "'");
				}else {
					buffer.append(",'" + split[i] + "'");
				}
			}
		} else {
			buffer.append(dataPrivilege);
		}
		commodityFiling.setDataPrivilege(buffer.toString());
		List<CCommodityFiling> allcommodityFiling = cCommodityFilingCustom.findAfterCommodityFiling(commodityFiling);
		PageInfo<CCommodityFiling> pageInfo = new PageInfo<>(allcommodityFiling);
		long total = pageInfo.getTotal();
		List<CCommodityFiling> list = pageInfo.getList();
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setTotal(total);
		return pageBean;
	}

	@Override
	public Workbook exportCommodityFiling(CCommodityFiling commodityFiling, String ids) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("产品备案审核");
		CellStyle style = workbook.createCellStyle();
        Font font = workbook.getFontAt((short) 0);
        font.setCharSet(HSSFFont.DEFAULT_CHARSET);
        //更改默认字体大小
        font.setFontHeightInPoints((short) 12);
        font.setFontName("宋体");
        style.setFont(font);

        //默认宽高
        sheet.setDefaultColumnWidth((short)20);
        sheet.setDefaultRowHeight((short)2000);
		//画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		String titles[] ={"id(请不要更改id)","货号","条形码","产品中文名称","产品英文名称","税号","单个净重","品牌","品牌类型","用途","功能","材质","型号","包装","规格尺寸","其他","图片","税号状态","备注"};
		String colums[] ={"id", "itemNumber", "barCode", "itemChName", "itemEnName","hsCode","netWeight","brand","brandType","uses","features","material","model","packageType","standardSizes","other","image","hsCodeStatus","note"};
		List<Map<String,Object>> list = null;
		if (ids == null || ids.equals("")) {
			list = cCommodityFilingCustom.exportCommodityFiling(commodityFiling);
		} else {
			list = cCommodityFilingCustom.exportCommodityFilingByID(ids);
		}
		HSSFRow firstRow = sheet.createRow(0);
		// 循环标题
		for (int i = 0; i < titles.length; i++) {
			HSSFCell cell = firstRow.createCell(i);
			cell.setCellValue(titles[i]);
			cell.setCellStyle(style);
		}
		for (int i = 0; i < list.size(); i++) {
			HSSFRow row = sheet.createRow(i + 1);
			for (int j = 0; j < colums.length; j++) {
				HSSFCell cell = row.createCell(j);
				Map<String, Object> map = list.get(i);
				if ("image".equals(colums[j])) { // 处理图片
					HSSFClientAnchor anchor =
		                     new HSSFClientAnchor
		                             (        0, //x缩放
		                                     0, // y缩放
		                                     500, //最大1023
		                                     50, //最大255
		                                     (short) 16,  //于下下个参数进行定位 0开始
		                                     i+1, //在第几行
		                                     (short) 16, //宽度占几格 0开始
		                                     j //第几列
		                             );
		             BufferedImage bufferImg = null;
		             bufferImg = ImageIO.read(new File(map.get("image").toString()));
		             // bufferImg = ImageIO.read(new File("D:\\imgs\\img\\pic1-1572251396011.png"));
		             ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();


		             //这里要注意formatName要缓存后缀名
		             ImageIO.write(bufferImg, "png", byteArrayOut);
		            //插入图片
		            patriarch.createPicture(anchor, workbook.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
				} else if ("hsCodeStatus".equals(colums[j])) {
					int hsCodeStatus = (int)map.get(colums[j]);
					cell.setCellValue(hsCodeStatus == 1 ? "正常" : "异常");
					cell.setCellStyle(style);
				} /*else if ("reviewStatus".equals(colums[j])) {
					int reviewStatus = (int)map.get((colums[j]));
					cell.setCellValue(reviewStatus == 1 ? "审核通过" : "审核失败");
					cell.setCellStyle(style);
				}*/ else {
					Object object = map.get(colums[j]);
					if (object == null) {
						// cell.setCellValue("");
					} else {
						cell.setCellValue(object.toString());
					}
					cell.setCellStyle(style);
				}
			}
		}
		return workbook;
	}

	@Override
	public E3Result ReviewCommodityFiling(String path, String userId) {
		Map<Integer, Object[]> items = ExcelUtil.read(path);
		boolean firstRows = true;
		int dataTotal = items.entrySet().size();
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		StringBuffer buffer = new StringBuffer();
		// ArrayList<CCommodityFiling> list = new ArrayList<>();
		aa:for (Entry<Integer, Object[]> entry : items.entrySet()) {
			if (firstRows) {
				firstRows = false;
				continue;
			}
			Object[] rowData =(Object[]) entry.getValue();
			// int row = entry.getKey() + 1 ;
			int row = entry.getKey();
			
			Object data0 = rowData[0];
			if (null == data0 || StringUtils.isEmpty(data0.toString().trim())) {
				buffer.append("导入第" + row + "行id失败!<br>");
				continue;
			}
			
			Object data1 = rowData[1];
			if (null == data1 || StringUtils.isEmpty(data1.toString().trim())) {
				buffer.append("导入第" + row + "行货号失败!<br>");
				continue;
			}
			
			Object data2 = rowData[2];
			if (null == data2 || StringUtils.isEmpty(data2.toString().trim())) {
				buffer.append("导入第" + row + "行条形码失败!<br>");
				continue;
			}
			
			Object data3 = rowData[3];
			if (null == data3 || StringUtils.isEmpty(data3.toString().trim())) {
				buffer.append("导入第" + row + "行产品中文名称失败!<br>");
				continue;
			}
			
			Object data4 = rowData[4];
			if (null == data4 || StringUtils.isEmpty(data4.toString().trim())) {
				buffer.append("导入第" + row + "行产品英文名称失败!<br>");
				continue;
			}
			
			Object data5 = rowData[5];
			/*if (null == data5 || StringUtils.isEmpty(data5.toString().trim())) {
				buffer.append("导入第" + row + "行HS编码失败!");
				continue;
			}*/
			
			Object data6 = rowData[6];
			if (null == data6 || StringUtils.isEmpty(data6.toString().trim())) {
				buffer.append("导入第" + row + "行单个净重失败!<br>");
				continue;
			}
			
			Object data7 = rowData[7];
			if (null == data7 || StringUtils.isEmpty(data7.toString().trim())) {
				buffer.append("导入第" + row + "行品牌失败!<br>");
				continue;
			}
			
			Object data8 = rowData[8];
			if (null == data8 || StringUtils.isEmpty(data8.toString().trim())) {
				buffer.append("导入第" + row + "行品牌类型失败!<br>");
				continue;
			}
			
			Object data9 = rowData[9];
			if (null == data9 || StringUtils.isEmpty(data9.toString().trim())) {
				buffer.append("导入第" + row + "行用途失败!<br>");
				continue;
			}
			
			Object data10 = rowData[10];
			if (null == data10 || StringUtils.isEmpty(data10.toString().trim())) {
				buffer.append("导入第" + row + "行功能失败!<br>");
				continue;
			}
			
			Object data11 = rowData[11];
			if (null == data11 || StringUtils.isEmpty(data11.toString().trim())) {
				buffer.append("导入第" + row + "行材质失败!<br>");
				continue;
			}
			
			Object data12 = rowData[12];
			if (null == data12 || StringUtils.isEmpty(data12.toString().trim())) {
				buffer.append("导入第" + row + "行型号失败!<br>");
				continue;
			}
			
			Object data13 = rowData[13];
			if (null == data13 || StringUtils.isEmpty(data13.toString().trim())) {
				buffer.append("导入第" + row + "行包装失败!<br>");
				continue;
			}
			
			Object data14 = rowData[14];
			if (null == data14 || StringUtils.isEmpty(data14.toString().trim())) {
				buffer.append("导入第" + row + "行规格尺寸失败!<br>");
				continue;
			}
			
			Object data15 = rowData[15];
			if (null == data15 || StringUtils.isEmpty(data15.toString().trim())) {
				buffer.append("导入第" + row + "行其他失败!<br>");
				continue;
			}
			
			/*Object data16 = rowData[16];
			if (null == data16 || StringUtils.isEmpty(data16.toString().trim())) {
				buffer.append("导入第" + row + "行图片失败!");
				continue;
			}*/
			
			Object data18 = rowData[18];
			
			/*Object data19 = rowData[19];
			
			Object data20 = rowData[20];
			
			Object data21 = rowData[21];*/
			
			
			
			CCommodityFiling commodityFiling = new CCommodityFiling();
			commodityFiling.setId(Integer.valueOf(data0.toString()));
			commodityFiling.setItemNumber(data1.toString().trim());
			commodityFiling.setBarCode(data2.toString().trim());
			commodityFiling.setItemChName(data3.toString().trim());
			commodityFiling.setItemEnName(data4.toString().trim());
			if (null == data5 || StringUtils.isEmpty(data5.toString().trim())) {
				commodityFiling.setHsCodeStatus(0); // 税号异常
				commodityFiling.setReviewStatus(-1); // 审核失败
				buffer.append("导入第" + row + "行税号异常!<br>");
			}else {
				THscode hscode = cCommodityFilingCustom.findHscodeByItemName(data5.toString().trim());
				commodityFiling.setHsCode(data5.toString().trim());
				if (null != hscode) {
					if (hscode.getHcode().equals(data5.toString().trim())) {
						commodityFiling.setHsCodeStatus(1);
						commodityFiling.setReviewStatus(1);
					} else {
						commodityFiling.setHsCodeStatus(0);
						commodityFiling.setReviewStatus(-1);
						buffer.append("导入第" + row + "行税号异常!<br>");
					}
				} else {
					commodityFiling.setHsCodeStatus(0);
					commodityFiling.setReviewStatus(-1);
					buffer.append("导入第" + row + "行税号异常!<br>");
				}
			}
			commodityFiling.setNetWeight(data6.toString().trim());
			commodityFiling.setBrand(data7.toString().trim());
			commodityFiling.setBrandType(data8.toString().trim());
			commodityFiling.setUses(data9.toString().trim());
			commodityFiling.setFeatures(data10.toString().trim());
			commodityFiling.setMaterial(data11.toString().trim());
			commodityFiling.setModel(data12.toString().trim());
			commodityFiling.setPackageType(data13.toString().trim());
			commodityFiling.setStandardSizes(data14.toString().trim());
			commodityFiling.setOther(data15.toString().trim());
			// commodityFiling.setImage(data16.toString().trim());
			commodityFiling.setReviewerId(Integer.valueOf(userId));
			commodityFiling.setReviewTime(new Date());
			commodityFiling.setNote(data18 == null ? "" : data18.toString());
			/*commodityFiling.setCompanyCode(data20 == null ? "" : data20.toString());
			commodityFiling.setBusinessNumber(data21 == null ? "" : data21.toString());*/
			cCommodityFilingMapper.updateByPrimaryKeySelective(commodityFiling);
			//list.add(commodityFiling);
		}
		
		E3Result result = new E3Result();
		if (buffer.indexOf("失败") != -1) {
			result.setMsg(buffer.toString());
		} else {
			buffer.append("总共" + dataTotal + "条数据,导入成功" + dataTotal + "条!<br>");
			result.setStatus(200);
			result.setMsg(buffer.toString());
		}
		return result;
	}
}
