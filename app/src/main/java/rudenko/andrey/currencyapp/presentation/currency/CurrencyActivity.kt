package rudenko.andrey.currencyapp.presentation.currency

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_currency_list.*
import kotlinx.android.synthetic.main.content_currency_list.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import android.support.v7.widget.DividerItemDecoration
import android.view.Menu
import android.view.MenuItem
import com.example.rudenkoandrey.tesapp.data.presentation.currency.CurrencyPresenter
import rudenko.andrey.currencyapp.R
import rudenko.andrey.currencyapp.common.CurrencyAdapter
import rudenko.andrey.currencyapp.entity.CurrencyEntity


/**
 * Created by rudenko.andrey on 09.05.2018.
 */
class CurrencyActivity : MvpAppCompatActivity(), CurrencyView {

    @InjectPresenter
    lateinit var presenter: CurrencyPresenter
    private val adapter: CurrencyAdapter by lazy {
        CurrencyAdapter(currencyList = ArrayList())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_list)
        toolbar.title = resources.getString(R.string.currency)
        setSupportActionBar(toolbar)
        initializeRecycler()
        srl_currency_list.setOnRefreshListener {
            presenter.currencyRefreshed()
        }

    }

    private fun initializeRecycler() {
        rv_currency_list.adapter = adapter
        val layoutManager = LinearLayoutManager(rv_currency_list.context)
        rv_currency_list.layoutManager = layoutManager
        rv_currency_list.addItemDecoration(DividerItemDecoration(rv_currency_list.context, DividerItemDecoration.VERTICAL))
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_currency, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        return if (id == R.id.i_update) {
            showProgressBar()
            presenter.getCurrency(false)
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun refreshCurrrencyList() {

        presenter.getCurrency(false)
    }

    override fun hideRefreshing() {
        srl_currency_list.isRefreshing = false
    }

    override fun showRefreshing() {
        srl_currency_list.isRefreshing = true
    }

    override fun showProgressBar() {
        pb_currency_list.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        pb_currency_list.visibility = View.GONE
    }

    override fun showConnectionError() {
        Snackbar.make(findViewById(android.R.id.content), "Не удалось установить соединение с сервером",
                Snackbar.LENGTH_SHORT).show()
    }

    override fun addCurrencysToList(proposals: ArrayList<CurrencyEntity>) {
        adapter.setCurrencyList(proposals)
        adapter.notifyDataSetChanged()
    }

}