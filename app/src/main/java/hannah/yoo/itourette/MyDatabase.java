package hannah.yoo.itourette;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MyDatabase extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test);
        TextView tv = findViewById(R.id.dbdb);

        Intent it = new Intent(MyDatabase.this,Homepage.class);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://itourette-default-rtdb.firebaseio.com/");

        DatabaseReference myRef = database.getReference("user");
        // myRef.child("Level/D2/").setValue("aa");
        myRef.child("D0DHRMd0kGPv9PNAoMJhguXHshO2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                User user = dataSnapshot.getValue(User.class);
                String username = String.valueOf(user.username);

                Log.e("DATA >> ", username);

                it.putExtra("username",username);
                startActivity(it);
                // tv.setText(String.valueOf(user.username));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}
