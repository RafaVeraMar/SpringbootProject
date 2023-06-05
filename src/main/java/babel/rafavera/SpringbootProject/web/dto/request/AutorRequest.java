package babel.rafavera.SpringbootProject.web.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutorRequest {
    private String nombre;
}