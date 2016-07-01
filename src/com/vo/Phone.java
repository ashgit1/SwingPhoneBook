package com.vo;

import java.io.Serializable;

public class Phone implements Serializable {

	private static final long serialVersionUID = 1549156135112135083L;

	private String No;
	private String Owner;
	private String Age;
	private String Nrc;
	private String Job;
	private String Addr;
	private String Amt;
	private String Date;

	/**
	 * @return the date
	 */
	public String getDate() {
		return Date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		Date = date;
	}

	/**
	 * @return the amt
	 */
	public String getAmt() {
		return Amt;
	}

	/**
	 * @param amt
	 *            the amt to set
	 */
	public void setAmt(String amt) {
		Amt = amt;
	}

	/**
	 * @return the no
	 */
	public String getNo() {
		return No;
	}

	/**
	 * @param no
	 *            the no to set
	 */
	public void setNo(String no) {
		No = no;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return Owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		Owner = owner;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return Addr;
	}

	/**
	 * @param addr
	 *            the addr to set
	 */
	public void setAddr(String addr) {
		Addr = addr;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return Age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		Age = age;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return Job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(String job) {
		Job = job;
	}

	/**
	 * @return the nrc
	 */
	public String getNrc() {
		return Nrc;
	}

	/**
	 * @param nrc
	 *            the nrc to set
	 */
	public void setNrc(String nrc) {
		Nrc = nrc;
	}
}