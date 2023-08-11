package com.example.a1mv20cs131_calculator;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtValue;
    String operatorValue;
    Boolean isNewOperation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValue = (EditText) findViewById(R.id.calculator_txt_valuetext);
        txtValue.setShowSoftInputOnFocus(false);
        txtValue.setSingleLine(false);
    }

    //Any Button Clicked then this method is called
    //In Design File - XML for each button there is a property called as OnClick which will be mapped to this method
    //This method is used to display the input given by user
    public void numberClick(View view) {

        //Used to automatically reset the value for next Operation
        if(isNewOperation) {
            isNewOperation = false;
            txtValue.setText("");
        }

        String value = txtValue.getText().toString();

        int view_id = view.getId();
            if(view_id== R.id.calculator_btn_zero) {
                value += "0";
            }
        else if(view_id==R.id.calculator_btn_One) {
                value += "1";
            }

        if(view_id== R.id.calculator_btn_Two) {
            value += "2";

        }
        else if(view_id==R.id.calculator_btn_Three) {
            value += "3";
        }

            else if(view_id==R.id.calculator_btn_four) {
            value += "4";
        }

           else if(view_id== R.id.calculator_btn_five) {
            value += "5";
        }

             else if(view_id== R.id.calculator_btn_six) {
            value += "6";

        }
            else if(view_id== R.id.calculator_btn_seven) {
            value += "7";

        }
             else if(view_id== R.id.calculator_btn_eight) {
            value += "8";
        }

             else if(view_id== R.id.calculator_btn_nine) {
            value += "9";
        }

            else if(view_id== R.id.calculator_btn_add) {
            value += "+";
        }

             else if(view_id== R.id.calculator_btn_subtract) {
            value += "-";

        }
             else if(view_id== R.id.calculator_btn_multiple) {
            value += "*";

        }
             else if(view_id== R.id.calculator_btn_divide) {
            value += "/";
        }

             else if(view_id== R.id.calculator_btn_dot) {
            value += ".";
        }

        txtValue.setText(value);
    }


    public void operatorClick(View view) {
        String value = txtValue.getText().toString();
        int view_id = view.getId();
        {
            if (view_id == R.id.calculator_btn_add) {
                operatorValue = "+";
                value += "+";
            } else if (view_id == R.id.calculator_btn_subtract) {
                operatorValue = "-";
                value += "-";
            } else if (view_id == R.id.calculator_btn_divide) {
                operatorValue = "/";
                value += "/";
            } else if (view_id == R.id.calculator_btn_multiple) {
                operatorValue = "*";
                value += "*";
            }

            txtValue.setText(value);
        }

    }
        public void clearButton(View view) {

        txtValue.setText("");
        }


        public void equalsClick(View view) {
        String value = txtValue.getText().toString();
        double calculatedValue = 0.0;
        String[] separated;

            if(operatorValue=="+") {
                separated = value.split("\\+");
                calculatedValue = Double.parseDouble(separated[0]) + Double.parseDouble(separated[1]);
            }

            if(operatorValue=="-") {
                separated = value.split("-");
                calculatedValue = Double.parseDouble(separated[0]) - Double.parseDouble(separated[1]);
            }
            if(operatorValue=="*") {
                separated = value.split("\\*");
                calculatedValue = Double.parseDouble(separated[0]) * Double.parseDouble(separated[1]);
            }
            if(operatorValue=="/") {
                separated = value.split("/");
                calculatedValue = Double.parseDouble(separated[0]) / Double.parseDouble(separated[1]);
            }


        //Restrict the Decimal value to 2 digit. Eg : 23.34567 -> 23.34
        String finalValue = String.format("%.2f",calculatedValue);

        txtValue.setText(value +"\n"+ finalValue);
        isNewOperation=true;



        //If you have to display int value without decimal -
        //Check if the finalResult is decimal or not then convert to Int and display

        }
}
