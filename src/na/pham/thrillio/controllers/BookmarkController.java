package na.pham.thrillio.controllers;

import na.pham.thrillio.entities.Bookmark;
import na.pham.thrillio.entities.User;
import na.pham.thrillio.managers.BookmarkManager;

public class BookmarkController {
	private BookmarkController() {
	}

	private static BookmarkController instance = new BookmarkController();

	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
	}

	public void setKidFriendlyStaus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStaus(user, kidFriendlyStatus, bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user, bookmark);
	}

}
