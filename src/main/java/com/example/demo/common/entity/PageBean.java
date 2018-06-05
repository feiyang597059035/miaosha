package com.example.demo.common.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.github.pagehelper.Page;

public class PageBean<T> implements Serializable{
	 private static final long serialVersionUID = 1L;
	    //当前页
	    private int pageNum;
	    //每页的数量
	    private int pageSize;
	    //当前页的数量
	    private int size;

	    //由于startRow和endRow不常用，这里说个具体的用法
	    //可以在页面中"显示startRow到endRow 共size条数据"

	    //当前页面第一个元素在数据库中的行号
	    private int startRow;
	    //当前页面最后一个元素在数据库中的行号
	    private int endRow;
	    //总记录数
	    private long total;
	    //总页数
	    private int pages;
	    //结果集
	    private List<T> list;

	    public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public int getStartRow() {
			return startRow;
		}

		public void setStartRow(int startRow) {
			this.startRow = startRow;
		}

		public int getEndRow() {
			return endRow;
		}

		public void setEndRow(int endRow) {
			this.endRow = endRow;
		}

		public long getTotal() {
			return total;
		}

		public void setTotal(long total) {
			this.total = total;
		}

		public int getPages() {
			return pages;
		}

		public void setPages(int pages) {
			this.pages = pages;
		}

		public List<T> getList() {
			return list;
		}

		public void setList(List<T> list) {
			this.list = list;
		}

	

		public PageBean() {
	    }

	    /**
	     * 包装Page对象
	     *
	     * @param list
	     */
	    public PageBean(List<T> list) {
	        this(list, 8);
	    }

	    /**
	     * 包装Page对象
	     *
	     * @param list          page结果
	     * @param navigatePages 页码数量
	     */
	    public PageBean(List<T> list, int navigatePages) {
	        if (list instanceof Page) {
	            Page page = (Page) list;
	            this.pageNum = page.getPageNum();
	            this.pageSize = page.getPageSize();

	            this.pages = page.getPages();
	            this.list = page;
	            this.size = page.size();
	            this.total = page.getTotal();
	            //由于结果是>startRow的，所以实际的需要+1
	            if (this.size == 0) {
	                this.startRow = 0;
	                this.endRow = 0;
	            } else {
	                this.startRow = page.getStartRow() + 1;
	                //计算实际的endRow（最后一页的时候特殊）
	                this.endRow = this.startRow - 1 + this.size;
	            }
	        } else if (list instanceof Collection) {
	            this.pageNum = 1;
	            this.pageSize = list.size();

	            this.pages = this.pageSize > 0 ? 1 : 0;
	            this.list = list;
	            this.size = list.size();
	            this.total = list.size();
	            this.startRow = 0;
	            this.endRow = list.size() > 0 ? list.size() - 1 : 0;
	        }
	    }

}
