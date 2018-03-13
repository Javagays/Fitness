package cn.easyproject.easyee.sm.card.entity;

import java.util.Date;

public class RecordsConsumption {

	private Integer recordId;// 订单表id
	private String recordName;// 订单表名称
	private Date startDate;// 开卡日期
	private Date endDate;// 使用结束日期
	private Integer payCashTime;// 订单支付时间
	private Integer payMoney;// 支付金额
	private String receiver;// 支付方 固定为逆袭Fitness
	private String keep;// 保留字段

	public Integer getRecordId() {
		return recordId;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getPayCashTime() {
		return payCashTime;
	}

	public void setPayCashTime(Integer payCashTime) {
		this.payCashTime = payCashTime;
	}

	public Integer getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Integer payMoney) {
		this.payMoney = payMoney;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getKeep() {
		return keep;
	}

	public void setKeep(String keep) {
		this.keep = keep;
	}

	public RecordsConsumption(String recordName, Date startDate, Date endDate, Integer payCashTime, Integer payMoney,
			String receiver, String keep) {
		super();
		this.recordName = recordName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.payCashTime = payCashTime;
		this.payMoney = payMoney;
		this.receiver = receiver;
		this.keep = keep;
	}

	public RecordsConsumption() {
		super();
	}

	@Override
	public String toString() {
		return "RecordsConsumption [recordName=" + recordName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", payCashTime=" + payCashTime + ", payMoney=" + payMoney + ", receiver=" + receiver + "]";
	}

}
