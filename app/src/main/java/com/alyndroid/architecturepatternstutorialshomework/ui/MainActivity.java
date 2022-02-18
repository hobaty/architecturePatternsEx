package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviderKt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,INumbers {

    DataBase dataBase ;
    NumbersPresenter presenter;
    NumbersViewModel numbersViewModel;

    TextView mulTv;
    TextView divTv;
    TextView plusTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plusButton = findViewById(R.id.plus_button);
        Button divButton = findViewById(R.id.div_button);
        Button mulButton = findViewById(R.id.mul_button);
        mulTv  = findViewById(R.id.mul_result_textView);
        divTv  = findViewById(R.id.div_result_textView);
        plusTv = findViewById(R.id.plus_result_textView);
        plusButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);
        dataBase = new DataBase();
        presenter = new NumbersPresenter(this);
        numbersViewModel = new ViewModelProvider(this).get(NumbersViewModel.class);
        numbersViewModel.numbersMutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer s) {
                mulTv.setText(""+s);
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            // apply MVC architecture
            case R.id.plus_button:
            {
                viewAddResult();
                break;
            }
            // apply MVP architecture
            case R.id.div_button:
            {
                presenter.getDivResult();
                break;
            }
            // apply MVVM architecture
            case R.id.mul_button:
            {
                numbersViewModel.getMulResult();
                break;
            }
        }
    }

    NumberModel getNumbersFromDataBase()
    {
      return dataBase.getNumbers();
    }

    int addTwoNumbers()
    {
        NumberModel numberModel = getNumbersFromDataBase();
        return numberModel.getFirstNum() + numberModel.getSecondNum();
    }

    void viewAddResult()
    {
        plusTv.setText("" + addTwoNumbers() );
    }

    // MVP
    @Override
    public void onGetDivResult(int i) {
        divTv.setText(""+i);
    }
}
