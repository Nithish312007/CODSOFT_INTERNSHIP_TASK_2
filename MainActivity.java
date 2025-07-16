package com.nithish.quoteofday;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView quoteText;
    Button newQuoteButton, shareButton, favoriteButton, viewFavoritesButton;
    ArrayList<String> quotes;
    ArrayList<String> favoriteQuotes = new ArrayList<>();
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteText = findViewById(R.id.quoteText);
        newQuoteButton = findViewById(R.id.newQuoteButton);
        shareButton = findViewById(R.id.shareButton);
        favoriteButton = findViewById(R.id.favoriteButton);
        viewFavoritesButton = findViewById(R.id.viewFavoritesButton);

        quotes = new ArrayList<>(Arrays.asList(
                "Life is very short nanba",
                "Love the life you live; live the life you love",
                "Long suffering is the greatest life survival virtue",
                "Life is a game, play it; life is a challenge, face it",
                "Believe in yourself.",
                "Dream big and dare to fail.",
                "Push yourself, because no one else is going to do it for you.",
                "Don’t stop until you’re proud.",
                "The only limit is your mind.",
                "Work hard in silence, let success make the noise."
        ));

        // Show a random quote on startup
        showRandomQuote();

        // New Quote Button
        newQuoteButton.setOnClickListener(v -> showRandomQuote());

        // Share Quote Button
        shareButton.setOnClickListener(v -> {
            String quote = quoteText.getText().toString();
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, quote);
            startActivity(Intent.createChooser(shareIntent, "Share Quote"));
        });

        // Add to Favorites Button
        favoriteButton.setOnClickListener(v -> {
            String currentQuote = quoteText.getText().toString();
            if (!favoriteQuotes.contains(currentQuote)) {
                favoriteQuotes.add(currentQuote);
                Toast.makeText(this, "Added to favorites", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Already in favorites", Toast.LENGTH_SHORT).show();
            }
        });

        // View Favorites Button
        viewFavoritesButton.setOnClickListener(v -> {
            if (favoriteQuotes.isEmpty()) {
                Toast.makeText(this, "No favorites yet!", Toast.LENGTH_SHORT).show();
            } else {
                StringBuilder allFavorites = new StringBuilder();
                for (String q : favoriteQuotes) {
                    allFavorites.append("• ").append(q).append("\n\n");
                }
                Toast.makeText(this, allFavorites.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showRandomQuote() {
        int index = random.nextInt(quotes.size());
        quoteText.setText(quotes.get(index));
    }
}
