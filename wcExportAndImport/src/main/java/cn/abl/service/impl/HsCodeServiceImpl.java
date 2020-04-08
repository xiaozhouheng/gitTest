package cn.abl.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.abl.dao.THscodeMapper;
import cn.abl.dao.THscodeMapperCustom;
import cn.abl.pojo.TEstimate;
import cn.abl.pojo.THscode;
import cn.abl.pojo.THscodeExample;
import cn.abl.pojo.THscodeExample.Criteria;
import cn.abl.service.HsCodeService;
import cn.abl.utils.E3Result;
import cn.abl.utils.ExcelUtil;
import cn.abl.utils.PageBean;

@Service
public class HsCodeServiceImpl implements HsCodeService {
	
	@Autowired
	private THscodeMapperCustom tHscodeMapperCustom;
	@Autowired
	private THscodeMapper tHscodeMapper;

	@Override
	public PageBean getAllHsCode(int page, int limit, THscode hscode) {
		PageHelper.startPage(page, limit);
		List<THscode> hscodeList = tHscodeMapperCustom.getAllHsCode(hscode);
		PageInfo<THscode> pageInfo = new PageInfo<>(hscodeList);
		List<THscode> list = pageInfo.getList();
		long total = pageInfo.getTotal();
		PageBean pageBean = new PageBean();
		pageBean.setList(list);
		pageBean.setTotal(total);
		return pageBean;
	}

	@Override
	public THscode findByID(int id) {
		THscode hscode = tHscodeMapper.selectByPrimaryKey(id);
		return hscode;
	}

	@Override
	public List<TEstimate> findAllEstimate() {
		List<TEstimate> list = tHscodeMapperCustom.getByEstimate();
		return list;
	}

	@Override
	public E3Result enditHsCode(THscode tHscode, String userId) {
		if (tHscode.getId() != null) {
			// 数据有效性验证
			if (StringUtils.isBlank(tHscode.getHcode()) || StringUtils.isBlank(tHscode.getItemname())) {
				return E3Result.build(400, "数据不完整,操作失败");
			}
			E3Result result = checkUpdate(tHscode.getHcode(), 1, tHscode.getId());
			if (!(boolean) result.getData()) {
				return E3Result.build(400, "hcode已被占用");
			}
			result = checkUpdate(tHscode.getItemname(), 2, tHscode.getId());
			if (!(boolean) result.getData()) {
				return E3Result.build(400, "商品名称已被占用");
			}
			// 修改数据
			tHscode.setUserid(Integer.valueOf(userId));
			tHscode.setIsok(1);
			tHscode.setTime(new Date());
			tHscodeMapper.updateByPrimaryKey(tHscode);
		}else {
			// 数据有效性验证
			if (StringUtils.isBlank(tHscode.getHcode()) || StringUtils.isBlank(tHscode.getItemname())) {
				return E3Result.build(400, "数据不完整,操作失败");
			}
			// 1-hcode 2-商品名称
			E3Result result = checkAdd(tHscode.getHcode(), 1);
			if (!(boolean) result.getData()) {
				return E3Result.build(400, "hcode已被占用");
			}
			result = checkAdd(tHscode.getItemname(), 2);
			if (!(boolean) result.getData()) {
				return E3Result.build(400, "商品名称已被占用");
			}
			// 添加数据
			tHscode.setUserid(Integer.parseInt(userId));
			tHscode.setIsok(1);
			tHscode.setTime(new Date());
			
			tHscodeMapper.insert(tHscode);
		}
		return E3Result.ok();
	}

	@Override
	public E3Result checkAdd(String param, int type) {
		// 根据不同的type生成不同的查询条件
		THscodeExample example = new THscodeExample();
		Criteria criteria = example.createCriteria();
		// 1-hcode 2-商品名称
		if (1 == type) {
			criteria.andHcodeEqualTo(param);
		}else if (2 == type) {
			criteria.andItemnameEqualTo(param);
		}else {
			E3Result.build(400, "数据类型错误");
		}
		// 查询数据库
		List<THscode> list = tHscodeMapper.selectByExample(example);
		if (list.size() > 0 && list != null) {
			return E3Result.ok(false);
		}
		return E3Result.ok(true);
	}

	@Override
	public E3Result checkUpdate(String param, int type, int id) {
		if (1 == type) {
			List<THscode> list = tHscodeMapperCustom.getCheckHcode(param, id);
			if (list.size() > 0 && list != null) {
				return E3Result.ok(false);
			}
		}else if (2 == type) {
			List<THscode> list = tHscodeMapperCustom.getCheckItemName(param, id);
			if (list.size() > 0 && list != null) {
				return E3Result.ok(false);
			}
		}else {
			E3Result.build(400, "数据类型错误");
		}
		return E3Result.ok(true);
	}

