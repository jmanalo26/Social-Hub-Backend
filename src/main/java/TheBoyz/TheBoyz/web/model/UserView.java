package TheBoyz.TheBoyz.web.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserView {

    private int userId;

    private String username;

    private String phoneNumber;

    private String email;

    private String password;

}
