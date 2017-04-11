package com.example.angelina.travelapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class Try extends Fragment {

private TextView mTextDetails;
private CallbackManager mCallbackManager;
        private FacebookCallback<LoginResult> mcallback = new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                        AccessToken accessToken = loginResult.getAccessToken();
                        Profile profile = Profile.getCurrentProfile();

                }

                @Override
                public void onCancel() {

                }

                @Override
                public void onError(FacebookException error) {

                }
        };
        public Try(){}

@Override
public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        mCallbackManager=CallbackManager.Factory.create();
        }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState){
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_try,container,false);
        }
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState){
                super.onViewCreated(view,savedInstanceState);
                LoginButton loginButton=(LoginButton) view.findViewById(R.id.login_button);
                loginButton.setReadPermissions("user_friends");
                loginButton.setFragment(this);
                loginButton.registerCallback(mCallbackManager,mcallback);
        }
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data){
                super.onActivityResult(requestCode,resultCode,data);
                mCallbackManager.onActivityResult(requestCode,resultCode,data);


        }
        public void displayWelcomeMessage(Profile profile){
                if(profile != null){
                        mTextDetails.setText("Welcome" + profile.getName());

                }
        }
        }
