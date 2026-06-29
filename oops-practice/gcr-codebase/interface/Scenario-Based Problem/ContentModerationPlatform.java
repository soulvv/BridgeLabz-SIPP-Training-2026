interface TextModeration {

    boolean isOffensive(String post);

    String getModerationCategory(String post);

    default void displayModerationPolicy() {
        System.out.println("[TextModeration Policy]");
        System.out.println("  - No hate speech, slurs, or abusive language.");
        System.out.println("  - No threats or incitement to violence.");
        System.out.println("  - Content must respect community guidelines.");
    }

    static boolean containsRestrictedWords(String post) {
        if (post == null || post.isEmpty()) {
            return false;
        }
        String lowerPost = post.toLowerCase();
        String[] restrictedWords = {"hate", "kill", "abuse", "violence", "attack", "threat", "scam"};

        for (String word : restrictedWords) {
            if (lowerPost.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

interface SpamDetection {

    boolean isSpam(String post);

    double getSpamScore(String post);

    default void displayModerationPolicy() {
        System.out.println("[SpamDetection Policy]");
        System.out.println("  - No repetitive promotional content.");
        System.out.println("  - No suspicious links or phishing attempts.");
        System.out.println("  - Automated bot content will be flagged.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {

    private String[] spamKeywords = {"buy now", "click here", "free money", "winner", "limited offer",
            "act now", "subscribe", "earn cash", "lottery", "congratulations"};

    private String[] offensiveWords = {"hate", "kill", "abuse", "violence", "attack", "stupid", "idiot"};

    @Override
    public boolean isOffensive(String post) {
        if (post == null) return false;
        String lowerPost = post.toLowerCase();
        for (String word : offensiveWords) {
            if (lowerPost.contains(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getModerationCategory(String post) {
        boolean offensive = isOffensive(post);
        boolean spam = isSpam(post);

        if (offensive && spam) return "OFFENSIVE + SPAM";
        if (offensive) return "OFFENSIVE";
        if (spam) return "SPAM";
        return "VALID";
    }

    @Override
    public boolean isSpam(String post) {
        return getSpamScore(post) >= 0.5;
    }

    @Override
    public double getSpamScore(String post) {
        if (post == null || post.isEmpty()) return 0.0;

        String lowerPost = post.toLowerCase();
        int matchCount = 0;

        for (String keyword : spamKeywords) {
            if (lowerPost.contains(keyword)) {
                matchCount++;
            }
        }

        int upperCount = 0;
        int letterCount = 0;
        for (char c : post.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount++;
                if (Character.isUpperCase(c)) upperCount++;
            }
        }
        boolean excessiveCaps = letterCount > 0 && ((double) upperCount / letterCount) > 0.5;
        if (excessiveCaps) matchCount++;

        int exclamationCount = 0;
        for (char c : post.toCharArray()) {
            if (c == '!') exclamationCount++;
        }
        if (exclamationCount >= 3) matchCount++;

        return Math.min(1.0, matchCount * 0.25);
    }

    @Override
    public void displayModerationPolicy() {
        System.out.println("========== CONTENT MODERATION POLICIES ==========\n");
        TextModeration.super.displayModerationPolicy();
        System.out.println();
        SpamDetection.super.displayModerationPolicy();
        System.out.println("\n=================================================\n");
    }

    public void moderatePosts(String[] posts) {
        System.out.println("========== CONTENT MODERATION REPORT ==========\n");

        int spamCount = 0, offensiveCount = 0, validCount = 0;

        for (int i = 0; i < posts.length; i++) {
            String post = posts[i];
            String category = getModerationCategory(post);
            double spamScore = getSpamScore(post);
            boolean hasRestricted = TextModeration.containsRestrictedWords(post);

            System.out.println("Post #" + (i + 1) + ": \"" + post + "\"");
            System.out.println("  Category      : " + category);
            System.out.println("  Spam Score     : " + String.format("%.2f", spamScore));
            System.out.println("  Restricted Words: " + (hasRestricted ? "YES" : "No"));

            switch (category) {
                case "SPAM":
                    System.out.println("  Action         : >> POST BLOCKED (Spam)\n");
                    spamCount++;
                    break;
                case "OFFENSIVE":
                case "OFFENSIVE + SPAM":
                    System.out.println("  Action         : >> POST REMOVED (Offensive Content)\n");
                    offensiveCount++;
                    break;
                default:
                    System.out.println("  Action         : >> POST APPROVED\n");
                    validCount++;
                    break;
            }
        }

        System.out.println("=============== SUMMARY ===============");
        System.out.println("  Total Posts    : " + posts.length);
        System.out.println("  Valid Posts    : " + validCount);
        System.out.println("  Spam Posts     : " + spamCount);
        System.out.println("  Offensive Posts: " + offensiveCount);
        System.out.println("=======================================\n");
    }
}

public class ContentModerationPlatform {
    public static void main(String[] args) {
        System.out.println("===== AI-BASED CONTENT MODERATION PLATFORM =====\n");

        String[] posts = {
            "Had a wonderful day at the park with family!",
            "BUY NOW!!! Click here for FREE MONEY!!! Limited offer!!!",
            "I hate this product, total abuse of customer trust.",
            "Check out my new blog post about Java programming.",
            "CONGRATULATIONS! You are the WINNER! Act now to claim!",
            "People who think differently are stupid idiots.",
            "Just finished reading a great book on design patterns.",
            "Subscribe now and earn cash! Click here! Buy now!",
            "This violence against peaceful protesters must stop.",
            "Happy birthday to my best friend! Wish you all the best."
        };

        ContentModerator moderator = new ContentModerator();

        moderator.displayModerationPolicy();

        moderator.moderatePosts(posts);

        System.out.println("--- Static Method: containsRestrictedWords() ---");
        System.out.println("\"Love and peace\"        -> " + TextModeration.containsRestrictedWords("Love and peace"));
        System.out.println("\"hate speech is wrong\"  -> " + TextModeration.containsRestrictedWords("hate speech is wrong"));
        System.out.println("\"Buy this scam product\" -> " + TextModeration.containsRestrictedWords("Buy this scam product"));
    }
}
