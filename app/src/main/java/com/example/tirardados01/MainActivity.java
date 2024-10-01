package com.example.tirardados01;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tirardados01.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int rand01;
    TextView valorDado;
    TextView valorTirada;
    ActivityMainBinding binding;
    Button btnLanzar;
    ImageView imgDado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());
        valorDado = (TextView) findViewById(R.id.txtValorDado);
        btnLanzar = (Button) findViewById(R.id.btnLanzar);
        imgDado = (ImageView) findViewById(R.id.imgDados);
        Toast.makeText(this, "A jugar", Toast.LENGTH_SHORT).show();
        btnLanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                rand01 = rand.nextInt(6) + 1;
                valorDado.setText(""+rand01);
                valorDado.setBackgroundColor(Color.WHITE);
                btnLanzar.setBackgroundColor(Color.MAGENTA);
                btnLanzar.setText("LANZAR");
                switch(rand01)
                {
                    case 1:
                        imgDado.setImageResource(R.drawable.dice_one);
                        valorDado.setBackgroundColor(Color.RED);
                        btnLanzar.setBackgroundColor(Color.RED);
                        btnLanzar.setText("FALLO!");
                        break;
                    case 2:
                        imgDado.setImageResource(R.drawable.dice_two);

                        break;
                    case 3:
                        imgDado.setImageResource(R.drawable.dice_three);
                        break;
                    case 4:
                        imgDado.setImageResource(R.drawable.dice_four);
                        break;
                    case 5:
                        imgDado.setImageResource(R.drawable.dice_five);
                        break;
                    case 6:
                        imgDado.setImageResource(R.drawable.dice_six);
                        break;
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}