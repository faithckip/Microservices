package com.banking.onlineBanking.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Withdrawal {
	
	@Id
	@SequenceGenerator(name = "withdrawal_sequence", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator ="withdrawal_sequence")
	
	Long withdrawalId;
    Long accountNumber;
    String reference;
    LocalDateTime localDateTime;
    Double amount;
    String userId;
	public Long getWithdrawalId() {
		return withdrawalId;
	}
	public void setWithdrawalId(Long withdrawalId) {
		this.withdrawalId = withdrawalId;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Withdrawal [withdrawalId=" + withdrawalId + ", accountNumber=" + accountNumber + ", reference="
				+ reference + ", localDateTime=" + localDateTime + ", amount=" + amount + ", userId=" + userId + "]";
	}

}
