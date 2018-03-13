package cn.easyproject.easyee.sm.card.entity;

/**
 * 
 * @author dell 卡使用天數=使用天數+使用期限天數
 * 
 */
public class Card {

	/* 私教次卡 */
	public static final int HUNDREDTIMESCARD = 110;// 私教次卡100次
	public static final int SEVENTYTIMESCARD = 111;// 私教次卡72次
	public static final int THIRTYTIMESCARD = 112;// 私教次卡36次
	public static final int TWELVETIMESCARD = 113;// 私教次卡12次
	public static final int TENTIMESCARD = 114;// 私教次卡10次
	public static final int FIVETIMESCARD = 115;// 私教次卡5次
	public static final int THREETIMESCARD = 116;// 私教次卡3次
	public static final int ONCETIMECARD = 117;// 私教次卡1次
	public static final int MOUTHCARD = 118;// 私教月卡
	public static final int QUARTERCARD = 119;// 私教季卡
	public static final int GRATISCARD = 130;// 免费体验卡

	/* 自由次卡 */
	public static final int ONCEFREETIMECARD = 120;// 自由次卡
	public static final int TENFREETIMECARD = 121;// 自由次10次卡
	public static final int TWENTYFREETIMECARD = 122;// 自由次20次卡
	public static final int FIFTYFREETIMECARD = 123;// 自由次50次卡
	public static final int HUNDREDFREETIMECARD = 124;// 自由次100次卡

	/* 储值卡 */
	public static final int DISCOUNTCARD = 200;// 99钜惠卡
	public static final int VIPCARD = 201;// VIP卡

	/* 期限卡 */
	public static final int FREEMONTHCARD = 300;// 自由训练月卡
	public static final int FREEHUNDREDCARD = 301;// 自由训练百天卡
	public static final int FREEYEARCARD = 302;// 自由训练年卡

	private Integer cardId;// 卡ID
	private String cardName;// 卡名称
	private Integer cardType;// 卡类型
	private Integer cardPrice;// 卡的价格
	private String cardCourse;// 课程名称
	private Integer cardDate;// 卡使用天数
	private String cardSite;// 支持的场馆
	private Integer cardFaceAmount;// 实际支付的金额
	private Integer cardNum;// 使用次数
	private String cardSalesName;// 销售人员名
	private Integer cardState;// 卡的状态 0正常 1隱藏 2逻辑删除

	public Integer getCardId() {
		return cardId;
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

	public Integer getCardNum() {
		return cardNum;
	}

	public void setCardNum(Integer cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardSalesName() {
		return cardSalesName;
	}

	public void setCardSalesName(String cardSalesName) {
		this.cardSalesName = cardSalesName;
	}

	public Integer getCardState() {
		return cardState;
	}

	public void setCardState(Integer cardState) {
		this.cardState = cardState;
	}

	public Card(String cardName, Integer cardType, Integer cardPrice, String cardCourse, Integer cardDate,
			String cardSite, Integer cardFaceAmount, Integer cardNum, String cardSalesName, Integer cardState) {
		super();
		this.cardName = cardName;
		this.cardType = cardType;
		this.cardPrice = cardPrice;
		this.cardCourse = cardCourse;
		this.cardDate = cardDate;
		this.cardSite = cardSite;
		this.cardFaceAmount = cardFaceAmount;
		this.cardNum = cardNum;
		this.cardSalesName = cardSalesName;
		this.cardState = cardState;
	}

	public Card() {
		super();
	}

	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardName=" + cardName + ", cardType=" + cardType + ", cardPrice="
				+ cardPrice + ", cardCourse=" + cardCourse + ", cardDate=" + cardDate + ", cardSite=" + cardSite
				+ ", cardFaceAmount=" + cardFaceAmount + ", cardNum=" + cardNum + ", cardSalesName=" + cardSalesName
				+ "]";
	}

}
