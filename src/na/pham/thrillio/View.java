package na.pham.thrillio;

import na.pham.thrillio.constants.KidFriendlyStatus;
import na.pham.thrillio.constants.UserType;
import na.pham.thrillio.controllers.BookmarkController;
import na.pham.thrillio.entities.Bookmark;
import na.pham.thrillio.entities.User;

public class View {
	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items ... ");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.BOOKMARK_TYPES_COUNT) {
					boolean isBookmark = getBookmarkDecision(bookmark);
					if (isBookmark) {
						bookmarkCount++;

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New item bookmarked -- " + bookmark);
					}
				}
				
				// mark as kid friendly
				if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					if(bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStaus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getFriendlyStatusDecision(bookmark);
						
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							bookmark.setKidFriendlyStaus(kidFriendlyStatus);
							System.out.println("Kid friendly status " + kidFriendlyStatus + ", " + bookmark);
						}
					}
				}
			}
		}
	}

	private static String getFriendlyStatusDecision(Bookmark bookmark) {
	    double randomVal = Math.random();

		return randomVal < 0.4 ? KidFriendlyStatus.APPROVED : (randomVal >= 0.4 && randomVal < 0.8) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;

		
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;

	}

//	public static void bookmark(User user, Bookmark[][] bookmarks) {
//		System.out.println("\n" + user.getEmail() + " is bookmarking");
//		for (int i=0; i < DataStore.BOOKMARK_TYPES_COUNT; i++) {
//			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
//			int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
//			
//			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
//			
//			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
//			
//			System.out.println(bookmark);
//		}
//	}
}
