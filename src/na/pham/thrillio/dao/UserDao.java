package na.pham.thrillio.dao;

import na.pham.thrillio.DataStore;
import na.pham.thrillio.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
