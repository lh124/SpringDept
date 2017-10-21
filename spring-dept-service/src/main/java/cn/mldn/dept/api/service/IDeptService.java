package cn.mldn.dept.api.service;

import java.util.Map;

import cn.mldn.dept.api.vo.Dept;

public interface IDeptService  {
	public boolean add(Dept vo)  ;

	public boolean edit(Dept vo)  ;

	public boolean delete (Long id)  ;

	public Map<String,Object>  perEdit(Long id) ;

	public Long get();
	public Map<String,Object> list(String column, String keyWord, Long currentPage, Integer lineSize);
}
