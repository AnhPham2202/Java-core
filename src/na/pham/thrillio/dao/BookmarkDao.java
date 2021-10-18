package na.pham.thrillio.dao;

import na.pham.thrillio.DataStore;
import na.pham.thrillio.entities.Bookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}
}
