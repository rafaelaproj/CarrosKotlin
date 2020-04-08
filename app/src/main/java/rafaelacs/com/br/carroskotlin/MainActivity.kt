package rafaelacs.com.br.carroskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import rafaelacs.com.br.carroskotlin.adapter.CarrosAdapter
import rafaelacs.com.br.carroskotlin.data.Mock
import rafaelacs.com.br.carroskotlin.domain.Carro

class MainActivity : AppCompatActivity() {

    val carros = ArrayList<Carro>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carros.addAll(savedInstanceState?.getParcelableArrayList(Carro.CARROS)?:Mock().gerarCarro(resources))
        initRecycler()
    }

    private fun initRecycler() {
        rv_carros.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        rv_carros.layoutManager = layoutManager

        val divider = DividerItemDecoration(this, layoutManager.orientation)
        rv_carros.addItemDecoration(divider)

        val adapter = CarrosAdapter(this, carros)
        rv_carros.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(Carro.CARROS, carros)
        super.onSaveInstanceState(outState)
    }
}
