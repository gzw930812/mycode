package com.cptech.system.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cptech.common.config.GlobleConfig;
import com.cptech.common.domain.FileDO;
import com.cptech.common.domain.Tree;
import com.cptech.common.service.FileService;
import com.cptech.common.utils.BuildTree;
import com.cptech.common.utils.FileType;
import com.cptech.common.utils.FileUtil;
import com.cptech.common.utils.ImageUtils;
import com.cptech.common.utils.MD5Utils;
import com.cptech.system.dao.DeptDao;
import com.cptech.system.dao.UserDao;
import com.cptech.system.dao.UserRoleDao;
import com.cptech.system.domain.DeptDO;
import com.cptech.system.domain.UserDO;
import com.cptech.system.domain.UserRoleDO;
import com.cptech.system.service.UserService;
import com.cptech.system.vo.UserVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

//@CacheConfig(cacheNames = "user")
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userMapper;
    @Autowired
    UserRoleDao userRoleMapper;
    @Autowired
    DeptDao deptMapper;
    @Autowired
    private FileService sysFileService;
    @Autowired
    private GlobleConfig globleConfig;
    //private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public UserDO get(String id) {
        List<String> roleIds = userRoleMapper.listRoleId(id);
        UserDO user = userMapper.get(id);
        DeptDO deptDO = deptMapper.get(user.getDeptId());
        user.setDeptName(deptDO==null?"无":deptDO.getName());
        user.setRoleIds(roleIds);
        return user;
    }

    @Override
    public int count(UserDO user) {
        return userMapper.count(user);
    }

    @Transactional
    @Override
    public int save(UserDO user) {
    	user.preInsert();
    	String userId = user.getId();
        int count = userMapper.save(user);
        List<String> roles = user.getRoleIds();
        userRoleMapper.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (String roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            ur.preInsert();
            list.add(ur);
        }
        if (list.size() > 0) {
        	if("mysql".equals(user.getDatabaseType()))
        		userRoleMapper.batchSaveForMysql(list);
        	else
        		userRoleMapper.batchSaveForOracle(list);
        }
        return count;
    }

    @Override
    public int update(UserDO user) {
    	user.preUpdate();
        int r = userMapper.update(user);
        String userId = user.getId();
        List<String> roles = user.getRoleIds();
        userRoleMapper.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (String roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            ur.preInsert();
            list.add(ur);
        }
        if (list.size() > 0) {
        	if("mysql".equals(user.getDatabaseType()))
        		userRoleMapper.batchSaveForMysql(list);
        	else
        		userRoleMapper.batchSaveForOracle(list);
        }
        return r;
    }

    @Override
    public int remove(String userId) {
        userRoleMapper.removeByUserId(userId);
        return userMapper.remove(userId);
    }

    @Override
    public boolean exit(UserDO user) {
        boolean exit;
        exit = userMapper.findAll(user).size() > 0;
        return exit;
    }

    @Override
    public Set<String> listRoles(String userId) {
        return null;
    }

    @Override
    public int resetPwd(UserVO userVO, UserDO userDO) throws Exception {
        if (Objects.equals(userVO.getUserDO().getId(), userDO.getId())) {
            if (Objects.equals(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdOld()), userDO.getPassword())) {
                userDO.setPassword(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdNew()));
                userDO.preUpdate();
                return userMapper.update(userDO);
            } else {
                throw new Exception("输入的旧密码有误！");
            }
        } else {
            throw new Exception("你修改的不是你登录的账号！");
        }
    }

    @Override
    public int adminResetPwd(UserVO userVO) throws Exception {
        UserDO userDO = get(userVO.getUserDO().getId());
        if ("admin".equals(userDO.getUsername())) {
            throw new Exception("超级管理员的账号不允许直接重置！");
        }
        userDO.setPassword(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdNew()));
        userDO.preUpdate();
        return userMapper.update(userDO);


    }

    @Transactional
    @Override
    public int batchremove(String[] userIds) {
        int count = userMapper.batchRemove(userIds);
        userRoleMapper.batchRemoveByUserId(userIds);
        return count;
    }

    @Override
    public Tree<DeptDO> getTree() {
        List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
        List<DeptDO> depts = deptMapper.findAll(new DeptDO());
        String[] pDepts = deptMapper.listParentDept();
        String[] uDepts = userMapper.listAllDept();
        String[] allDepts = (String[]) ArrayUtils.addAll(pDepts, uDepts);
        for (DeptDO dept : depts) {
            if (!ArrayUtils.contains(allDepts, dept.getId())) {
                continue;
            }
            Tree<DeptDO> tree = new Tree<DeptDO>();
            tree.setId(dept.getId().toString());
            tree.setParentId(dept.getParentId().toString());
            tree.setText(dept.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "dept");
            tree.setState(state);
            trees.add(tree);
        }
        List<UserDO> users = userMapper.findAll(new UserDO());
        for (UserDO user : users) {
            Tree<DeptDO> tree = new Tree<DeptDO>();
            tree.setId(user.getId().toString());
            tree.setParentId(user.getDeptId().toString());
            tree.setText(user.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "user");
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<DeptDO> t = BuildTree.build(trees,"根菜单");
        return t;
    }

    @Override
    public int updatePersonal(UserDO userDO) {
    	userDO.preUpdate();
        return userMapper.update(userDO);
    }

    @Override
    public Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, String userId) throws Exception {
        String fileName = file.getOriginalFilename();
        fileName = FileUtil.renameToUUID(fileName);
        FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName);
        //获取图片后缀
        String prefix = fileName.substring((fileName.lastIndexOf(".") + 1));
        String[] str = avatar_data.split(",");
        //获取截取的x坐标
        int x = (int) Math.floor(Double.parseDouble(str[0].split(":")[1]));
        //获取截取的y坐标
        int y = (int) Math.floor(Double.parseDouble(str[1].split(":")[1]));
        //获取截取的高度
        int h = (int) Math.floor(Double.parseDouble(str[2].split(":")[1]));
        //获取截取的宽度
        int w = (int) Math.floor(Double.parseDouble(str[3].split(":")[1]));
        //获取旋转的角度
        int r = Integer.parseInt(str[4].split(":")[1].replaceAll("}", ""));
        try {
            BufferedImage cutImage = ImageUtils.cutImage(file, x, y, w, h, prefix);
            BufferedImage rotateImage = ImageUtils.rotateImage(cutImage, r);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(rotateImage, prefix, out);
            //转换后存入数据库
            byte[] b = out.toByteArray();
            FileUtil.uploadFile(b, globleConfig.getUploadPath(), fileName);
        } catch (Exception e) {
            throw new Exception("图片裁剪错误！！");
        }
        Map<String, Object> result = new HashMap<>();
        sysFile.preInsert();
        String fileId = sysFile.getId();
        if (sysFileService.save(sysFile) > 0) {
            UserDO userDO = new UserDO();
            userDO.setId(userId);
            userDO.setPicId(fileId);
            userDO.preUpdate();
            if (userMapper.update(userDO) > 0) {
                result.put("url", sysFile.getUrl());
            }
        }
        return result;
    }

	@Override
	public List<UserDO> findAll(UserDO user) {
		return userMapper.findAll(user);
	}

	@Override
	public Page<UserDO> findByPage(UserDO user) {
		PageHelper.startPage(user.getOffset(), user.getLimit());
		Page<UserDO> findByPage = userMapper.findByPage(user);
		for (UserDO userDO : findByPage) {
			String deptId = userDO.getDeptId();
			DeptDO deptDO = deptMapper.get(deptId);
			String areaId = deptDO.getAreaId();
			String parentAreaName = "";
			if("1".equals(areaId)){
				parentAreaName="中华人民共和国";
			}else{
				parentAreaName=deptMapper.getParentAreaName(deptDO.getAreaId());
			}
			userDO.setDeptName(deptDO.getName());
			userDO.setProvince(parentAreaName);
		}
		return findByPage;
	}

}
