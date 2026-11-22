package alvarico.allynn;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextEmail;
    EditText editTextPassword;
    Button btnSignIn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextEmail = findViewById(R.id.txtEmail);
        editTextPassword = findViewById(R.id.txtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        auth = FirebaseAuth.getInstance();

//        btnSignIn.setOnClickListener( v -> signIn(v));
    }

    @Override
    public void onClick(View clickedView) {
        if (clickedView == btnSignIn) {
            signIn();
        }
    }

    public void signIn() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()) {
            System.out.println("Enter line 51");

            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
        }

        btnSignIn.setEnabled(false);

    }

    public String isSuccess(View v, boolean outcome){

        if (outcome) {
            return "Signed in successfully.";
        }

        return "Failed to login.";
    }

    public void authentication(View v, String email, String password){
        Task<AuthResult> task = auth.signInWithEmailAndPassword(email, password);

    }

}