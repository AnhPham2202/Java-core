package na.pham.thrillio.dao;

import na.pham.thrillio.DataStore;
import na.pham.thrillio.entities.Bookmark;
import na.pham.thrillio.entities.User;
import na.pham.thrillio.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
