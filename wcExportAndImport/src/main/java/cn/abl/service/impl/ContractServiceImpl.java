package cn.abl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.abl.dao.AArrivalPlanDetailsMapper;
import cn.abl.dao.AArrivalPlanMapper;
import cn.abl.dao.CCorporateInformationMapper;
import cn.abl.dao.SShippingPlanDetailsMapper;
import cn.abl.dao.SShippingPlanMapper;
import cn.abl.pojo.AArrivalPlan;
import cn.abl.pojo.AArrivalPlanDetails;
import cn.abl.pojo.AArrivalPlanDetailsExample;
import cn.abl.pojo.AArrivalPlanDetailsExample.Criteria;
import cn.abl.pojo.CCorporateInformation;
import cn.abl.pojo.CCorporateInformationExample;
import cn.abl.pojo.SShippingPlan;
import cn.abl.pojo.SShippingPlanDetails;
import cn.abl.pojo.SShippingPlanDetailsExample;
import cn.abl.service.ContractService;
@Service
public class ContractServiceImpl implements ContractService {
	
	@Autowired
	private AArrivalPlanMapper aArrivalPlanMapper;
	@Autowired
	private AArrivalPlanDetailsMapper aArrivalPlanDetailsMapper;
	@Autowired
	private CCorporateInformationMapper cCorporateInformationMapper;
	@Autowired
	private SShippingPlanMapper shippingPlanMapper;
	@Autowired
	private SShippingPlanDetailsMapper shippingPlanDetailsMapper;
	 
	@Override
	public AArrivalPlan findByID(int id) {
		AArrivalPlan arrivalPlan = aArrivalPlanMapper.selectByPrimaryKey(id);
		return arrivalPlan;
	}

	@Override
	public List<AArrivalPlanDetails> findByAID(int id) {
		AArrivalPlanDetailsExample example = new AArrivalPlanDetailsExample();
		Criteria criteria = example.createCriteria();
		criteria.andAIdEqualTo(id);
		List<AArrivalPlanDetails> list = aArrivalPlanDetailsMapper.selectByExample(example);
		return list;
	}

	@Override
	public CCorporateInformation findByUserID(int userID) {
		CCorporateInformationExample example = new CCorporateInformationExample();
		cn.abl.pojo.CCorporateInformationExample.Criteria criteria = example.createCriteria();
		criteria.andCreateUseridEqualTo(userID);
		List<CCorporateInformation> list = cCorporateInformationMapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public SShippingPlan findSShippingPlanByID(int id) {
		SShippingPlan shippingPlan = shippingPlanMapper.selectByPrimaryKey(id);
		return shippingPlan;
	}

	@Override
	public List<SShippingPlanDetails> findBySID(int id) {
		SShippingPlanDetailsExample example = new SShippingPlanDetailsExample();
		cn.abl.pojo.SShippingPlanDetailsExample.Criteria criteria = example.createCriteria();
		criteria.andSIdEqualTo(id);
		List<SShippingPlanDetails> list = shippingPlanDetailsMapper.selectByExample(example);
		return list;
	}

}
