package com.banking.onlineBanking.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name= "account")
public class Account {
	
	@Id
	@SequenceGenerator(name="id_sequence", allocationSize = 1, initialValue = 1000000000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
	
	Long account_number;
	String account_name;
	String account_type;
	LocalDateTime date_created;
	String userId;
	Double account_balance;
	public Long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(Long account_number) {
		this.account_number = account_number;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public LocalDateTime getDate_created() {
		return date_created;
	}
	public void setDate_created(LocalDateTime date_created) {
		this.date_created = date_created;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(Double account_balance) {
		this.account_balance = account_balance;
	}
	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", account_name=" + account_name + ", account_type="
				+ account_type + ", date_created=" + date_created + ", userId=" + userId + ", account_balance="
				+ account_balance + ", getAccount_number()=" + getAccount_number() + ", getAccount_name()="
				+ getAccount_name() + ", getAccount_type()=" + getAccount_type() + ", getDate_created()="
				+ getDate_created() + ", getUserId()=" + getUserId() + ", getAccount_balance()=" + getAccount_balance()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
