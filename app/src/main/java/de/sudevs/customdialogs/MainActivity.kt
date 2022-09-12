package de.sudevs.customdialogs

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var snackBar: ImageButton?= null
    private var btnAlertDialog: Button? = null
    private var btnCustomDialog: Button? = null
    private var btnCustomProgress: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        snackBar = findViewById(R.id.sn_bar)
        btnAlertDialog = findViewById(R.id.btn_alert_dialog)
        btnCustomDialog = findViewById(R.id.btn_custom_dialog)
        btnCustomProgress = findViewById(R.id.btn_custom_progress_dialog)

        snackBar?.setOnClickListener { view ->
            Snackbar.make(view,"You have clicked the image button and showed a SnackBar", Snackbar.LENGTH_LONG).show()
        }

        btnAlertDialog!!.setOnClickListener {
            alertDialogFunction()
        }

        btnCustomDialog!!.setOnClickListener { view ->
            customDialogFunction()
        }

        btnCustomProgress!!.setOnClickListener {
            customProgressDialogFunction()
        }


    }
    private fun alertDialogFunction(){
        //We use the builder for convenient dialog construction
        val builder = AlertDialog.Builder(this)
        //set title for the alert dialog
        builder.setTitle("Alert")
        //Set message for the alert dialog
        builder.setMessage("This is a Alert Dialog. Wich is used to show alerts to the user")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        // Performing positive action
        builder.setPositiveButton("Yes"){ dialogInterface, wich ->
            Toast.makeText(applicationContext,"clicked yes",Toast.LENGTH_LONG).show()
            dialogInterface.dismiss() // Dialog will be dismissed
        }
        //Performing cancel action
        builder.setNeutralButton("Cancel"){dialogInterface, wich ->
            Toast.makeText(applicationContext,"clicked cancel\n operation cancel", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss() // Dialog will be dismissed
        }
        builder.setNegativeButton("No"){dialogInterface, wich ->
            Toast.makeText(applicationContext,"clicked No", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss() // Dialog will be dismissed
        }
        // Create the Alert Dialog
        val alertDialog: AlertDialog = builder.create()
        // Set other Alert Dialog properties
        alertDialog.setCancelable(false) //Will not allow user to cancel after clicking on remaining screen area
        alertDialog.show() //We show the dialog to UI
    }

    private fun customDialogFunction() {

        val customDialog = Dialog(this)

        /*Set the screen content from a layout resource.
           The resource will inflate, adding all top-level views to the screen.*/
        customDialog.setContentView(R.layout.dialog_custom)

        customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "clicked submit", Toast.LENGTH_LONG).show()
            customDialog.dismiss() // Dialog will be dismissed
        })

        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        })
        //Start the dialog and display it on screen.
        customDialog.show()
    }

    private fun customProgressDialogFunction(){
        val customProgressDialog = Dialog(this)

        /*We set the screen from a Layout resource.
        the resource will be inflated, adding all top-level views to the screen
         */
        customProgressDialog.setContentView(R.layout.dialog_custom_progress)

        //Start the dialog and display it on screen.
        customProgressDialog.show()


    }
}