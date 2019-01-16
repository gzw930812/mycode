package com.cptech.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cptech.common.domain.Tree;
import com.cptech.system.domain.DeptDO;
import com.cptech.system.domain.UserDO;
import com.cptech.system.vo.UserVO;
import com.github.pagehelper.Page;

@Service
public interface UserService {
	UserDO get(String id);

	List<UserDO> findAll(UserDO user);
	
	Page<UserDO> findByPage(UserDO user);

	int count(UserDO user);

	int save(UserDO user);

	int update(UserDO user);

	int remove(String userId);

	int batchremove(String[] userIds);

	boolean exit(UserDO user);

	Set<String> listRoles(String userId);

	int resetPwd(UserVO userVO,UserDO userDO) throws Exception;
	int adminResetPwd(UserVO userVO) throws Exception;
	Tree<DeptDO> getTree();

	/**
	 * 更新个人信息
	 * @param userDO
	 * @return
	 */
	int updatePersonal(UserDO userDO);

	/**
	 * 更新个人图片
	 * @param file 图片
	 * @param avatar_data 裁剪信息
	 * @param userId 用户ID
	 * @throws Exception
	 */
    Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, String userId) throws Exception;
}
