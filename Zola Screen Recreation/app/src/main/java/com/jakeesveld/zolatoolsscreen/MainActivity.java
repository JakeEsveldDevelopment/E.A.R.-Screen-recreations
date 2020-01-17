package com.jakeesveld.zolatoolsscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainActivityRecyclerAdapter adapter;
    List<ToolItem> dataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = getDataList();

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new MainActivityRecyclerAdapter(dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }



    private List<ToolItem> getDataList() {
        return new ArrayList<>(Arrays.asList(
                new ToolItem("Registry", "Add, manage, and track your gifts", R.drawable.zola_registry_icon,
                        new ArrayList<String>(Arrays.asList(
                                "Your Registry",
                                "Add Gifts",
                                "Registry Checklist",
                                "Blender",
                                "Gift Tracker"
                        ))),
                new ToolItem("Website", "Customize your design.", R.drawable.zola_website_icon,
                        new ArrayList<String>(Arrays.asList(
                                "Your Website",
                                "Browse Designs"
                        ))),
                new ToolItem("Guests + RSVPs", "Manage your guest list and RSVPs", R.drawable.zola_guests_icon,
                        new ArrayList<String>(Arrays.asList(
                                "Your Guest List",
                                "Your Events",
                                "Track RSVPs"
                        ))),
                new ToolItem("Shop", "Shop for your home, life, and wedding.", R.drawable.zola_shop_icon,
                        new ArrayList<String>(Arrays.asList(
                                "Add Gifts",
                                "New Arrivals",
                                "Kitchen",
                                "Tabletop",
                                "Bed & Bath",
                                "Furniture",
                                "Home",
                                "Weekend",
                                "Experiences & Gift Cards",
                                "Bridal Boutique",
                                "Wedding Party Attire",
                                "Gifts & Favors",
                                "Party Supplies & Decor",
                                "Accessories",
                                "Jewelry",
                                "Intimates",
                                "Beauty & Wellness"
                        ))),
                new ToolItem("Wedding Checklist", "Cusomize for your wedding and traditions.", R.drawable.zola_checklist_icon,
                        new ArrayList<String>(Arrays.asList(
                                "Wedding Checklist"
                        ))),
                new ToolItem("Expert Advice", "Get all your questions answered.", R.drawable.zola_advice_icon,
                        new ArrayList<String>(Arrays.asList(
                                "Read Expert Advice",
                                "Chat with Zola Advisor"
                        ))),
                new ToolItem("Your Cart + Orders", "And view your Zola credit balance.", R.drawable.zola_cart_icon,
                        new ArrayList<String>(Arrays.asList(
                                "View Your Cart",
                                "Orders You've Placed",
                                "View Zola Credits"
                        )))
        ));
    }
}
