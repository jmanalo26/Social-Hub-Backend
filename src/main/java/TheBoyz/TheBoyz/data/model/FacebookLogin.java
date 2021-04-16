package TheBoyz.TheBoyz.data.model;

import java.util.ArrayList;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FacebookLogin {
    private String loginDialogURL;
    private String logoutDialogURL;
}
