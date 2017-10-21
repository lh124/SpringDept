package cn.mldn.dept.api.abs.service;

public abstract class AbstractService {
	public boolean isEmpty(String str) {
		if (str == null || "".equals(str)) {
			return true ;
		}
		return false ;
	}
}
