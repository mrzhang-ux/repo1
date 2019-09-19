package com.yidongxueyuan.utils;

import java.util.List;

/**
 * ���һ���ࣺ Page�ࣺ�ͷ�ҳ��ص�ʵ���ࣺ 
 * @author Mrzhang
 *
 */
public class Page<T> {
	private List<T> records; //��װҪ��ʾ�����еļ�¼��  ��ѯ���ݿ�ĵõ�
	private Integer currentPage;//��ǰҳ �û�ָ����    **
	private Integer totalPageNum; //��ҳ���� ����õ���   totalRecords/pagesSize;  **
	private Integer totalRecords; //�ܼ�¼���� ��ѯ���ݿ�õ�; select count(*) from xxx; **
	private Integer pagesSize=2;//ҳ����ʾ�������� �����û�ָ���� ���Գ���Աָ����  **
	
	//��һҳ�� ��һҳ
	private Integer prePageNum; //��һҳ�� currentPage-1  **
	private Integer nextPageNum; //��һҳ�� currentPage+1 **
	
	// limit �ؼ���ʹ�õģ� 
	private Integer startIndex;//������һ�������� ����õ� ** 
	
	//�趨��ʼҳ�� ����ҳ�룺  ͨ��currentPage ������
	
	private Integer startPage; //ҳ�����ʼҳ
	private Integer endPage; //ҳ��Ľ���ҳ
	
	//url ���÷�ҳ��ѯ��url��
	private String url;
	
	
	
	public Page(Integer currentPage, Integer totalRecords){
		this.currentPage = currentPage; 
		this.totalRecords = totalRecords;
		//��ҳ��
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
			
			
		}else{//��ҳ��С��9
			startPage=1; 
			endPage= totalPageNum;
		}
	}

	//����õ���һҳ�� 
	public Integer getNextPageNum() {
		nextPageNum = currentPage+1;
		
		if(nextPageNum > totalPageNum){
			nextPageNum = totalPageNum;
		}
		return nextPageNum;
	}
	//����õ���һҳ�� 
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
