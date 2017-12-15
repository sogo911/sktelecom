package com.sktelecom.jes.serviceImpl;

import com.sktelecom.jes.domain.MemberBean;
import com.sktelecom.jes.domain.PhoneBean;
import com.sktelecom.jes.service.PhoneService;

public class PhoneServiceImpl implements PhoneService{
	MemberBean[] members;
	PhoneBean[] phones;
	private int memberCount,phoneCount,customNum;
	public PhoneServiceImpl() {
		memberCount = phoneCount = 0;
		customNum = 1000;
		customNum++;
		members = new MemberBean[2];
		phones = new PhoneBean[2];
		//멤버변수 할당
	}
	
	@Override
	public String showMessage(MemberBean member, PhoneBean phone) {
		addUser(member, phone);
		String message = 
				String.format(""
						+ "[%s]님 이름으로 "
						+ "[%s]번호로 [%s]핸드폰이 "
						+ "개통되었습니다.",
						member.getName(),
						phone.getPhoneNum(),
						phone.getName());
		return message;
	}

	@Override
	public String makeNumber() {
		int res1 = (int)(Math.random()*10000+1);
		int res2 = (int)(Math.random()*10000+1);
		String res = "010-" + res1 + "-" + res2 ;
		return res;
	}
	@Override
	public String createCustomNum() {
		return String.valueOf(customNum++);
	}

	@Override
	public void addUser(MemberBean member, PhoneBean phone) {
		String customNum = createCustomNum();
		System.out.println("생성된 커스텀 넘버 :" + customNum);
		member.setCustomNum(customNum);
		phone.setCustomNum(customNum);
		phone.setPhoneNum(makeNumber());
		phone.setName(selectName(phone.getName()));
		this.members[memberCount++] = member;
		this.phones[phoneCount++] = phone;
	}
	@Override
	public String list() {
		System.out.println("리스트호출");
		String res = "";
		for(int i = 0; i < members.length ; i++) {
			if(members[i].getCustomNum().equals(phones[i].getCustomNum())) {
				res = res.concat(members[i].getCustomNum())
					.concat(members[i].getName())
					.concat(phones[i].getPhoneNum())
					.concat(phones[i].getName()+"\n");
			
			}
		}
		return res;
	}

	@Override
	public String findByKey(String key) {
		String res = "";
		for(int i = 0 ; i < members.length; i++) {
			if(key.equalsIgnoreCase(members[i].getCustomNum())) {
				res = res.concat(members[i].getCustomNum())
						.concat(members[i].getName())
						.concat(phones[i].getPhoneNum())
						.concat(phones[i].getName()+"\n");
			}
		}
		return res;
	}

	@Override
	public String selectName(String flag) {
		String res = "";
		if(flag.equals("1")) {
			res = "갤럭시";
		}else {
			res = "아이폰";
		}
		return res;
	}

	@Override
	public String findByName(String name) {
		String res = "";
		for(int i = 0; i < members.length; i++) {
			if(name.equalsIgnoreCase(members[i].getName())) {
				res = res.concat(members[i].getCustomNum())
						.concat(members[i].getName())
						.concat(phones[i].getPhoneNum())
						.concat(phones[i].getName()+"\n");
			}
		}
		return res;
	}

	@Override
	public void updatePhoneNumber(String key) {
		for(int i = 0; i < members.length; i++) {
			if(key.equalsIgnoreCase(phones[i].getCustomNum())) {
				phones[i].setPhoneNum(makeNumber());
				break;
			}
		}
	}

	@Override
	public void deleteMember(String key) {
		// TODO Auto-generated method stub
		
	}
}
