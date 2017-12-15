package com.sktelecom.jes.service;

import com.sktelecom.jes.domain.MemberBean;
import com.sktelecom.jes.domain.PhoneBean;

public interface PhoneService {
	public String showMessage(MemberBean member, PhoneBean phone);
	public String makeNumber();
	public String createCustomNum();
	public void addUser(MemberBean member, PhoneBean phone);
	public String list();
	public String findByKey(String key);
	public String selectName(String flag);
	public String findByName(String name);
	public void updatePhoneNumber(String key);
	public void deleteMember(String key);
}
