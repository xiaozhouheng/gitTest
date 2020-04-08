package cn.abl.service;

import java.util.List;

import cn.abl.pojo.UUser;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface CustomsDeclarationService {
	
	PageBean importDeclaration(int page, int limit, String param1, String customsCode, String beginTime, String endTime, String status, String createUserid, String userType);

	List<UUser> getUser();
	
	E3Result updateReview(int id, int userId);
	
	PageBean exportDeclaration(int page, int limit, String param1, String customsCode, String beginTime, String endTime, String status, String createUserid, String userType);
	
	E3Result updateExportDeclaration(int id, int userId);
}
