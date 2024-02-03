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
@Data
@Builder
public class Transfer {
	
	@Id
	@SequenceGenerator(name= "transfer_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "transfer_sequence")
	
	Long transferId;
	Long accountHolder;
	Long beneficiaryAccount;
	String reference;
	Double amount;
	String userId;
	LocalDateTime localDateTime;
	public Long getTransferId() {
		return transferId;
	}
	public void setTransferId(Long transferId) {
		this.transferId = transferId;
	}
	public Long getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(Long accountHolder) {
		this.accountHolder = accountHolder;
	}
	public Long getBeneficiaryAccount() {
		return beneficiaryAccount;
	}
	public void setBeneficiaryAccount(Long beneficiaryAccount) {
		this.beneficiaryAccount = beneficiaryAccount;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
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
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	@Override
	public String toString() {
		return "Transfer [transferId=" + transferId + ", accountHolder=" + accountHolder + ", beneficiaryAccount="
				+ beneficiaryAccount + ", reference=" + reference + ", amount=" + amount + ", userId=" + userId
				+ ", localDateTime=" + localDateTime + "]";
	}
	

}
