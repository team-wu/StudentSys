package common;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {
	private List<T> pageItems=new ArrayList<T>();
	private Integer page;
	private Integer perPage;
	private int pageCount;
	
	public List<T> getPageItems() {
		return pageItems;
	}
	public void setPageItems(List<T> pageItems) {
		this.pageItems = pageItems;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPerPage() {
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
}
