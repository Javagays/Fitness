package cn.easyproject.easyee.sm.user.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.service.BaseService;
import cn.easyproject.easyee.sm.user.criteria.UserCriteria;
import cn.easyproject.easyee.sm.user.dao.UserDAO;
import cn.easyproject.easyee.sm.user.entity.User;
import cn.easyproject.easyee.sm.user.service.UserService;

/**
 * 业务实现类统一继承 BaseService 类
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

	@Resource
	UserDAO userDAO;
	
	@Override
	public void save(User user) {
		userDAO.save(user);
	}

	@Override
	public void delete(Serializable userId) {
		userDAO.delete(userId);
	}

	@Override
	public void update(User user) {
		userDAO.update(user);
	}

	

	@SuppressWarnings({ "rawtypes"})
	@Override
	public void findByPage(PageBean pageBean, UserCriteria userCriteria) {
		pageBean.setFrom("user user");
		pageBean.setSelect("user.*");
		pageBean.setEasyCriteria(userCriteria);
		// 按条件分页查询
		userDAO.pagination(pageBean);
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User get(Integer userId) {
		return userDAO.get(userId);
	}

	

	@Override
	public User get(String user_phone) {
		// TODO Auto-generated method stub
		return userDAO.get(user_phone);
	}
}
