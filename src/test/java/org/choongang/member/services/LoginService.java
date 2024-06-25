package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.member.controllers.LoginRequest;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.LoginValidator;
import org.choongang.member.validators.Validator;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginValidator validator;
    private final MemberMapper mapper;

    public void process(LoginRequest form) {
        //로그인 유효성 검사
        validator.check(form);

        //로그인 처리 - 회원 정보 조회, 세션에 유지
        String email = request.getParameter("email");
        Member member = mapper.get(email);

        HttpSession session = request.getSession();
        session.setAttribute("member", member);
    }
}
