package com.favworks.taskmanager;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.regex.Pattern;

/**
 * Created by User on 6/12/15.
 */
public class Validator {
    private EditText edText;
    private Spinner spin;

    public Validator(EditText str){
        this.edText = str;
    }

    public Validator(Spinner spin){
        this.spin = spin;
    }

    public boolean checkForBlank(String msg){
        if (edText == null || edText.getText().toString().trim().length() == 0) {
            edText.setError(msg);
            return false;
        }
        return true;
    }

    public boolean checkSelect(String msg){
        String st =spin.getSelectedItem().toString();  //value
        int pos =spin.getSelectedItemPosition();   //position

        if (spin == null || pos == 0) {
    //        spin.setError(msg);
            return false;
        }
        return true;
    }


    public boolean checkLength(Integer min,Integer max,String msg){
        if (edText == null || (edText.getText().toString().trim().length() < min || edText.getText().toString().trim().length() > max)) {
            edText.setError(msg);
            return false;
        }
        return true;
    }

    public boolean checkRegExp(String type,String msg){
        String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String NUMERIC_REGEX = "^[0-9+]+$";
        String DECIMAL_REGEX = "^[0-9+]+(\\.[0-9+])$";
        String PASSWORD_REGEX = "^[A-Za-z0-9!@#$%^&*()_]{6,20}$";
        String UNAME_REGEX = "^[a-zA-Z]([0-9a-zA-Z_])+$";
        String DEFAULT_REGEX = "^[a-z]([0-9a-z_])+$";
        switch (type){
            case "email":
                if (!Pattern.matches(EMAIL_REGEX, edText.getText().toString())) {
                    edText.setError(msg);
                    return false;
                }
                break;
            case "numeric":
                if (!Pattern.matches(NUMERIC_REGEX, edText.getText().toString())) {
                    edText.setError(msg);
                    return false;
                }
                break;
            case "decimal":
                if (!Pattern.matches(DECIMAL_REGEX, edText.getText().toString())) {
                    edText.setError(msg);
                    return false;
                }
                break;
            case "password":
                if (!Pattern.matches(PASSWORD_REGEX, edText.getText().toString())) {
                    edText.setError(msg);
                    return false;
                }
                break;
            case "username":
                if (!Pattern.matches(UNAME_REGEX, edText.getText().toString())) {
                    edText.setError(msg);
                    return false;
                }
                break;
            default:
                if (!Pattern.matches(DEFAULT_REGEX, edText.getText().toString())) {
                    edText.setError(msg);
                    return false;
                }
        }
        return true;
    }

}
