package com.geored.frontoffice.utiles;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.geored.frontoffice.activities.R;

public class AlertaDialogManager
{
    /**
     * Funcion que muestra un mensaje de alerta.
     * */
    public static void showAlertDialog(Context context, String title, String mensaje, Boolean estado) 
    {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
 
        // Titulo
        alertDialog.setTitle(title);
 
        // Mensaje
        alertDialog.setMessage(mensaje);
 
        if(estado != null)
        {
            // Iconos de Alerta
            alertDialog.setIcon((estado) ? R.drawable.success_icon : R.drawable.error_icon);
        }
        
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
 
        alertDialog.show();
    }
}
