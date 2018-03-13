package cn.easyproject.easyee.sm.user.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
public class User implements java.io.Serializable {

	// Fields

	/**
	 * user_idint(11) NOT NULL用户ID
		user_namevarchar(255) NULL用户昵称
		user_phonevarchar(255) NULL用户电话号码
		user_integralint(11) NULL用户积分
		home_locationvarchar(255) NULL家庭住址
		work_locationvarchar(255) NULL工作地址
		sitevarchar(255) NULL场地
		birthdaydate NULL生日
		user_IDcardvarbinary(255) NULL身份证号
		login_timedate NULL注册时间
		heightvarbinary(64) NULL身高
		weightvarbinary(64) NULL体重
		sexvarchar(64) NULL性别,0代表女，1代表男
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userName;
	private String userPhone;
	private Integer userIntegral;
	private String homeLocation;
	private String workLocation;
	private String site;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date birthday;
	private String userIDcard;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date registerTime;
	private double height;
	private double weight;
	private String sex;

	
//	private Set moduleEmps = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}
	
	/** full constructor */
	
	public User(Integer userId, String userName, String userPhone, Integer userIntegral, String homeLocation,
			String workLocation, String site, Date birthday, String userIDcard, Date registerTime, double height,
			double weight, String sex) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userIntegral = userIntegral;
		this.homeLocation = homeLocation;
		this.workLocation = workLocation;
		this.site = site;
		this.birthday = birthday;
		this.userIDcard = userIDcard;
		this.registerTime = registerTime;
		this.height = height;
		this.weight = weight;
		this.sex = sex;
	}
	


	public User(String userName, String userPhone, Integer userIntegral, String homeLocation, String workLocation,
			String site, Date birthday, String userIDcard, Date registerTime, double height, double weight,
			String sex) {
		super();
		this.userName = userName;
		this.userPhone = userPhone;
		this.userIntegral = userIntegral;
		this.homeLocation = homeLocation;
		this.workLocation = workLocation;
		this.site = site;
		this.birthday = birthday;
		this.userIDcard = userIDcard;
		this.registerTime = registerTime;
		this.height = height;
		this.weight = weight;
		this.sex = sex;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public Integer getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}

	public String getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserIDcard() {
		return userIDcard;
	}

	public void setUserIDcard(String userIDcard) {
		this.userIDcard = userIDcard;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", userIntegral="
				+ userIntegral + ", homeLocation=" + homeLocation + ", workLocation=" + workLocation + ", site=" + site
				+ ", birthday=" + birthday + ", userIDcard=" + userIDcard + ", registerTime=" + registerTime
				+ ", height=" + height + ", weight=" + weight + ", sex=" + sex + "]";
	}


}