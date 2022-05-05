import java.util.ArrayList;
import java.util.Scanner;

public class MovieLab {

    // Movies
    private static final ArrayList<Movie> MOVIES = new ArrayList<>();

    // Console messages
    private static final String MESSAGE_WELCOME = "Welcome to the Movie List Application!%n%n";
    private static final String MESSAGE_LIST_STATUS = "There are %d movies in this list.%n";
    private static final String MESSAGE_WHAT_CATEGORY = "What category are you interested in?%n";
    private static final String MESSAGE_CONTINUE = "Continue? (y/n):%n";
    private static final String MESSAGE_INVALID_CATEGORY = "Category not found! Please try again.%n";
    private static final String MESSAGE_AVAILABLE_CATEGORIES = "Available categories: %s%n";

    public static void main(String[] args) {
        populateMoviesList();

        // Print the welcome message
        System.out.printf(MESSAGE_WELCOME);
        // Print how many movies we have
        System.out.printf(MESSAGE_LIST_STATUS, MOVIES.size());

        boolean takeInput = true;

        Scanner scanner = new Scanner(System.in);

        while (takeInput) {
            // Ask what category the user wants to check
            System.out.printf(MESSAGE_WHAT_CATEGORY);
            // Print available categories
            System.out.printf(MESSAGE_AVAILABLE_CATEGORIES, Movie.Category.getCategories());

            // The user input which in this case is the requested category to search
            String nextLine = scanner.nextLine();

            try {
                // Find the category the user entered
                Movie.Category category = Movie.Category.getCategory(nextLine);
                // Print each movie with that specific category
                MOVIES.forEach(m -> { if (m.getCategory() == category) { System.out.println(m.getTitle()); }});
                // Ask the user if they want to continue
                System.out.printf(MESSAGE_CONTINUE);

                // If the user does not want to continue, stop taking input
                if (scanner.nextLine().equalsIgnoreCase("n")) {
                    takeInput = false;
                }
            } catch (NullPointerException e) {
                // If the user enters an invalid category, tell them and then re-run this while loop
                System.out.printf(MESSAGE_INVALID_CATEGORY);
            }
        }

        scanner.close();
    }

    /**
     * Populates the movies list, adding 10 movies to the list so the program
     * can actually do something.
     */
    private static void populateMoviesList() {
        MOVIES.add(new Movie("2001: A Space Odyssey", Movie.Category.SCIFI));
        MOVIES.add(new Movie("Star Wars", Movie.Category.SCIFI));
        MOVIES.add(new Movie("E.T. The Extra-Terrestrial", Movie.Category.SCIFI));
        MOVIES.add(new Movie("Hereditary", Movie.Category.HORROR));
        MOVIES.add(new Movie("The Shining", Movie.Category.HORROR));
        MOVIES.add(new Movie("Shrek", Movie.Category.ANIMATED));
        MOVIES.add(new Movie("Shrek 2", Movie.Category.ANIMATED));
        MOVIES.add(new Movie("Shrek 3", Movie.Category.ANIMATED));
        MOVIES.add(new Movie("Parasite", Movie.Category.DRAMA));
        MOVIES.add(new Movie("Citizen Kane", Movie.Category.DRAMA));
    }
}
