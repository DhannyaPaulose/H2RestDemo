package com.rak.rakassignment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registration")
public class Registration {

	private int registrationId;
	private String userName;
	private String password;
	private String email;
	private String mobile;
	private String prefCommication;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(String userName, String password, String email, String mobile, String prefCommication) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.prefCommication = prefCommication;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	@Column(name = "userName" , nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password" , nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email" , nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mobile" , nullable = false)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "prefCommunication" , nullable = false)
	public String getPrefCommication() {
		return prefCommication;
	}

	public void setPrefCommication(String prefCommication) {
		this.prefCommication = prefCommication;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((prefCommication == null) ? 0 : prefCommication.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (prefCommication == null) {
			if (other.prefCommication != null)
				return false;
		} else if (!prefCommication.equals(other.prefCommication))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Registration [RegistrationId=" + registrationId + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", mobile=" + mobile + ", prefCommication=" + prefCommication + "]";
	}
	

}
