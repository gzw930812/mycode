package com.cptech.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cptech.common.annotation.Log;
import com.cptech.common.controller.BaseController;
import com.cptech.common.domain.Tree;
import com.cptech.common.utils.R;
import com.cptech.system.domain.DeptDO;
import com.cptech.system.domain.UserDO;
import com.cptech.system.service.DeptService;

@Controller
@RequestMapping("/system/sysDept")
public class DeptController extends BaseController {
	private String prefix = "system/dept";
	@Autowired
	private DeptService sysDeptService;
	@GetMapping()
	@RequiresPermissions("system:sysDept:sysDept")
	String dept() {
		return prefix + "/dept";
	}
	
	@Log("查询机构列表")
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:sysDept:sysDept")
	public Map<String, Object> list(DeptDO deptDO) {
		deptDO.setParentId(getUser().getDeptId());
		DeptDO depts = sysDeptService.findAllByTree(deptDO);
		Map<String, Object> map=new HashMap<>();
		map.put("rs", depts!=null?1:0);
		map.put("data", depts);
		return map;
	}

	@GetMapping("/add/{pId}")
	@RequiresPermissions("system:sysDept:add")
	String add(@PathVariable("pId") String pId, Model model) {
		String pName="";
		if("-1".equals(pId)) {
			UserDO user = getUser();
			String deptId = user.getDeptId();
			pId=deptId;
			DeptDO deptDO = sysDeptService.get(deptId);
			pName=deptDO==null?"上级机构已删除，请选择上级机构":deptDO.getName();
		} else {
			DeptDO deptDO = sysDeptService.get(pId);
			pName=deptDO==null?"上级机构已删除，请选择上级机构":deptDO.getName();
		}
		model.addAttribute("pId", pId);
		model.addAttribute("pName", pName);
		return  prefix + "/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:sysDept:edit")
	String edit(@PathVariable("id") String id, Model model) {
		DeptDO sysDept = sysDeptService.get(id);
		model.addAttribute("sysDept", sysDept);
		DeptDO parDept = sysDeptService.get(sysDept.getParentId());
		model.addAttribute("parentDeptName", parDept.getName());
		
		return  prefix + "/edit";
	}

	/**
	 * 保存
	 */
	@Log("保存机构")
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:sysDept:add")
	public R save(DeptDO sysDept) {
		if (sysDeptService.save(sysDept) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@Log("修改机构")
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:sysDept:edit")
	public R update(DeptDO sysDept) {
		if (sysDeptService.update(sysDept) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@Log("删除机构")
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("system:sysDept:remove")
	public R remove(String id) {
		DeptDO dpt=new DeptDO();
		dpt.setParentId(id);
		if("1".equals(id)) {
			return R.error(1, "根机构,不允许修改");
		}
		if(sysDeptService.count(dpt)>0) {
			return R.error(1, "包含下级机构,不允许修改");
		}
		if(sysDeptService.checkDeptHasUser(id)) {
			if (sysDeptService.remove(id) > 0) {
				return R.ok();
			}
		}else {
			return R.error(1, "机构包含用户,不允许修改");
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@Log("批量删除机构")
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:sysDept:batchRemove")
	public R remove(@RequestParam("ids[]") String[] deptIds) {
		sysDeptService.batchRemove(deptIds);
		return R.ok();
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<DeptDO> tree() {
		Tree<DeptDO> tree = new Tree<DeptDO>();
		DeptDO deptDO=new DeptDO();
		deptDO.setParentId(getUser().getDeptId());
		tree = sysDeptService.getTree(deptDO);
		return tree;
	}

	@GetMapping("/treeView")
	String treeView() {
		return  prefix + "/deptTree";
	}

}
