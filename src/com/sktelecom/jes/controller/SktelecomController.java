package com.sktelecom.jes.controller;

import javax.swing.JOptionPane;

import com.sktelecom.jes.domain.MemberBean;
import com.sktelecom.jes.domain.PhoneBean;
import com.sktelecom.jes.service.PhoneService;
import com.sktelecom.jes.serviceImpl.PhoneServiceImpl;

public class SktelecomController {
	public static void main(String[] args) {
		PhoneBean phone = null;
		MemberBean member = null;{
		PhoneService phoneService = new PhoneServiceImpl();
		while(true) 
			switch (JOptionPane.showInputDialog(""
					+ "0.[종료]\n"
					+ "1.[개통]"
					+ "2.[목록]"
					+ "3.[회원번호로 고객정보찾기]"
					+ "4.[이름으로 고객정보찾기]"
					+ "5.[전화번호변경]")) {
				case "0":
					return;
				case "1":
					phone = new PhoneBean();
					member = new MemberBean();
					phone.setName(JOptionPane.showInputDialog("폰 ? 1.겔 2.아이"));
					member.setName(JOptionPane.showInputDialog("이름 ?"));
					JOptionPane.showMessageDialog(null,
							phoneService.showMessage(member,phone));
					break;
				case "2":
					JOptionPane.showMessageDialog(null,
							phoneService.list());
					break;
				case "3":
					JOptionPane.showMessageDialog(null, 
							phoneService.findByKey(JOptionPane.showInputDialog("회원번호입력")));
					break;
				case "4":
					JOptionPane.showMessageDialog(null,
							phoneService.findByName(JOptionPane.showInputDialog("회원이름입력")));
					break;
				case "5":
					JOptionPane.showMessageDialog(null,
							phoneService.findByKey(JOptionPane.showInputDialog("전화번호를 변경하실 회원의 회원번호를 입력하세요.")));
					break;
			}
		}
	}
}
