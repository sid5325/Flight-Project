package com.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
@Embeddable
public class UserEntityId implements Serializable{

	private int pnrNumber;
	private String userName;
	private String emailId;

	public int getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailId, pnrNumber, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntityId other = (UserEntityId) obj;
		return Objects.equals(emailId, other.emailId) && pnrNumber == other.pnrNumber
				&& Objects.equals(userName, other.userName);
	}

}
