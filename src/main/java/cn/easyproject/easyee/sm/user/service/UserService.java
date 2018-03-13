package cn.easyproject.easyee.sm.user.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.user.criteria.UserCriteria;
import cn.easyproject.easyee.sm.user.entity.User;
/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
@Transactional
public interface UserService {
	
	public void save(User user);
	public void delete(Serializable userId);
	public void update(User user);
	
	@Transactional(readOnly=true)
	public User get(Integer userId);
	
	public User get(String user_phone);

	@SuppressWarnings("rawtypes")
	@Transactional(readOnly=true)
	public void findByPage(PageBean pageBean, UserCriteria userCriteria);
	
	@Transactional(readOnly=true)
	public List<User> findAll();
}
