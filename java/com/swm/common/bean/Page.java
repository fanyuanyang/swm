package com.swm.common.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 用于WEB持久层，目前对整个项目意义不大
 * 主要用于分页，将分页的一些操作全部提取出来了。
 * JLEcgWeb   
 * @author fanyuanyang
 * @开发日期: 2012-9-28 上午09:11:53 
 * @version 1.0
 * @description 分页对象
 * @see
 */
public class Page implements Serializable, Cloneable {

	// 查询数据
	private List data;
	// 当前页号
	private int currentPageNo;
	// 总行数
	private int totalRows;
	// 每页显示条数
	private int pageSize;

	public Page(int currentPageNo, int pageSize) {
		if (currentPageNo <=0 ) {currentPageNo = 1;};
		this.currentPageNo = currentPageNo;
		this.pageSize = pageSize;
	}

	public Page(int currentPageNo, int totalRows, int pageSize, List data) {
		if (currentPageNo <=0 ) {currentPageNo = 1;};
		this.data = data;
		this.currentPageNo = currentPageNo;
		this.totalRows = totalRows;
		this.pageSize = pageSize;
	}

	// 得到总页数
	public int getTotalPages() {
		if (totalRows == 0) {
            return 1;
        }
        return (totalRows%pageSize == 0 ? totalRows/pageSize : totalRows/pageSize + 1);
	}

	// 得到第一页页号
	public int getFirstPageNo() {
		return 1;
	}

	// 得到最后一页页号
	public int getLastPageNo() {
		return getTotalPages();
	}

	// 得到上一页页号
	public int getPrePageNo() {
		if (currentPageNo == 1) {
			return 1;
		}
		return currentPageNo - 1;
	}

	// 得到下一页页号
	public int getNextPageNo() {
		if (currentPageNo == getTotalPages()) {
			return currentPageNo;
		}
		return currentPageNo + 1;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public static int getStartOfPage(int pageNo, int pageSize) {
        if (0 > pageNo)
            throw new IllegalArgumentException("页面索引不能小于0!");
        return (pageNo - 1) * pageSize;
    }
	
	/**
	 * 计算该页起始下标
	 * @return
	 */
	public int computerFirstRowIndex() {
		return (currentPageNo - 1) * pageSize;
	}

	/**
	 * 克隆新的分页对象
	 * @return
	 */
	public Page clonePage() {
		Page p = null;
		try {
			p = (Page)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * 是否有下一页
	 * @return
	 */
	public boolean getHasNext() {
		return currentPageNo < this.getTotalPages();
	}
	
	/**
	 * 是否有上一页
	 * @return
	 */
	public boolean getHasPre() {
		return currentPageNo >1;
	}
	

}
