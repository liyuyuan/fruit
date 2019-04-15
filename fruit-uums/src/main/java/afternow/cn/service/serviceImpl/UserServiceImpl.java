package afternow.cn.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import afternow.cn.entity.Users;
import afternow.cn.entity.example.UsersExample;
import afternow.cn.mapper.UsersMapper;
import afternow.cn.service.service.UserService;

@Service
public class UserServiceImpl implements UserService{
//	@Autowired
	private UsersMapper userMapper;
	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		UsersExample usersExample = new UsersExample();
		List<Users> users = userMapper.selectByExample(usersExample);
		return users;
	}

}
