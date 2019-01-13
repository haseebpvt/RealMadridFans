package apps.andorid.sprout.project;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import apps.andorid.sprout.project.Adapter.GameListAdapter;
import apps.andorid.sprout.project.Data.Game;
import apps.andorid.sprout.project.Util.GridSpacingItemDecoration;

public class MainActivity extends AppCompatActivity {

    //Views
    private RecyclerView recyclerView;

    //Variables
    private List<Game> gameList;

    //Bluetooth
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothDevice bluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencing views
        recyclerView = findViewById(R.id.recyclerView);

        //Setting up recycler view
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, 50, false));

        //Initializing variables
        gameList = new ArrayList<>();

        //Initializing Bluetooth
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        //Checking if Bluetooth is present
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "This device does not support Bluetooth", Toast.LENGTH_SHORT).show();
        }

        //Enabling bluetooth
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth, 1);
        }

        //Getting paired devices
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        if (pairedDevices.size()>0) {
            for (BluetoothDevice device : pairedDevices) {
                bluetoothDevice = device;
            }
        }


        //Adding dummy data to list
        //https://ibb.co/wcBSTQY
        //for (int i = 0; i < 10; i++) {
            Game game = new Game();
            game.setId("game_calculation_1");
            game.setTitle("Calculation");
            game.setSubTitle("Practice calculation");
            game.setImage(R.drawable.calculator);

            gameList.add(game);
            gameList.add(createDummyData());
        //}

        //Adapter
        GameListAdapter adapter = new GameListAdapter(gameList, this);

        recyclerView.setAdapter(adapter);

    }

    //TODO: Remove this. Dummy data creation
    private Game createDummyData() {
        Game game2 = new Game();
        game2.setId("game_memory_1");
        game2.setTitle("Memory");
        game2.setSubTitle("Improve memory");
        game2.setImage(R.drawable.image);
        return game2;
    }

}
