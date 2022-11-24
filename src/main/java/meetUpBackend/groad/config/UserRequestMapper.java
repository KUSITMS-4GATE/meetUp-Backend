package meetUpBackend.groad.config;

import meetUpBackend.groad.domain.Member;
import meetUpBackend.groad.dto.UserDto;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper {
    public Member toDto(OAuth2User oAuth2User) {
        var attribute = oAuth2User.getAttributes();
        Member member = new Member();
        member.setEmail((String) attribute.get("email"));
        member.setName((String) attribute.get("name"));
        return member;
    }

}
