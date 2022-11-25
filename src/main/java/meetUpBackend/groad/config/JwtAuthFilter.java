package meetUpBackend.groad.config;

import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.Member;
import meetUpBackend.groad.dto.UserDto;
import meetUpBackend.groad.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@RequiredArgsConstructor
public class JwtAuthFilter extends GenericFilterBean {

    private final TokenService tokenService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = ((HttpServletRequest) request).getHeader("Auth");
        System.out.println("do-filter called");

        if (token != null && tokenService.verifyToken(token)) {
            String email = tokenService.getUid(token);
            String name = tokenService.getName(token);

            Member member = new Member();
            member.setEmail(email);
            member.setName(name);

//            UserDto userDto = UserDto.builder()
//                    .email(email)
//                    .name(name)
//                    .picture("프로필이미지 테스트")
//                    .build();

//            Authentication authentication = getAuthentication(userDto);
            Authentication authentication = getAuthentication(member);

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    public Authentication getAuthentication(Member member) {
        return new UsernamePasswordAuthenticationToken(
                member,
                "",
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
