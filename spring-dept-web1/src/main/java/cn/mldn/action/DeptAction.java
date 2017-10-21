package cn.mldn.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dept.api.service.IDeptService;
import cn.mldn.dept.api.vo.Dept;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;
@Controller
@RequestMapping("/pages/back/admin/dept/*")
public class DeptAction  extends AbstractAction{
	@Resource
	private IDeptService deptService;
	@RequestMapping("dept_add")
	public ModelAndView add(Dept vo) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page")) ;
		if (this.deptService.add(vo)) {
			super.setMsgAndUrl(mav, "dept.add.action", "vo.add.success", "部门");
		}  else {
			super.setMsgAndUrl(mav, "dept.add.action", "vo.add.failure", "部门");
		}
		return mav ;
	}
	@RequestMapping("dept_add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("dept.add.page")) ;
		return mav ;
	}
	@RequestMapping("dept_list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getPage("dept.list.page")) ;
		SplitPageUtil spu = new SplitPageUtil("部门名称:dname", super.getPage("dept.list.action")) ;
		Map<String,Object> map = this.deptService.list(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize()) ;
		mav.addAllObjects(map) ;
		return mav ;
	}

	@RequestMapping("dept_delete")
	public ModelAndView delete(Long deptno) { 
		ModelAndView mav = new ModelAndView(super.getPage("forward.page")) ;
		if(this.deptService.delete(deptno)) {
			super.setMsgAndUrl(mav, "dept.list.action", "vo.delete.success", "部门");
		}else {
			super.setMsgAndUrl(mav, "dept.list.action", "vo.delete.success", "部门");
		}
		return mav;
	}
	@RequestMapping("edit_pre")
	public ModelAndView preEdit(Long deptno) {
		ModelAndView mav = new ModelAndView(super.getPage("dept.edit.page")) ;
		System.out.println(this.deptService.perEdit(deptno)); 
		mav.addAllObjects(this.deptService.perEdit(deptno));
		return mav;
	}
	@RequestMapping("dept_edit1")
	public ModelAndView edit(Dept vo) {
		System.out.println("111111111111111");
		ModelAndView mav = new ModelAndView(super.getPage("forward.page")) ;
		if (this.deptService.edit(vo)) {
			System.out.println("(888888888888");
			super.setMsgAndUrl(mav, "dept.list.action", "vo.edit.success", "部门");
		}  else {
			System.out.println("(999999999999");
			super.setMsgAndUrl(mav, "dept.list.action", "vo.edit.failure", "部门");
		}  
		return mav;
	}
}
