package na.pham.thrillio.entities;

import na.pham.thrillio.constants.KidFriendlyStatus;

public abstract class  Bookmark {
	private long id;
	private String title;
	private String profileUrl;
	private String kidFriendlyStaus = KidFriendlyStatus.UNKNOWN;
	private User kidFriendlyMarkedBy;
	private User sharedBy;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", title=" + title + ", profileUrl=" + profileUrl + "]";
	}
	
	public abstract boolean isKidFriendlyEligible();

	public String getKidFriendlyStaus() {
		return kidFriendlyStaus;
	}

	public void setKidFriendlyStaus(String kidFriendlyStaus) {
		this.kidFriendlyStaus = kidFriendlyStaus;
	}

	public User getKidFriendlyMarkedBy() {
		return kidFriendlyMarkedBy;
	}

	public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}

	public User getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}
}
