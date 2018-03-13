package cn.easyproject.easyee.sm.buyorder.criteria;

import cn.easyproject.easyee.sm.base.pagination.EasyCriteria;
import cn.easyproject.easyee.sm.base.util.StringUtils;

@SuppressWarnings("serial")
public class BuyOrderCriteria extends EasyCriteria implements java.io.Serializable{

	private Integer orderId;    //订单id
	private Integer userId;     //关联的用户id
	private String cardName;     //卡名称
	private Integer cardType;	//卡种类
	private Integer cardPrice;    //价格
	private String cardCourse;    //课程
	private Integer cardDate;		//使用期限天数
	private String cardSite;     //场地
	private Integer cardFaceAmount;    //面额
	private Integer useNumber;    //使用次数
	private String cardSalesMan;   //销售人员
	private Integer cardState;    //状态
	
	public BuyOrderCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getCondition() {
		values.clear(); //清除条件数据
		StringBuffer condition = new StringBuffer();
		if(StringUtils.isNotNullAndEmpty(this.getOrderId())){
			condition.append(" and order_id like #{orderId}");
			values.put("orderId", "%"+this.getOrderId()+"%");
		}
		if(StringUtils.isNotNullAndEmpty(this.getUserId())){
			condition.append(" and user_id=#{userId}");
			values.put("userId",this.getUserId());
		}
		if(StringUtils.isNotNullAndEmpty(this.getCardName())){
			condition.append(" and card_name=#{cardName}");
			values.put("cardName",this.getCardName());
		}
		if(StringUtils.isNotNullAndEmpty(this.getCardType())){
			condition.append(" and card_type=#{cardType}");
			values.put("cardType",this.getCardType());
		}
		if(StringUtils.isNotNullAndEmpty(this.getCardPrice())){
			condition.append(" and card_price=#{cardPrice}");
			values.put("cardPrice",this.getCardPrice());
		}
		if(StringUtils.isNotNullAndEmpty(this.getCardCourse())){
			condition.append(" and card_course=#{cardCourse}");
			values.put("cardCourse",this.getCardCourse());
		}
		if(StringUtils.isNotNullAndEmpty(this.getCardDate())){
			condition.append(" and card_date=#{cardDate}");
			values.put("cardDate",this.getCardDate());
		}
		if(StringUtils.isNotNullAndEmpty(this.getCardSite())){
			condition.append(" and card_site=#{cardSite}");
			values.put("cardSite",this.getCardSite());
		}
		if(StringUtils.isNotNullAndEmpty(this.getCardSalesMan())){
			condition.append(" and card_salesman=#{cardSalesMan}");
			values.put("cardSalesMan",this.getCardSalesMan());
		}
		if(StringUtils.isNotNullAndEmpty(this.getCardFaceAmount())){
			condition.append(" and card_face_amount=#{cardFaceAmount}");
			values.put("cardFaceAmount",this.getCardFaceAmount());
		}
		if(StringUtils.isNotNullAndEmpty(this.getUseNumber())){
			condition.append(" and use_number=#{useNumber}");
			values.put("useNumber",this.getUseNumber());
		}
		if(StringUtils.isNotNullAndEmpty(this.getCardState())){
			condition.append(" and card_state=#{cardState}");
			values.put("cardState",this.getCardState());
		}
		return condition.toString();
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	public Integer getCardPrice() {
		return cardPrice;
	}
	public void setCardPrice(Integer cardPrice) {
		this.cardPrice = cardPrice;
	}
	public String getCardCourse() {
		return cardCourse;
	}
	public void setCardCourse(String cardCourse) {
		this.cardCourse = cardCourse;
	}
	public Integer getCardDate() {
		return cardDate;
	}
	public void setCardDate(Integer cardDate) {
		this.cardDate = cardDate;
	}
	public String getCardSite() {
		return cardSite;
	}
	public void setCardSite(String cardSite) {
		this.cardSite = cardSite;
	}
	public Integer getCardFaceAmount() {
		return cardFaceAmount;
	}
	public void setCardFaceAmount(Integer cardFaceAmount) {
		this.cardFaceAmount = cardFaceAmount;
	}
	public Integer getUseNumber() {
		return useNumber;
	}
	public void setUseNumber(Integer useNumber) {
		this.useNumber = useNumber;
	}
	public String getCardSalesMan() {
		return cardSalesMan;
	}
	public void setCardSalesMan(String cardSalesMan) {
		this.cardSalesMan = cardSalesMan;
	}
	public Integer getCardState() {
		return cardState;
	}
	public void setCardState(Integer cardState) {
		this.cardState = cardState;
	}

	
}
