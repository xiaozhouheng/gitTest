package cn.abl.service;

import java.util.List;
import java.util.Map;

import cn.abl.pojo.UUser;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

public interface UserService {

	PageBean findAllUser(int page, int limit, UUser user);
	
	Map<String, Object> getUserBySession(String userId);
	
	E3Result login(String username, String password);
	
	E3Result register(UUser user);
	
	Object findModularPrivilege();
	
	UUser findUserByID(String id);
	
	E3Result updateModularPrivilege(UUser user, String userId);
	
	List<UUser> findDataPrivilege();
	
	E3Result deleteByID(String ids);
	
	E3Result updateDataPrivilege(int userId, String dataPrivilege);
	
	List<UUser> selectAllUsers();
	
	int findCorporateByStatus();
}
