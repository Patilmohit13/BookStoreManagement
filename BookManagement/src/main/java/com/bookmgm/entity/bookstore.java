package com.bookmgm.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@SuppressWarnings("deprecation")
@javax.persistence.Entity
@Table(name = "bookstore")
public class bookstore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Bid;

	@Column(name = "BName")
	private String BName;

	@Column(name = "BPrice")
	private int BPrice;

	@Column(name = "BAuthor")
	private String BAuthor;

	public bookstore() {
		super();
	}

	public bookstore(int bid, String bName, int bPrice, String bAuthor) {
		super();
		Bid = bid;
		BName = bName;
		BPrice = bPrice;
		BAuthor = bAuthor;

	}

	public int getBid() {
		return Bid;
	}

	public void setBid(int bid) {
		Bid = bid;
	}

	public String getBName() {
		return BName;
	}

	public void setBName(String bName) {
		BName = bName;
	}

	public int getBPrice() {
		return BPrice;
	}

	public void setBPrice(int bPrice) {
		BPrice = bPrice;
	}

	public String getBAuthor() {
		return BAuthor;
	}

	public void setBAuthor(String bAuthor) {
		BAuthor = bAuthor;
	}

}
