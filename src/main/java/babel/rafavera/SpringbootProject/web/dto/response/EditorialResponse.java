package babel.rafavera.SpringbootProject.web.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditorialResponse {
    private Integer id;
    private String nombre;
}
