package cn.abl.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.Buffer;

import cn.abl.dao.CCorporateInformationMapper;
import cn.abl.dao.CCorporateInformationMapperCustom;
import cn.abl.pojo.CCorporateInformation;
import cn.abl.pojo.CCorporateInformationExample;
import cn.abl.pojo.CCorporateInformationExample.Criteria;
import cn.abl.service.CompanyService;
import cn.abl.utils.E3Result;
import cn.abl.utils.PageBean;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CCorporateInformationMapperCustom cCorporateInformationMapperCustom;
	@Autowired
	private CCorporateInformationMapper cCorporateInformationMapper;
	
	@Override
	public PageBean getAllCompany(int page, int limit, CCorporateInformation corporateInformation) {
		PageHelper.startPage(page, limit);
		List<CCorporateInformation> companyList = cCorporateInformationMapperCustom.getAllCompany(corporateInformation);
		PageInfo<CCorporateInformation> pageInfo = new PageInfo<>(companyList);
		List<CCorporateInformation> list = pageInfo.getList();
		long total = pageInfo.getTotal();
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setTotal(total);
		return pageBean;
	}

	@Override
	public CCorporateInformation findCompanyByUserID(String userID) {
		CCorporateInformationExample example = new CCorporateInformationExample();
		Criteria criteria = example.createCriteria();
		criteria.andCreateUseridEqualTo(Integer.valueOf(userID));
		List<CCorporateInformation> list = cCorporateInformationMapper.selectByExample(example);
		if (list.size() != 0) {
			CCorporateInformation corporateInformation = list.get(0);
			return corporateInformation;
		}
		return null;
	}

	@Override
	public E3Result updateCompany(CCorporateInformation corporateInformation, String userId) {
		if (corporateInformation.getId() != null) { // 修改
			int i = cCorporateInformationMapperCustom.checkCompanyChName(corporateInformation.getId(), corporateInformation.getCompanyChName());
			if (i != 0) {
				return E3Result.build(400, "企业中文名称已存在!");
			}
			int j = cCorporateInformationMapperCustom.checkCompanyEnName(corporateInformation.getId(), corporateInformation.getCompanyEnName());
			if (j != 0) {
				return E3Result.build(400, "企业英文名称已存在!");
			}
			int k = cCorporateInformationMapperCustom.checkCommodityNumber(corporateInformation.getId(), corporateInformation.getCommodityNumber());
			if (k != 0) {
				return E3Result.build(400, "商检注册编号已存在!");
			}
			int l = cCorporateInformationMapperCustom.checkCreditCode(corporateInformation.getId(), corporateInformation.getCreditCode());
			if (l != 0) {
				return E3Result.build(400, "企业统一社会信用代码证编号已存在!");
			}
			int m = cCorporateInformationMapperCustom.checkCustomsCode(corporateInformation.getId(), corporateInformation.getCustomsCode());
			if (m != 0) {
				return E3Result.build(400, "海关注册编码已存在!");
			}
			corporateInformation.setCreateTime(new Date());
			corporateInformation.setStatus(0);
			corporateInformation.setCreateUserid(Integer.parseInt(userId));
			cCorporateInformationMapper.updateByPrimaryKey(corporateInformation);
			
		} else { // 新增
			CCorporateInformationExample example = new CCorporateInformationExample();
			CCorporateInformationExample example2 = new CCorporateInformationExample();
			CCorporateInformationExample example3 = new CCorporateInformationExample();
			CCorporateInformationExample example4 = new CCorporateInformationExample();
			CCorporateInformationExample example5 = new CCorporateInformationExample();
			Criteria criteria = example.createCriteria();
			Criteria criteria2 = example2.createCriteria();
			Criteria criteria3 = example3.createCriteria();
			Criteria criteria4 = example4.createCriteria();
			Criteria criteria5 = example5.createCriteria();
			
			criteria.andCompanyChNameEqualTo(corporateInformation.getCompanyChName());
			List<CCorporateInformation> companyChNameList = cCorporateInformationMapper.selectByExample(example);
			if (null != companyChNameList && companyChNameList.size() > 0) {
				return E3Result.build(400, "企业中文名称已存在!");
			}
			criteria2.andCompanyEnNameEqualTo(corporateInformation.getCompanyEnName());
			List<CCorporateInformation> companyEnNameList = cCorporateInformationMapper.selectByExample(example2);
			if (null != companyEnNameList && companyEnNameList.size() > 0) {
				return E3Result.build(400, "企业英文名称已存在!");
			}
			criteria3.andCreditCodeEqualTo(corporateInformation.getCreditCode());
			List<CCorporateInformation> creditCodeList = cCorporateInformationMapper.selectByExample(example3);
			if (null != creditCodeList && creditCodeList.size() > 0) {
				return E3Result.build(400, "企业统一社会信用代码证编号已存在!");
			}
			criteria4.andCustomsCodeEqualTo(corporateInformation.getCustomsCode());
			List<CCorporateInformation> customsCodeList = cCorporateInformationMapper.selectByExample(example4);
			if (null != customsCodeList && customsCodeList.size() > 0) {
				return E3Result.build(400, "海关注册编码已存在!");
			}
			criteria5.andCommodityNumberEqualTo(corporateInformation.getCommodityNumber());
			List<CCorporateInformation> commodityNumberList = cCorporateInformationMapper.selectByExample(example5);
			if (null != commodityNumberList && commodityNumberList.size() > 0) {
				return E3Result.build(400, "商检注册编号已存在!");
			}
			corporateInformation.setCreateTime(new Date());
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR) + 1);
			Date time = calendar.getTime();
			corporateInformation.setAnnualInspectionTime(time);
			corporateInformation.setStatus(0);
			corporateInformation.setCreateUserid(Integer.parseInt(userId));
			cCorporateInformationMapper.insert(corporateInformation);
		}
		return E3Result.ok();
	}

	@Override
	public E3Result deleteCompanyByID(String id) {
		int i = cCorporateInformationMapperCustom.deleteCompanyByID(id);
		return E3Result.ok(i);
	}

	@Override
	public E3Result updateCompanyStatus(int id) {
		CCorporateInformation corporateInformation = cCorporateInformationMapper.selectByPrimaryKey(id);
		if (0 == corporateInformation.getStatus()) {
			corporateInformation.setStatus(1);
			int i = cCorporateInformationMapper.updateByPrimaryKey(corporateInformation);
			if (0 == i) {
				return E3Result.build(400, "审核失败!");
			}
		} else if (1 == corporateInformation.getStatus()) {
			corporateInformation.setStatus(0);
			int i = cCorporateInformationMapper.updateByPrimaryKey(corporateInformation);
			if (0 == i) {
				return E3Result.build(400, "审核失败");
			}
		}
		return E3Result.ok();
	}

	@Override
	public CCorporateInformation findCompanyByID(String id) {
		CCorporateInformation corporateInformation = cCorporateInformationMapper.selectByPrimaryKey(Integer.valueOf(id));
		return corporateInformation;
	}

	@Override
	public E3Result AnnualInspection(String userId) {
		int i = cCorporateInformationMapperCustom.AnnualInspection(userId);
		return i > 0 ? E3Result.ok() : E3Result.build(400, "企业审核日期将至!");
	}

}
