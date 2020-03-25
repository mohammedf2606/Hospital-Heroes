package com.hummer.hospital_heroes;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginToApp extends DialogFragment {

    public static final String TAG = "LoginDialog";

    public static LoginToApp newInstance() {
        LoginToApp login = new LoginToApp();
        login.setStyle(STYLE_NO_TITLE, 0);
        login.setCancelable(false);
        return login;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.prompt, container, false);

        final EditText passwordEditText = view.findViewById(R.id.dialog_login_password);
        Button loginButton = view.findViewById(R.id.dialog_login_loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();
                if (getActivity() != null) {
                    CharSequence passwordFromShared;
                    passwordFromShared = "Password";

                    if (password.contains(passwordFromShared) && password.length() == passwordFromShared.length()) {
                        LoginToApp.super.dismiss();
                        MusicService.stop();
                        System.exit(0);
                    } else {
                        LoginToApp.super.dismiss();
                        Toast.makeText(inflater.getContext(), "Password Incorrect!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        return view;
    }
}