package com.swm.store.bean;

import java.io.Serializable;

/**
 * 门店信息
* @Title: Store.java 
* @Package com.swm.store.bean 
* @Description: TODO(用一句话描述该文件做什么) 
* @author fyy 
* @date 2017-3-23 上午10:33:58 
* @version V1.0
 */
public class Store implements Serializable{
	/**门店ID */
	private String id;
	/**门店名称 */
	private String name;
	/**门店省份 */
	private String province;
	/**门店城市 */
	private String city;
	/**门店区域 */
	private String district;
	/**门店地址 */
	private String address;
	/**门店经度 */
	private String longitude;
	/**门店纬度 */
	private String  latitude;
	/**门店说明 */
	private String  description;
	/**门店创建人 */
	private int  userId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
