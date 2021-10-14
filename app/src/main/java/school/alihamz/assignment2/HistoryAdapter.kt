package school.alihamz.assignment2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import school.alihamz.assignment2.model.AppData

class HistoryAdapter(
    private val context: Context,
    private val dataList: MutableList<AppData>,

    ) :
    RecyclerView.Adapter<HistoryAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNumber: TextView = view.findViewById(R.id.tv_number)
        val tvRightAns: TextView = view.findViewById(R.id.tv_right_ans)
        val tvText: TextView = view.findViewById(R.id.tv_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ans, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = dataList[holder.position]

        holder.tvNumber.text =
            data.firstNo.toString().plus(" * ").plus(data.secondNo).plus(" = ").plus(data.answer)

        if (data.firstNo * data.secondNo == data.answer) {
            holder.tvRightAns.visibility = View.GONE
            holder.tvRightAns.text = ""
            holder.tvText.text = context.getString(R.string.right_ans)
        } else {
            holder.tvRightAns.visibility = View.VISIBLE
            holder.tvRightAns.text = data.answer.toString()
            holder.tvText.text = context.getString(R.string.wrong_ans)
        }


    }

    override fun getItemCount() = dataList.size

}