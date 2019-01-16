package com.cptech.common.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cptech.common.dao.DictDao;
import com.cptech.common.domain.DictDO;
import com.cptech.common.service.DictService;
import com.cptech.common.utils.StringUtils;
import com.cptech.system.domain.UserDO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictDao dictDao;

    @Override
    public DictDO get(String id) {
        return dictDao.get(id);
    }

    @Override
    public int count(DictDO dict) {
        return dictDao.count(dict);
    }

    @Override
    public int save(DictDO dict) {
    	dict.preInsert();
        return dictDao.save(dict);
    }

    @Override
    public int update(DictDO dict) {
    	dict.preUpdate();
        return dictDao.update(dict);
    }

    @Override
    public int remove(String id) {
        return dictDao.remove(id);
    }

    @Override
    public int batchRemove(String[] ids) {
        return dictDao.batchRemove(ids);
    }

    @Override

    public List<DictDO> listType() {
        return dictDao.listType();
    }

    @Override
    public String getName(String type, String value) {
        DictDO dict=new DictDO();
    	dict.setType(type);
    	dict.setValue(value);
        String rString = dictDao.findAll(dict).get(0).getName();
        return rString;
    }

    @Override
    public List<DictDO> getHobbyList(UserDO userDO) {
    	DictDO dict=new DictDO();
    	dict.setType("hobby");
        List<DictDO> hobbyList = dictDao.findAll(dict);

        if (StringUtils.isNotEmpty(userDO.getHobby())) {
            String userHobbys[] = userDO.getHobby().split(";");
            for (String userHobby : userHobbys) {
                for (DictDO hobby : hobbyList) {
                    if (!Objects.equals(userHobby, hobby.getId().toString())) {
                        continue;
                    }
                    hobby.setRemarks("true");
                    break;
                }
            }
        }

        return hobbyList;
    }

    @Override
    public List<DictDO> getSexList() {
    	DictDO dict=new DictDO();
    	dict.setType("sex");
        return dictDao.findAll(dict);
    }

    @Override
    public List<DictDO> listByType(String type) {
    	DictDO dict=new DictDO();
    	dict.setType(type);
        return dictDao.findAll(dict);
    }

	@Override
	public List<DictDO> findAll(DictDO dict) {
		return dictDao.findAll(dict);
	}

	@Override
	public Page<DictDO> findByPage(DictDO dict) {
		PageHelper.startPage(dict.getOffset(),dict.getLimit());
		return dictDao.findByPage(dict);
	}

}
