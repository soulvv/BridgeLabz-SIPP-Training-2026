interface StreamingService {

    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("[StreamingService] Plan: Premium HD Streaming");
        System.out.println("[StreamingService] Price: $14.99/month");
        System.out.println("[StreamingService] Features: 4K, HDR, Dolby Atmos, Offline Downloads");
    }
}

interface GamingService {

    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("[GamingService] Plan: Cloud Gaming Plus");
        System.out.println("[GamingService] Price: $9.99/month");
        System.out.println("[GamingService] Features: 60fps, Low Latency, 500+ Games Library");
    }
}

class SmartTV implements StreamingService, GamingService {

    private String tvModel;
    private String[] movieLibrary;
    private String[] gameLibrary;

    public SmartTV(String tvModel, String[] movies, String[] games) {
        this.tvModel = tvModel;
        this.movieLibrary = movies;
        this.gameLibrary = games;
    }

    @Override
    public void streamMovie(String movieName) {
        boolean found = false;
        for (String movie : movieLibrary) {
            if (movie.equalsIgnoreCase(movieName)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("[SmartTV] Now streaming: \"" + movieName + "\" in 4K HDR...");
        } else {
            System.out.println("[SmartTV] Movie \"" + movieName + "\" not found in library.");
        }
    }

    @Override
    public void playGame(String gameName) {
        boolean found = false;
        for (String game : gameLibrary) {
            if (game.equalsIgnoreCase(gameName)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("[SmartTV] Launching game: \"" + gameName + "\"... Enjoy!");
        } else {
            System.out.println("[SmartTV] Game \"" + gameName + "\" not found in library.");
        }
    }

    @Override
    public void showSubscriptionDetails() {
        System.out.println("========== " + tvModel + " - SUBSCRIPTION DETAILS ==========\n");

        System.out.println("--- Streaming Subscription ---");
        StreamingService.super.showSubscriptionDetails();

        System.out.println();

        System.out.println("--- Gaming Subscription ---");
        GamingService.super.showSubscriptionDetails();

        System.out.println("\n--- Bundle Offer ---");
        System.out.println("[SmartTV] Combined Bundle: $19.99/month (Save $4.99!)");
        System.out.println("=======================================================\n");
    }

    public void displayAllContent() {
        System.out.println("========== ALL AVAILABLE CONTENT ON " + tvModel + " ==========\n");

        System.out.println("--- Movies (" + movieLibrary.length + " titles) ---");
        for (int i = 0; i < movieLibrary.length; i++) {
            System.out.println("  " + (i + 1) + ". " + movieLibrary[i]);
        }

        System.out.println("\n--- Games (" + gameLibrary.length + " titles) ---");
        for (int i = 0; i < gameLibrary.length; i++) {
            System.out.println("  " + (i + 1) + ". " + gameLibrary[i]);
        }
        System.out.println("\n===========================================================\n");
    }
}

public class MultiServiceSmartTV {
    public static void main(String[] args) {
        System.out.println("===== MULTI-SERVICE SMART TV =====\n");

        String[] movies = {
            "Inception", "The Matrix", "Interstellar",
            "Avengers: Endgame", "Dune", "Oppenheimer"
        };

        String[] games = {
            "Cyberpunk 2077", "Elden Ring", "Fortnite",
            "God of War", "Halo Infinite"
        };

        SmartTV tv = new SmartTV("Samsung Neo QLED 8K", movies, games);

        tv.displayAllContent();

        tv.showSubscriptionDetails();

        System.out.println("--- Streaming Movies ---");
        tv.streamMovie("Inception");
        tv.streamMovie("Avatar");

        System.out.println("\n--- Playing Games ---");
        tv.playGame("Elden Ring");
        tv.playGame("Minecraft");

        System.out.println("\n--- Polymorphic References ---");
        StreamingService streamer = tv;
        GamingService gamer = tv;

        streamer.streamMovie("Dune");
        gamer.playGame("Fortnite");
    }
}
