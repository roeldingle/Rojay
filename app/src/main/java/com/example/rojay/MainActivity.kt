package com.example.rojay

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*

class MainActivity : AppCompatActivity() {

    var adapter : AlphabetAdapter? = null
    var alphabetList = ArrayList<Alphabet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alphabetList.add(Alphabet("A",R.drawable.letter_a, "Apple", R.raw.apple))
        alphabetList.add(Alphabet("B",R.drawable.letter_b, "Bee", R.raw.ting))
        alphabetList.add(Alphabet("C",R.drawable.letter_c, "Cat", R.raw.ting))
        alphabetList.add(Alphabet("D",R.drawable.letter_d, "Drums", R.raw.ting))
        alphabetList.add(Alphabet("E",R.drawable.letter_e, "Egg", R.raw.ting))
        alphabetList.add(Alphabet("F",R.drawable.letter_f, "Fish", R.raw.ting))
        alphabetList.add(Alphabet("G",R.drawable.letter_g, "Gloves", R.raw.ting))
        alphabetList.add(Alphabet("H",R.drawable.letter_h, "House", R.raw.ting))
        alphabetList.add(Alphabet("I",R.drawable.letter_i, "Igloo", R.raw.ting))
        alphabetList.add(Alphabet("J",R.drawable.letter_j, "Jar", R.raw.ting))
        alphabetList.add(Alphabet("K",R.drawable.letter_k, "Keys", R.raw.ting))
        alphabetList.add(Alphabet("L",R.drawable.letter_l, "Lock", R.raw.ting))
        alphabetList.add(Alphabet("M",R.drawable.letter_m, "Mug", R.raw.ting))
        alphabetList.add(Alphabet("N",R.drawable.letter_n, "Net", R.raw.ting))
        alphabetList.add(Alphabet("O",R.drawable.letter_o, "Orange", R.raw.ting))
        alphabetList.add(Alphabet("P",R.drawable.letter_p, "Pumpkin", R.raw.ting))
        alphabetList.add(Alphabet("Q",R.drawable.letter_q, "Queen", R.raw.ting))
        alphabetList.add(Alphabet("R",R.drawable.letter_r, "Robot", R.raw.ting))
        alphabetList.add(Alphabet("S",R.drawable.letter_s, "Snake", R.raw.ting))
        alphabetList.add(Alphabet("T",R.drawable.letter_t, "Tea pot", R.raw.ting))
        alphabetList.add(Alphabet("U",R.drawable.letter_u, "Umbrella", R.raw.ting))
        alphabetList.add(Alphabet("V",R.drawable.letter_v, "Volcano", R.raw.ting))
        alphabetList.add(Alphabet("W",R.drawable.letter_w, "Watch", R.raw.ting))
        alphabetList.add(Alphabet("X",R.drawable.letter_x, "Xylophone", R.raw.ting))
        alphabetList.add(Alphabet("Y",R.drawable.letter_y, "Yoyo", R.raw.ting))
        alphabetList.add(Alphabet("Z",R.drawable.letter_z, "Zipper", R.raw.ting))

        adapter = AlphabetAdapter(this, alphabetList)
        gridview.adapter = adapter

    }

    class AlphabetAdapter : BaseAdapter{
        var alphabetList = ArrayList<Alphabet>()
        var context : Context? = null

        constructor(context: Context?, alphabetList: ArrayList<Alphabet>) : super() {
            this.alphabetList = alphabetList
            this.context = context
        }


        override fun getView(index: Int, p1: View?, p2: ViewGroup?): View {
            var alphabet : Alphabet = this.alphabetList[index]
            var inflater: LayoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var alphabetview = inflater.inflate(R.layout.item, null)

            alphabetview.imageView.setImageResource(alphabet.image!!)

            alphabetview.imageView.setOnClickListener {
                var intent = Intent(context,AlphabetDetailsActivity::class.java)

                intent.putExtra("name", alphabet.name!!)
                intent.putExtra("image", alphabet.image!!)
                intent.putExtra("desc", alphabet.desc!!)
                intent.putExtra("media", alphabet.media!!)

                context!!.startActivity(intent)
            }

            return alphabetview

        }

        override fun getItem(p0: Int): Any {
            return p0
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return alphabetList.size
        }

    }
}