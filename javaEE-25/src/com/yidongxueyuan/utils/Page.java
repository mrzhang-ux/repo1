package com.yidongxueyuan.utils;

import java.util.List;

/**
 * 设计一个类： Page类：和分页相关的实体类： 
 * @author Mrzhang
 *
 */
public class Page<T> {
	private List<T> records; //封装要显示的所有的记录：  查询数据库的得到
	private Integer currentPage;//当前页 用户指定：    **
	private Integer totalPageNum; //总页数： 计算得到：   totalRecords/pagesSize;  **
	private Integer totalRecords; //总记录数： 查询数据库得到; select count(*) from xxx; **
	private Integer pagesSize=2;//页面显示的条数： 可以用户指定， 可以程序员指定：  **
	
	//上一页： 下一页
	private Integer prePageNum; //上一页： currentPage-1  **
	private Integer nextPageNum; //下一页： currentPage+1 **
	
	// limit 关键字使用的： 
	private Integer startIndex;//定义了一个索引： 计算得到 ** 
	
	//设定起始页： 结束页码：  通过currentPage 计算获得
	
	private Integer startPage; //页码的起始页
	private Integer endPage; //页码的结束页
	
	//url 设置分页查询的url：
	private String url;
	
	
	
	public Page(Integer currentPage, Integer totalRecords){
		this.currentPage = currentPage; 
		this.totalRecords = totalRecords;
		//总页数
		totalPageNum  = totalRecords%pagesSize==0?totalRecords/pagesSize:totalRecords/pagesSize+1; 
		
		startIndex = (currentPage-1)*	pagesSize;
		
		
		if(totalPageNum>9){
			startPage= currentPage-4; 
			endPage = currentPage+4; 
			
			if(startPage<1){
				startPage= 1; 
				endPage=9; 
			}
			
			if(endPage>totalPageNum){
				startPage= totalPageNum-8; 
				endPage=totalPageNum; 
			}
			
			
		}else{//总页数小于9
			startPage=1; 
			endPage= totalPageNum;
		}
	}

	//计算得到下一页： 
	public Integer getNextPageNum() {
		nextPageNum = currentPage+1;
		
		if(nextPageNum > totalPageNum){
			nextPageNum = totalPageNum;
		}
		return nextPageNum;
	}
	//计算得到上一页： 
	public Integer getPrePageNum() {
		prePageNum = currentPage-1; 
		if(prePageNum<1){
			prePageNum=1; 
		}
		return prePageNum;
	}

	
	public List<T> getRecords() {
		return records;
	}


	public void setRecords(List<T> records) {
		this.records = records;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	public Integer getTotalPageNum() {
		return totalPageNum;
	}


	public void setTotalPageNum(Integer totalPageNum) {
		this.totalPageNum = totalPageNum;
	}


	public Integer getTotalRecords() {
		return totalRecords;
	}


	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}


	public Integer getPagesSize() {
		return pagesSize;
	}


	public void setPagesSize(Integer pagesSize) {
		this.pagesSize = pagesSize;
	}




	public void setPrePageNum(Integer prePageNum) {
		this.prePageNum = prePageNum;
	}





	public void setNextPageNum(Integer nextPageNum) {
		this.nextPageNum = nextPageNum;
	}


	public Integer getStartIndex() {
		return startIndex;
	}


	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	
	
}
