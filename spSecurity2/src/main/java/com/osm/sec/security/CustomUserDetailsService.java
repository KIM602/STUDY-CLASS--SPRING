package com.osm.sec.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.osm.sec.constant.Constant;
import com.osm.sec.dao.SecDao;
import com.osm.sec.dto.JoinDto;

//로그인 처리 클래스
public class CustomUserDetailsService implements UserDetailsService {

	//추상메서드 구현(securityfilterchain모듈에서 호출하는 메서드)
	// username은 pid로 했음 security.xml에서 usernameparameter 설정
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username은 우리는 id(form에서 pid)라고 설정했음
		SecDao sdao = Constant.sdao;
		JoinDto dto = sdao.login(username);
		System.out.println("dto는 "+ dto);
		if(dto == null) {
			System.out.println("id가 null로 로그인 실패"); // 로그인 실패
			throw new UsernameNotFoundException("유저네임이없어요");
		}
		
		String pw = dto.getPpw(); // db의 ppw이므로 암호화된 패스워드
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		// 콜렉션은 최상위 인터페이스임
		// 리스트는 SimpleGrantedAuthority객체로 구성 
		// <SimpleGrantedAuthority> 권한 관련
		// 권한등급을 처리하는 리스트 객체 roles를 정의
		// 권한등급은 Role_useR(회원) role_admin (최고등급), role_admin(매니저등급)
		// 페이지 접근 권한
		// 만일 db에 autority컬럼과 dto에도 autority멤버변수를 사용하면 dto.getAutority()로 얻은 값을 이용하여 
		// new SimpleGrantedAuthority(autority)로 얻어내어 roles에 add메서드로 추가
		// list로 한 이유는 한 사람이 여러개의 등급 보유 할수도 있음
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails user = new User(username, pw, roles);
		// UserDetails는 사용자 정보를 처리하는 인터페이스이고 User는 이를 구현한 클래스
		return user;
	}

}
