package il.ac.huji.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends ActionBarActivity implements View.OnClickListener{


    EditText edtTip;
    Button calc;
    CheckBox chkRound;
    TextView txtResult;

    private static  final double TIP_PRECENT=0.12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        edtTip=(EditText)findViewById(R.id.edtBillAmount);
        calc=(Button)findViewById(R.id.btnCalculate);
        chkRound=(CheckBox)findViewById(R.id.chkRound);
        txtResult=(TextView)findViewById(R.id.txtTipResult);

        calc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double amount=0;
        if(!TextUtils.isEmpty(edtTip.getText().toString())) {
             amount = Double.parseDouble(edtTip.getText().toString());
        }

        double result=TIP_PRECENT*amount;
         if (chkRound.isChecked()){
             result=Math.round(result);
         }

        txtResult.setText(getString(R.string.tip_title)+result);

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
