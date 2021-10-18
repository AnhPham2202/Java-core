package na.pham.thrillio.managers;

import na.pham.thrillio.dao.UserDao;
import na.pham.thrillio.entities.User;

public class UserManager {
	private static UserManager intstance = new UserManager();
	private static UserDao dao = new UserDao();

	private UserManager() {
	} // singleton: k thể tạo đc instance 1 cáhc bừa bãi và chỉ nên tạo được 1 object
		// tạo hàm để tạo instance vì không thể sử dụng constructor

	public static UserManager getInstance() {
		return intstance;
	}

	/** CÁCH VIẾT TRÊN ĐỂ TẠO INSTANCE 1 LẦN KHI GỌI METHOD getInstance */

	public User createUser(long id, String email, String password, String firstName, String lastName, int gender,
			String userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setPassword(password);
		user.setUserType(userType);
		return user;
	}
	
	public User[] getUsers() {
		return dao.getUsers();
	}
}
