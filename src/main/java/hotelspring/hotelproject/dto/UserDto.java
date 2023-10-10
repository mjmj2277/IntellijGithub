package hotelspring.hotelproject.dto;

import hotelspring.hotelproject.domain.SiteUser;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

public class UserDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class Request{
        private Long id;

        @Size(min = 3, max = 25)
        @NotEmpty(message = "사용자ID는 필수항목입니다.")
        private String username;

        @NotEmpty(message = "비밀번호는 필수항목입니다.")
        private String password;

        @NotEmpty(message = "이메일은 필수항목입니다.")
        @Email
        private String email;

        // Dto -> Entity
        public SiteUser createUser() {
            return SiteUser.builder()
                    .id(id)
                    .username(username)
                    .password(password)
                    .email(email)
                    .build();
        }
    }

    @Getter
    public static class Response implements Serializable {

        private final Long id;
        private final String username;
        private final String password;
        private final String email;


        // Entity -> Dto
        public Response(SiteUser user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.email = user.getEmail();
        }
    }
}
