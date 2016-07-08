package ru.startandroid.stringapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    TextView textView;
    String editTextString1;
    String editTextString2;
    String COMPARETO = "Строка %s не совпадает со строкой %s";
    private static final String mCHAR = "ABCDEFGHIJKIHNOPQRSTUWXYZ1234567890";
    public static final int STR_LENGTH = 9; // длина генерируемой строки
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClick(View view) {

        TextView infoTextView = (TextView) findViewById(R.id.textView);
        infoTextView.setText(createRandomString());
    }


    public String createRandomString() {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < STR_LENGTH; i++) {

            int number = random.nextInt(mCHAR.length());
            char ch = mCHAR.charAt(number);
            builder.append(ch);
        }
        return builder.toString();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.textView);


        editTextString1 = editText1.getText().toString();
        editTextString2 = editText2.getText().toString();
        CharSequence editTextString3 = editTextString2;
        char editTextString4 = editTextString2.charAt(0);


        //noinspection SimplifiableIfStatement
        if (id == R.id.compareTo) { // сравнение с учетом регистра
            if (editTextString1.compareTo(editTextString2) == 0) {
                textView.setText("Строки совпадают!");
            } else {
                String res = String.format(COMPARETO, editTextString1, editTextString2);
                textView.setText(res);
            }
        }
        if (id == R.id.compareToIgnoreCase) { //сравнение без учета регистра
            if (editTextString1.compareToIgnoreCase(editTextString2) == 0) {
                textView.setText("Строки совпадают!");
            } else {
                String res = String.format(COMPARETO, editTextString1, editTextString2);
                textView.setText(res);
            }
        }
        if (id == R.id.contains) { //вхождение в строку
            if (editTextString1.contains(editTextString3) == true) {
                textView.setText("Строкa " + editTextString2 + " входит в строку " + editTextString1);
            } else {
                String res = String.format(COMPARETO, editTextString1, editTextString2);
                textView.setText("Строкa " + editTextString2 + " не входит в строку " + editTextString1);
            }
        }
        if (id == R.id.endsWith) { //заканчивается ли данным символом
            if (editTextString1.endsWith(editTextString2) == true) {
                textView.setText("Строкa " + editTextString2 + " входит в строку " + editTextString1);
            } else {
                String res = String.format(COMPARETO, editTextString1, editTextString2);
                textView.setText("Строкa " + editTextString2 + " не входит в строку " + editTextString1);
            }
        }
        if (id == R.id.startsWith) { //начинается ли данным символом
            if (editTextString1.startsWith(editTextString2) == true) {
                textView.setText("Строкa " + editTextString2 + " входит в строку " + editTextString1);
            } else {
                String res = String.format(COMPARETO, editTextString1, editTextString2);
                textView.setText(res);
            }
        }
        if (id == R.id.equals) { //идентична ли строка данному объекту
            if (editTextString1.equals(editTextString2) == true) {
                textView.setText("Строки совпадают!");
            } else {
                String res = String.format(COMPARETO, editTextString1, editTextString2);
                textView.setText(res);
            }
        }
        if (id == R.id.indexOf) { //поиск первого вхождения символа в строке

            int q = editTextString1.indexOf(editTextString2);


            if (q == -1) {
                textView.setText("Строки не содержит символа!");
            } else {
                String res = String.format("Символ " + editTextString2 + " на позиции " + q);
                textView.setText(res);
            }
        }
        if (id == R.id.lastIndexOf) { //поиск последнего вхождения символа в строке
            int q = editTextString1.lastIndexOf(editTextString2);
            if (q == -1) {
                textView.setText("Строки не содержит символа!");
            } else {
                String res = String.format("Последнее вхождение символа " + editTextString2 + " на позиции " + q);
                textView.setText(res);
            }
        }
        if (id == R.id.replace) { //Str.replace('l', 'D'), регистрозависим
            String res = editTextString1.replace('w', editTextString4);

            textView.setText(res);
        }
        if (id == R.id.toLowerCase) { //нижний регистр
            String res = editTextString1.toLowerCase();
            String res1 = editTextString2.toLowerCase();
            textView.setText(res + "  " + res1);
        }
        if (id == R.id.toUpperCase) { //верхний регистр
            String res = editTextString1.toUpperCase();
            String res1 = editTextString2.toUpperCase();
            String str = new StringBuilder().append("").append(res).append(' ').append(res1).toString();
            textView.setText(str);
        }
        if (id == R.id.trim) {// отсекает лишние пробелы на концах строк
            String res = editTextString1.trim();
            String res1 = editTextString2.trim();
               /* for (int i = 0; i<(res.length()); i++)
                {
                    res += res + "\n";
                }
                for (int i = 0; i<(res1.length()); i++)
                {
                    res1 += res1 + "\n";
                }*/
            textView.setText(res + "\n" + res1 + "\n" + "//");
        }
        if (id == R.id.split) { //разбиение строки по указанной строки
            String[] splitResult = editTextString1.split(editTextString2);
            String qw = "";
            for (int i = 0; i < splitResult.length; i++) {
                qw += splitResult[i] + "\n";
            }
            textView.setText(qw);
        }
        if (id == R.id.substring) { // разбивает строку от указананного до указанного элемента
            char c;
            for (int i = 0; i < editTextString2.length(); i++) {
                c = editTextString2.charAt(i);

                if (!(c >= '0' && c <= '9')) {
                    textView.setText("Введите число");
                } else {

                    int first = Integer.parseInt(editTextString2);
                    if (editTextString2.length() >= first) {
                        String splitResult = editTextString1.substring(0, first);

                        textView.setText(splitResult + '\n');
                    } else {
                        textView.setText("Строка слишком мала");
                    }
                }
            }

        }

        return super.onOptionsItemSelected(item);

    }
}
