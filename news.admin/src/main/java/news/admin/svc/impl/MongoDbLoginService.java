package news.admin.svc.impl;

import org.springframework.stereotype.Service;

import news.admin.svc.AccountService;

@Service
public class MongoDbLoginService implements AccountService {

	@Override
	public boolean valid(String username, String password) {
		// TODO Auto-generated method stub
		return true;
	}

}
