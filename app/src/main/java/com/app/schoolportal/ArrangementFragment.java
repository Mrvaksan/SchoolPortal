package com.app.schoolportal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.app.schoolportal.databinding.FragmentArrangementBinding;

public class ArrangementFragment extends Fragment {
    private FragmentArrangementBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentArrangementBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ArrangementFragment.this)
                        .navigate(R.id.action_ArrangementFragment_to_GradeFragment);
            }
        });

        binding.buttonNonAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ArrangementFragment.this)
                        .navigate(R.id.action_ArrangementFragment_to_NonAttendanceFragment);
            }
        });

        binding.buttonTranscript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ArrangementFragment.this)
                        .navigate(R.id.action_ArrangementFragment_to_TranscriptFragment);
            }
        });

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ArrangementFragment.this)
                        .navigate(R.id.action_ArrangementFragment_to_TeacherFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
