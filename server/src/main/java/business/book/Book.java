package business.book;

public class Book {

	private long bookId;
	private long categoryId;
	private String title;
	private String author;
	private String description;
	private int price;
	private int rating;
	private boolean isPublic;
	private boolean isFeatured;


	public Book(long bookId, long categoryId, String title, String author, String description, int price, int rating, boolean isPublic, boolean isFeatured) {
		this.bookId = bookId;
		this.categoryId = categoryId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.isPublic = isPublic;
		this.isFeatured = isFeatured;
	}

	public long getBookId() {
		return bookId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public int getRating() {
		return rating;
	}

	public boolean getIsPublic() {
		return isPublic;
	}

	public boolean getIsFeatured() {
		return isFeatured;
	}

	@Override
	public String toString() {
		return "Book{" +
				"bookId=" + bookId +
				", categoryId=" + categoryId +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", rating=" + rating +
				", isPublic=" + isPublic +
				", isFeatured=" + isFeatured +
				'}';
	}
}
