package com.book.entity;
/*
 * 分页对象
 */

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	//上一页
	private Integer prePage;
	//下一页
	private Integer nextPage;
	//当前页
	private Integer curPage;
	//总页数
	private Integer lastPage;
	//首页
	private Integer firstPage;
	//数据列表
	private List<T> list;
	//总条数
	private Integer counts;
	//每页显示的条数
	private Integer pageNum;
	//页码序号，最多5个页码
	private List<Integer> nums = new ArrayList<Integer>();
	
	public void countNums() {
		//统计页码 总页数小于等于5页
		//页码大于5 9页 当前页是1
		if (this.lastPage<=5) {//全部显示出来
			for (int i = 1; i <= this.lastPage; i++) {
				nums.add(i);
			}
		}else if (this.curPage<=2) {
			for (int i = 1; i <= 5; i++) {
				nums.add(i);
			}
		}else if (this.curPage>=this.lastPage-1) {//当前页是倒数第二页或者最后一页
			for (int i = this.lastPage-4; i <=this.lastPage; i++) {
				nums.add(i);//56789
			}
		}else {
			for (int i = this.curPage-2; i <=this.curPage+2; i++) {
				nums.add(i);//保证当前页在中间
			}
		}
	}
	
	
	public PageBean(Integer curPage, List<T> list, Integer counts, Integer pageNum) {
		super();
		//当前页
		this.curPage = curPage;
		//每页的数据列表
		this.list = list;
		//总条数
		this.counts = counts;
		//每页多少条
		this.pageNum = pageNum;
		//上一页(如果是首页，上一页还是首页，否则就是当前页-1)
		this.prePage=this.curPage==1?1:this.curPage-1;
		//总页数 如果是整数，那么页数刚好，否则+1
		this.lastPage=counts%pageNum==0?counts/pageNum:counts/pageNum+1;
		//下一页(如果是尾页，下一页就是尾页，否则就是当前页+1)
		this.nextPage=this.curPage==this.lastPage?this.lastPage:this.curPage+1;
		this.firstPage=1;
		countNums();//计算分页
	}
	
	public List<Integer> getNums() {
		return nums;
	}
	//上一页
	public Integer getPrePage() {
		return getCurPage()==1?getCurPage():getCurPage()-1;
	}
	public Integer getNextPage() {
		return getCurPage()==getLastPage()?getLastPage():getCurPage()+1;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public Integer getLastPage() {
		return getCounts()%getPageNum()==0?getCounts()/getPageNum():getCounts()/getPageNum()+1;
	}
	public Integer getFirstPage() {
		return 1;
	}
	public List<T> getList() {
		return list;
	}
	public Integer getCounts() {
		return counts;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	
}
