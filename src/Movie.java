import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Represents a movie.  This object only contains two pieces of information - the title of the movie and the category.
 */
public class Movie {

    private final String title;
    private final Category category;

    public Movie(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    /**
     * @return The title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The category of the movie
     */
    public Category getCategory() {
        return category;
    }

    public enum Category {

        ANIMATED("Animated"), DRAMA("Drama"), HORROR("Horror"), SCIFI("Sci-Fi");

        private final String title;

        Category(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        /**
         * Returns a String displaying each of the available categories separated by comma
         * @return Each of the available categories
         */
        public static String getCategories() {
            return Arrays.stream(Movie.Category.values()).map(Category::getTitle).collect(Collectors.joining(", "));
        }

        /**
         * Attempts to find a {@link Category} given the title
         *
         * @param s The title of the {@link Category} to find
         * @return The {@link Category} with the given title
         * @throws NullPointerException If no results are found
         */
        public static Category getCategory(String s) throws NullPointerException {
            Optional<Category> category = Arrays.stream(values()).filter(c -> c.toString().equalsIgnoreCase(s)).findFirst();
            if (category.isPresent()) {
                return category.get();
            }
            throw new NullPointerException("Category not found!");
        }
    }
}
