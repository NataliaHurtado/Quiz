import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea.Inventario;
import com.example.tarea.InventarioAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Inventario> inventarioList;
    private InventarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        inventarioList = loadInventarioData();

        adapter = new InventarioAdapter(inventarioList, inventario -> {
            inventario.setQuantity("Nuevo Nombre");
            adapter.notifyDataSetChanged();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private List<Inventario> loadInventarioData() {
        List<Inventario> inventarios = new ArrayList<>();
        inventarios.add(new Inventario("Lapiz",500));
        inventarios.add(new Inventario("Borrador",500));
        inventarios.add(new Inventario("Cuaderno",5000));
        inventarios.add(new Inventario("Tajalapiz",500));
        inventarios.add(new Inventario("Blog",10000));

        return inventarios;
    }
}

