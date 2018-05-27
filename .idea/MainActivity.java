package com.example.a10013517.superheroproject;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView infoView;
    TextView mainInfoText;
    ArrayList<String> arrayList;
    String select;
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("view", arrayList);
        outState.putString("select", select);
    }

    @Override
    protected  void onStart() {
        super.onStart();
        Log.d("LIFECYCLETAG", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLETAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLETAG", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLETAG", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECYCLETAG", "onResume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LIFECYCLETAG", "onCreate");
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.id_list);
        infoView = (TextView)findViewById(R.id.id_infoText);
        mainInfoText = (TextView)findViewById(R.id.id_mainInfoText);
        final heroInfo superman = new heroInfo("Superhuman Abilities, Flight, Heat Vision, Freezing Breath", "Superboy, Clark Kent, Kal-El", "Superman is part of the DC Universe. He is one of the most iconic male superhero ever in the comic world. By the opinion of most people, he is the most overpowered superhero in any comic book franchise.");
        final heroInfo wonderwoman = new heroInfo("Superhuman Healing, Skilled Hand to Hand Combat, Utilities of Lasso of Truth", "Diana Prince, Princess Diana of Themyscira", "Wonder Woman is the most iconic female superhero. Recently, her movie did the best when compared to other movies produced by DC Comics. With the bad reviews from other movies, Wonder Woman has stand out the most in the last few years.");
        final heroInfo theflash = new heroInfo("Speed, Time Travel, Time Manipulation, Phasing Through Objects", "Barry Allen, Mister Element", "The Flash has a tv show in the CW Network. He is played by Grant Gustin. He also is currently in love with Iris West and just got married right after a crossover with other superhero tv shows.");
        final heroInfo batman = new heroInfo("Genius-Level Intelligence, Peak Human Physical Condition, Master Martial Artist, Genius Detective, Rich", "Bruce Wayne", "Batman is one of the most well-known superhero of all time. What is different about him is that he has a sad back story where both his parents are killed in front of him. But, Batman overcomes the event and becomes a better person. In addition, he technically has no superpowers, which makes him an idol human.");
        final heroInfo aquaman = new heroInfo("Superhuman Strength, Speed, Durability, Telepathy of Aquatic Life", "Arthur Curry, Orin, The King of the Seven Seas, The Marine Marvel, Terra Firma", "Aquaman is easiest my least favorite superhero in this list. I do not know much about him and I do not find him appealing. Yet, Aquaman is easily one of the strongest superhero because he has full control of aquatic life, which makes him unique in many ways.");
        final heroInfo blackpanther = new heroInfo("Genius-Level Intelligence, Enhanced Human Abilities, Olympic-Level Athlete, Vibranium Armor, Rich", "T'Challa, Luke Charles, Black Leopard, Mr. Okonkwo", "Blakc Panther is currently my second most favorite superhero. He is a knew character brought to the movie screens and many Marvel fans love him. He is the richest superhero of all time and is unique in every way possible. He is a King, athlete, scientist, detective, and the list goes on and on.");
        final heroInfo captainamerica = new heroInfo("Enhanced Superhuman Speed, Durability, Strength, Healing, Vibranium Shield", "Steve Rogers, Nomad, The Captain", "Captain America is expected by many Marvel fans to end his career in the upcoming Avengers movie. He is the oldest Avenger in the current period. He has many movies, but I think Thanos will be the end of Captain America so the newcomers can have a chance to be in th spotlight.");
        final heroInfo shazam = new heroInfo("Superhuman Abilities, Flight, Spell-Casting, Control of Magical Lightning", "Billy Batson, Captain Thunder, Marvel, World's Mightiest Mortal", "Shazam is expected to have a movie in 2018. After legal issues with Marvel, DC has able to make Shazam into an usable character and give him a movie. Shazam is my third favorite superhero and I think he has potential at being one of the most iconic superhero of all time.");
        final heroInfo spiderman = new heroInfo("Enhanced Superhuman Abilities, Spidey-Sense, Crawling Walls, Web-Shooter", "Peter Parker, Ricochet, Dusk, Scarlet Spider, Iron Spider", "Spiderman is very well-known to roam in New York City, he is sometimes referred to as 'your' Neighborhood-Friendly Superhero. He is my favorite superhero since I was a kid.");
        arrayList = new ArrayList<>();
        arrayList.add("Superman");
        arrayList.add("Wonder Woman");
        arrayList.add("The Flash");
        arrayList.add("Batman");
        arrayList.add("Aquaman");
        arrayList.add("Black Panther");
        arrayList.add("Captain America");
        arrayList.add("Shazam");
        arrayList.add("Spiderman");
        if(savedInstanceState != null) {
            arrayList = savedInstanceState.getStringArrayList("view");
            select = savedInstanceState.getString("select");
        }
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.adapter_layout, arrayList);
        listView.setAdapter(customAdapter);
        for(int x = 0; x < arrayList.size(); x++) {
            if(arrayList.get(x).equals(select)) {
                if(arrayList.get(x).toString().equals("Superman")) {
                    infoView.setText("Powers: " + superman.getPowers() + "\n\nOther Name(s): " + superman.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(superman.getReview());
                    }
                }
                if(arrayList.get(x).toString().equals("Wonder Woman")) {
                    infoView.setText("Powers: " + wonderwoman.getPowers() + "\n\nOther Name(s): " + wonderwoman.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(wonderwoman.getReview());
                    }
                }
                if(arrayList.get(x).toString().equals("The Flash")) {
                    infoView.setText("Powers: " + theflash.getPowers() + "\n\nOther Name(s): " + theflash.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(theflash.getReview());
                    }
                }
                if(arrayList.get(x).toString().equals("Batman")) {
                    infoView.setText("Powers: " + batman.getPowers() + "\n\nOther Name(s): " + batman.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(batman.getReview());
                    }
                }
                if(arrayList.get(x).toString().equals("Aquaman")) {
                    infoView.setText("Powers: " + aquaman.getPowers() + "\n\nOther Name(s): " + aquaman.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(aquaman.getReview());
                    }
                }
                if(arrayList.get(x).toString().equals("Black Panther")) {
                    infoView.setText("Powers: " + blackpanther.getPowers() + "\n\nOther Name(s): " + blackpanther.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(blackpanther.getReview());
                    }
                }
                if(arrayList.get(x).toString().equals("Captain America")) {
                    infoView.setText("Powers: " + captainamerica.getPowers() + "\n\nOther Name(s): " + captainamerica.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(captainamerica.getReview());
                    }
                }
                if(arrayList.get(x).toString().equals("Shazam")) {
                    infoView.setText("Powers: " + shazam.getPowers() + "\n\nOther Name(s): " + shazam.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(shazam.getReview());
                    }
                }
                if(arrayList.get(x).toString().equals("Spiderman")) {
                    infoView.setText("Powers: " + spiderman.getPowers() + "\n\nOther Name(s): " + spiderman.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(spiderman.getReview());
                    }
                }
            }
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                select = arrayList.get(position).toString();
                if(arrayList.get(position).toString().equals("Superman")) {
                    infoView.setText("Powers: " + superman.getPowers() + "\n\nName(s): " + superman.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(superman.getReview());
                    }
                }
                if(arrayList.get(position).toString().equals("Wonder Woman")) {
                    infoView.setText("Powers: " + wonderwoman.getPowers() + "\n\nName(s): " + wonderwoman.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(wonderwoman.getReview());
                    }
                }
                if(arrayList.get(position).toString().equals("The Flash")) {
                    infoView.setText("Powers: " + theflash.getPowers() + "\n\nName(s): " + theflash.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(theflash.getReview());
                    }
                }
                if(arrayList.get(position).toString().equals("Batman")) {
                    infoView.setText("Powers: " + batman.getPowers() + "\n\nName(s): " + batman.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(batman.getReview());
                    }
                }
                if(arrayList.get(position).toString().equals("Aquaman")) {
                    infoView.setText("Powers: " + aquaman.getPowers() + "\n\nName(s): " + aquaman.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(aquaman.getReview());
                    }
                }
                if(arrayList.get(position).toString().equals("Black Panther")) {
                    infoView.setText("Powers: " + blackpanther.getPowers() + "\n\nName(s): " + blackpanther.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(blackpanther.getReview());
                    }
                }
                if(arrayList.get(position).toString().equals("Captain America")) {
                    infoView.setText("Powers: " + captainamerica.getPowers() + "\n\nName(s): " + captainamerica.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(captainamerica.getReview());
                    }
                }
                if(arrayList.get(position).toString().equals("Shazam")) {
                    infoView.setText("Powers: " + shazam.getPowers() + "\n\nName(s): " + shazam.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(shazam.getReview());
                    }
                }
                if(arrayList.get(position).toString().equals("Spiderman")) {
                    infoView.setText("Powers: " + spiderman.getPowers() + "\n\nName(s): " + spiderman.getAliases());
                    if(mainInfoText != null) {
                        mainInfoText.setText(spiderman.getReview());
                    }
                }
            }
        });
    }
    public class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        List list;
        public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
            super(context, resource, objects);
            this.context = context;
            list = objects;
        }
        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterView = layoutInflater.inflate(R.layout.adapter_layout, null);
            TextView textView = adapterView.findViewById(R.id.id_textView);
            Button button = adapterView.findViewById(R.id.id_button);
            button.setFocusable(false);
            ImageView imageView = adapterView.findViewById(R.id.id_imageView);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });
            String name = list.get(position).toString();
            if(name.equals("Superman")) {
                imageView.setImageResource(R.drawable.superman);
            }
            if(name.equals("Wonder Woman")) {
                imageView.setImageResource(R.drawable.wonderwoman);
            }
            if(name.equals("The Flash")) {
                imageView.setImageResource(R.drawable.theflash);
            }
            if(name.equals("Batman")) {
                imageView.setImageResource(R.drawable.batman);
            }
            if(name.equals("Aquaman")) {
                imageView.setImageResource(R.drawable.aquaman);
            }
            if(name.equals("Black Panther")) {
                imageView.setImageResource(R.drawable.blackpanther);
            }
            if(name.equals("Captain America")) {
                imageView.setImageResource(R.drawable.captainamerica);
            }
            if(name.equals("Shazam")) {
                imageView.setImageResource(R.drawable.shazam);
            }
            if(name.equals("Spiderman")) {
                imageView.setImageResource(R.drawable.spiderman);
            }
            textView.setText(name);
            return adapterView;
        }
    }
    public class heroInfo {
        String powers;
        String aliases;
        String review;
        public heroInfo(String powers, String aliases, String review) {
            this.powers = powers;
            this.aliases = aliases;
            this.review = review;
        }
        public String getPowers() {
            return powers;
        }
        public String getAliases() {
            return aliases;
        }
        public String getReview() {
            return review;
        }
    }
}
