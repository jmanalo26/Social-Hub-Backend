package TheBoyz.TheBoyz.data.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ObjectHolder {

    private MultipartFile formData;

    private String textContent;
}
