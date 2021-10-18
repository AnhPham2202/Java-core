package na.pham.thrillio.managers;

import na.pham.thrillio.dao.BookmarkDao;
import na.pham.thrillio.entities.Book;
import na.pham.thrillio.entities.Bookmark;
import na.pham.thrillio.entities.Movie;
import na.pham.thrillio.entities.User;
import na.pham.thrillio.entities.UserBookmark;
import na.pham.thrillio.entities.Weblink;

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
	
	public Book createBook (long id, String title, int publicationYear, String publisher, String[] authors, String genre, double amazonRating) {
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
		
		dao.saveUserBookmark(userBookmark);
	}
}
