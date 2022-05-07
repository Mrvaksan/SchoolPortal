package com.app.schoolportal;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.app.schoolportal.databinding.FragmentGradeBinding;
import com.app.schoolportal.logic.Portal;
import com.app.schoolportal.logic.Student;
import com.app.schoolportal.logic.Teacher;
import com.google.android.material.snackbar.Snackbar;

public class GradeFragment extends Fragment {

    private FragmentGradeBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentGradeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSaveGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int grade;

                Teacher teacher=Portal.getCurrentTeacher();
                Student student=Portal.getCurrentStudent();

                grade = Integer.parseInt(binding.editTextStudentGrade.getText().toString());
                teacher.changeStudentGrade(student,grade);
                NavHostFragment.findNavController(GradeFragment.this).navigateUp();

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
