package cn.mldn.dept.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dept.api.abs.service.AbstractService;
import cn.mldn.dept.api.dao.IDeptDAO;
import cn.mldn.dept.api.service.IDeptService;
import cn.mldn.dept.api.vo.Dept;
@Service
public class DeptServiceImpl extends AbstractService implements IDeptService {
	@Resource
	private IDeptDAO dao;
	@Override
	public boolean add(Dept vo)  {
		vo.setDflag(0);
		return dao.doCreate(vo);
	}

	@Override
	public boolean edit(Dept vo)  {
		return dao.doEdit(vo);
	}

	@Override
	public boolean delete(Long id)  {
		return this.dao.doRemove(id);
	}

	@Override
	public Map<String,Object> perEdit(Long id)  {
		Map<String,Object> map=new HashMap<>();
		map.put("alldept", this.dao.findById(id));
		return map;
	}



	@Override
	public Long get()  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (super.isEmpty(column) || super.isEmpty(keyWord)) { // 查询全部操作
			map.put("allRecorders", this.dao.getAllCount());
			map.put("alldept", this.dao.findAll(currentPage, lineSize));
		} else {
			map.put("allRecorders", this.dao.getSplitCount(column, keyWord));
			map.put("alldept", this.dao.findSplit(column, keyWord, currentPage, lineSize));
		}
		return map;
	}

}
