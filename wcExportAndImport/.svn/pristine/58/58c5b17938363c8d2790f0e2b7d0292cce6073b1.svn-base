package cn.abl.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import cn.abl.pojo.TEstimate;
import cn.abl.pojo.THscode;
import cn.abl.service.HsCodeService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Controller
@RequestMapping("hsCode")
public class HsCodeController {
	
	@Autowired
	private HsCodeService hsCodeServiceImpl;

	
	@RequestMapping(value = "/getAllHsCode")
	@ResponseBody
	public JSONObject getAllHsCode(int page, int limit, THscode hscode) {
		PageBean pageBean = hsCodeServiceImpl.getAllHsCode(page, limit, hscode);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping("/editUi")
	public String endit(HttpServletRequest request) {
		String param = request.getParameter("id");
		List<TEstimate> list = hsCodeServiceImpl.findAllEstimate();
		request.setAttribute("tEstimate", list);
		if (param != null) {
			THscode tHscode = hsCodeServiceImpl.findByID(Integer.parseInt(param));
			request.setAttribute("tHscode", tHscode);
		}
		return "/after/hscode/enditHSCODE";
	}
	
	@RequestMapping(value="/endit", method=RequestMethod.POST)
	@ResponseBody
	public E3Result enditHscode(THscode tHscode, HttpServletRequest request) {
		String userId = request.getSession().getAttribute("userId").toString();
		E3Result result = hsCodeServiceImpl.enditHsCode(tHscode, userId);
		return result;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public E3Result delete(String ids) {
		E3Result result = hsCodeServiceImpl.deleteByID(ids);
		return result;
	}
	
	@RequestMapping(value="/importHcode")
	public ModelAndView importHcode(@RequestParam("excelFile") MultipartFile excelFile, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId").toString();
		//System.out.println(attribute.toString());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/tools/commonMsg");
		E3Result result = new E3Result();
		try {
			String path = System.getProperty("user.home") + File.separator + "upload/";
			String fileName = "offline_" + System.currentTimeMillis() + ".xlsx";
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			excelFile.transferTo(targetFile);
			result = hsCodeServiceImpl.importHcode(path + fileName, userId);
			modelAndView.addObject("result", result);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("xlsx数据表格不正确");
			modelAndView.addObject("result",result);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/exportHcode")
	public void exportHcode(String ids, THscode tHscode, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-disposition",
				"attachment;filename=HSCODE.xlsx");
		if (tHscode.getItemname() != null) {
			String itemname = tHscode.getItemname();
			String string = new String(itemname.getBytes("ISO8859-1"), "utf-8");
			tHscode.setItemname(string);
		}
		List<THscode> list = hsCodeServiceImpl.exportHcode(ids, tHscode);
		
		// 创建XSSFWorkbook对象
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 创建Sheet对象
		Sheet sheet = workbook.createSheet("sheet1");
		sheet.setDefaultColumnWidth(10); // 设置表格默认列宽度为10个字节
		// sheet.createFreezePane(30, 1); // 冻结第一行，下拉显示字段名 
		// 创建Row对象
		Row row = sheet.createRow(0);
		CellStyle cellStyle = workbook.createCellStyle();
		//时间格式
		CreationHelper createHelper = workbook.getCreationHelper();  
		CellStyle cellStyle1 = workbook.createCellStyle();
		cellStyle1.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
		// cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		// cellStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
		
		
		// 设置表头信息
		Cell cell = row.createCell(0);
		cell.setCellValue("hcode");
		cell.setCellStyle(cellStyle);

		cell = row.createCell(1);
		cell.setCellValue("商品名称");
		cell.setCellStyle(cellStyle);

		cell = row.createCell(2);
		cell.setCellValue("第一单位");
		cell.setCellStyle(cellStyle);
		
		cell = row.createCell(3);
		cell.setCellValue("第二单位");
		cell.setCellStyle(cellStyle);

		cell = row.createCell(4);
		cell.setCellValue("状态");
		cell.setCellStyle(cellStyle);

		cell = row.createCell(5);
		cell.setCellValue("备注");
		cell.setCellStyle(cellStyle);
		
		int i = 1;
		for (THscode tHscode2 : list) {
			row = sheet.createRow(i++);
			
			cell = row.createCell(0);
			if (tHscode2.getHcode() == null) {
				cell.setCellValue("");
			}else {
				cell.setCellValue(tHscode2.getHcode());
			}
			cell.setCellStyle(cellStyle);
			
			cell = row.createCell(1);
			if (tHscode2.getItemname() == null) {
				cell.setCellValue("");
			}else {
				cell.setCellValue(tHscode2.getItemname());
			}
			cell.setCellStyle(cellStyle);
			
			cell = row.createCell(2);
			if (tHscode2.getUnit1() == null) {
				cell.setCellValue("");
			}else {
				cell.setCellValue(tHscode2.getUnit1());
			}
			cell.setCellStyle(cellStyle);
			
			cell = row.createCell(3);
			if (tHscode2.getUnit2() == null) {
				cell.setCellValue("");
			}else {
				cell.setCellValue(tHscode2.getUnit2());
			}
			cell.setCellStyle(cellStyle);
			
			cell = row.createCell(4);
			if (tHscode2.getIsok() == null) {
				cell.setCellValue("");
			}else {
				if (tHscode2.getIsok() == 1) {
					cell.setCellValue("有效");
				}else {
					cell.setCellValue("失效");
				}
			}
			cell.setCellStyle(cellStyle);
			
			cell = row.createCell(5);
			if (tHscode2.getBz() == null) {
				cell.setCellValue("");
			}else {
				cell.setCellValue(tHscode2.getBz());
			}
			cell.setCellStyle(cellStyle);
		}
		
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		
	}
}
