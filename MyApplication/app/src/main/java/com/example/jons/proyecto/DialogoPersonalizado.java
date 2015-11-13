package com.example.jons.proyecto;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class DialogoPersonalizado extends DialogFragment {

	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    LayoutInflater inflater = getActivity().getLayoutInflater();

		builder.setView(inflater.inflate(R.layout.dialog_personal, null));
		/*.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
		   public void onClick(DialogInterface dialog, int id) {
	       dialog.cancel();
	               }
	           });*/

	    return builder.create();
    }

}
