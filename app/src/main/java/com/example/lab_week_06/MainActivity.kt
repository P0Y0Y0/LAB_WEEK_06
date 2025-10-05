package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object:
            CatAdapter.OnClickListener  {
            //When this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        recyclerView.adapter = catAdapter

        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Lion,
                    "Simba",
                    "Future king of the jungle",
                    "https://cdn2.thecatapi.com/images/5sm.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Luna",
                    "Night explorer and moon gazer",
                    "https://cdn2.thecatapi.com/images/8kj.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Oscar",
                    "Professional nap taker",
                    "https://cdn2.thecatapi.com/images/3rt.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Misty",
                    "Mysterious and elegant",
                    "https://cdn2.thecatapi.com/images/3pq.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Leo",
                    "Brave heart with golden fur",
                    "https://cdn2.thecatapi.com/images/6rt.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Bella",
                    "Loves cuddles and treats",
                    "https://cdn2.thecatapi.com/images/7kj.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Max",
                    "Adventurous and curious",
                    "https://cdn2.thecatapi.com/images/2ab.jpg"
                )
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}