package meetUpBackend.groad.config;

import meetUpBackend.groad.dto.UserDto;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper {
    public UserDto toDto(OAuth2User oAuth2User) {
        var attribute = oAuth2User.getAttributes();
        return UserDto.builder()
                .email((String) attribute.get("email"))
                .name((String) attribute.get("name"))
                .picture((String) attribute.get("picture"))
                .build();
    }

}
