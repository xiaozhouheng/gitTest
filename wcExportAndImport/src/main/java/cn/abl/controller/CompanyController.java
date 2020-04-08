package cn.abl.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.abl.pojo.CCorporateInformation;
import cn.abl.service.CompanyService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;





//商家
@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyServiceImpl;
	
	@RequestMapping("afterCompanyUI")
	public ModelAndView companyUI(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("after/company/companyMain");
		return mv;
	}
	
	@RequestMapping("/CompanyUI")
	public ModelAndView afterCompanyUI() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("views/company/companyVO");
		return mv;
	}
	
	@RequestMapping("/ReviewCompany")
	public String ReviewCompany(HttpServletRequest request) {
		String id = request.getParameter("id");
		CCorporateInformation company = companyServiceImpl.findCompanyByID(id);
		request.setAttribute("company", company);
		return "/after/company/companyAudit";
	}
	
	@RequestMapping(value = "/getAllCompany")
	@ResponseBody
	public JSONObject getAllCompany(int page, int limit, CCorporateInformation corporateInformation) {
		PageBean pageBean = companyServiceImpl.getAllCompany(page, limit, corporateInformation);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("count", pageBean.getTotal());
		jsonObject.put("value", pageBean.getList());
		jsonObject.put("success", true);
		return jsonObject;
	}
	
	@RequestMapping(value = "/editCompany")
	public String editCompany(HttpServletRequest request) {
		String userID = request.getSession().getAttribute("userId").toString();
		if (null != userID) {
			CCorporateInformation company = companyServiceImpl.findCompanyByUserID(userID);
			request.setAttribute("company", company);
		}
		return "views/company/companyVO";
	}
	
	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateCompany(HttpServletRequest request, CCorporateInformation corporateInformation,
			@RequestParam(value = "file1", required = false) MultipartFile file1, @RequestParam(value = "file2", required = false) MultipartFile file2, 
			@RequestParam(value = "file3", required = false) MultipartFile file3, @RequestParam(value = "file4", required = false) MultipartFile file4) throws Exception{
		// file1-营业执照     file2-对外贸易经营者备案登记表    file3-海关备案登记证    file4-企业统一社会信用代码证
		String filePath = "C://wc//corporateInformation//";
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		if (null != file1) {
			String file1Name = file1.getOriginalFilename();
			File targetFile1 = new File(filePath, UUID.randomUUID().toString().replace("-", "").substring(0, 15) + "_file_" + file1Name);
			corporateInformation.setBusinessLicense(filePath + targetFile1.getName());
			file1.transferTo(targetFile1);
		}
		if (null != file2) {
			String file2Name = file2.getOriginalFilename();
			File targetFile2 = new File(filePath, UUID.randomUUID().toString().replace("-", "").substring(0, 15) + "_file_" + file2Name);
			corporateInformation.setForeignTrade(filePath + targetFile2.getName());
			file2.transferTo(targetFile2);
		}
		if (null != file3) {
			String file3Name = file3.getOriginalFilename();
			File targetFile3 = new File(filePath, UUID.randomUUID().toString().replace("-", "").substring(0, 15) + "_file_" + file3Name);
			corporateInformation.setCustomsRegistration(filePath + targetFile3.getName());
			file3.transferTo(targetFile3);
		}
		if (null != file4) {
			String file4Name = file4.getOriginalFilename();
			File targetFile4 = new File(filePath, UUID.randomUUID().toString().replace("-", "").substring(0, 15) + "_file_" + file4Name);
			corporateInformation.setUscc(filePath + targetFile4.getName());
			file4.transferTo(targetFile4);
		}
		// 取session中的userId
		String userId = request.getSession().getAttribute("userId").toString();
		E3Result result = companyServiceImpl.updateCompany(corporateInformation, userId);
		return result;
	}
	
	@RequestMapping(value = "/deleteCompanyByID")
	@ResponseBody
	public E3Result deleteCompanyByID(String ids) {
		E3Result result = companyServiceImpl.deleteCompanyByID(ids);
		return result;
	}
	
	@RequestMapping(value = "/updateCompanyStatus")
	@ResponseBody
	public E3Result updateCompanyStatus(Integer id) {
		E3Result result = companyServiceImpl.updateCompanyStatus(id);
		return result;
	}
	
	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public void downloadBL(String fileAdress, HttpServletRequest request, HttpServletResponse response) {
		File file = new File(fileAdress);
		try {
		if (!file.exists()) {
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().print("你要下载的文件已被删除!");
		}
		String name = file.getName();
		response.addHeader("Content-Disposition", "attachment;filename=" + name);
		response.setContentType("multipart/form-data");
		FileInputStream inputStream = new FileInputStream(file);
		BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
		byte buffer[] = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, len);
			outputStream.flush();
		}
		outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/AnnualInspection", method = RequestMethod.GET)
	@ResponseBody
	public E3Result AnnualInspection(HttpServletRequest request) {
		String userID = request.getSession().getAttribute("userId").toString();
		E3Result result = companyServiceImpl.AnnualInspection(userID);
		return result;
	}
}
