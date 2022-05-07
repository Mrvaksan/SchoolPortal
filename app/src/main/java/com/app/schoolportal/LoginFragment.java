package com.app.schoolportal;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.app.schoolportal.databinding.ActivityMainBinding;
import com.app.schoolportal.databinding.FragmentLoginBinding;
import com.app.schoolportal.logic.Portal;
import com.app.schoolportal.logic.Student;
import com.app.schoolportal.logic.Teacher;
import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int loginType = getArguments().getInt("loginType");

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO check username and password, move next Fragment if valid
                int id;
                String password;

                id=Integer.parseInt(binding.editTextUserName.getText().toString());
                password=binding.editTextPassword.getText().toString();

                if(loginType==1){
                    Student student;
                    student = Portal.getCurrentSchool().getStudentByCredentials(id,password);

                    if(student!=null){
                        Portal.setCurrentStudent(student);
                        NavHostFragment.findNavController(LoginFragment.this)
                                .navigate(R.id.action_LoginFragment_to_StudentFragment);
                    }else {
                        Snackbar.make(view,"Kullanıcı bulunamadı",Snackbar.LENGTH_SHORT).show();
                    }
                }else if(loginType==2){
                    Teacher teacher;
                    teacher = Portal.getCurrentSchool().getTeacherByCredentials(id,password);

                    if(teacher!=null){
                        Portal.setCurrentTeacher(teacher);
                        NavHostFragment.findNavController(LoginFragment.this)
                                .navigate(R.id.action_LoginFragment_to_TeacherFragment);
                    }else {
                        Snackbar.make(view,"Kullanıcı bulunamadı",Snackbar.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}