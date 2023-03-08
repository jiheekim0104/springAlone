package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest registerRequest) {
		Member member = memberDao.selsctByEmail(registerRequest.getEmail());
		if(member!=null) {
			throw new DuplicateMemberException(registerRequest.getEmail()+"�� �̹� ��ϵ� �̸����Դϴ�.");
		}
		Member newMember = new Member(registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getName(),LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
