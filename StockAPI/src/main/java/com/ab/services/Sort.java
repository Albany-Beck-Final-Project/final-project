package com.ab.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ab.entities.Exchange;
import com.ab.entities.OrderBook;
import com.ab.enums.SortType;


@Service
public class Sort {
	
	private int sortID;
	private String sortName;
	private SortType sortType;
	private List<OrderBook> orderBooks;
	private List<Exchange> exchanges;
	
	public Sort() {
		super();
	}
	public Sort(int sortID, String sortName, SortType sortType, List<OrderBook> orderBooks, List<Exchange> exchanges) {
		super();
		this.sortID = sortID;
		this.sortName = sortName;
		this.sortType = sortType;
		this.orderBooks = orderBooks;
		this.exchanges = exchanges;
	}
	public int getSortID() {
		return sortID;
	}
	public void setSortID(int sortID) {
		this.sortID = sortID;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public SortType getSortType() {
		return sortType;
	}
	public void setSortType(SortType sortType) {
		this.sortType = sortType;
	}
	public List<OrderBook> getOrderBooks() {
		return orderBooks;
	}
	public void setOrderBooks(List<OrderBook> orderBooks) {
		this.orderBooks = orderBooks;
	}
	public List<Exchange> getExchanges() {
		return exchanges;
	}
	public void setExchanges(List<Exchange> exchanges) {
		this.exchanges = exchanges;
	}
	@Override
	public String toString() {
		return "Sort [sortID=" + sortID + ", sortName=" + sortName + ", sortType=" + sortType + ", orderBooks="
				+ orderBooks + ", exchanges=" + exchanges + "]";
	}
	
	
	
}
