package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import static com.example.toolbox.Notification.CHANNEL_1_ID;

//---------------- Scurces Cited ----------------
//Notifications - https://youtu.be/tTbd1Mfi-Sk
//Checkboxes    - https://youtu.be/HO7CsnUEJAs
//RadioButton   - https://youtu.be/cTlWwuAvRpE
//
//-----------------------------------------------

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle, editTextMessage;
    private CheckBox checkbox1, checkbox2, checkbox3;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Switch switchButton;
    private Button buttonCheck, buttonRadio, buttonSwitch, buttonSpinner;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);
    }

    public void sendNotification(View v){
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        android.app.Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_looks_one_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);

    }

    public void addListenerCheck(View v){
        checkbox1 = (CheckBox)findViewById(R.id.checkBox1);
        checkbox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkbox3 = (CheckBox)findViewById(R.id.checkBox3);
        buttonCheck = (Button)findViewById(R.id.buttonCheck);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v){
                    StringBuffer result = new StringBuffer();
                    result.append("Check 1: ").append(checkbox1.isChecked());
                    result.append("\nCheck 2: ").append(checkbox2.isChecked());
                    result.append("\nCheck 3: ").append(checkbox3.isChecked());

                    Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addListenerRadio(View v){
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        buttonRadio = (Button)findViewById(R.id.buttonRadio);

        buttonRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected_id = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton)findViewById(selected_id);
                StringBuffer result = new StringBuffer();
                result.append(radioButton.getText().toString()).append(": True");

                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addListenerSwitch(View v){
        switchButton = (Switch)findViewById(R.id.switch1);
        buttonSwitch = (Button)findViewById(R.id.buttonSwitch);

        buttonSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    StringBuffer result = new StringBuffer();

                    if (switchButton.isChecked())
                        result.append("Switch: true");
                    else
                        result.append("Switch: false");

                    Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
                }
        });
    }
}
