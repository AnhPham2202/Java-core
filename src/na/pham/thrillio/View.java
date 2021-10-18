package na.pham.thrillio;

import na.pham.thrillio.entities.Bookmark;
import na.pham.thrillio.entities.User;

public class View {
	public static void bookmark (User user, Bookmark[][] bookmark) {
		System.out.println("\n" + user.getEmail() + " is bookmarking");
	}
}
