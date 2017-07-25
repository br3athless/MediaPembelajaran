package r3ckless.mediapembelajaran;

/**
 * Created by r3ckless on 5/13/2017.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class AboutDialogFragment extends DialogFragment
{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        // Build dialog

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.about_layout, new LinearLayout(getActivity()), false);
        builder.setView(view);

        Button dismiss = (Button) view.findViewById(R.id.dismiss_dialog);
        dismiss.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();
    }
}
