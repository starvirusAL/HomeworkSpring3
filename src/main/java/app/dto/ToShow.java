package app.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
public class ToShow {

    private Integer id;
    private String name;
    private String email;

}
