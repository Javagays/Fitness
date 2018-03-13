package cn.easyproject.easyee.sm.user.criteria;

import cn.easyproject.easyee.sm.base.pagination.EasyCriteria;
import cn.easyproject.easyee.sm.base.util.StringUtils;

public class UserCriteria extends EasyCriteria implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
 	 * 1. 条件属性
 	 */
	
	private String userName;
	private String userPhone;
	
	 /*
 	 * 2. 构造方法
 	 */
	public UserCriteria() {
		super();
	}


	public UserCriteria(String userName, String userPhone) {
		super();
		this.userName = userName;
		this.userPhone = userPhone;
	}


	/*
 	 * 3. 条件生成抽象方法实现
 	 */
	public String getCondition() {
		values.clear(); //清除条件数据
		StringBuffer condition = new StringBuffer();
		if (StringUtils.isNotNullAndEmpty(this.getUserName())) {
			condition.append(" and user_name like #{userName}");
			values.put("userName", "%" + this.getUserName() + "%");
		}
		if (StringUtils.isNotNullAndEmpty(this.getUserPhone())) {
			condition.append(" and user_phone={userPhone}");
			values.put("userPhone",this.getUserPhone());
		}
		return condition.toString();
	}


	 /*
 	 * 4. Setters & Getters...
 	 */
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	


	
}