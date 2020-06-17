package fr.cnam.nfa024.jpmena.notificationservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import fr.cnam.nfa024.jpmena.notificationservice.Service.ParcoursOptimalService;
import fr.cnam.nfa024.jpmena.notificationservice.bean.Movement;

public class ReceiverActivity extends AppCompatActivity {

    private Movement movement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        Bundle bundle = getIntent().getExtras();
        movement = (Movement) bundle.getSerializable(ParcoursOptimalService.MOVEMENT);
        TextView idFromTv = findViewById(R.id.idFrom);
        idFromTv.setText(movement.getIdFrom()+"");
        TextView idToTv = findViewById(R.id.idTo);
        idToTv.setText(movement.getIdTo()+"");
        TextView moveTv = findViewById(R.id.move);
        moveTv.setText(movement.getMovement());

    }
}
