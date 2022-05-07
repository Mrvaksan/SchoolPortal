package com.app.schoolportal;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.app.schoolportal.databinding.FragmentStudentInformationBinding;
import com.app.schoolportal.logic.Portal;
import com.app.schoolportal.logic.Student;
import com.google.android.material.snackbar.Snackbar;

public class StudentInformationFragment extends Fragment {

    private FragmentStudentInformationBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentStudentInformationBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //binding.editTextStudentNumber.setText(Portal.getCurrentStudent().generateTranscript());
        binding.buttonLoginInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id;
                id=Integer.parseInt(binding.editTextStudentNumber.getText().toString());
                Student student;
                student = Portal.getCurrentSchool().getStudentByNumbers(id);

                if(student!=null){
                    Portal.setCurrentStudent(student);
                    NavHostFragment.findNavController(StudentInformationFragment.this)
                            .navigate(R.id.action_StudentInformationFragment_to_ArrangementFragment);
                }else {
                    Snackbar.make(view,"Öğrenci bulunamadı",Snackbar.LENGTH_SHORT).show();
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
