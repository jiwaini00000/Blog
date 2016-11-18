package com.okchem.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oc_users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue()
	@Column(name="user_id")
	private long uid;
	@Column(name="user_name")
	private String userName;
	public String getUseNrame() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	
}
