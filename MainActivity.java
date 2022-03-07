package com.example.klicker;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";
    Integer counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnAddStudents(View view) {
        counter++;
        TextView counterView = (TextView) findViewById(R.id.txt_counter);
        counterView.setText(counter.toString());
        if (counter >= 1000) {
            TextView layout = (TextView) findViewById(R.id.txt_counter);
            ViewGroup.LayoutParams params = layout.getLayoutParams();
            params.height = 200;
            params.height = 400;
            layout.setLayoutParams(params);
        }
        if (counter >= 10000) {
            TextView layout = (TextView) findViewById(R.id.txt_counter);
            ViewGroup.LayoutParams params = layout.getLayoutParams();
            params.height = 200;
            params.height = 600;
            layout.setLayoutParams(params);
        }
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("Count");
        Log.d(LOG_TAG, "onRestoreInstanceState");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Count", counter);
        Log.d(LOG_TAG, "onSaveInstateState");
    }
    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
// Восстановить состояние UI с учетом того,
// что данная Активность уже была видимой.
    }
    // Вызывается, когда Активность стала видимой
    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
        resetUI();
// Проделать необходимые действия для
// Активности, видимой на экране
    }
    // Должен вызываться в начале видимого состояния.
// На самом деле Android вызывает данный обработчик только
// для Активностей, восстановленных из неактивного состояния
    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "onResume");
// Восстановить приостановленные обновления UI,
// потоки и процессы, замороженные, когда
// Активность была в неактивном состоянии
    }
    @Override
    public void onPause(){
// «Заморозить» обновления UI, потоки или
// «трудоемкие» процессы, не нужные, когда Активность
// не на переднем плане
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }
    // Вызывается перед выходом из видимого состояния
    @Override
    public void onStop(){
// «Заморозить» обновления UI, потоки или
// «трудоемкие» процессы, ненужные, когда Активность
// не на переднем плане.
// Сохранить все данные и изменения в UI, так как
// процесс может быть в любой момент убит системой
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }
    // Вызывается перед уничтожением активности
    @Override
    public void onDestroy(){
// Освободить все ресурсы, включая работающие потоки,
// соединения с БД и т. д.
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    private void resetUI() {
        ((TextView) findViewById(R.id.txt_counter)).setText(counter.toString());
        Log.d(LOG_TAG, "resetUI");
    }
}