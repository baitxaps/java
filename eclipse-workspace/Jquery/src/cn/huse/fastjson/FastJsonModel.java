package cn.huse.fastjson;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FastJsonModel {
	@JSONField(name = "unique")
	private int id;
	private String name;
	private int count;
	private double price;
	//@JSONField(format="yyyy年MM月dd日")
	private Date pdate;
	
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
