package com.example.quizapp
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.models.Item




class DataAdapter(private val DataList: List<Item>,
                  private val listener: OnItemClickListener
                  ) : RecyclerView.Adapter<DataAdapter.DataViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        Log.i(TAG,"onCreateViewHolder()")
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = DataList[position]
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2

        Log.i(TAG,"onBindViewHolder()")
    }

    override fun getItemCount(): Int {
        return DataList.size
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val textView1 : TextView = itemView.findViewById(R.id.question)
        val textView2: TextView = itemView.findViewById(R.id.correctanswer)
        private val buttonDetail : Button = itemView.findViewById(R.id.buttonDetails)
        private val buttonDelete : Button = itemView.findViewById(R.id.buttonDelete)

        init{

            buttonDetail.setOnClickListener(this)
            buttonDelete.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val currentPosition = this.adapterPosition
            if (currentPosition != RecyclerView.NO_POSITION) {
                if (this.buttonDetail.isPressed) {
                    listener.onDetailsClick(currentPosition)
                }

                if (this.buttonDelete.isPressed) {
                    listener.onDeleteClick(currentPosition)
                }
            }

        }
    }

    interface OnItemClickListener{
        fun onDeleteClick(position : Int)
        fun onDetailsClick(position : Int)

    }



}

