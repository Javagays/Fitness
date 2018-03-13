package cn.easyproject.easyee.sm.user.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.user.entity.User;
/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
public interface UserDAO {
	
	public void save(User user);

	public void delete(Serializable userId);

	public void update(User user);
	
	public User get(Integer userId);
	
	public User get(String user_phone);

	@SuppressWarnings("rawtypes")
	public List pagination(PageBean pageBean);

	public List<User> findAll();
	
	public int findMaxRow();
}
