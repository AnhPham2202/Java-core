package na.pham.thrillio;

import na.pham.thrillio.entities.Bookmark;
import na.pham.thrillio.entities.User;
import na.pham.thrillio.managers.BookmarkManager;
import na.pham.thrillio.managers.UserManager;

public class Launch {

	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		System.out.println("1. Loading ...");
		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

		System.out.println("1. Printing ...");

		printUserData();
		printBookmarkData();
	}

	private static void printBookmarkData() {
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookMark : bookmarkList) {
				System.out.println(bookMark);
			}
		}
	}

	private static void printUserData() {
		for (User user : users) {
			System.out.println(user);
		}
	}

	public static void main(String[] args) {
		loadData();
		startBookmark();
	}

	private static void startBookmark() {
		System.out.println("2. Bookmarking ...");
		for (User user : users) {
			View.bookmark(user, bookmarks);
		}
	}

}
