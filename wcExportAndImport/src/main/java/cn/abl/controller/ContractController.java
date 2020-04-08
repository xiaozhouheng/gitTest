package cn.abl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.abl.pojo.AArrivalPlan;
import cn.abl.pojo.AArrivalPlanDetails;
import cn.abl.pojo.CCorporateInformation;
import cn.abl.pojo.SShippingPlan;
import cn.abl.pojo.SShippingPlanDetails;
import cn.abl.service.ContractService;
import cn.abl.utils.DateUtil;
import cn.abl.utils.E3Result;

@Controller
@RequestMapping("contract")
public class ContractController {
	
	@Autowired
	private ContractService contractServiceImpl;

	
	@RequestMapping("/exportInvoice")
	@ResponseBody
	public E3Result exportInvoice(int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType ("application/vnd.ms-excel");
        response.addHeader ("Content-Disposition", "attachment;filename=" + URLEncoder.encode (DateUtil.getCurrentDate("yyyyMMdd") + "鍙戠エ", "UTF-8") + ".xlsx");
		
        String templatePath = request.getSession().getServletContext().getRealPath("/import/fp1.xlsx");
		AArrivalPlan arrivalPlan = contractServiceImpl.findByID(id);
		CCorporateInformation corporateInformation = contractServiceImpl.findByUserID(arrivalPlan.getCreateUserid());
		List<AArrivalPlanDetails> list = contractServiceImpl.findByAID(id);
		if (arrivalPlan == null || list.size() == 0 || corporateInformation == null) {
			return E3Result.build(400, "数据不完整,无法下载发票!");
		}
		File file = new File(templatePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFSheet sheetAt = workbook.getSheetAt(0);
		
		sheet.setForceFormulaRecalculation(true);
		
		XSSFCell firstCell = sheet.getRow(0).getCell(0);
		firstCell.setCellValue(corporateInformation.getCompanyChName());
		
		XSSFCell SecondCell = sheet.getRow(1).getCell(0);
		SecondCell.setCellValue(corporateInformation.getCompanyEnName());
		
		XSSFCell cell = sheet.getRow(7).getCell(9);
		cell.setCellValue(new Date());
		int lastRowNum = sheet.getLastRowNum();
		
		sheet.shiftRows(14, lastRowNum, list.size(), true, false);
		int i = 0;
		BigDecimal sumNumber = new BigDecimal(0);
		BigDecimal sumTotalPrice = new BigDecimal(0);
		for (AArrivalPlanDetails tContractDetails : list) {
			i = ++i;
			XSSFRow createRow = sheet.createRow(14 + i);
			createRow.createCell(1).setCellValue(tContractDetails.getChItemName());
			createRow.createCell(2).setCellValue(tContractDetails.getModel());
			createRow.createCell(4).setCellValue(arrivalPlan.getNumber()); // 提单件数
			createRow.createCell(5).setCellValue(arrivalPlan.getPackageDimensions());
			createRow.createCell(6).setCellValue(tContractDetails.getNumber()); // 数量
			createRow.createCell(8).setCellValue(tContractDetails.getPrice()); // 单价
			createRow.createCell(10).setCellValue(tContractDetails.getTotalPrice()); // 总价
			sumNumber = new BigDecimal(tContractDetails.getNumber()).add(sumNumber);
			sumTotalPrice = new BigDecimal(tContractDetails.getTotalPrice()).add(sumTotalPrice);
		}
		XSSFCell cell2 = sheetAt.getRow(14 + i + 2).getCell(4);
		cell2.setCellValue(arrivalPlan.getNumber());
		XSSFCell cell8 = sheetAt.getRow(14 + i + 2).getCell(6);
		cell8.setCellValue(sumNumber.toString());
		XSSFCell cell3 = sheetAt.getRow(14 + i + 2).getCell(10);
		cell3.setCellValue(sumTotalPrice.toString());
		XSSFCell cell4 = sheetAt.getRow(14 + i + 4).getCell(2);
		cell4.setCellValue(arrivalPlan.getNumber());
		XSSFCell cell5 = sheetAt.getRow(14 + i + 5).getCell(2);
		cell5.setCellValue(arrivalPlan.getWeight());
		XSSFCell cell6 = sheetAt.getRow(14 + i + 6).getCell(2);
		cell6.setCellValue(arrivalPlan.getWeight());
		XSSFCell cell7 = sheetAt.getRow(14 + i + 7).getCell(2);
		cell7.setCellValue("无");
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		return E3Result.ok();
	}
	
	@RequestMapping(value = "/exportPackList")
	@ResponseBody
	public E3Result exportPackList(int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType ("application/vnd.ms-excel");
        response.addHeader ("Content-Disposition", "attachment;filename=" + URLEncoder.encode (DateUtil.getCurrentDate("yyyyMMdd") + "鍙戠エ", "UTF-8") + ".xlsx");
		
        String templatePath = request.getSession().getServletContext().getRealPath("/import/zxd1.xlsx");
		AArrivalPlan arrivalPlan = contractServiceImpl.findByID(id);
		CCorporateInformation corporateInformation = contractServiceImpl.findByUserID(arrivalPlan.getCreateUserid());
		List<AArrivalPlanDetails> list = contractServiceImpl.findByAID(id);
		if (arrivalPlan == null || list.size() == 0 || corporateInformation == null) {
			return E3Result.build(400, "数据不完整,无法下载装箱单!");
		}
		
		File file = new File(templatePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		sheet.setForceFormulaRecalculation(true);
		
		XSSFCell firstCell = sheet.getRow(0).getCell(0);
		firstCell.setCellValue(corporateInformation.getCompanyChName());
		
		XSSFCell SecondCell = sheet.getRow(1).getCell(0);
		SecondCell.setCellValue(corporateInformation.getCompanyEnName());
		
		XSSFCell cell = sheet.getRow(7).getCell(11);
		cell.setCellValue(new Date());
		int lastRowNum = sheet.getLastRowNum();
		sheet.shiftRows(12, lastRowNum, list.size(), true, false);
		int i = 0;
		BigDecimal sumNumber = new BigDecimal(0);
		BigDecimal sumNetWeight = new BigDecimal(0);
		for (AArrivalPlanDetails arrivalPlanDetails : list) {
			i = ++i;
			XSSFRow createRow = sheet.createRow(12 + i);
			createRow.createCell(1).setCellValue(arrivalPlanDetails.getChItemName());
			createRow.createCell(2).setCellValue(arrivalPlanDetails.getModel());
			createRow.createCell(5).setCellValue(arrivalPlan.getNumber());
			createRow.createCell(6).setCellValue(arrivalPlan.getPackageDimensions());
			createRow.createCell(7).setCellValue(arrivalPlanDetails.getNumber());
			createRow.createCell(9).setCellValue(arrivalPlanDetails.getNetWeight());
			createRow.createCell(10).setCellValue(arrivalPlanDetails.getNetWeight());
			createRow.createCell(11).setCellValue("无");
			sumNumber = new BigDecimal(arrivalPlanDetails.getNumber()).add(sumNumber);
			sumNetWeight = new BigDecimal(arrivalPlanDetails.getTotalPrice()).add(sumNetWeight);
		}
		XSSFCell cell2 = sheet.getRow(12 + i + 4).getCell(5);
		cell2.setCellValue(arrivalPlan.getNumber());
		XSSFCell cell3 = sheet.getRow(12 + i + 4).getCell(7);
		cell3.setCellValue(sumNumber.toString());
		XSSFCell cell4 = sheet.getRow(12 + i + 4).getCell(9);
		cell4.setCellValue(sumNetWeight.toString());
		XSSFCell cell5 = sheet.getRow(12 + i + 4).getCell(10);
		cell5.setCellValue(sumNetWeight.toString());
		XSSFCell cell6 = sheet.getRow(12 + i + 4).getCell(11);
		cell6.setCellValue("无");
		
		sheet.getRow(12 + i + 6).getCell(3).setCellValue(arrivalPlan.getNumber());
		sheet.getRow(12 + i + 7).getCell(3).setCellValue(sumNetWeight.toString());
		sheet.getRow(12 + i + 8).getCell(3).setCellValue(sumNetWeight.toString());
		sheet.getRow(12 + i + 9).getCell(3).setCellValue("无");
		
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		
		return E3Result.ok();
	}
	
	@RequestMapping(value = "/exportShippingPlanInvoice")
	@ResponseBody
	public E3Result exportShippingPlanInvoice(int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType ("application/vnd.ms-excel");
        response.addHeader ("Content-Disposition", "attachment;filename=" + URLEncoder.encode (DateUtil.getCurrentDate("yyyyMMdd") + "鍙戠エ", "UTF-8") + ".xlsx");
		
        String templatePath = request.getSession().getServletContext().getRealPath("/import/fp1.xlsx");
        
        SShippingPlan shippingPlan = contractServiceImpl.findSShippingPlanByID(id);
		CCorporateInformation corporateInformation = contractServiceImpl.findByUserID(Integer.valueOf(shippingPlan.getCreateUserid()));
		List<SShippingPlanDetails> list = contractServiceImpl.findBySID(id);
		if (shippingPlan == null || list.size() == 0 || corporateInformation == null) {
			return E3Result.build(400, "数据不完整,无法下载发票!");
		}
		File file = new File(templatePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFSheet sheetAt = workbook.getSheetAt(0);
		
		sheet.setForceFormulaRecalculation(true);
		
		XSSFCell firstCell = sheet.getRow(0).getCell(0);
		firstCell.setCellValue(corporateInformation.getCompanyChName());
		
		XSSFCell SecondCell = sheet.getRow(1).getCell(0);
		SecondCell.setCellValue(corporateInformation.getCompanyEnName());
		
		XSSFCell cell = sheet.getRow(7).getCell(9);
		cell.setCellValue(new Date());
		int lastRowNum = sheet.getLastRowNum();
		
		sheet.shiftRows(14, lastRowNum, list.size(), true, false);
		int i = 0;
		BigDecimal sumNumber = new BigDecimal(0);
		BigDecimal sumTotalPrice = new BigDecimal(0);
		for (SShippingPlanDetails tContractDetails : list) {
			i = ++i;
			XSSFRow createRow = sheet.createRow(14 + i);
			createRow.createCell(1).setCellValue(tContractDetails.getChItemName());
			createRow.createCell(2).setCellValue(tContractDetails.getModel());
			createRow.createCell(4).setCellValue(shippingPlan.getTotalNumber()); // 提单件数
			createRow.createCell(5).setCellValue(shippingPlan.getPackageDimensions());
			createRow.createCell(6).setCellValue(tContractDetails.getNumber()); // 数量
			createRow.createCell(8).setCellValue(tContractDetails.getPrice()); // 单价
			createRow.createCell(10).setCellValue(tContractDetails.getTotalPrice()); // 总价
			sumNumber = new BigDecimal(tContractDetails.getNumber()).add(sumNumber);
			sumTotalPrice = new BigDecimal(tContractDetails.getTotalPrice()).add(sumTotalPrice);
		}
		XSSFCell cell2 = sheetAt.getRow(14 + i + 2).getCell(4);
		cell2.setCellValue(shippingPlan.getTotalNumber());
		XSSFCell cell8 = sheetAt.getRow(14 + i + 2).getCell(6);
		cell8.setCellValue(sumNumber.toString());
		XSSFCell cell3 = sheetAt.getRow(14 + i + 2).getCell(10);
		cell3.setCellValue(sumTotalPrice.toString());
		XSSFCell cell4 = sheetAt.getRow(14 + i + 4).getCell(2);
		cell4.setCellValue(shippingPlan.getTotalNumber());
		XSSFCell cell5 = sheetAt.getRow(14 + i + 5).getCell(2);
		cell5.setCellValue(shippingPlan.getTotalGrossWeight());
		XSSFCell cell6 = sheetAt.getRow(14 + i + 6).getCell(2);
		cell6.setCellValue(shippingPlan.getTotalGrossWeight());
		XSSFCell cell7 = sheetAt.getRow(14 + i + 7).getCell(2);
		cell7.setCellValue("无");
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		return E3Result.ok();
	}
	
	@RequestMapping(value = "/exportShippingPlanPackList")
	@ResponseBody
	public E3Result exportShippingPlanPackList(int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType ("application/vnd.ms-excel");
        response.addHeader ("Content-Disposition", "attachment;filename=" + URLEncoder.encode (DateUtil.getCurrentDate("yyyyMMdd") + "鍙戠エ", "UTF-8") + ".xlsx");
		
        String templatePath = request.getSession().getServletContext().getRealPath("/import/zxd1.xlsx");
        SShippingPlan shippingPlan = contractServiceImpl.findSShippingPlanByID(id);
		CCorporateInformation corporateInformation = contractServiceImpl.findByUserID(Integer.valueOf(shippingPlan.getCreateUserid()));
		List<SShippingPlanDetails> list = contractServiceImpl.findBySID(id);
		if (shippingPlan == null || list.size() == 0 || corporateInformation == null) {
			return E3Result.build(400, "数据不完整,无法下载装箱单!");
		}
		
		File file = new File(templatePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		sheet.setForceFormulaRecalculation(true);
		
		XSSFCell firstCell = sheet.getRow(0).getCell(0);
		firstCell.setCellValue(corporateInformation.getCompanyChName());
		
		XSSFCell SecondCell = sheet.getRow(1).getCell(0);
		SecondCell.setCellValue(corporateInformation.getCompanyEnName());
		
		XSSFCell cell = sheet.getRow(7).getCell(11);
		cell.setCellValue(new Date());
		int lastRowNum = sheet.getLastRowNum();
		sheet.shiftRows(12, lastRowNum, list.size(), true, false);
		int i = 0;
		BigDecimal sumNumber = new BigDecimal(0);
		BigDecimal sumNetWeight = new BigDecimal(0);
		for (SShippingPlanDetails arrivalPlanDetails : list) {
			i = ++i;
			XSSFRow createRow = sheet.createRow(12 + i);
			createRow.createCell(1).setCellValue(arrivalPlanDetails.getChItemName());
			createRow.createCell(2).setCellValue(arrivalPlanDetails.getModel());
			createRow.createCell(5).setCellValue(shippingPlan.getTotalNumber());
			createRow.createCell(6).setCellValue(shippingPlan.getPackageDimensions());
			createRow.createCell(7).setCellValue(arrivalPlanDetails.getNumber());
			createRow.createCell(9).setCellValue(arrivalPlanDetails.getNetWeight());
			createRow.createCell(10).setCellValue(arrivalPlanDetails.getNetWeight());
			createRow.createCell(11).setCellValue("无");
			sumNumber = new BigDecimal(arrivalPlanDetails.getNumber()).add(sumNumber);
			sumNetWeight = new BigDecimal(arrivalPlanDetails.getTotalPrice()).add(sumNetWeight);
		}
		XSSFCell cell2 = sheet.getRow(12 + i + 4).getCell(5);
		cell2.setCellValue(shippingPlan.getTotalNumber());
		XSSFCell cell3 = sheet.getRow(12 + i + 4).getCell(7);
		cell3.setCellValue(sumNumber.toString());
		XSSFCell cell4 = sheet.getRow(12 + i + 4).getCell(9);
		cell4.setCellValue(sumNetWeight.toString());
		XSSFCell cell5 = sheet.getRow(12 + i + 4).getCell(10);
		cell5.setCellValue(sumNetWeight.toString());
		XSSFCell cell6 = sheet.getRow(12 + i + 4).getCell(11);
		cell6.setCellValue(shippingPlan.getTotalCapacity());
		
		sheet.getRow(12 + i + 6).getCell(3).setCellValue(shippingPlan.getTotalNumber());
		sheet.getRow(12 + i + 7).getCell(3).setCellValue(sumNetWeight.toString());
		sheet.getRow(12 + i + 8).getCell(3).setCellValue(sumNetWeight.toString());
		sheet.getRow(12 + i + 9).getCell(3).setCellValue(shippingPlan.getTotalCapacity());
		
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		
		return E3Result.ok();
	}
}
