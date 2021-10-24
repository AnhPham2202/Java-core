package na.pham.thrillio.managers;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import na.pham.thrillio.constants.BookGenre;
import na.pham.thrillio.dao.BookmarkDao;
import na.pham.thrillio.entities.Book;
import na.pham.thrillio.entities.Bookmark;
import na.pham.thrillio.entities.Movie;
import na.pham.thrillio.entities.User;
import na.pham.thrillio.entities.UserBookmark;
import na.pham.thrillio.entities.Weblink;
import na.pham.thrillio.ulti.HttpConnect;
import na.pham.thrillio.ulti.IOUtil;

public class BookmarkManager {
	private static BookmarkManager intstance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();
	private BookmarkManager() {
	} // singleton: k thể tạo đc instance 1 cáhc bừa bãi và chỉ nên tạo được 1 object
		// tạo hàm để tạo instance vì không thể sử dụng constructor

	public static BookmarkManager getInstance() {
		return intstance;
	}

	/** CÁCH VIẾT TRÊN ĐỂ TẠO INSTANCE 1 LẦN KHI GỌI METHOD getInstance */
	
	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast, String[] directors, String genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setCast(cast);
		movie.setDirectors(cast);
		movie.setId(id);
		movie.setImdbRating(imdbRating);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setTitle(title);
		
		return movie;
	}
	
	public Book createBook (long id, String title, int publicationYear, String publisher, String[] authors, BookGenre genre, double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setGenre(genre);
		book.setAuthors(authors);
		book.setAmazonRating(amazonRating);
		
		return book;
	}
	
	public Weblink createWebLink (long id, String title, String url, String host) {
		Weblink webLink = new Weblink();
		webLink.setId(id);
		webLink.setTitle(title);
		webLink.setUrl(url);
		webLink.setHost(host);
		
		return webLink;
	
	}
	
	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		
		if (bookmark instanceof Weblink) {
			try {				
				String url = ((Weblink)bookmark).getUrl();
				if (!url.endsWith(".pdf")) {
					String webpage = HttpConnect.download(((Weblink)bookmark).getUrl());
					if (webpage != null) {
						IOUtil.write(webpage, bookmark.getId());					}
				}				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dao.saveUserBookmark(userBookmark);
	}

	public void setKidFriendlyStaus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStaus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println("Kid friendly status " + kidFriendlyStatus + ", marked by" + user.getEmail() + " -- " + bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		System.out.println("Data to be shared: ");
		if(bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());
		} else {
			System.out.println(((Weblink)bookmark).getItemData());

		}
	}
}
