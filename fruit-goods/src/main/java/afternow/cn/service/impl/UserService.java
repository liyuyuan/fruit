package afternow.cn.service.impl;


import afternow.cn.model.UserAccess;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("${access-file-path}")
    private String accessFilePath;

    public void saveUserAccess(UserAccess userAccess) {
      //TODO
        //savo to db
    }

    public boolean hasAccess(long userId, String resource) {
        //TODO
        return true;
    }
}