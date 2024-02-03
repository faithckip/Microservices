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
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment {
	
	@Id
	@SequenceGenerator(name=" payment_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "payment_sequence")
	
	Long paymentId;
	Long accountHolder;
	Long beneficiaryAccount;
	String reference;
	Double amount;
	LocalDateTime localDateTime;
	String userId;
	
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", accountHolder=" + accountHolder + ", beneficiaryAccount="
				+ beneficiaryAccount + ", reference=" + reference + ", amount=" + amount + ", localDateTime="
				+ localDateTime + ", userId=" + userId + "]";
	}
		
}
