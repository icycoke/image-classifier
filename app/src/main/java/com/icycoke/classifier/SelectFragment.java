package com.icycoke.classifier;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


public class SelectFragment extends DialogFragment {

    private SelectFragmentListener listener;

    public SelectFragment() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String[] methodNames = new String[2];
        methodNames[0] = getResources().getString(R.string.take_pic_by_camera);
        methodNames[1] = getResources().getString(R.string.import_pic_from_file);

        builder.setItems(methodNames, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.selectOnClick(i);
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (SelectFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement SelectFragmentListener");
        }
    }

    /**
     * Listener of this dialog fragment
     */
    public interface SelectFragmentListener {
        void selectOnClick(int actionCode);
    }
}