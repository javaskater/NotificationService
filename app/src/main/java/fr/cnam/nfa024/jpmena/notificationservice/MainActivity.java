package fr.cnam.nfa024.jpmena.notificationservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fr.cnam.nfa024.jpmena.notificationservice.Service.ParcoursOptimalService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callService(View v){
        //on lance un service pour claculer le parcours optimal
        Intent i = new Intent(this, ParcoursOptimalService.class);

        startService(i);

    }
}
