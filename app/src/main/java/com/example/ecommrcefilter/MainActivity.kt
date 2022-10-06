package com.example.ecommrcefilter

import StatusAdpter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommrcefilter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var filterlist = arrayListOf<StatusData>()
    var imgMoArray = arrayOf(
        R.drawable.samm33,
        R.drawable.iphone12,
        R.drawable.iphone13,
        R.drawable.oneplus,
        R.drawable.redmi9,
        R.drawable.ximireminote11,
        R.drawable.iphone14,
        R.drawable.redminote10,
        R.drawable.sams13,
        R.drawable.samzfold4,
        R.drawable.oneplusnordce2lite,
        R.drawable.ximi,
        R.drawable.oneplus9,
        R.drawable.viviy751
    )

    var MoNameArray = arrayOf(
        "Samsung Galaxy M33 (128 ROM, 8 RAM)",
        "Iphone 12 (128 ROM)",
        "Iphone 13 (512 ROM)",
        "Oneplus (128 ROM, 8 RAM)",
        "Redmi 9 (64 ROM, 4 RAM)",
        "Xiaomi (128 ROM, 8 RAM)",
        "Iphone 14 (1 TB)",
        "Redmi Note 10 (64 ROM, 4 RAM)",
        "Samsung F13(64 ROM, 6RAM)",
        "Samsung Z Fold 4 (128 ROM, 12 RAM)",
        "Oneplus Nord E21 Lite (128 ROM, 12RAM)",
        "Xiaomi (128 ROM, 8RAM)",
        "One plus 9 (128 ROM, 8RAM)",
        "Vivo Y75 (128 ROM, 8RAM)"


    )
    var Moprice = arrayOf(
        "20999",
        "90999",
        "120999",
        "30999",
        "9999",
        "15999",
        "180999",
        "12999",
        "15999",
        "120999",
        "30999",
        "10999",
        "21999",
        "25000"
    )
    var MRating = arrayOf("1", "5", "4", "3", "2", "4", "5", "3", "2", "5", "4", "3", "5", "4")
    var list = arrayListOf<StatusData>()
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        while (i < imgMoArray.size) {
            val statusData = StatusData(imgMoArray[i], MoNameArray[i], Moprice[i], MRating[i])
            list.add(statusData)
            i++
        }
        val swipeToDeleteCallback = object : SwipeToDeleteCall() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                filterlist.removeAt(position)
                binding.mrecycle.adapter?.notifyItemRemoved(position)
            }

        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(binding.mrecycle)

    }


    fun Rvsetup(l1: ArrayList<StatusData>) {


        val statusAdpter = StatusAdpter(this, l1)
        val ln = LinearLayoutManager(this)

        binding.mrecycle.layoutManager = ln
        binding.mrecycle.adapter = statusAdpter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.pr1 -> {
                for (h in list) {
                    if (h.price.toInt() >= 5000 && h.price.toInt() <= 20000) {
                        filterlist.add(h)
                    }
                }
                Rvsetup(filterlist)
            }
            R.id.pr2 -> {
                for (h in list) {
                    if (h.price.toInt() >= 21000 && h.price.toInt() <= 50000) {
                        filterlist.add(h)
                    }
                }
                Rvsetup(filterlist)
            }
            R.id.pr3 -> {
                for (h in list) {
                    if (h.price.toInt() >= 51000 && h.price.toInt() <= 100000) {
                        filterlist.add(h)
                    }
                }
                Rvsetup(filterlist)
            }
            R.id.pr4 -> {
                for (h in list) {
                    if (h.price.toInt() >= 101000 && h.price.toInt() <= 150000) {
                        filterlist.add(h)
                    }
                }
                Rvsetup(filterlist)
            }
            R.id.pr5 -> {
                for (h in list) {
                    if (h.price.toInt() >= 151000 && h.price.toInt() <= 200000) {
                        filterlist.add(h)
                    }
                }
                Rvsetup(filterlist)
            }

            R.id.a -> {
                for (h in list) {
                    if (h.rating == 1.toString()) {
                        filterlist.add(h)
                    }

                }
                Rvsetup(filterlist)

            }
            R.id.b -> {
                for (h in list) {
                    if (h.rating == 2.toString()) {
                        filterlist.add(h)
                    }

                }
                Rvsetup(filterlist)

            }

            R.id.c -> {
                for (h in list) {
                    if (h.rating == 3.toString()) {
                        filterlist.add(h)
                    }

                }
                Rvsetup(filterlist)
            }
            R.id.d -> {
                for (h in list) {
                    if (h.rating == 4.toString()) {
                        filterlist.add(h)
                    }

                }
                Rvsetup(filterlist)
            }
            R.id.e -> {
                for (h in list) {
                    if (h.rating == 5.toString()) {
                        filterlist.add(h)
                    }

                }
                Rvsetup(filterlist)

            }

            R.id.apple -> {
                for (h in list) {
                    if (h.name == "Iphone 12 (128 ROM)") {
                        filterlist.add(h)
                    } else if
                                   (h.name == "Iphone 13 (512 ROM)")
                        filterlist.add(h)
                    else if
                                 (h.name == "Iphone 14 (1 TB)")
                        filterlist.add(h)


                }
                Rvsetup(filterlist)

            }
            R.id.oneplus -> {
                for (h in list) {
                    if (h.name == "Oneplus (128 ROM, 8 RAM)") {
                        filterlist.add(h)
                    } else if
                                   (h.name == "Oneplus Nord E21 Lite (128 ROM, 12RAM)")
                        filterlist.add(h)
                    else if
                                 (h.name == "One plus 9 (128 ROM, 8RAM)")
                        filterlist.add(h)


                }
                Rvsetup(filterlist)

            }
            R.id.samsung -> {
                for (h in list) {
                    if (h.name == "Samsung Galaxy M33 (128 ROM, 8 RAM)") {
                        filterlist.add(h)
                    } else if
                                   (h.name == "Samsung F13(64 ROM, 6RAM)")
                        filterlist.add(h)
                    else if
                                 (h.name == "Samsung Z Fold 4 (128 ROM, 12 RAM)")
                        filterlist.add(h)


                }
                Rvsetup(filterlist)

            }
            R.id.REDMI -> {
                for (h in list) {
                    if (h.name == "Redmi 9 (64 ROM, 4 RAM)") {
                        filterlist.add(h)
                    } else if
                                   (h.name == "Xiaomi (128 ROM, 8 RAM)")
                        filterlist.add(h)
                    else if
                                 (h.name == "Redmi Note 10 (64 ROM, 4 RAM)")
                        filterlist.add(h)
                    else if
                                 (h.name == "Xiaomi (128 ROM, 8RAM)")
                        filterlist.add(h)


                }
                Rvsetup(filterlist)

            }
            R.id.vivo -> {
                for (h in list) {
                    if (h.name == "Vivo Y75 (128 ROM, 8RAM)") {
                        filterlist.add(h)
                    }

                }
                Rvsetup(filterlist)

            }


        }

        return super.onOptionsItemSelected(item)
    }

}