package cn.abl.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import cn.abl.pojo.CCommodityFiling;
import cn.abl.pojo.UUser;
import cn.abl.service.CommodityFilingService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Controller
@RequestMapping("commodityFiling")
public class CommodityFilingController {

	@Autowired
	private CommodityFilingService commodityFilingServiceImpl;
	
	@RequestMapping(value = "/getAllcommodityFiling")
	@ResponseBody
	public JSONObject getAllcommodityFiling(int page, int limit, CCommodityFiling commodityFiling, HttpServletRequest request) {
		String userId = request.getSession().getAttribute("userId").toString();
		PageBean pageBean = commodityFilingServiceImpl.getAllcommodityFiling(page, limit, commodityFiling, userId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/importCommodityFiling")
	public ModelAndView importCommodityFiling(@RequestParam("excelFile") MultipartFile excelFile, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/tools/commonMsg");
		E3Result result = new E3Result();
		String userId = request.getSession().getAttribute("userId").toString();
		try {
			String originalFilename = excelFile.getOriginalFilename();
			String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
			String fileName = null;
			if (".xlsx".equals(fileType)) {
				fileName = "offline_" + System.currentTimeMillis() + ".xlsx";
			} else {
				fileName = "offline_" + System.currentTimeMillis() + ".xls";
			}
			 String path = System.getProperty("user.home") + File.separator + "upload/";
			 File targetFile = new File(path, fileName);
			 if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			 excelFile.transferTo(targetFile);
			 result = commodityFilingServiceImpl.insertAllcommodityFiling(path + fileName, userId);
			 view.addObject("result", result);
			 return view;
		} catch (Exception e) {
			e.printStackTrace();
	    	result.setMsg(e.getMessage());
	    	view.addObject("result", result);
		}
		return view;
	}
	
	@RequestMapping(value = "/findAfterCommodityFiling", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject findAfterCommodityFiling(int page, int limit, CCommodityFiling commodityFiling, HttpServletRequest request) {
		UUser user = (UUser)request.getSession().getAttribute("user");
		PageBean pageBean = commodityFilingServiceImpl.findAfterCommodityFiling(page, limit, commodityFiling, user.getDataPrivilege() == null ? "" : user.getDataPrivilege());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/exportCommodityFiling", method = RequestMethod.GET)
	public void exportCommodityFiling(HttpServletResponse response, CCommodityFiling commodityFiling, String ids) throws IOException {
		Workbook workbook = commodityFilingServiceImpl.exportCommodityFiling(commodityFiling, ids);
		try {
            //设置响应头
            response.setContentType("application/octet-stream");//所有文件都支持
            String fileName = "产品备案审核.xls";
            // fileName = URLEncoder.encode(fileName,"utf-8");
            response.setHeader("content-disposition","attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
            //文件下载
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@RequestMapping(value = "/ReviewCommodityFiling")
	public ModelAndView ReviewCommodityFiling(@RequestParam("excelFile") MultipartFile excelFile, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/tools/commonMsg");
		E3Result result = new E3Result();
		String userId = request.getSession().getAttribute("userId").toString();
		try {
			String originalFilename = excelFile.getOriginalFilename();
			String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
			String fileName = null;
			if (".xlsx".equals(fileType)) {
				fileName = "offline_" + System.currentTimeMillis() + ".xlsx";
			} else {
				fileName = "offline_" + System.currentTimeMillis() + ".xls";
			}
			 String path = System.getProperty("user.home") + File.separator + "upload/";
			 File targetFile = new File(path, fileName);
			 if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			 excelFile.transferTo(targetFile);
			 result = commodityFilingServiceImpl.ReviewCommodityFiling(path + fileName, userId);
			 view.addObject("result", result);
			 return view;
		} catch (Exception e) {
			e.printStackTrace();
	    	result.setMsg(e.getMessage());
	    	view.addObject("result", result);
		}
		return view;
	}
	
}
