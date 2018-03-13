package cn.easyproject.easyee.sm.buyorder.entity;

public class BuyOrder {

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
	public BuyOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyOrder(Integer orderId, Integer userId, String cardName, Integer cardType, Integer cardPrice,
			String cardCourse, Integer cardDate, String cardSite, Integer cardFaceAmount, Integer useNumber,
			String cardSalesMan, Integer cardState) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.cardName = cardName;
		this.cardType = cardType;
		this.cardPrice = cardPrice;
		this.cardCourse = cardCourse;
		this.cardDate = cardDate;
		this.cardSite = cardSite;
		this.cardFaceAmount = cardFaceAmount;
		this.useNumber = useNumber;
		this.cardSalesMan = cardSalesMan;
		this.cardState = cardState;
	}
	@Override
	public String toString() {
		return "BuyOrder [orderId=" + orderId + ", userId=" + userId + ", cardName=" + cardName + ", cardType="
				+ cardType + ", cardPrice=" + cardPrice + ", cardCourse=" + cardCourse + ", cardDate=" + cardDate
				+ ", cardSite=" + cardSite + ", cardFaceAmount=" + cardFaceAmount + ", useNumber=" + useNumber
				+ ", cardSalesMan=" + cardSalesMan + ", cardState=" + cardState + "]";
	}
	
	
	
}
