package cn.mldn.dept.api.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.mldn.dept.api.abs.dao.AbstractDAO;
import cn.mldn.dept.api.dao.IDeptDAO;
import cn.mldn.dept.api.vo.Dept;
@Repository
public class DeptDAOImpl extends AbstractDAO implements IDeptDAO,RowMapper<Dept> {

	@Override
	public boolean doCreate(Dept vo) {
		String sql="insert into dept (dname,loc,dflag) values (?,?,?)" ;
		return super.jdbcTemplate.update(sql, vo.getDname(),vo.getLoc(),0)>0;
	}

	@Override
	public boolean doEdit(Dept vo) {
		String sql="update  dept set dname=?,loc=? where deptno =?" ;
		return super.jdbcTemplate.update(sql, vo.getDname(),vo.getLoc(),vo.getDeptno())>0;
	}

	@Override
	public boolean doRemove(Long id) {
		String sql="delete from dept where deptno =? ";
		return super.jdbcTemplate.update(sql, new Object[] {id})>0;
	}

	@Override
	public boolean doRemove(Set<Long> ids) {
		return false;
	}

	@Override
	public Dept findById(Long id) {
		String sql="select deptno,dname,loc from dept where dflag=0 and deptno =? ";
		return super.jdbcTemplate.queryForObject(sql, new Object[] { id }, this);
	}

	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAll(Long currentPage, Integer lineSize) {
		String sql="select deptno,dname,loc from dept where dflag=0 limit ?,?";
		return super.jdbcTemplate.query(sql, new Object[] { (currentPage - 1) * lineSize, lineSize }, this);

	}

	@Override
	public List<Dept> findSplit(String column, String keyWord, Long currentPage, Integer lineSize) {
		String sql="select deptno ,dname,loc from dept where dflag =0 and "+column+" like ? limit ?,?"; 
	
		return super.jdbcTemplate.query(sql, new Object[] {"%"+keyWord+"%", (currentPage - 1) * lineSize, lineSize }, this);
	}

	@Override
	public Long getAllCount() {
		String sql="select count(*) from dept where dflag =0 ";
		return super.jdbcTemplate.queryForObject(sql, Long.class);
	}

	@Override
	public Long getSplitCount(String column, String keyWord) {
		String sql="select count(*) from dept where "+column+" like ?  and dflag =0";
		return super.jdbcTemplate.queryForObject(sql, new Object[] { "%" + keyWord + "%" }, Long.class);
	}

	@Override
	public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
		Dept vo =new Dept();
		vo.setDeptno(rs.getLong(1));
		vo.setDname(rs.getString(2));
		vo.setLoc(rs.getString(3));
		vo.setDflag(0);
		return vo;
	}

}
