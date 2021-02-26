package com.vobi.devops.bank.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "account", schema = "public")
public class Account implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "acco_id", unique = true, nullable = false)
	@NotNull
	private String accoId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	@NotNull
	private Customer customer;

	@NotNull
	@Column(name = "balance", nullable = false)
	private Double balance;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "enable", nullable = false)
	private String enable;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "version", nullable = true)
	private Long version;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private List<RegisteredAccount> registeredAccounts = new ArrayList<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private List<Transaction> transactions = new ArrayList<>();
	public String getAccoId() {
		return accoId;
	}
	public void setAccoId(String accoId) {
		this.accoId = accoId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public List<RegisteredAccount> getRegisteredAccounts() {
		return registeredAccounts;
	}
	public void setRegisteredAccounts(List<RegisteredAccount> registeredAccounts) {
		this.registeredAccounts = registeredAccounts;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	

}