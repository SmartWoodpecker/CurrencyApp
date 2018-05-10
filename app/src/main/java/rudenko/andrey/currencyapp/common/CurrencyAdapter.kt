package rudenko.andrey.currencyapp.common

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_currency.view.*
import rudenko.andrey.currencyapp.R
import rudenko.andrey.currencyapp.entity.CurrencyEntity


/**
 * Created by rudenko.andrey on 09.05.2018.
 */
class CurrencyAdapter(private var currencyList: MutableList<CurrencyEntity>) :
        RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item_currency, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = currencyList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(currencyList[position])


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: CurrencyEntity) {
            itemView.tv_currency_name.text = item.name
            val formattedDouble = String.format("%.2f", item.price?.amount)
            itemView.tv_amount.text = formattedDouble
            itemView.tv_volume.text = item.volume.toString()
        }
    }

    fun setCurrencyList(employeeList: MutableList<CurrencyEntity>) {
        this.currencyList = employeeList
    }

}