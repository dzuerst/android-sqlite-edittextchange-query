package com.neonusa.belajarnavigationdrawer.ui.adapter

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neonusa.belajarnavigationdrawer.databinding.ItemWordBinding
import com.neonusa.belajarnavigationdrawer.room.Word

class WordAdapter: RecyclerView.Adapter<WordAdapter.WordViewHolder>(){
    lateinit var words: List<Word>

    fun setList(words: List<Word>){
        this.words = words;
        notifyDataSetChanged()
    }

    //todo binding kesini
    inner class WordViewHolder(private val binding: ItemWordBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(word: Word){
            with(binding){
                itemTxtWord.text = word.word
                itemTxtDef.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(word.definition, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    Html.fromHtml(word.definition)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemWordBinding = ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(itemWordBinding)
    }

    override fun getItemCount(): Int = words.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = words[position]
        holder.bind(word)
    }

}