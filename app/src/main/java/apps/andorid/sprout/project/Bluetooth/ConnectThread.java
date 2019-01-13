package apps.andorid.sprout.project.Bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

public class ConnectThread extends Thread {
    private BluetoothSocket bluetoothSocket;
    private BluetoothDevice bluetoothDevice;
    private BluetoothAdapter adapter;
    private UUID MY_UUID = UUID.randomUUID();

    public ConnectThread(BluetoothDevice device) {
        BluetoothSocket temp = null;
        bluetoothDevice = device;

        try {
            temp = device.createInsecureRfcommSocketToServiceRecord(MY_UUID);
        } catch (Exception e) {
            bluetoothSocket = temp;
        }
    }

    @Override
    public void run() {
        super.run();
        adapter.cancelDiscovery();

        try {
            bluetoothSocket.connect();
        } catch (Exception e) {
            try {
                bluetoothSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
