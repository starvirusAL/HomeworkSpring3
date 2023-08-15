package app.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class TableHeader {
    @Getter
    String id;
    @Getter
    String name;
    @Getter

    String email;
    @Getter
    String account;




}
