package cn.mldn.dept.api.abs.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDAO {
	@Resource
	protected JdbcTemplate jdbcTemplate ;
}
