package afternow.cn.model;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class UserAccess {
    private long userId;
    private List<String> endpoints;

}