	@Override
	public E3Result deleteByID(String id) {
		int i = tHscodeMapperCustom.deleteByID(id);
		if (i == 0) {
			return E3Result.build(400, "删除失败!");
		}
		return E3Result.ok();
	}

	@Override
	public E3Result importHcode(String path, String userId) {
		// 读取上传的文件
				Map<Integer, Object[]> items = ExcelUtil.read(path);
				File file = new File(path);
				if (file.exists()) {
					file.delete();
				}
				boolean firstRow = true;
				StringBuffer Str = new StringBuffer();
				
				// 文件中一共有多少行数据
				int dataTotal = items.entrySet().size() - 1;
				
				List<THscode> hscodeAndItemName = tHscodeMapperCustom.getHscodeAndItemName();
				
				/*String[] noString = tNostringMapperCustom.getNoString();
				
				String[] goodString = tNostringMapperCustom.getGoodString();*/
				
				/*List<String> asList = Arrays.asList(goodString);*/
				
				List<THscode> list = new ArrayList<THscode>();
				// 读取文件中的行
				aa:for (Entry<Integer, Object[]> entry : items.entrySet()) {
					if (firstRow) {
						firstRow = false;
						continue;
					}
					// 将文件的一行放到数组中
					Object[] nowRowData = (Object[]) entry.getValue();
					// 拿到数据所在行
					int rows = entry.getKey() + 1;
					
					// 判断数据是否为空
					Object data1 = nowRowData[0];
					if (data1 == null || StringUtils.isEmpty(data1.toString().trim())) {
						Str.append("导入第" + rows + "行数据HSCODE失败<br>/");
						continue;
					}
					Object data2 = nowRowData[1];
					if (data2 == null || StringUtils.isEmpty(data2.toString().trim())) {
						Str.append("导入第" + rows + "行数据商品名称失败<br>/");
						continue;
					}
					
					
					/*for(String str:noString){
						// 判断商品名称是否存在违禁字段
						if(str.contains(data2.toString().trim())){
							// 判断商品名称是否存在白名单
							if (!asList.contains(data2.toString().trim())) {
								Str.append("导入第" + rows + "行数据失败,失败原因:商品名称存在违禁字段!<br>/");
								continue aa;
							}
						}
					}*/
					
					
					// 判断数据是否在数据库中已经存在
					for (THscode tHscode : hscodeAndItemName) {
						if (tHscode.getHcode().equals(data1.toString().trim())) {
							Str.append("第" + rows + "行数据上传失败,失败原因:hcode已经存在!<br>");
							continue aa;
						}else if (tHscode.getItemname().equals(data2.toString().trim())) {
							Str.append("第" + rows + "行数据上传失败,失败原因:商品名称已经存在!<br>");
							continue aa;
						}
					}
					
					Object data3 = nowRowData[2];
					if (data3 == null || StringUtils.isEmpty(data3.toString().trim())) {
						Str.append("导入第" + rows + "行数据第一计量单位失败<br>/");
						continue;
					}
					Object data4 = nowRowData[3];
					if (data4 == null || StringUtils.isEmpty(data4.toString().trim())) {
						Str.append("导入第" + rows + "行数据第二计量单位失败<br>/");
						continue;
					}
					Object data5 = nowRowData[4];
					/*	if (data5 == null || StringUtils.isEmpty(data5.toString().trim())) {
						Str.append("导入第" + rows + "行数据备注失败<br>/");
						continue;
					}*/
					
					
					// 将读取的数据放到集合对象中
					THscode hsocde = new THscode();
					hsocde.setHcode(data1.toString());
					hsocde.setItemname(data2.toString());
					hsocde.setUnit1(data3.toString());
					hsocde.setUnit2(data4.toString());
					hsocde.setTime(new Date());
					hsocde.setIsok(1);
					hsocde.setUserid(Integer.valueOf(userId));
					hsocde.setBz(data5.toString());
					list.add(hsocde);
				}
				E3Result result = new E3Result();
				// 判断读取的数据条数是否等于表格中的总条数
				if (list.size() == dataTotal) {
					result.setStatus(200);
					tHscodeMapperCustom.insertAll(list);
					Str.append("总共" + dataTotal + "条数据,导入成功" + list.size() + "条!<br>");
					result.setMsg(Str.toString());
				}else {
					result.setMsg(Str.toString());
				}
				return result;
	}

	@Override
	public List<THscode> exportHcode(String id, THscode tHscode) throws Exception {
		if ("".equals(id) || null == id) {
			List<THscode> list = tHscodeMapperCustom.getAllHsCode(tHscode);
			return list;
		} else {
			List<THscode> list = tHscodeMapperCustom.getByID(id);
			return list;
		}
	}

}
