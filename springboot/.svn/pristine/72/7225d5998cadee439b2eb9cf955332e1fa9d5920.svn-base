package com.cptech.common.controller;

import java.util.List;

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
import com.cptech.common.domain.DictDO;
import com.cptech.common.service.DictService;
import com.cptech.common.utils.PageUtils;
import com.cptech.common.utils.R;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * 字典表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-29 18:28:07
 */

@Controller
@RequestMapping("/common/dict")
public class DictController extends BaseController {
	@Autowired
	private DictService dictService;

	@GetMapping()
	@RequiresPermissions("common:dict:dict")
	String dict() {
		return "common/dict/dict";
	}
	
	@Log("字典-查询列表")
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:dict:dict")
	public PageUtils list(DictDO dictDO) {
		// 查询列表数据
		Page<DictDO> findByPage = dictService.findByPage(dictDO);
		PageInfo<DictDO> pageInfo = new PageInfo<>(findByPage);
		PageUtils pageUtil = new PageUtils(pageInfo.getList(), (int)pageInfo.getTotal());
		return pageUtil;
	}

	@GetMapping("/add")
	@RequiresPermissions("common:dict:add")
	String add() {
		return "common/dict/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:dict:edit")
	String edit(@PathVariable("id") String id, Model model) {
		DictDO dict = dictService.get(id);
		model.addAttribute("dict", dict);
		return "common/dict/edit";
	}

	/**
	 * 保存
	 */
	@Log("添加字典")
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:dict:add")
	public R save(DictDO dict) {
		if (dictService.save(dict) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@Log("修改字典")
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:dict:edit")
	public R update(DictDO dict) {
		dictService.update(dict);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@Log("删除字典")
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("common:dict:remove")
	public R remove(String id) {
		if (dictService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@Log("批量删除字典")
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:dict:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids) {
		dictService.batchRemove(ids);
		return R.ok();
	}

	@GetMapping("/type")
	@ResponseBody
	public List<DictDO> listType() {
		return dictService.listType();
	};

	// 类别已经指定增加
	@GetMapping("/add/{type}/{description}")
	@RequiresPermissions("common:dict:add")
	String addD(Model model, @PathVariable("type") String type, @PathVariable("description") String description) {
		model.addAttribute("type", type);
		model.addAttribute("description", description);
		return "common/dict/add";
	}

	@ResponseBody
	@GetMapping("/list/{type}")
	public List<DictDO> listByType(@PathVariable("type") String type) {
		// 查询列表数据
		DictDO dict=new DictDO();
    	dict.setType(type);
		List<DictDO> dictList = dictService.findAll(dict);
		return dictList;
	}
}
