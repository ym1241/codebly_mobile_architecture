package com.codebly.zibro.ui.login;

import android.app.Activity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.codebly.zibro.R;
import com.codebly.zibro.ui.login.LoginViewModel;
import com.codebly.zibro.ui.login.LoginViewModelFactory;
import com.codebly.zibro.databinding.ActivityLoginBinding;
import com.codebly.zibro.view.home.HomeActivity;
// TODO : 해당메소드 실행중일때, 오류날확률이 많음. 다 한번씩 기능실행해봐야함. JUnit, Mockito 사용해야함.
// 일단 자동로그인은 빼겠음. 아직 총 로그인이 구현되지 않아서
// TODO : 로그인 구현부터하고 자동로그인 구현 추가
public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding; //findViewById를 사용할 필요 없이 XML에 있는 요소를 참조가능

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        // TODO : 자동 로그인 기능 : 내가 처음에 만든 LoginActivity를 여기에 적용시키는중..
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            return; //로그인되어있다면 이후 코드를 실행하지 않도록 리턴. : 오류가 생길수 있음.
        }
         */

        // 로그인 상태가 아닐 때 로그인 화면 설정
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // xml에서 루트화면을 보이게함.

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);
        //ui 요소 정의 :
        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login; // TODO : 우리는 버튼을 imageview로 하였기에 일단 이래야함.
        final ProgressBar loadingProgressBar = binding.loading;

        // 관찰자 메소드 : LiveData를 통한 ui 상태 업데이트. LoginViewModel클래스에서 틀렸는지 아닌지 확인
        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                } //로그인버튼을 눌렀을때가 아니라 갔다댔을때에 확인해주는거 같은데.?
                loginButton.setEnabled(loginFormState.isDataValid()); // 로그인버튼을 enabled한다는 것인데.. 어차피 이미지뷰로 만들어서 disabled해도 표시안남. TODO : imageview를 버튼으로 바꿔야하는 이유.
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
                // return하고 바로아래 메소드에서도 확인하는것 같음
            }
        });
        // 관찰자 메소드. LoginViewModel에서 확인함.
        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);
                /*
                //Complete and destroy login activity once successful
                // 로그인 성공 시 SharedPreferences에 로그인 상태를 저장
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", true); //변경상태
                editor.apply(); // 변경 사항을 저장


                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                // TODO : 이 함수 어디로 가는지 확인. -> 가진 않을거 같고, 관찰자같음.
                */
                // destroy activity. 이러면 앱이 나가짐. 굿바이
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                // TODO 240923 : 일단 여기까지 구현완료 : 패스워드 최소 5자리이상까지ㅇㅇ
            }
        });

        // 텍스트 변경 리스너 및 이벤트 처리
        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };

        // 로그인 처리 : 실제 viewmodel로 전달
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });
    }

    // 로그인 성공 및 실패 처리
    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        // TODO : 사용자를 다음 화면으로 이동시키는 작업
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}